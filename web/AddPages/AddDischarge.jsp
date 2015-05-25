<%-- 
    Document   : AddDischarge
    Created on : 20-May-2015, 20:18:38
    Author     : Lester Chong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discharge </title>
    </head>
    <body>
        <form action="AddDischargeServlet" method="POST">
            First Name: <input type="text" name="firstName"/>
            <br>
            Last Name: <input type="text" name="lastName"/>
            <br>
            Attending Physician: <input type="text" name="attendingPhysician"/>
            <br>
            Room Number: <input type="number" name="roomNumber"/>
            <br>
            Patient Number: <input type="number" name="patientNumber"/>
            <br>
            Date of Admission: <input type="date" name="dateOfAdmission"/>
            <br>
            Date of Discharge: <input type="date" name="dateOfDischarge"/>
            <br>
            Provisional Diagnosis: <input type="text" name="provisionalDiagnosis"/>
            <br>
            Final Diagnosis: <input type="text" name="finalDiagnosis"/>
            <br>
            Brief History: <input type="text" name="briefHistory"/>
            <br>
            Patient and Laboratory Findings: <input type="text" name="findings"/>
            <br>
            Course of Treatment: <input type="text" name="courseOfTreatment"/>
            <br>
            Condition of Discharge: <input type="text" name="conditionOfDischarge"/>
            <br>
            Rehabilitation Potential: <input type="text" name="rehabPotential"/>
            <br>
            Follow-up and Discharge Medication: <input type="text" name="followUp"/>
            <br>
            Date: <input type="date" name="dateFiled"/>
            <br>
            Approved By: <input type="text" name="approvedBy"/>
            <br>
            <button type="submit"/>Submit
        </form>
    </body>
</html>
