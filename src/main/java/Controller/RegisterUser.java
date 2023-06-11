package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/register")
public class RegisterUser extends HttpServlet
{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String firstName=req.getParameter("first");
	String lastName=req.getParameter("last");
	long mobile=Long.parseLong(req.getParameter("mobile"));
	String email=req.getParameter("email");
	String gender=req.getParameter("gender");
	String password1=req.getParameter("password1");
	String password2=req.getParameter("password2");
	Date dob=Date.valueOf(req.getParameter("dob"));
	
	int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
	
	if(password1.equals(password2))
	{
		if(age>18)
		{
			User user=new User();
			user.setAge(age);
			user.setDob(dob);
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setGender(gender);
			user.setLastName(lastName);
			user.setMobile(mobile);
			user.setPassword(password1);
			
			UserDao dao=new UserDao();
			dao.save(user);
			
			
			resp.getWriter().print("<h1 style='color:green'>Account created successsfully <br> your userId"+user.getId()+"</h1>");
			resp.getWriter().print("<h1 style='color:blue'>Your UserId is:</h1>");
			
		}
		else{
			resp.getWriter().print("<h1 style='color:red'>You are not old enough to register</h1>");
			req.getRequestDispatcher("Register_Form.html").include(req, resp);
		}

}
	else{
		resp.getWriter().print("<h1 style='color:red'>You are not old enough to register</h1>");
		req.getRequestDispatcher("Register_Form.html").include(req, resp);
	}
	
}	
}
	

