package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/managementLogin")
public class ManagementLogin extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	if(email.equals("admin"))
	{
		if(password.equals("admin"))
		{
		resp.getWriter().print("<h1 style='color:green'>Login sucuss</h1>");
		req.getRequestDispatcher("Managementhome.html").include(req, resp);

	}
	else	{
			resp.getWriter().print("<h1 style='color:red'>Invalid password</h1>");

		req.getRequestDispatcher("Managementlogin.html").include(req, resp);
		}
}
	else {
		resp.getWriter().print("<h1 style='color:red'>you are not old enough to register</h1>");
		req.getRequestDispatcher("Register.html").include(req, resp);

	}
}
	
}

