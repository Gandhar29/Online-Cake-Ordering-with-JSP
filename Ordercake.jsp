<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cake Management System</title>
<style>
body {
  background-image: url('cake.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
h1, form{
	text-align: center;
}
</style>
</head>
<body>
    <h1>Cake Menu</h1>
    <form action="CakeshopServlet" method="POST">
        <label for="flavour">Select a flavour:</label>
        <select name="flavour" id="flavour">
            <option value="flavour1">Red Velvet</option>
            <option value="flavour2">Butterscotch</option>
            <option value="flavour3">Black Forest</option>
            <option value="flavour4">Chocolate</option>
            <option value="flavour5">Cheese</option>
        </select>
        <br><br>
        <label for="quantity(kg)">Quantity(kg):</label>
        <input type="number" name="quantity_in_Kg" id="quantity">
        <br><br>
        <input type="submit" value="Place Order">
    </form>
</body>
</html>
