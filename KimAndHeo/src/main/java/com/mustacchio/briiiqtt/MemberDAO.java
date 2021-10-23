package com.mustacchio.briiiqtt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DAO {

	List<Member> members = new ArrayList<Member>();

	public int addMember(Member input) {
		connect();

		String sql = "insert into members values (?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input.getMemberID());
			pstmt.setString(2, input.getMemberPW());
			pstmt.setString(3, input.getMemberName());
			pstmt.setString(4, input.getMemberEMail());
			int r = pstmt.executeUpdate();
			System.out.println(r + "개 행 추가됨");
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -1;
	}

	public Member login(String memberID, String memberPW) {
		connect();
		String sql = "select id, pw, name, email from members where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);

				if (memberPW.equals(pw)) {
					Member member = new Member();
					member.setMemberID(id);
					member.setMemberPW(pw);
					member.setMemberName(name);
					member.setMemberEMail(email);
					return member;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		dao.login("zxc", "zxc");
	}

}
