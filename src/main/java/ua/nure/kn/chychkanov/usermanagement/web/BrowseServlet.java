package ua.nure.kn.chychkanov.usermanagement.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.kn.chychkanov.usermanagement.db.DaoFactory;
import ua.nure.kn.chychkanov.usermanagement.db.DatabaseException;

public class BrowseServlet extends HttpServlet {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		if (req.getParameter("add") != null) {
	           add(req, resp);
	       } else if (req.getParameter("edit") != null) {
	           edit(req, resp);
	       } else if (req.getParameter("delete") != null) {
	           delete(req, resp);
	       } else if (req.getParameter("details") != null) {
	           details(req, resp);
	       } else {
	           browse(req, resp);
	       }
		browse(req, resp);
	}

	private void details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection users;
		try {
			users = DaoFactory.getInstance().getUserDao().findAll();
			req.getSession().setAttribute("users", users);
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
		} catch (DatabaseException e) {
			throw new ServletException(e);
		}
	}
	
}
