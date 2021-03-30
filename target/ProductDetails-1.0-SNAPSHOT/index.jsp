<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details..</title>
</head>
<body>
<h3><%= "Product Details Dashboard" %> </h3>
<br/>
<div class="col-md-8 order-md-1">
    <div class="form-group">
<div align="center">

    <form action="ProductDetails" method="GET">
        productID : <input type="text" name="ProductID"  class="form-control" required><br/>
        <input type="submit" class="btn btn-secondary" value="Submit">
    </form>
</div>
    </div>
</div>
</body>
</html>