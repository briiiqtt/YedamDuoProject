package co.yedam.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mustacchio.briiiqtt.DAO;

public class EpilogueDAO extends DAO{
	
	// 방명록 불러오기
	public List<Epilogue> getEpilogue() {
		connect() ;
		List<Epilogue> list = new ArrayList<>() ;
		
		try {
			stmt = conn.createStatement() ;
			rs = stmt.executeQuery("select * from epilogue order by id") ;
			while(rs.next()) {
				Epilogue epilogue = new Epilogue() ;
				epilogue.setId(rs.getString("id")) ;
				epilogue.setName(rs.getString("name")) ;
				epilogue.setContent(rs.getString("content")) ;
				list.add(epilogue) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect() ;
		}
		return list ;
	}
	
	// 방명록 입력
	public Epilogue insertEpilogue(Epilogue epilogue) {
		connect() ;
		int currId = 0 ;
		try {
			conn.setAutoCommit(false) ; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt = conn.createStatement() ;
			rs = stmt.executeQuery("select value from id_repository2 where name='epilogue'") ;
			if (rs.next()) {
				currId = rs.getInt("value") ;
			}
			currId++ ;
			pstmt = conn.prepareStatement("insert into epilogue values(?,?,?)") ;
			pstmt.setInt(1, currId) ;
			pstmt.setString(2, epilogue.getName()) ;
			pstmt.setString(3, epilogue.getContent()) ;
			int r = pstmt.executeUpdate() ;
			System.out.println(r + "건 입력") ;
			
			pstmt = conn.prepareStatement("update id_repository2 set value=? where name='epilogue'") ;
			pstmt.setInt(1, currId) ;
			pstmt.executeUpdate() ;
			
			conn.commit() ;
			epilogue.setId(String.valueOf(currId)) ;
			return epilogue ;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback() ;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null ;
		} finally {
			disconnect() ;
		}
	}
	
	// 방명록 수정
	public Epilogue updateEpilogue (Epilogue epilogue) {
		connect() ;
		String sql = "update epilogue set content=? where id=?" ;
		try {
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, epilogue.getContent()) ;
			pstmt.setString(2, epilogue.getId()) ;
			int r = pstmt.executeUpdate() ;
			System.out.println(r + "건 변경") ;
			return epilogue ;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null ;
		} finally {
			disconnect() ;
		}
	}
	
	// 방명록 삭제
	public String deleteEpilogue (String id) {
		connect() ;
		try {
			pstmt = conn.prepareStatement("delete from epilogue where id=?") ;
			pstmt.setString(1, id) ;
			int r = pstmt.executeUpdate() ;
			System.out.println(r + "건 삭제") ;
			return id ;
		} catch (SQLException e) {
			e.printStackTrace();
			return null ;
		} finally {
			disconnect() ;
		}
	}
}
