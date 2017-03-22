package com.pms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.domain.Member;
import com.pms.domain.Project;
import com.pms.domain.User;
import com.pms.services.MemberService;
import com.pms.services.ProjectService;
import com.pms.services.UserService;

@Controller
public class ProjectCreateController {

	@Autowired
	ProjectService projectservice;

	@Autowired
	MemberService memberservice;

	@Autowired
	UserService userservice;

	List<User> userNameList = new ArrayList<User>();

	@RequestMapping("/createProject")
	public ModelAndView createNewProject() {

		return new ModelAndView("createProject");
	}

	@RequestMapping("/insertProject")
	public String insertProjectData(@ModelAttribute Project project, HttpServletRequest request) throws ParseException {

		if (project != null) {

			String projName = project.getProjectName();

			String projStartdate = project.getProjectStartDate();
			String projEnddate = project.getProjectEndDate();

			HttpSession session = request.getSession(true);

			SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date d1 = (Date) myFormat.parse(projStartdate);
			Date d2 = (Date) myFormat.parse(projEnddate);
			String dateError = null;

			if (d1.compareTo(d2) > 0) {
				dateError = "Project End Date Must Be Greater Than Start Date.";
				session.setAttribute("DateError", dateError);

				return "redirect:/createProject";
			} else if (d1.compareTo(d2) == 0) {
				dateError = "Project Start Date And End Date Should Not Be Equal.";
				session.setAttribute("DateError", dateError);

				return "redirect:/createProject";
			}

			// int teamId=(Integer)session.getAttribute("");
			// int userId=(Integer) session.getAttribute("userId");

			int teamId = 1;
			session.setAttribute("TeamId", teamId);

			int userId = 1;
			User u = userservice.getUserName(userId);
			String projectCreatorName = u.getUserName();

			int projectCreatorId = Integer.parseInt(userservice.getProjectCreatorIdByCreatorName(projectCreatorName));

			session.setAttribute("ProjectCreatorName", projectCreatorName);
			session.setAttribute("ProjectCreatorId", projectCreatorId);

			List<Project> projectList = projectservice.getAllProjectName();

			int projectId;

			if (projectList.isEmpty()) {

				projectservice.saveProject(projName, projStartdate, projEnddate, teamId);

				projectId = Integer.parseInt(projectservice.getProjectIdbyName(projName));

				memberservice.updateProjectMemberRole(projectId, userId, teamId);

				session.setAttribute("ProjectId", projectId);

			} else {

				for (Project p : projectList) {

					String projectName = p.getProjectName().toLowerCase();

					if (projectName.equals(projName.toLowerCase())) {
						session.setAttribute("projectNameDuplicateError", "Project Name Already Exist.");
						return "redirect:/createProject";
					}
				}

				projectservice.saveProject(projName, projStartdate, projEnddate, teamId);
				projectId = Integer.parseInt(projectservice.getProjectIdbyName(projName));
				memberservice.updateProjectMemberRole(projectId, userId, teamId);

				session.setAttribute("ProjectId", projectId);
			}

			session.setAttribute("ProjectName", projName);
		}
		return "redirect:/projectMemberList";
	}

	@RequestMapping(value = "/projectMemberList")
	public ModelAndView getMemberList(HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		// int teamId=(Integer) session.getAttribute("");
		int teamId = 1;
		
		List<Member> userIdList = memberservice.getUserIdByTeamId(teamId);

		List<User> nameList = new ArrayList<User>();
		List<User> userNameList = new ArrayList<User>();

		for (Member m : userIdList) {
			int userId = m.getUserId();
			userNameList = userservice.getUserNameByUserId(userId);
			nameList.addAll(userNameList);
		}
		if (!nameList.isEmpty()) {

			session.setAttribute("nameList", nameList);
		}
		return new ModelAndView("addProjectMember", "userNameList", nameList);
	}

	@RequestMapping(value = "/projectMemberSave/{userId}")
	public String insertMember(@PathVariable int userId, HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		int projectId = (Integer) session.getAttribute("ProjectId");
		int teamId = (Integer) session.getAttribute("TeamId");

		// List<Member> userIdList = memberservice.getUserIdByTeamId(teamId);

		List<Member> list = memberservice.getProjectIdByUserId(userId);

		for (int i = 0; i < list.size(); i++) {

			int projId = list.get(i).getProjectId();
			if (projId == 0) {
				memberservice.updateMember(projectId, userId, teamId);
				User user = userservice.getUserName(userId);
				userNameList.add(user);
				session.setAttribute("AlreadySelectedError", "");

			} else

			{
				session.setAttribute("AlreadySelectedError", "This user is already selected in this project.");
			}

		}

		session.setAttribute("UserName", userNameList);
		return "redirect:/projectMemberList";
	}

	@RequestMapping("/editMember")
	public ModelAndView editMemberList(HttpServletRequest request) {

		HttpSession session = request.getSession();
		int projectId = (Integer) session.getAttribute("ProjectId");
		int teamId = (Integer) session.getAttribute("TeamId");

		List<Member> userIdList = memberservice.getUserIdByProjectIdAndTeamId(projectId, teamId);

		List<User> nameListInProject = new ArrayList<User>();
		List<User> userNameList = new ArrayList<User>();

		for (Member m : userIdList) {
			int projMemRole = m.getProjectMemberRole();
			if (projMemRole == 0) {
				int userId = m.getUserId();
				userNameList = userservice.getUserNameByUserId(userId);
				nameListInProject.addAll(userNameList);
			}
		}

		List<User> nameListInTeam = new ArrayList<User>();
		List<Member> userid = memberservice.getUserIdByTeamId(teamId);

		for (Member m : userid) {
			int projId = m.getProjectId();
			if (projId == 0) {
				int userId = m.getUserId();
				userNameList = userservice.getUserNameByUserId(userId);
				nameListInTeam.addAll(userNameList);
				/*
				 * session.setAttribute("userNameListInTeam", nameListInTeam);
				 */
			}
		}
		session.setAttribute("userNameListInTeam", nameListInTeam);
		session.setAttribute("userNameListInProject", nameListInProject);
		return new ModelAndView("editMember", "userNameListInProject", nameListInProject);
	}

	@RequestMapping(value = "/projectMemberDelete/{userId}")
	public String deleteMember(@PathVariable int userId, HttpServletRequest request) {

		HttpSession session = request.getSession();
		int projectId = 0;
		int teamId = (Integer) session.getAttribute("TeamId");

		int projectCreatorId = (Integer) session.getAttribute("ProjectCreatorId");
		// int loginUserId=(Integer) session.getAttribute("");
		int loginUserId = 1;
		if (projectCreatorId == loginUserId) {
			memberservice.updateMember(projectId, userId, teamId);
		} else {
			String error = "You are not allow to delete project member.";
			session.setAttribute("NotAllowToDeleteMemberError", error);
		}

		return "redirect:/editMember";
	}

	@RequestMapping(value = "/projectMemberAdd/{userId}")
	public String addMember(@PathVariable int userId, HttpServletRequest request) {

		HttpSession session = request.getSession();
		int projectId = (Integer) session.getAttribute("ProjectId");
		int teamId = (Integer) session.getAttribute("TeamId");
		memberservice.updateMember(projectId, userId, teamId);

		return "redirect:/editMember";
	}

}
