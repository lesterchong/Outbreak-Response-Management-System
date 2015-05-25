package org.apache.jsp.AddPages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import MODEL.AdmittanceModel;
import java.util.LinkedList;
import DAO.AdmittanceDAO;

public final class AddDischarge_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Discharge </title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            AdmittanceDAO dao = new AdmittanceDAO();
            LinkedList<AdmittanceModel> list = dao.getAdmittances();
        
      out.write("\n");
      out.write("        <form action=\"AddDischargeServlet\" method=\"POST\">\n");
      out.write("            Patient: <select name=\"patient\">\n");
      out.write("                ");

                    for(int ctr=0; ctr<list.size(); ctr++){
                        out.println("<option value="+list.get(ctr).getAdmittanceID()+">"+list.get(ctr).getLastName()+","+list.get(ctr).getFirstName()+"</option>");
                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <br>\n");
      out.write("            Room Number: <input type=\"number\" name=\"roomNumber\"/>\n");
      out.write("            <br>\n");
      out.write("            Date of Discharge: <input type=\"date\" name=\"dateOfDischarge\"/>\n");
      out.write("            <br>\n");
      out.write("            Provisional Diagnosis: <input type=\"text\" name=\"provisionalDiagnosis\"/>\n");
      out.write("            <br>\n");
      out.write("            Final Diagnosis: <input type=\"text\" name=\"finalDiagnosis\"/>\n");
      out.write("            <br>\n");
      out.write("            Brief History: <input type=\"text\" name=\"briefHistory\"/>\n");
      out.write("            <br>\n");
      out.write("            Patient and Laboratory Findings: <input type=\"text\" name=\"findings\"/>\n");
      out.write("            <br>\n");
      out.write("            Course of Treatment: <input type=\"text\" name=\"courseOfTreatment\"/>\n");
      out.write("            <br>\n");
      out.write("            Condition of Discharge: <input type=\"text\" name=\"conditionOfDischarge\"/>\n");
      out.write("            <br>\n");
      out.write("            Rehabilitation Potential: <input type=\"text\" name=\"rehabPotential\"/>\n");
      out.write("            <br>\n");
      out.write("            Follow-up and Discharge Medication: <input type=\"text\" name=\"followUp\"/>\n");
      out.write("            <br>\n");
      out.write("            Approved By: <input type=\"text\" name=\"approvedBy\"/>\n");
      out.write("            <br>\n");
      out.write("            <button type=\"submit\"/>Submit\n");
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
