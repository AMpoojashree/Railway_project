<%@page import="java.util.List"%>
<%@page import="dto.Train"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Train> list=(List<Train>)request.getAttribute("list"); %>
     <table border="1">
    <tr>
    <th>Number</th>
    <th>Name</th>
    <th>Seat</th>
    <th>Station</th>
    <th>Price</th>
    <th>Timings</th>
    <th>Days</th>
    <th>Delete</th>
     <th>Edit</th>
    </tr>

    <%for(Train train:list){ %>

     <tr>
    <th><%= train.getNumber() %></th>
    <th><%= train.getName() %></th>
    <th><%= train.getSeat() %></th>
    <th><%= Arrays.toString(train.getStations()) %></th>
    <th><%= Arrays.toString(train.getPrice()) %></th>
    <th><%= Arrays.toString(train.getTime()) %></th>
    <th><%= Arrays.toString(train.getDays()) %></th>
    <th><a href="delete?number=<%= train.getNumber() %>"><button>Delete</button></a></th>
      <th><a href="EditTrain.jsp?number=<%= train.getNumber() %>"><button>Edit</button></a></th>
    </tr>
    <%} %>
    </table><br>
    <a href="Home.html"><button>Home</button></a>
</body>
</html>