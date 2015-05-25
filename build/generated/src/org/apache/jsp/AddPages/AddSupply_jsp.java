package org.apache.jsp.AddPages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import MODEL.ReferenceModel;
import java.util.LinkedList;
import DAO.ReferenceDAO;

public final class AddSupply_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Supply</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            ReferenceDAO dao = new ReferenceDAO();
            LinkedList<ReferenceModel> list = dao.getPharmacy();
        
      out.write("\n");
      out.write("        <form method=\"POST\" action=\"../AddSupplyServlet\">\n");
      out.write("            Supply Name: <input type=\"text\" name=\"supplyName\"/>\n");
      out.write("            <br>\n");
      out.write("            Supply Amount: <input type=\"number\" name=\"supplyAmount\"/>\n");
      out.write("            <br>\n");
      out.write("            Hospital: <select name=\"hospital\">\n");
      out.write("            ");

                for(int ctr=0; ctr<list.size(); ctr++){
                    out.println("<option value="+list.get(ctr).getReferenceID()+">"+list.get(ctr).getReferenceName()+"</option>");
                }
            
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <br>\n");
      out.write("            <button type=\"submit\"/>Submit\n");
      out.write("        </form>\n");
      out.write("        \n");
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
