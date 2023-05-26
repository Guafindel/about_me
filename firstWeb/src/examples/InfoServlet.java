package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printer = response.getWriter();

		printer.println("<html>");
		printer.println("	<head>");
		printer.println("		<title>form</title>");
		printer.println("	</head>");
		printer.println("	<body>");

		String remoteHost = request.getRemoteHost();
		String remoteAddr = request.getRemoteAddr();
		String contextPath = request.getContextPath();
		String requestUri = request.getRequestURI();
		StringBuffer requestUrl = request.getRequestURL();
		
		printer.println("<p>" + remoteHost + "</p>");
		printer.println("<p>" + remoteAddr + "</p>");
		printer.println("<p>" + contextPath + "</p>");
		printer.println("<p>" + requestUri + "</p>");
		printer.println("<p>" + requestUrl + "</p>");

		printer.println("	</body>");
		printer.println("</html>");
		printer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
