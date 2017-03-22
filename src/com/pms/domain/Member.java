package com.pms.domain;

import java.util.List;

public class Member {

	private int memberId;

	private int memberRole;

	private int projectId;

	private int teamId;

	private int userId;

	private int projectMemberRole;

	private List<Member> memberList;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(int memberRole) {
		this.memberRole = memberRole;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectMemberRole() {
		return projectMemberRole;
	}

	public void setProjectMemberRole(int projectMemberRole) {
		this.projectMemberRole = projectMemberRole;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

}
