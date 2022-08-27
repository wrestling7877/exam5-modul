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
        } .button6 {
              border-radius: 12px;
          }

        .button6 {
            background-color: #063410;
        }

        /* Black */
    </style>
    <title>Product PAGE</title>


    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>

<body>

<a href="/add-product"> Add product</a>
<section class="container mt-4 ">


    <div class="row justify-content-around">
        <c:forEach items="${productList}" var="product">
            <div class="card my-4 text-center shadow col-md-3" style="width: 18rem;">
                <img src="files/${product.getImgUrl()}" class="card-img-top" alt="${product.getName()}">
                <div class="card-body">
                    <h5 class="card-title">${product.getName()}</h5>

                    <p class="card-text">${product.getCategory().getName()}</p>

                    <a href="/update-product?id=${product.getId()}"><button class="button button6">Update</button></a>
                    <a href="/delete-product?id=${product.getId()}"><button class="button button6">Delete</button></a>


                </div>
            </div>
        </c:forEach>



    </div>
    <button><a href="/adminPage.jsp"> back</a></button>
    <div align="center">


                <% int page1 = (int) request.getAttribute("page");
                    int next = page1;
                %>
                <% int page2 = (int) request.getAttribute("prev");
                    int prev = page2;
                %>


        <a href="admin-page?page=<%=prev%>">
            <button class="button button2">Previous</button>
        </a>
        <c:forEach begin="${1}" end="${productSize}" var="pages">
<%--            <a href="admin-page?page=${pages}"> <button class="button button2"> ${pages}</button></a>--%>
              <a href="admin-page?page=${pages}"> <button class="button button2"> ${pages}</button>
        </a>
        </c:forEach>
        <%--        <a href="view-Product?page=${2}"><button class="button button2"> ${2}</button>. . .</a>--%>

        <a href="admin-page?page=<%=next%>">
            <button class="button button5">Next</button>
        </a>

    </div>





</section>


</body>
</html>
