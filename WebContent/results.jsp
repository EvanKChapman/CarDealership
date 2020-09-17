<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.ArrayList"%> <%@ page import ="java.util.List"%>
<%@ page isELIgnored="false" %>
<%@ page import="com.carSalesSystem.Car"%>

<%ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");%>
<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- CSS -->
  <link rel="stylesheet" type="text/css" href="styles/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="styles/navbar.css">
  <link rel="stylesheet" type="text/css" href="styles/carSalesSystem.css">

  <title>Results</title>
</head>

<body>
  <nav class="navbar navbar-expand-sm navbar-dark p-3 px-md-4 mb-3 bg-dark">
    <a class="navbar-brand" href="index.jsp">My Dealership</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03"
      aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExample03">
      <ul class="navbar-nav mr-sm-1 ml-auto">

        <li class="nav-item">
          <a class="nav-link" href="InventoryLoader">Display Inventory</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">Search Inventory</a>
          <div class="dropdown-menu a:hover dropdown-menu-right" aria-labelledby="dropdown03">
            <a class="dropdown-item" href="searchMake.jsp">Search by Make</a>
            <a class="dropdown-item" href="searchModel.jsp">Search by Model</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">Inventory Control</a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown03">
            <a class="dropdown-item" href="addNew.jsp">Add New Vehicle</a>
            <a class="dropdown-item" href="registerSale.jsp">Register a Sale</a>
          </div>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">Reports</a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown03">
            <a class="dropdown-item" href="inventoryReport.jsp">Inventory List</a>
            <a class="dropdown-item" href="salesReport.jsp">Sales History</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>

  <section id="showcase">
    <div class="container">
      <h1 class="display-4">Results</h1>
      <p class="lead">Status of changes</p>
    </div>
  </section>

  <div class="container">
    <br>
    <h1 class="display-4"><% String msg = (String)request.getAttribute("message1");
      out.println(msg);%>
      <br>
      <% String msg2 = (String)request.getAttribute("message2");
      out.println(msg2);%></h1><br>
    <a href="addNew.jsp" class="btn btn-lg btn-block btn-dark" role="button">Add Vehicle to Inventory</a><br>
    <a href="registerSale.jsp" class="btn btn-lg btn-block btn-dark" role="button">Register a Sale</a><br>
    <a href="InventoryLoader" class="btn btn-lg btn-block btn-dark" role="button">Return to Inventory</a><br>
  </div>

</body>
<footer class="footer font-small bg-dark">

  <div class="footer text-center py-3">
    <a href="index.jsp"> MyDealership.net</a> &copy 2020 Copyright
  </div>

</footer>

</html>