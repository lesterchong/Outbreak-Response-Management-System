package org.apache.jsp.AddPages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddAdmittance_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Add Admittance</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"POST\" action=\"\">            \n");
      out.write("            First Name: <input type='text' name='firstName'/>\n");
      out.write("            <br>\n");
      out.write("            Last Name: <input type='text' name='lastName'/>\n");
      out.write("            <br>\n");
      out.write("            Nickname: <input type='text' name='nickName'/>\n");
      out.write("            <br>\n");
      out.write("            Date Of Birth: <input type='date' name='dateOfBirth'/>\n");
      out.write("            <br>\n");
      out.write("            SSS: <input type='number' name='sss'/>\n");
      out.write("            <br>\n");
      out.write("            Address: <input type='text' name='address'/>\n");
      out.write("            <br>\n");
      out.write("            Phone Number: <input type='number' name='phoneNumber'/>\n");
      out.write("            <br>\n");
      out.write("            Allergies: Increment as needed \n");
      out.write("            <br>\n");
      out.write("            Civil Status: <select name='civilStatus'/>\n");
      out.write("            <br>\n");
      out.write("            Age: <input type='number' name='age'/>\n");
      out.write("            <br>\n");
      out.write("            Primary Doctor: <input type='text' name='primaryDoctor'/>\n");
      out.write("            <br>\n");
      out.write("            Phone Number: <input type='number' name='doctorNumber'/>\n");
      out.write("            <br>\n");
      out.write("            Dengue Level: Limit number field 1-4\n");
      out.write("            <br>\n");
      out.write("            Consent for Release of Information:\n");
      out.write("            <br>\n");
      out.write("            Incident Report: <input type='text' name='incidentReport'/>\n");
      out.write("            <br>\n");
      out.write("            Incident Location: <select name='incidentLocation'/>\n");
      out.write("            <br>\n");
      out.write("            <button type=\"submit\">Submit</button>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
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
