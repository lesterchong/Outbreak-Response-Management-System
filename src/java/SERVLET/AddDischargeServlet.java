/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVLET;

import DAO.DischargeDAO;
import MODEL.DischargeModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lester Chong
 */
public class AddDischargeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DischargeDAO dao = new DischargeDAO();
            DischargeModel model = new DischargeModel();
            SimpleDateFormat sd = new SimpleDateFormat();
            RequestDispatcher rd = getServletContext().getRequestDispatcher(null);
            
            try{
                model.setFirstName(request.getParameter("firstName"));
                model.setLastName(request.getParameter("lastName"));
                model.setAttendingPhysician(request.getParameter("attendingPhysician"));
                model.setRoomNumber(Integer.parseInt(request.getParameter("roomNumber")));
                model.setPatientNumber(Integer.parseInt(request.getParameter("patientNumber")));
                model.setDateOfAdmission(new java.sql.Date(sd.parse(request.getParameter("dateOfAdmission")).getTime()));
                model.setDateOfDischarge(new java.sql.Date(sd.parse(request.getParameter("dateOfDischarge")).getTime()));
                model.setProvisionalDiagnosis(request.getParameter("provisionalDiagnosis"));
                model.setFinalDiagnosis(request.getParameter("finalDiagnosis"));
                model.setBriefHistory(request.getParameter("briefHistory"));
                model.setFindings(request.getParameter("findings"));
                model.setCourseOfTreatment(request.getParameter("courseOfTreatment"));
                model.setDischargeCondition(request.getParameter("conditonOfDischarge"));
                model.setRehabPotential(request.getParameter("rehabPotential"));
                model.setFollowUp(request.getParameter("followUp"));
                model.setDateFiled(new java.sql.Date(new java.util.Date().getTime()));
                model.setApprovedBy(request.getParameter("approvedBy"));
                
                if(dao.addDischarge(model)){
                    out.printf("<script>alert(\"Successfully Updated\")</script>");
                    rd.include(request, response);
                    return;
                }else{
                    rd = getServletContext().getRequestDispatcher("/./AddPages/AddAdmittance.jsp");
                    out.printf("<script>alert(\"Error\")</script>");
                    rd.include(request, response);
                    return;
                }
            }catch(ParseException e){
                e.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
