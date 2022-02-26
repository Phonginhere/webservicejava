package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import client.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <centre>\n");
      out.write("        <h1>Employee Information</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th><b>Employee No</b></th>\n");
      out.write("                <th><b>Name</b></th>\n");
      out.write("                <th><b>Place of Work</b></th>\n");
      out.write("                <th><b>Phone No</b></th>\n");
      out.write("                <th><b>Delete</b></th>\n");
      out.write("            </tr>\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <a href=\"./add.jsp\">Add New</a>\n");
      out.write("    </centre>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
