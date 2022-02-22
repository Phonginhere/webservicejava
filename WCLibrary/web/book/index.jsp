<%-- 
    Document   : index
    Created on : Feb 22, 2022, 8:48:38 AM
    Author     : Phong_learning
--%>

<%@page import="services.book.Book"%>
<%@page import="services.book.BookWebService"%>
<%@page import="services.book.BookWebService_Service"%>
<%@page import="java.util.List"%>
<%@page import="services.bookservice.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <table border="1">
        <tr>
          <th>Book Name</th>
          <th>Price</th>
          <th>Delivered Date</th>
          <th>NickName</th>
          <th>Factory</th>
          <th>Author Name</th>
          <th>Action</th>
        </tr>
         <%
            //call service, like WCF trong C#
            
            BookWebService_Service service = new BookWebService_Service();
            BookWebService port = service.getBookWebServicePort();
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
            List<Book> books = port.findAll1();
            for(Book book: books) {
                out.println("<tr>");
                out.println("<td>"+book.getBookName()+"</td>");
                out.println("<td>"+book.getPrice()+"</td>");
                out.println("<td>"+book.getDeliveredDate()+"</td>");
                out.println("<td>"+book.getNickname()+"</td>");
                out.println("<td>"+book.getFactory()+"</td>");
                out.println("<td>"+book.getAuthorId().getAuthorName()+"</td>");
                out.println("<td><a href='./index.jsp?deleteEmployeeNo="
                        +book.getId()+"'>Delete</td>");
                out.println("</tr>");                
            }
            
        %>        
      </table>
    </body>
</html>
