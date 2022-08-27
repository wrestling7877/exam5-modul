<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 30/07/2022
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">




</head>
<body>
<div align="center" >

            <form action = "update-user" method="post">

                <input type="number" hidden name="id"value="${user.getId()}" required><br><br>
                <label for="username">User Name:</label>
                <input type="text" id="username" name="username"value="${user.getUsername()}" required><br><br>

                <label for="fullName">Full Name:</label>
                <input type="text" id="fullname" name="fullName"value="${user.getFullName()}" required><br><br>

                <label for="password">Password:</label>
                <input type="password"  id="password" name="password"value="${user.getPassword()}" required><br><br>

                <input type="submit" value="edit"><br><br>


                <br><br>

                <br>
                <a href="https://www.instagram.com/wrestling_7877/"> Wrestling7877</a>
            </form>
            <br>
        </div>
    </div>
</body>
</html>


</body>
</html>