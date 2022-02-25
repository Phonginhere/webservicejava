<%-- 
    Document   : add
    Created on : Feb 25, 2022, 9:06:10 PM
    Author     : Phong_learning
--%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="javax.xml.datatype.DatatypeFactory"%>
<%@page import="javax.xml.datatype.XMLGregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="service.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                    <td><select name="gender">
                            <option value="0">Male</option>
                            <option value="1">Female</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Birth</td>
                    <td><input type="date" required name="birth"/></td>
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
        <%
            String rollno = request.getParameter("rollno");
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            
            String birth = request.getParameter("birth");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(birth);
             GregorianCalendar c = new GregorianCalendar();
            c.setTime(startDate);
            XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            
            String email = request.getParameter("email");
            if (rollno == null || name == null
                    || gender == null || birth == null || email == null) {
                return;
            }
            try {
                StudentWS_Service service = new StudentWS_Service();
                StudentWS port = service.getStudentWSPort();
                Student student = port.insert(name, gender, email, date2);
            } catch (Exception e) {
                out.println("Cannot insert employee, error: " + e.toString());
            }
        %>
    </body>
</html>
