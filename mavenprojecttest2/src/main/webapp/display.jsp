<%-- 
    Document   : display.jsp
    Created on : Feb 8, 2022, 4:56:14 PM
    Author     : Phong_learning
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1 style="text-align: center;"> Quản lí thông tin nhân viên!</h1>
        <form method="get" action="student-list">
            Search: <input type="text" name="studentf" >
            <input type="submit" value="search">
        </form>
        <div class="container">
            <table class="table table-hover hover-bordered">        
                <tr>
                    <th>Employee No</th>
                    <th>Name</th>
                    <th>Place of work</th>
                    <th>Phone No</th>
                    <th></th>
                </tr>
                <c:forEach var="d" items="${display}">
                    <tr>
                    <td>${d.employeeNo}</td>
                    <td>${d.employeeName}</td>
                    <td>${d.placeOfWork}</td>
                    <td>${d.phoneNo}</td>
                    <td><a href="?id_edit=${d.employeeNo}"><button class="btn btn-info">Edit</button></a></td>
                    <td><a href="?id_delete=${d.employeeNo}"><button class="btn btn-danger">Delete</button></a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>