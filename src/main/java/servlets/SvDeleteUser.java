package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import bdController.BdController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SvDeleteUser
 */
public class SvDeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SvDeleteUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = new PrintWriter(response.getOutputStream());
		response.setCharacterEncoding("UTF-8");

		String dniSeleccionado = request.getParameter("usuario");

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
		if (BdController.deleteUser(dniSeleccionado)) {
			out.println("Usuario eliminado correctamente");
		} else {
			out.println("Error al eliminar el usuario");
		}
		out.println("</body>");
		out.println("</html>");

		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
