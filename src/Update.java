

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String rollno=request.getParameter("rollno");
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		String fees=request.getParameter("fees");
		out.println("<form action=Updatepro>");
		out.println(rollno);
		out.println("<input type=hidden name=rollno value="+rollno+" ><br>");
		out.println("Name<input type=text name=name values="+name+" ><br>");
		out.println("Course<input type=text name=course values="+course+" ><br>");
		out.println("Fees<input type=text name=fees values="+fees+" ><br>");
		out.println("<input type=submit value=update/>");
		out.println("</form>");
		
		
	}

}
