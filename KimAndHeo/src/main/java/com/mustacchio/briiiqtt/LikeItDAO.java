package com.mustacchio.briiiqtt;

import java.sql.SQLException;

public class LikeItDAO extends DAO {

	public int isLikeItAlreadyPressed(LikeIt likeIt) {
		int r = -1;
		// -1 : 에러
		// 0 : 좋아요 취소
		// 1 : 좋아요
		connect();
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("select is_liked from likes where id = ? and who_likes_it = ?");
			pstmt.setString(1, likeIt.getProductID());
			pstmt.setString(2, likeIt.getWhoLikesIt());
			rs = pstmt.executeQuery();
			if (rs.next()) { // 값이 있다.
				// 0인지 1인지
				int result = rs.getInt(1);
				System.out.println("기존 좋아요: " + result);
				if (result == 0/* 0이면 */) {
					// 1로 update
					System.out.println("이프0");
					pstmt = conn.prepareStatement("update likes set is_liked = '1' where id = ? and who_likes_it = ?");
					pstmt.setString(1, likeIt.getProductID());
					pstmt.setString(2, likeIt.getWhoLikesIt());
					r = pstmt.executeUpdate();
					System.out.println("좋아요 r="+r);
					pstmt = conn.prepareStatement("update product set likeit = likeit+1 where id = ?");
					pstmt.setString(1, likeIt.getProductID());
					pstmt.execute();
				} else if (result == 1)/* 1이면 */ {
					// 0으로 update
					System.out.println("엘스이프1");
					pstmt = conn.prepareStatement("update likes set is_liked = '0' where id = ? and who_likes_it = ?");
					pstmt.setString(1, likeIt.getProductID());
					pstmt.setString(2, likeIt.getWhoLikesIt());
					r = pstmt.executeUpdate();
					r--;
					System.out.println("안좋아요 r="+r);
					pstmt = conn.prepareStatement("update product set likeit = likeit-1 where id = ?");
					pstmt.setString(1, likeIt.getProductID());
					pstmt.execute();
				} else {
					System.out.println("????????????????");
				}
			} else { // 값이 없다.
				// insert into
				pstmt = conn.prepareStatement("insert into likes values (?, ?, '1')");
				pstmt.setString(1, likeIt.getProductID());
				pstmt.setString(2, likeIt.getWhoLikesIt());
				r = pstmt.executeUpdate();
				System.out.println("좋아요 r="+r);
				pstmt = conn.prepareStatement("update product set likeit = likeit+1 where id = ?");
				pstmt.setString(1, likeIt.getProductID());
				pstmt.execute();
			}
			conn.commit();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return r;
		} finally {
			disconnect();
		}
	}
}