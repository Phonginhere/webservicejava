<%-- 
    Document   : display
    Created on : Feb 14, 2022, 8:14:57 PM
    Author     : Phong_learning
--%>

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
        <form method="post" action="./index.jsp">
            <table>
                    <tr>
                        <td>Roll No</td>
                        <td><input type="text" required name="rollno"/></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" required name="name"/></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><input type="text" required name="gender"/></td>
                    </tr>
                    <tr>
                        <td>Birth</td>
                        <td><input type="text" required name="birth"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" required name="email"/></td>
                    </tr>
                    <tr>                    
                        <td><input type="submit" value="Submit Query"></td>
                        <td><input type="reset" value="Reset"></td>
                    </tr>
                </table> 
                <a href="./index.jsp" >Back to List</a>
        </form>
    </center>
        <%
                String rollno = request.getParameter("rollno");
                String name = request.getParameter("name");
                String gender = request.getParameter("gender");
                String birth = request.getParameter("birth");
                String email = request.getParameter("email");
                if(rollno == null || name == null ||
                        gender == null || birth == null || email == null ) {
                    return;
                }
                try {
                    StudentWS_Service service = new StudentWS_Service();
                    StudentWS port = service.getStudentWSPort();
                    Student student = port.insert(rollno, name, gender, birth, email);
                } catch(Exception e) {
                    out.println("Cannot insert employee, error: "+e.toString());
                }
            %>
    </body>
</html>
