<%-- 
    Document   : index
    Created on : Feb 12, 2022, 8:58:18 AM
    Author     : Phong_learning
--%>

<%@page import="services.Tblemployee"%>
<%@page import="java.util.List"%>
<%@page import="services.EmployeeWS"%>
<%@page import="services.EmployeeWS_Service"%>
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
            EmployeeWS_Service service = new EmployeeWS_Service();
            EmployeeWS port = service.getEmployeeWSPort();
            List<Tblemployee> employees = port.findAll();
            System.err.println("haha");
            
            for(Tblemployee employee: employees) {
                out.println(employee.getEmployeeName());
            }
        %>
    </body>
</html>
