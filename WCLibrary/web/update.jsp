<%-- 
    Document   : update
    Created on : Feb 25, 2022, 4:06:09 PM
    Author     : Phong_learning
--%>

<%@page import="services.book.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
            BookWebService_Service service = new BookWebService_Service();
            BookWebService port = service.getBookWebServicePort();
            String id = request.getParameter("deleteEmployeeNo");
            Book bookone = null;
            if(id != null){
                try{
                    bookone = port.
                }
            }
        %>
        <form method="get">
            <table>
                <tr>
                    <td>Roll No</td>
                    <td><input type="text" readonly name="rollno" value="<%=studentone.getRollNo()%>"/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" required name="name" value="<%=studentone.getFullname()%>"/></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><input type="text" required name="gender" value="<%=studentone.getGender()%>"/></td>
                </tr>
                <tr>
                    <td>Birth</td>
                    <td><input type="text" required name="birth" value="<%=studentone.getBirthday()%>"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" required name="email" value="<%=studentone.getEmail()%>"/></td>
                </tr>
                <tr>                    
                    <td><input type="submit" value="Submit Query" value="<%=studentone.getRollNo()%>"></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
            </table> 
            <a href="./index.jsp" >Back to List</a>
        </form>
    </body>
</html>
