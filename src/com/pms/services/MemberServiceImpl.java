package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dao.MemberDao;
import com.pms.domain.Member;

public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberdao;

	public void updateProjectMemberRole(int projectid, int userid, int teamid) {
		memberdao.updateProjectMemberRole(projectid, userid, teamid);
	}

	public List<Member> getUserIdByTeamId(int teamid) {
		return memberdao.getUserIdByTeamId(teamid);
	}

	public void updateMember(int projectId, int userid, int teamid) {
		memberdao.updateMember(projectId, userid, teamid);

	}

	public List<Member> getUserIdByProjectIdAndTeamId(int projectid, int teamid) {
		return memberdao.getUserIdByProjectIdAndTeamId(projectid, teamid);
	}
	
	public List<Member> getProjectIdByUserId(int userid)
	{
		return memberdao.getProjectIdByUserId(userid);
	}

}
