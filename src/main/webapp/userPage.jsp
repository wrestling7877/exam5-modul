<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>List_User</title>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">--%>
<%--    <link rel="stylesheet" href="style_view.css">--%>
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>--%>
<%--</head>--%>

<%--<body>--%>
<%--<div class="card">--%>
<%--    <c:if test="${message != null}">--%>
<%--       <center><h1 id="messegid">${message}</h1></center>--%>
<%--    </c:if>--%>

<%--     <button> <a href="/add-user" >ADD USER</a></button>--%>

<%--    <div class="table-concept">--%>
<%--        <input class="table-radio" type="radio" name="table_radio" id="table_radio_0" checked="checked"/>--%>
<%--        <div class="table-display">--%>
<%--        </div>--%>
<%--        <table>--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th>№</th>--%>
<%--                <th>Full Name</th>--%>
<%--                <th>Password</th>--%>
<%--                <th>Username</th>--%>
<%--                <th>Role</th>--%>
<%--                <th>Action</th>--%>
<%--               --%>

<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <c:forEach items="${userList}" var="user" varStatus="x">--%>
<%--                <tr>--%>
<%--                    <td> ${x.count} </td>--%>
<%--                    <td> ${user.getFullName()} </td>--%>
<%--                    <td> ${user.getPassword()} </td>--%>
<%--                    <td> ${user.getUsername()} </td>--%>
<%--                    <td> ${user.getRole()} </td>--%>
<%--                    <td class="danger">--%>
<%--                        <button class="danger"><a href="update-user?id=${user.getId()}"> Update</a></button>--%>
<%--                    </td>--%>
<%--                    <td class="danger">--%>
<%--                        <button class="danger"><a href="delete-user?id=${user.getId()}"> Delete</a></button>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>

<%--</div>--%>

<%--</body>--%>
<%--</html>--%>




<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 03/08/2022
  Time: 05:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>

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

        .button2 {background-color: #008CBA;} /* Blue */
        .button2 {border-radius: 12px;}
        .button5 {border-radius: 12px;}
        .button5 {background-color: #555555;} /* Black */
    </style>
</head>
<body>
<button> <a href="/add-user" >ADD USER</a></button>

<table>
    <tr>
        <th> N%</th>
        <th>Full Name</th>
        <th>Password</th>
        <th>Username</th>
        <th>Role</th>
        <th>Action</th>
    </tr>


<c:forEach items="${userList}" var="user" varStatus="x">


        <tr>
            <td> ${x.count} </td>
            </td>

            <td> ${user.getFullName()} </td>
            <td> ${user.getPassword()} </td>
            <td> ${user.getUsername()} </td>
            <td> ${user.getRole()} </td>


            <td>
                <button><a href="update-user?id=${user.getId()}"> Update</a></button>


                <button><a href="delete-user?id=${user.getId()}"> Delete</a></button>
            </td>


        </tr>

    </c:forEach>


</table>
 <button><a href="/adminPage.jsp"> back</a></button>
<div align="center">




    <%    int page1 = (int) request.getAttribute("page");
        int next = page1;
    %>
    <%    int page2= (int) request.getAttribute("prev") ;
        int prev = page2;
    %>



    <a href="/showUser?page=<%=prev%>">  <button class="button button2">Previous</button> </a>

    <a href="/showUser?page=${1}"> ${1}</a>
    <a href="/showUser?page=${2}"> ${2}</a>

    <a href="/showUser?page=<%=next%>">  <button class="button button5">Next</button> </a>


</div>
</body>
</html>
