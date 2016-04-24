package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import DAOs.ProfileDAO;
import exceptions.DataBaseProblemException;
import instagram.Profile;

@WebServlet("/editProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			session.invalidate();
			response.sendRedirect("./login");
			return;
		}
		Profile profile = null;
		System.out.println(session.getAttribute("user") + " !!!");
		try {
			profile = new ProfileDAO().getProfileByUserName((String) session.getAttribute("user"));
		} catch (DataBaseProblemException e) {
			e.printStackTrace();
		}
		session.setAttribute("subs", profile.getNumberOfSubscribers());
		session.setAttribute("email", profile.getEmail());
		session.setAttribute("first", profile.getFirstName());
		System.out.println(profile.getFirstName()+" !!!!");
		session.setAttribute("last", profile.getLastName());
		session.setAttribute("password", profile.getPassword());
		request.getRequestDispatcher("./jsp/EditUserName.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
