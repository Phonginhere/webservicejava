<%-- 
    Document   : index
    Created on : Feb 22, 2022, 8:35:44 AM
    Author     : Phong_learning
--%>

<%@page import="services.Author"%>
<%@page import="java.util.List"%>
<%@page import="services.AuthorWebService_Service"%>
<%@page import="services.AuthorWebService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form>
            <table>
                <tr>
                    <th> <input type="text" name="authorName" placeholder="Tac Gia"></th>
                    <th><input type="submit" value="Nut tim kiem"></th>
                    <th><input type="button" value="Them Tac gia"></th>
                </tr>
                <tr>
                <input type="text" name="authorName" placeholder="Ten sach" size="35">
                <input type="button" value="Nut them sach">
                </tr>
                <tr>
                <input type="text" name="authorName" placeholder="Gia tien">
                <input type="button" value="Nut xoa sach">
                </tr>
                <tr>
                <input type="text" name="authorName" placeholder="Nha San Xuat" size="35">
                <input type="button" value="Gui">
                </tr>
            </table>





        </form>
        <table border="1">
            <tr>
                <th>Author Name</th>
                <th>Birth Day</th>
                <th>Address</th>
                <th>NickName</th>
                <th>Action</th>
            </tr>
            <%
                //call service, like WCF trong C#

                AuthorWebService_Service service = new AuthorWebService_Service();
                AuthorWebService port = service.getAuthorWebServicePort();
                /*
               String deleteEmployeeNo = request.getParameter("deleteEmployeeNo");
               if(deleteEmployeeNo != null) {
                   try {
                       port.deleteEmployee(deleteEmployeeNo);
                   } catch(Exception e) {
                       System.err.println("dsjhjds");
                   }
               } 
                 */
                List<Author> authors = port.findAll();
                for (Author author : authors) {
                    out.println("<tr>");
                    out.println("<td>" + author.getAuthorName() + "</td>");
                    out.println("<td>" + author.getBirthday() + "</td>");
                    out.println("<td>" + author.getAddress() + "</td>");
                    out.println("<td>" + author.getNickname() + "</td>");
                    out.println("<td><a href='./update.jsp?deleteEmployeeNo="
                            + author.getAuthorId() + "'>Update</td>");
                    out.println("<td><a href='./index.jsp?deleteEmployeeNo="
                            + author.getAuthorId() + "'>Delete</td>");
                    out.println("</tr>");
                }

            %>        
        </table>
    </body>
</html>
