package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.LoginDao;
import DAOs.ProfileDAO;
import exceptions.DataBaseProblemException;
import instagram.Profile;

@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession(false) != null) {
			request.getSession().invalidate();
		}
		request.getRequestDispatcher("./html/index.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		Profile profile = null;
		int number = 0;
		try {
			profile = new ProfileDAO().getProfileByUserName(username);
			number = profile.getNumberOfSubscribers();
		} catch (DataBaseProblemException e) {
			e.printStackTrace();
		}

		LoginDao logIn = new LoginDao();
		response.setContentType("text/html");

		if (logIn.validate(username, password)) {
			request.getSession().setAttribute("user", username);
			request.getSession().setAttribute("followers", number);
			response.sendRedirect("./jsp/Home.jsp");
		} else {
			response.sendRedirect("./html/index.html");
		}

	}

}
