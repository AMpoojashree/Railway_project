package Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/addtrain")
public class AddTrain extends HttpServlet
{
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    int trainnumber=Integer.parseInt(req.getParameter("tnumber"));
		    String trainname=req.getParameter("tname");
		    int trainseat=Integer.parseInt(req.getParameter("tseat"));

		    String station=req.getParameter("tstation");
		    String [] trainstation=station.split(",");

		    String price=req.getParameter("tprice");
		    String [] trainprice=price.split(",");

		    String timing=req.getParameter("ttime");
		    String [] traintimings=timing.split(",");

		    String days=req.getParameter("tday");
		    String [] traindays=days.split(",");

//		    PrintWriter out=resp.getWriter();
//		    out.print("<h1>");
//		    out.print("Train number: "+trainnumber);
//		    out.print("<br>");
//		    out.print("Train Name: "+trainname);
//		    out.print("<br>");
//		    out.print("Train Seat: "+trainseat);
//		    out.print("<br>");
//		    out.print("Train Stations: "+Arrays.toString(trainstation));
//		    out.print("<br>");
//		    out.print("Ticket Price: "+Arrays.toString(trainprice));
//		    out.print("<br>");
//		    out.print("Train Time: "+Arrays.toString(traintimings));
//		    out.print("<br>");
//		    out.print("Train Days: "+Arrays.toString(traindays));
//		    out.print("<br>");
//		    out.print("</h1>");

		    Train train=new Train();
		    train.setNumber(trainnumber);
		    train.setName(trainname);
		    train.setTime(traintimings);
		    train.setDays(traindays);
		    train.setSeat(trainseat);
		    train.setPrice(trainprice);
		    train.setStations(trainstation);

		    TrainDao dao=new TrainDao();
		    dao.save(train);

		    resp.getWriter().print("<h1 style='color:green'>Train details added successfully</h1>");
		    req.getRequestDispatcher("ManagementHome.html").include(req, resp);







		}

}
