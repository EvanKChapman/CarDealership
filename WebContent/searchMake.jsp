<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.ArrayList"%> <%@ page import ="java.util.List"%>
<%@ page isELIgnored="false" %>
<%@ page import="com.carSalesSystem.Car"%>

<%ArrayList<Car> makeFound = (ArrayList<Car>) session.getAttribute("makeFound");%>

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

  <title>Search Make</title>
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
          <a class="nav-link" href="inventory.jsp">Display Inventory</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link active dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">Search Inventory</a>
          <div class="dropdown-menu a:hover dropdown-menu-right" aria-labelledby="dropdown03">
            <a class="dropdown-item active" href="searchMake.jsp">Search by Make</a>
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
      <h1 class="display-4">Search Make</h1>
      <p class="lead">List of our cars for sale by make</p>
    </div>
  </section>

  <div class="container">
    <div style="width: 300px; height: 75px;">

      <form class="form-inline" action="FindCarByMake" method="POST">

        Please Enter Manufacturer:<br><input type="text" name="searchMake"><br><br>

        <button type="submit" class="btn btn-dark">Search</button>

      </form>
      <br>
      <br>
    </div>
  </div>
  <div class="container">
    <div class="card-deck mb-3 text-left">
      <c:forEach var="car" items="${makeFound}">
        <div class="card mb-4 shadow-sm">
          <div class="card-header">
            <h4 class="my-0 font-weight-normal">${car.year} ${car.make} ${car.model}</h4>
          </div>
          <div class="card-body">

            <h4 class="card-title pricing-card-title">$ ${car.askingPrice}</h4>
            <div class="img">
              <img src="InventoryData/carImages/${car.imageName}" alt="car">
            </div><br>

            <a href="FindCarByVin?vin=${car.vin}" class="btn btn-lg btn-block btn-dark" role="button">More Info</a>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
</body>

<footer class="footer font-small bg-dark">

  <div class="footer text-center py-3">
    <a href="index.jsp"> MyDealership.net</a> &copy 2020 Copyright
  </div>

</footer>

</html>