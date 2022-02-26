<%-- 
    Document   : add
    Created on : Feb 26, 2022, 8:29:42 AM
    Author     : Phong_learning
--%>
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
        <h1 style="color: red;">Hello World!</h1>
        <form method="GET">
            <table>
                <tr>
                    <td>Employee No</td>
                    <td><input type="text" name="rollNo"/></td>
                    <td><p style="color: red;"><% if(request.getAttribute("mustRollNo") != null){ out.print("You must input employee number");} %></p></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"/></td>
                    <td><p style="color: red;"><% if(request.getAttribute("mustRollNo") != null){ out.print("You must input employee name");} %></p></td>
                </tr>
                <tr>
                    <td>Place of Work</td>
                    <td><input type="text" name="placeofwork"/></td>
                    <td><p style="color: red;"><% if(request.getAttribute("mustRollNo") != null){ out.print("You must input place of work");} %></p></td>
                </tr>
                <tr>
                    <td>Phone No</td>
                    <td><input type="text" name="phoneno"/></td>
                    <td><p style="color: red;"><% if(request.getAttribute("mustRollNo") != null){ out.print("You must input phone no");} %></p></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit Query"></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
            </table>
        </form>
        <a href="./index.jsp">back To List</a>
    </centre>
       <% 
           EmployeeWebService_Service service = new EmployeeWebService_Service();
           EmployeeWebService port = service.getEmployeeWebServicePort();
            String employeeNo = request.getParameter("rollNo");
            String employeeName = request.getParameter("name");
            String placeOfWork = request.getParameter("placeofwork");
            String phoneno = request.getParameter("phoneno");
            if(employeeNo == null){
                request.setAttribute("mustRollNo", "missrollNo");
            }
            if(employeeName == null){
                request.setAttribute("mustName", "missName");
            }
            if(placeOfWork == null){
                request.setAttribute("mustPlaceofwork", "missPlaceofwork");
            }
            if(phoneno == null){
                request.setAttribute("mustpno", "misspno");
            }
            if(employeeNo != null && employeeName != null && placeOfWork != null && phoneno != null){
               try{
                //Employee employee = port.adding(rollNo, name, placeofwork, phoneno);
                port.adding(employeeNo, employeeName, placeOfWork, phoneno);
                 RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("/index.jsp");
                 dispatcher.forward(request, response);
               }catch(Exception e){
                   out.print("This employee is existed, please try other");
               }
            }
                        %>
                        </body>
                        </html>
