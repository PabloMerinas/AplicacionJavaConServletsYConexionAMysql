package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bdController.BdController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 * Servlet implementation class SvShowUsers
 */
public class SvShowUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SvShowUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> userList = new ArrayList<>();

		BdController.connect();
		BdController.disconnect();

		userList.add(new User("p", "d", "d", "d", "d"));
		userList.add(new User("p", "h", "e", "s", "d"));
		userList.add(new User("p", "h", "e", "s", "d"));

		request.setAttribute("userList", userList);

		request.getRequestDispatcher("/usuarios.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
