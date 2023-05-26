package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printer = response.getWriter();

		printer.println("<html>");
		printer.println("	<head>");
		printer.println("		<title>form</title>");
		printer.println("	</head>");
		printer.println("	<body>");

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		printer.println("<p> name :" + name + " </p>");
		printer.println("<p> age :" + age + " </p>");

		printer.println("	</body>");
		printer.println("</html>");
		printer.close();
	}

}
