<%-- 
    Document   : update
    Created on : Feb 14, 2022, 8:15:28 PM
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
    <!--    <script>
    
            var sn = getParameterByName('updateEmployeeNo');
    
        </script>-->
    <body>
        <%

            StudentWS_Service service = new StudentWS_Service();
            StudentWS port = service.getStudentWSPort();
            String rollno = request.getParameter("updateEmployeeNo");
            Student studentone = null;
            if (rollno != null) {
                try {
                    studentone = port.getone(rollno);

                } catch (Exception e) {
                    System.err.println("dsjhjds");
                }


        %>
    <center>
        <h1>Hello World!</h1>
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
    </center>
    <%
        }
        String Rollno = request.getParameter("rollno");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String birth = request.getParameter("birth");
        String email = request.getParameter("email");
        String string = port.update(Rollno, name, gender, birth, email);
        if (string != null) {
            RequestDispatcher requestdispatcher = request.getRequestDispatcher("./index.jsp");
            requestdispatcher.forward(request, response);
        }

    %>
</body>
</html>
