/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVLET;

import DAO.AdmittanceDAO;
import MODEL.AdmittanceModel;
import MODEL.ConsentStatusModel;
import MODEL.EmergencyContactModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Unfinished
 */
public class AddAdmittanceServlet extends HttpServlet {

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
            int age;
            AdmittanceModel model = new AdmittanceModel();
            ConsentStatusModel consentModel = new ConsentStatusModel();
            EmergencyContactModel contactModel = new EmergencyContactModel();
            LinkedList<EmergencyContactModel> emergencyContacts = new LinkedList<>();
            LinkedList<String> allergy = new LinkedList<>();
            AdmittanceDAO dao = new AdmittanceDAO();
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/./rome.jsp");
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            
            try{
            model.setFirstName(request.getParameter("firstName"));
            model.setLastName(request.getParameter("lastName"));
            model.setNickName(request.getParameter("nickName"));
            model.setDateOfBirth(new java.sql.Date(sd.parse(request.getParameter("dateOfBirth")).getTime()));
            model.setSocialSecurityNumber(Integer.parseInt(request.getParameter("sss")));
            model.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
            model.setCivilStatus(request.getParameter("civilStatus"));
            age = Integer.parseInt(request.getParameter("age"));
            model.setAge(age);
            model.setInsuranceType(Integer.parseInt(request.getParameter("insuranceType")));
            model.setInsuranceNumber(Integer.parseInt(request.getParameter("insuranceNumber")));
            model.setPrimaryDoctor(request.getParameter("primaryDoctor"));
            model.setDoctorPhoneNumber(Integer.parseInt(request.getParameter("doctorNumber")));
            model.setDengueLevel(Integer.parseInt(request.getParameter("dengueLevel")));
            model.setDateFiled(new java.sql.Date(new java.util.Date().getTime()));
            
            contactModel.setFirstName(request.getParameter("emergencyFirstName"));
            contactModel.setLastName(request.getParameter("emergencyLastName"));
            contactModel.setPrimaryPhoneNumber(Long.parseLong(request.getParameter("emergencyPrimaryNumber")));
            contactModel.setSecondaryPhoneNumber(Long.parseLong(request.getParameter("emergencySecondaryNumber")));
            contactModel.setRelationship(request.getParameter("emergencyRelationship"));
            model.setEmergencyContact(contactModel);
            
            allergy.add(request.getParameter("allergy"));
            model.setAllergies(allergy);
                    
            //Fucking consent status is here
            if(age>18){
                consentModel.setConsentStatus("1");
                consentModel.setLegalGuardian(request.getParameter("legalGuardian"));
                consentModel.setGuardianNumber(Integer.parseInt(request.getParameter("guardianNumber")));
            }else
                consentModel.setConsentStatus("0");
            
            model.setConsentStatus(consentModel);   
            model.setAddress(request.getParameter("address"));
            model.setReleaseInfo(Integer.parseInt(request.getParameter("releaseInfo")));
            model.setIncidentReport(request.getParameter("incidentReport"));
            model.setIncidentLocation(request.getParameter("incidentLocation"));
            //Remember to access session to know from which hospital
            model.setHospital((request.getSession().getAttribute("hospitalID").toString()));
            
            if(dao.addAdmittance(model)){
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
