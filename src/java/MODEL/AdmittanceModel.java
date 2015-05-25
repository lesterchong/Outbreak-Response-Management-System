/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODEL;

import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author Lester Chong
 */
public class AdmittanceModel {
    private int admittanceID;
    private String lastName;
    private String firstName;
    private String nickName;
    private Date dateOfBirth;
    private long socialSecurityNumber;
    private long phoneNumber;
    private String civilStatus;
    private int age;
    private int insuranceType;
    private int insuranceNumber;
    private String primaryDoctor;
    private long doctorPhoneNumber;
    private int dengueLevel;
    private ConsentStatusModel consentStatus;
    private int releaseInfo;
    private String incidentReport;
    private String incidentLocation;
    private String address;
    private LinkedList<String> allergies;
    private LinkedList<EmergencyContactModel> emergencyContact;
    private String hospital;

    /**
     * @return the admittanceID
     */
    public int getAdmittanceID() {
        return admittanceID;
    }

    /**
     * @param admittanceID the admittanceID to set
     */
    public void setAdmittanceID(int admittanceID) {
        this.admittanceID = admittanceID;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the socialSecurityNumber
     */
    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * @param socialSecurityNumber the socialSecurityNumber to set
     */
    public void setSocialSecurityNumber(long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * @return the phoneNumber
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the civilStatus
     */
    public String getCivilStatus() {
        return civilStatus;
    }

    /**
     * @param civilStatus the civilStatus to set
     */
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the insuranceType
     */
    public int getInsuranceType() {
        return insuranceType;
    }

    /**
     * @param insuranceType the insuranceType to set
     */
    public void setInsuranceType(int insuranceType) {
        this.insuranceType = insuranceType;
    }

    /**
     * @return the insuranceNumber
     */
    public int getInsuranceNumber() {
        return insuranceNumber;
    }

    /**
     * @param insuranceNumber the insuranceNumber to set
     */
    public void setInsuranceNumber(int insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    /**
     * @return the primaryDoctor
     */
    public String getPrimaryDoctor() {
        return primaryDoctor;
    }

    /**
     * @param primaryDoctor the primaryDoctor to set
     */
    public void setPrimaryDoctor(String primaryDoctor) {
        this.primaryDoctor = primaryDoctor;
    }

    /**
     * @return the doctorPhoneNumber
     */
    public long getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    /**
     * @param doctorPhoneNumber the doctorPhoneNumber to set
     */
    public void setDoctorPhoneNumber(long doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    /**
     * @return the dengueLevel
     */
    public int getDengueLevel() {
        return dengueLevel;
    }

    /**
     * @param dengueLevel the dengueLevel to set
     */
    public void setDengueLevel(int dengueLevel) {
        this.dengueLevel = dengueLevel;
    }

    /**
     * @return the consentStatus
     */
    public ConsentStatusModel getConsentStatus() {
        return consentStatus;
    }

    /**
     * @param consentStatus the consentStatus to set
     */
    public void setConsentStatus(ConsentStatusModel consentStatus) {
        this.consentStatus = consentStatus;
    }

    /**
     * @return the releaseInfo
     */
    public int getReleaseInfo() {
        return releaseInfo;
    }

    /**
     * @param releaseInfo the releaseInfo to set
     */
    public void setReleaseInfo(int releaseInfo) {
        this.releaseInfo = releaseInfo;
    }

    /**
     * @return the incidentReport
     */
    public String getIncidentReport() {
        return incidentReport;
    }

    /**
     * @param incidentReport the incidentReport to set
     */
    public void setIncidentReport(String incidentReport) {
        this.incidentReport = incidentReport;
    }

    /**
     * @return the incidentLocation
     */
    public String getIncidentLocation() {
        return incidentLocation;
    }

    /**
     * @param incidentLocation the incidentLocation to set
     */
    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the allergies
     */
    public LinkedList<String> getAllergies() {
        return allergies;
    }

    /**
     * @param allergies the allergies to set
     */
    public void setAllergies(LinkedList<String> allergies) {
        this.allergies = allergies;
    }

    /**
     * @return the emergencyContact
     */
    public LinkedList<EmergencyContactModel> getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * @param emergencyContact the emergencyContact to set
     */
    public void setEmergencyContact(LinkedList<EmergencyContactModel> emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    /**
     * @return the hospitalID
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * @param hospital the hospitalID to set
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
