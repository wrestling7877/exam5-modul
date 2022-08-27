<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 01/08/22
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <style>
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 8px;
            margin: 4px 2px;
            cursor: pointer;
        }

        .button2 {
            background-color: #008CBA;
        }

        /* Blue */
        .button2 {
            border-radius: 12px;
        }

        .button5 {
            border-radius: 12px;
        }

        .button5 {
            background-color: #f44336;
        }

        /* Black */
    </style>
    <title>Product PAGE</title>


    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>

<body>

<%--<button> <a href="index.jsp"> Login</a></button>--%>
<button> <a href="logout"> Logout</a></button>
<section class="container mt-4 ">


    <div class="row justify-content-around">

        <c:forEach items="${productList}" var="product">
            <div class="card my-4 text-center shadow col-md-3" style="width: 18rem;">
                <img src="files/${product.getImgUrl()}" class="card-img-top" alt="${product.getName()}">
                <div class="card-body">
                    <h5 class="card-title">${product.getName()}</h5>

                    <p class="card-text">${product.getCategory().getName()}</p>

                </div>
            </div>
        </c:forEach>

    </div>
    <div align="center">


        <% int page1 = (int) request.getAttribute("page");
            int next = page1;
        %>
        <% int page2 = (int) request.getAttribute("prev");
            int prev = page2;
        %>


        <a href="view-Product?page=<%=prev%>">
            <button class="button button2">Previous</button>
        </a>
        <c:forEach items="${pageList}" var="pages">
        <a href="view-Product?page=${pages}"> <button class="button button2"> ${pages}</button>
        </a>  <a href="view-Product?page=${pages+1}"> <button class="button button2"> ${pages+1}</button>
        </a>
        </c:forEach>
<%--        <a href="view-Product?page=${2}"><button class="button button2"> ${2}</button>. . .</a>--%>

        <a href="view-Product?page=<%=next%>">
            <button class="button button5">Next</button>
        </a>


    </div>




</section>


</body>
</html>