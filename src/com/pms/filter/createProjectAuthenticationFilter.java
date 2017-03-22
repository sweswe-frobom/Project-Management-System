/*package com.pms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/projectMemberDelete")
public class createProjectAuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(true);
		int projectCreatorId = (Integer) session.getAttribute("ProjectCreatorId");

		// int loginUserId=(Integer)session.getAttribute("");
		int loginUserId = 1;

		if (projectCreatorId == loginUserId) {
			chain.doFilter(request, response);
		} else
			session.setAttribute("deleteProjMemError", "You are not allow to delete project member.");
		// response.getWriter().append("You are not allow to delete member.");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
*/