package co.yedam.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mustacchio.briiiqtt.DAO;
import com.mustacchio.briiiqtt.Member;

public class MemberDAO2 extends DAO{
	
	// 회원 목록 불러오기
	public List<Member> getMemberList() {
		connect() ;
		List<Member> list = new ArrayList<>() ;
		
		try {
			stmt = conn.createStatement() ;
			rs = stmt.executeQuery("select * from members") ;
			while(rs.next()) {
				Member member = new Member() ;
				member.setMemberID(rs.getString("id")) ;
				member.setMemberPW(rs.getString("pw")) ;
				member.setMemberName(rs.getString("name")) ;
				member.setMemberEMail(rs.getString("email")) ;
				list.add(member) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect() ;
		}
		return list ;
	}
	
}
