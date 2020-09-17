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

  <title>Inventory Report</title>
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
          <a class="nav-link active dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">Reports</a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown03">
            <a class="dropdown-item active" href="inventoryReport.jsp">Inventory List</a>
            <a class="dropdown-item" href="salesReport.jsp">Sales History</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>

  <section id="showcase">
    <div class="container">
      <h1 class="display-4">Inventory Report</h1>
      <p class="lead">Text based inventory of all cars for sale</p>
    </div>
  </section>

  <div class="table-responsive-sm">
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">Purchase Date</th>
          <th scope="col">Year</th>
          <th scope="col">Make</th>
          <th scope="col">Model</th>
          <th scope="col">VIN</th>
          <th scope="col">Mileage</th>
          <th scope="col">AskingPrice</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="car" items="${inventory}">
          <tr>
            <td>
              <c:out value="${car.purchaseDate}" />
            </td>
            <td>
              <c:out value="${car.year}" />
            </td>
            <td>
              <c:out value="${car.make}" />
            </td>
            <td>
              <c:out value="${car.model}" />
            </td>
            <td>
              <c:out value="${car.vin}" />
            </td>
            <td>
              <c:out value="${car.mileage}" />
            </td>
            <td>
              <c:out value="${car.askingPrice}" />
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
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