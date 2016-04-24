package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.ProfileDAO;
import DAOs.SubscriberDAO;
import exceptions.DataBaseProblemException;
import instagram.Profile;

@WebServlet("/follow")
public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Profile user;
		Profile sub;
		try {
			user = new ProfileDAO().getProfileByUserName(request.getParameter("user"));
			sub = new ProfileDAO().getProfileByUserName((String) request.getSession().getAttribute("user"));
			new SubscriberDAO().addSubscriber(user, sub);
		} catch (DataBaseProblemException e) {
			e.printStackTrace();
		}
		
	}

}
