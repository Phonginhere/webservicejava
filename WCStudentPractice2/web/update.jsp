<%-- 
    Document   : update
    Created on : Feb 25, 2022, 9:33:28 PM
    Author     : Phong_learning
--%>

<%@page import="javax.xml.datatype.DatatypeFactory"%>
<%@page import="javax.xml.datatype.XMLGregorianCalendar"%>
<%@page import="java.util.GregorianCalendar"%>
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
         <form method="GET">
            <%                
                StudentWS_Service service = new StudentWS_Service();
                StudentWS port = service.getStudentWSPort();
                Student student = null;
                if(request.getParameter("updateEmployeeNo")!= null){
                    student = port.find(request.getParameter("updateEmployeeNo"));
                
                
                
            %>
            <table>
                <tr>
                    <td>Roll No</td>
                    <td><input type="text" value ="<%=student.getRollNo()%>" name="rollNo" readonly/></td>
                </tr>
                <tr>
                    <td>Full Name</td>
                    <td><input type="text" value ="<%=student.getFullname()%>" required name="fullName"/></td>
                </tr>
                <tr>
                    <td>Birthday</td>
                    <td><input type="text" value ="<%=student.getBirthday()%>" required name="birthday"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" value ="<%=student.getEmail()%>" required name="email"/></td>
                </tr>
                <tr>                    
                    <td><input type="submit" value="Submit Query" ></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
            </table> 
            <a href="./index.jsp" >Back to List</a>
        </form>
        <%
            }
            String rollNo = request.getParameter("rollNo");
            String fullName = request.getParameter("fullName");
            String birthday = request.getParameter("birthday");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
                String format = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
GregorianCalendar cal = new GregorianCalendar();
     cal.setTime(new SimpleDateFormat(format).parse(birthday));
     XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar( cal);
            try{            
            Student studentupdate = port.update(rollNo, fullName, gender, email, calendar);
            }catch(Exception e){
                System.err.println(""+e.toString());
            }
        %>
    </body>
</html>
