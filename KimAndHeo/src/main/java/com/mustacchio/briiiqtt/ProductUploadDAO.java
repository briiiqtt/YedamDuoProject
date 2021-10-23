package com.mustacchio.briiiqtt;

import java.sql.SQLException;

import co.yedam.cart.Product;

public class ProductUploadDAO extends DAO {

	public int uploadProduct(Product product) {
		connect();
		int currId = 0;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select value from id_repository2 where name='product'");
			if (rs.next()) {
				currId = rs.getInt("value");
			}
			System.out.println("현재id"+currId);
			currId++;
			System.out.println("추가될id"+currId);

			pstmt = conn.prepareStatement("insert into product values (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, currId);
			pstmt.setString(2, product.getBrand());
			pstmt.setString(3, product.getName());
			pstmt.setInt(4, product.getOriginprice());
			pstmt.setInt(5, product.getOffprice());
			pstmt.setInt(6, 0);
			pstmt.setString(7, product.getFilename());
			int r = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update id_repository2 set value=? where name='product'") ;
			pstmt.setInt(1, currId) ;
			pstmt.executeUpdate() ;
			
			conn.commit();
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			disconnect();
		}
		return -1;
	}
}
