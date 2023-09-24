package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import bdController.BdController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		try {
			String name = request.getParameter("name");
			String subname = request.getParameter("subName");
			String dni = request.getParameter("dni");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// Realiza la validación de los parámetros aquí antes de crear el objeto User.

			User user = new User(name, subname, dni, username, password);

			if (BdController.modifyUser(dni, user)) {
				response.setContentType("text/html");
				response.setStatus(HttpServletResponse.SC_OK);

				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset='UTF-8'>");
				out.println("<title>Mensaje de éxito</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<script>");
				out.println("setTimeout(function () {");
				out.println("    window.location.href = 'index.html';");
				out.println("}, 1500);"); // Tiempo para que vuelva al index.html
				out.println("</script>");
				out.println("Usuario modificado correctamente");
				out.println("</body>");
				out.println("</html>");
			} else {
				response.setContentType("text/html");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				out.println("Error al modificar el usuario");
			}
		} catch (Exception e) {
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("Error interno del servidor: " + e.getMessage());
		} finally {
			out.close();
		}
	}

}
