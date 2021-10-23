package com.mustacchio.briiiqtt;

public class Member {

	private String memberID;
	private String memberPW;
	private String memberName;
	private String memberEMail;

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPW() {
		return memberPW;
	}

	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEMail() {
		return memberEMail;
	}

	public void setMemberEMail(String memberEMail) {
		this.memberEMail = memberEMail;
	}

	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", memberPW=" + memberPW + ", memberName=" + memberName
				+ ", memberEMail=" + memberEMail + "]";
	}

}
