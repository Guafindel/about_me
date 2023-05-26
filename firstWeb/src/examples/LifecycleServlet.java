package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet
 */
@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifecycleServlet() {
        System.out.println("LifecycleServlet Create");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init call");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy call");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printer = response.getWriter();
		printer.println("<html>");
		printer.println("	<head>");
		printer.println("		<title>form</title>");
		printer.println("	</head>");
		printer.println("	<body>");
		printer.println("		<form method='post' action='/firstWeb/LifecycleServlet'>");
		printer.println("			<span>Name : </span>");
		printer.println("			<input type='text' name='name'><br>");
		printer.println("			<input type='submit' value='ok'><br>");
		printer.println("		</form>");
		printer.println("	</body>");
		printer.println("</html>");
		printer.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");	
		request.setCharacterEncoding("utf-8");
		PrintWriter printer = response.getWriter();
		String name = request.getParameter("name");
		printer.println("<html>");
		printer.println("	<head>");
		printer.println("		<title>form</title>");
		printer.println("	</head>");
		printer.println("	<body>");
		printer.println("		<form method='post' action='/firstWeb/LifecycleServlet'>");
		printer.println("			<span>Name : </span>");
		printer.println("			<input type='text' name='name'><br>");
		printer.println("			<input type='submit' value='ok'><br>");
		printer.println("			<h1>Input name : " + name + " </h1>");
		printer.println("		</form>");
		printer.println("	</body>");
		printer.println("</html>");
		printer.close();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service call");
//	}
	
	
	
}
