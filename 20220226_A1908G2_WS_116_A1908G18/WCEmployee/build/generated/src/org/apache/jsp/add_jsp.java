package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import client.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <centre>\n");
      out.write("        <h1 style=\"color: red;\">Hello World!</h1>\n");
      out.write("        <form method=\"post\" action=\"./index.jsp\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Employee No</td>\n");
      out.write("                    <td><input type=\"text\" name=\"rollNo\"/></td>\n");
      out.write("                    <td><p style=\"color: red;\">");
 if(request.getAttribute("mustRollNo") != null){ out.print("You must input employee number");} 
      out.write("</p></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Name</td>\n");
      out.write("                    <td><input type=\"text\" name=\"name\"/></td>\n");
      out.write("                    <td><p style=\"color: red;\">");
 if(request.getAttribute("mustRollNo") != null){ out.print("You must input employee name");} 
      out.write("</p></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Place of Work</td>\n");
      out.write("                    <td><input type=\"text\" name=\"placeofwork\"/></td>\n");
      out.write("                    <td><p style=\"color: red;\">");
 if(request.getAttribute("mustRollNo") != null){ out.print("You must input place of work");} 
      out.write("</p></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Phone No</td>\n");
      out.write("                    <td><input type=\"text\" name=\"phoneno\"/></td>\n");
      out.write("                    <td><p style=\"color: red;\">");
 if(request.getAttribute("mustRollNo") != null){ out.print("You must input phone no");} 
      out.write("</p></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"submit\" value=\"Submit Query\"></td>\n");
      out.write("                    <td><input type=\"reset\" value=\"Reset\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        <a href=\"./index.jsp\">back To List</a>\n");
      out.write("    </centre>\n");
      out.write("      \n");
      out.write("                        </body>\n");
      out.write("                        </html>\n");
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
