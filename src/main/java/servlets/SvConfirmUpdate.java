package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

import bdController.BdController;

/**
 * Servlet implementation class SvConfirmUpdate
 */
public class SvConfirmUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvConfirmUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String name = request.getParameter("name");
		String subname = request.getParameter("subname");
		String dni = request.getParameter("dni");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User(name, subname, dni, username, password);
		System.out.println(request.getParameter(username));
		
		if(BdController.modifyUser(request.getParameter(username), user)) {
			System.out.println("Modded");
		};
		doGet(request, response);
	}

}
