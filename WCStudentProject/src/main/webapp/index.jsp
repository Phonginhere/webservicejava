<%-- 
    Document   : index
    Created on : Feb 14, 2022, 8:14:38 PM
    Author     : Phong_learning
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="services.StudentWS_Service" %>
<%@page import="services.StudentWS" %>
<%@page import="services.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h1>Hello World!</h1>
        <center>
            <h1>Employee information</h1>
            <form method="GET" action="./update.jsp">
            <table>
                <tr>
                    <th>Roll No</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>BirthDay</th>
                    <th>Email</th>
                    <th>Update</th>
                </tr>
                <%
                    //call service, like WCF trong C#
                    StudentWS_Service service = new StudentWS_Service();
                    StudentWS port = service.getStudentWSPort();        
                    List<Student> students = port.findall();
                    for (Student student : students) {
                        out.println("<tr>");
                        out.println("<td>" + student.getRollNo() + "</td>");
                        out.println("<td>" + student.getFullname() + "</td>");
                        out.println("<td>" + student.getGender() + "</td>");
                        out.println("<td>" + student.getBirthday() + "</td>");
                        out.println("<td>" + student.getEmail() + "</td>");
                       out.println("<td><a href='./update.jsp?updateEmployeeNo="
                               +student.getRollNo()+"'>Update</td>");
                        out.println("</tr>");
                    }
                %>        
            </table>
            </form>
            <a href="./add.jsp">Add New</a>
        </center>
    </body>
</html>
