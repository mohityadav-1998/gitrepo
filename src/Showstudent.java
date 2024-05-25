

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Showstudent
 */
@WebServlet("/Showstudent")
public class Showstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv630","root","root");
			String qr="select * from student";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			if(rs.next())
			{
				out.println("<table align='center' border='1px'>");
				do
					{
					String rollno=rs.getString("rollno");
					String name=rs.getString("name");
					String course=rs.getString("course");
					String fees=rs.getString("fees");
					out.println("<tr>");
					out.println("<td>");
					out.println(rollno);
					out.println("</td>");
					out.println("<td>");
					out.println(name);
					out.println("</td>");
					out.println("<td>");
					out.println(course);
					out.println("</td>");
					out.println("<td>");
					out.println(fees);
					out.println("</td>");
					out.println("<td>");
					out.println("<a href=DelStudent?name="+name+">delete</a>");
					out.println("</td>");
					out.println("<td>");
					out.println("<a href=Update?rollno="+rollno+"&name="+name+"&course="+course+"&fees="+fees+">Update</a>");
					out.println("</td>");
					out.println("</tr>");
					}while(rs.next());
				out.println("</table>");
			}
			con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
