package co.yedam.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mustacchio.briiiqtt.DAO;

public class ProductDAO extends DAO{

	// 상세 페이지에서 ID 받아서 제품정보 불러오기
	public List<Product> getProductList(String id) {
		connect() ;
		List<Product> list = new ArrayList<>() ;
		String sql = "select * from product where id=?" ;
		
		try {
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1 , id) ;
			rs = pstmt.executeQuery() ;
			
			while(rs.next()) {
				Product product = new Product() ;
				product.setId(rs.getString("id")) ;
				product.setBrand(rs.getString("brand")) ;
				product.setName(rs.getString("name")) ;
				product.setOriginprice(rs.getInt("originprice")) ;
				product.setOffprice(rs.getInt("offprice")) ;
				product.setLikeit(rs.getInt("likeit")) ;
				product.setFilename(rs.getString("filename")) ;
				list.add(product) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect() ;
		}		
		return list ;
	}
	
	// 프로덕트테이블 모든 정보 조회
	public List<Product> getProductListAll() {
		connect() ;
		List<Product> list = new ArrayList<>() ;
		String sql = "select * from product";
		
		try {
			pstmt = conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;
			
			while(rs.next()) {
				Product product = new Product() ;
				product.setId(rs.getString("id")) ;
				product.setBrand(rs.getString("brand")) ;
				product.setName(rs.getString("name")) ;
				product.setOriginprice(rs.getInt("originprice")) ;
				product.setOffprice(rs.getInt("offprice")) ;
				product.setLikeit(rs.getInt("likeit")) ;
				product.setFilename(rs.getString("filename")) ;
				list.add(product) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect() ;
		}		
		return list ;
	}
}
