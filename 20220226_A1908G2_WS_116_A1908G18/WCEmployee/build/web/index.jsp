<%-- 
    Document   : index
    Created on : Feb 26, 2022, 8:29:21 AM
    Author     : Phong_learning
--%>

<%@page import="java.util.List"%>
<%@page import="client.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <centre>
        <h1>Employee Information</h1>
        <table border="1">
            <tr>
                <th><b>Employee No</b></th>
                <th><b>Name</b></th>
                <th><b>Place of Work</b></th>
                <th><b>Phone No</b></th>
                <th><b>Delete</b></th>
            </tr>
            <%
                EmployeeWebService_Service service = new EmployeeWebService_Service();
                EmployeeWebService port = service.getEmployeeWebServicePort();
                String deleteEmployeeNo = request.getParameter("deleteEmployeeNo");
                if (deleteEmployeeNo != null) {
                    port.deleting(deleteEmployeeNo);
                }
                List<Employee> employees = port.gettingAll();
                for (Employee employee : employees) {
                    out.println("<tr>");
                    out.println("<td>" + employee.getEmployeeNo() + "</td>");
                    out.println("<td>" + employee.getEmployeeName() + "</td>");
                    out.println("<td>" + employee.getPlaceOfWork() + "</td>");
                    out.println("<td>" + employee.getPhoneNo() + "</td>");
                    out.println("<td> <a href='?deleteEmployeeNo=" + employee.getEmployeeNo() + "'>Delete</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <a href="./add.jsp">Add New</a>
    </centre>



</body>
</html>
