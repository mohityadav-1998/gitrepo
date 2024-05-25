

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addstudent
 */
@WebServlet("/Addstudent")
public class Addstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String rollno=request.getParameter("rollno");
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		String fees=request.getParameter("fees");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv630","root","root");
			String qr="insert into student values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1,rollno);
			ps.setString(2,name);
			ps.setString(3,course);
			ps.setString(4,fees);
			int i=ps.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Addstudent.html");
				rd.include(request, response);
				out.println("Data added successfully");
			}
			else
			{

				RequestDispatcher rd=request.getRequestDispatcher("Addstudent.html");
				rd.include(request, response);
				out.println("Data not added");	
			}
			
		} catch (Exception e) {
			out.println(e);
		}
		
	}

}
