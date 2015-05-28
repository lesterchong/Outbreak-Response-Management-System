/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DB.ConcreteConnection;
import DB.ConnectionFactory;
import MODEL.AdmittanceModel;
import MODEL.ConsentStatusModel;
import MODEL.EmergencyContactModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Lester Chong
 */
public class AdmittanceDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private ConnectionFactory cf;
    
    public LinkedList<AdmittanceModel> getAdmittances(){
        LinkedList<AdmittanceModel> admittances = new LinkedList<>();
        LinkedList<String> allergies;
        LinkedList<EmergencyContactModel> emergencyContacts;
        EmergencyContactModel temp;
        Connection con2;
        PreparedStatement ps2;
        ResultSet rs2;
        AdmittanceModel model;
        ConsentStatusModel consentModel;
        int admittanceID;
        
        try{
            cf = new ConcreteConnection();
            con = cf.getConnection();
            con2 = cf.getConnection();
            ps = con.prepareStatement("SELECT * FROM admittance ad, allergies al, consent_status cs, emergency_contact ec, ref_barangay rb, ref_hospital rh WHERE ad.admittanceID = al.admittanceID and ad.admittanceID = ec.admittanceID and rb.barangayID = ad.barangayID and rb.barangayID = ad.incidentLocation and ad.hospitalID = rh.hospitalID and ad.admittanceID = cs.admittanceID");
            rs = ps.executeQuery();
            while(rs.next()){
                model = new AdmittanceModel();
                consentModel = new ConsentStatusModel();
                allergies = new LinkedList<>();
                emergencyContacts = new LinkedList<>();
                
                model.setAdmittanceID(rs.getInt("admittanceID"));
                admittanceID = model.getAdmittanceID();
                
                model.setFirstName(rs.getString("firstName"));
                model.setLastName(rs.getString("lastName"));
                model.setNickName(rs.getString("nickName"));
                model.setDateOfBirth(rs.getDate("dateOfBirth"));
                model.setSocialSecurityNumber(rs.getInt("socialSecurityNumber"));
                model.setPhoneNumber(rs.getInt("phoneNumber"));
                model.setCivilStatus(rs.getString("civilStatusName"));
                model.setAge(rs.getInt("age"));
                model.setInsuranceType(rs.getInt("insuranceType"));
                model.setInsuranceNumber(rs.getInt("insuranceNumber"));
                model.setPrimaryDoctor(rs.getString("primaryDoctor"));
                model.setDoctorPhoneNumber(rs.getInt("doctorPhoneNumber"));
                model.setDengueLevel(rs.getInt("dengueLevel"));
                model.setReleaseInfo(rs.getInt("releaseInfo"));
                model.setIncidentReport(rs.getString("incidentReport"));
                model.setIncidentLocation(rs.getString("incidentLocation"));
                model.setAddress(rs.getString("barangayName"));
                model.setHospital(rs.getString("hospitalName"));
                
                //More complicated objects
                consentModel.setConsentStatusID(rs.getInt("consentStatusID"));
                consentModel.setConsentStatus(rs.getString("consentStatus"));
                if(Integer.parseInt(consentModel.getConsentStatus())==1){
                    consentModel.setLegalGuardian(rs.getString("legalGuardian"));
                    consentModel.setGuardianNumber(rs.getInt("guardianPhone"));
                }else if(Integer.parseInt(consentModel.getConsentStatus())==2){
                    consentModel.setDecisionMaker(rs.getString("decisionMaker"));
                    consentModel.setDecisionNumber(rs.getInt("decisionPhone"));
                    consentModel.setMedicalPOA("medicalPOA");
                    consentModel.setMedicalNumber(rs.getInt("medicalNumber"));
                }
                model.setConsentStatus(consentModel);
                
                ps2 = con2.prepareStatement("SELECT * FROM allergies a WHERE a.admittanceID = ?");
                ps2.setInt(1, admittanceID);
                rs2 = ps2.executeQuery();
                while(rs2.next()){
                    allergies.add(rs.getString("allergyName"));
                }
                model.setAllergies(allergies);
                
                ps2 = con2.prepareStatement("SELECT * FROM emergency_contact ec WHERE ec.admittanceID = ?");
                ps.setInt(1, admittanceID);
                rs2 = ps2.executeQuery();
                while(rs2.next()){
                    temp = new EmergencyContactModel();
                    temp.setEmergencyContactID(rs.getInt("emergencyContactID"));
                    temp.setFirstName(rs.getString("firstName"));
                    temp.setLastName(rs.getString("lastName"));
                    temp.setPrimaryPhoneNumber(rs.getInt("primaryPhoneNumber"));
                    temp.setSecondaryPhoneNumber(rs.getInt("secondaryPhoneNumber"));
                    temp.setRelationship(rs.getString("relationship"));
                    emergencyContacts.add(temp);
                }
                model.setEmergencyContact(emergencyContacts);
                
                admittances.add(model);
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return admittances;
    }
    
    public boolean addAdmittance(AdmittanceModel model){
        int admittanceID;
        
        try{
            cf = new ConcreteConnection();
            con = cf.getConnection();
            ps = con.prepareStatement("INSERT INTO admittance(firstName, lastName, nickName, dateOfBirth, socialSecurityNumber, phoneNumber, civilStatusID, age, insuranceType, insuranceNumber, primaryDoctor, doctorPhoneNumber, dengueLevel, releaseInfo, incidentReport, incidentLocation, barangayID, hospitalID, dateFiled) VALUES(?, ? , ?, ?, ?, ?, ? , ?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setString(3, model.getNickName());
            ps.setDate(4, model.getDateOfBirth());
            ps.setInt(5, (int)model.getSocialSecurityNumber());
            ps.setInt(6, (int)model.getPhoneNumber());
            ps.setInt(7, Integer.parseInt(model.getCivilStatus()));
            ps.setInt(8, model.getAge());
            ps.setInt(9, model.getInsuranceType());
            ps.setInt(10, model.getInsuranceNumber());
            ps.setString(11, model.getPrimaryDoctor());
            ps.setInt(12, (int)model.getDoctorPhoneNumber());
            ps.setInt(13, model.getDengueLevel());
            ps.setInt(14, model.getReleaseInfo());
            ps.setString(15, model.getIncidentReport());
            ps.setInt(16, Integer.parseInt(model.getIncidentLocation()));
            ps.setInt(17, Integer.parseInt(model.getAddress()));
            ps.setInt(18, Integer.parseInt(model.getHospital()));
            ps.setDate(19, model.getDateFiled());
            ps.executeUpdate();
            
            ps = con.prepareStatement("SELECT LAST_INSERT_ID()");
            rs = ps.executeQuery();
            rs.next();
            admittanceID = rs.getInt(1);
            
            ps = con.prepareStatement("INSERT INTO consent_status(admittanceID, consentStatus, legalGuardian, guardianPhone, decisionMaker, decisionPhone, medicalPOA, medicalNumber) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, admittanceID);
            ps.setInt(2, Integer.parseInt(model.getConsentStatus().getConsentStatus()));
            ps.setString(3, model.getConsentStatus().getLegalGuardian());
            ps.setInt(4, (int)model.getConsentStatus().getGuardianNumber());
            ps.setString(5, model.getConsentStatus().getDecisionMaker());
            ps.setInt(6, (int)model.getConsentStatus().getDecisionNumber());
            ps.setString(7, model.getConsentStatus().getMedicalPOA());
            ps.setInt(8, (int)model.getConsentStatus().getMedicalNumber());
            ps.executeUpdate();
            
            ps = con.prepareStatement("INSERT INTO allergies(admittanceID, allergyName) VALUES(?, ?)");
            for(int ctr=0; ctr<model.getAllergies().size(); ctr++){
                ps.setInt(1, admittanceID);
                ps.setString(2, model.getAllergies().get(ctr));
                ps.executeUpdate();
            }
                
            ps = con.prepareStatement("INSERT INTO emergency_contact(firstName, lastName, primaryPhoneNumber, secondaryPhoneNumber, relationship, admittanceID) VALUES(?, ?, ?, ?, ?, ?)");
            for(int ctr=0; ctr<model.getEmergencyContact().size(); ctr++){
                ps.setString(1, model.getEmergencyContact().get(ctr).getFirstName());
                ps.setString(2, model.getEmergencyContact().get(ctr).getLastName());
                ps.setInt(3, (int)model.getEmergencyContact().get(ctr).getPrimaryPhoneNumber());
                ps.setInt(4, (int)model.getEmergencyContact().get(ctr).getSecondaryPhoneNumber());
                ps.setString(5, model.getEmergencyContact().get(ctr).getRelationship());
                ps.setInt(6, admittanceID);
                ps.executeUpdate();
            }
            con.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public int getPatientCountByHospital(int hospitalID){
        int temp=0;
        try{
            cf = new ConcreteConnection();
            con = cf.getConnection();
            ps = con.prepareStatement("SELECT COUNT(admittanceID) AS patientcount FROM admittance ad, ref_hospital rh WHERE ad.hospitalID = ?");
            ps.setInt(1, hospitalID);
            rs = ps.executeQuery();
            rs.next();
            temp = rs.getInt("patientcount");
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return temp;
    }
    
    public boolean deleteAdmittance(int admittanceID){
        cf = new ConcreteConnection();
        
        try{
            con = cf.getConnection();
            ps = con.prepareStatement("DELETE FROM admittance WHERE admittanceID = ?");
            ps.setInt(1, admittanceID);
            ps.executeUpdate();
            con.close();
            return true;
        }catch(SQLException e){

        }
        return true;
    }
    
    public LinkedList<AdmittanceModel> getAdmittancesByHospital(int hospitalID){
        LinkedList<AdmittanceModel> admittances = new LinkedList<>();
        LinkedList<String> allergies;
        LinkedList<EmergencyContactModel> emergencyContacts;
        EmergencyContactModel temp;
        Connection con2;
        PreparedStatement ps2;
        ResultSet rs2;
        AdmittanceModel model;
        ConsentStatusModel consentModel;
        int admittanceID;
        
        try{
            cf = new ConcreteConnection();
            con = cf.getConnection();
            con2 = cf.getConnection();
            ps = con.prepareStatement("SELECT * FROM admittance ad, allergies al, consent_status cs, emergency_contact ec, ref_barangay rb, ref_hospital rh WHERE ad.admittanceID = al.admittanceID and ad.admittanceID = cs.admittanceID and ad.admittanceID = ec.admittanceID and rb.barangayID = ad.barangayID and rb.barangayID = ad.incidentLocation and ad.hospitalID = rh.hospitalID and ad.hospitalID = ?");
            ps.setInt(1, hospitalID);
            rs = ps.executeQuery();
            while(rs.next()){
                model = new AdmittanceModel();
                consentModel = new ConsentStatusModel();
                allergies = new LinkedList<>();
                emergencyContacts = new LinkedList<>();
                
                model.setAdmittanceID(rs.getInt("admittanceID"));
                admittanceID = model.getAdmittanceID();
                
                model.setFirstName(rs.getString("firstName"));
                model.setLastName(rs.getString("lastName"));
                model.setNickName(rs.getString("nickName"));
                model.setDateOfBirth(rs.getDate("dateOfBirth"));
                model.setSocialSecurityNumber(rs.getInt("socialSecurityNumber"));
                model.setPhoneNumber(rs.getInt("phoneNumber"));
                model.setCivilStatus(rs.getString("civilStatusName"));
                model.setAge(rs.getInt("age"));
                model.setInsuranceType(rs.getInt("insuranceType"));
                model.setInsuranceNumber(rs.getInt("insuranceNumber"));
                model.setPrimaryDoctor(rs.getString("primaryDoctor"));
                model.setDoctorPhoneNumber(rs.getInt("doctorPhoneNumber"));
                model.setDengueLevel(rs.getInt("dengueLevel"));
                model.setReleaseInfo(rs.getInt("releaseInfo"));
                model.setIncidentReport(rs.getString("incidentReport"));
                model.setIncidentLocation(rs.getString("incidentLocation"));
                model.setAddress(rs.getString("barangayName"));
                model.setHospital(rs.getString("hospitalName"));
                model.setDateFiled(rs.getDate("dateFiled"));
                
                //More complicated objects
                consentModel.setConsentStatusID(rs.getInt("consentStatusID"));
                consentModel.setConsentStatus(rs.getString("consentStatus"));
                if(Integer.parseInt(consentModel.getConsentStatus())==1){
                    consentModel.setLegalGuardian(rs.getString("legalGuardian"));
                    consentModel.setGuardianNumber(rs.getInt("guardianPhone"));
                }else if(Integer.parseInt(consentModel.getConsentStatus())==2){
                    consentModel.setDecisionMaker(rs.getString("decisionMaker"));
                    consentModel.setDecisionNumber(rs.getInt("decisionPhone"));
                    consentModel.setMedicalPOA("medicalPOA");
                    consentModel.setMedicalNumber(rs.getInt("medicalNumber"));
                }
                model.setConsentStatus(consentModel);
                
                ps2 = con2.prepareStatement("SELECT * FROM allergies a WHERE a.admittanceID = ?");
                ps2.setInt(1, admittanceID);
                rs2 = ps2.executeQuery();
                while(rs2.next()){
                    allergies.add(rs.getString("allergyName"));
                }
                model.setAllergies(allergies);
                
                ps2 = con2.prepareStatement("SELECT * FROM emergency_contact ec WHERE ec.admittanceID = ?");
                ps.setInt(1, admittanceID);
                rs2 = ps2.executeQuery();
                while(rs2.next()){
                    temp = new EmergencyContactModel();
                    temp.setEmergencyContactID(rs.getInt("emergencyContactID"));
                    temp.setFirstName(rs.getString("firstName"));
                    temp.setLastName(rs.getString("lastName"));
                    temp.setPrimaryPhoneNumber(rs.getInt("primaryPhoneNumber"));
                    temp.setSecondaryPhoneNumber(rs.getInt("secondaryPhoneNumber"));
                    temp.setRelationship(rs.getString("relationship"));
                    emergencyContacts.add(temp);
                }
                model.setEmergencyContact(emergencyContacts);
                
                admittances.add(model);
            }
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return admittances;
    }
    
    public AdmittanceModel getAdmittanceByID(int id){
        LinkedList<AdmittanceModel> list = getAdmittances();
        for(int ctr=0; ctr<list.size(); ctr++){
            if(list.get(ctr).getAdmittanceID()==1)
                return list.get(ctr);
        }
        return null;
    }
}
