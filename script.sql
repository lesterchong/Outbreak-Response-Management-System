-- MySQL dump 10.13  Distrib 5.6.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: outbreakresponsemanagement
-- ------------------------------------------------------
-- Server version	5.1.72-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `admittanceID` int(11) NOT NULL,
  `streetName` varchar(45) DEFAULT NULL,
  `barangayID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admittance`
--

DROP TABLE IF EXISTS `admittance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admittance` (
  `admittanceID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `nickName` varchar(45) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `socialSecurityNumber` int(11) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `civilStatusID` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `insuranceType` int(1) DEFAULT NULL,
  `insuranceNumber` int(11) DEFAULT NULL,
  `primaryDoctor` varchar(45) DEFAULT NULL,
  `doctorPhoneNumber` int(11) DEFAULT NULL,
  `dengueLevel` int(3) DEFAULT NULL,
  `consentStatusID` int(11) DEFAULT NULL,
  `releaseInfo` int(1) DEFAULT NULL,
  `incidentReport` varchar(45) DEFAULT NULL,
  `incidentLocation` int(11) DEFAULT NULL,
  `barangayID` int(11) NOT NULL,
  `hospitalID` int(11) NOT NULL,
  PRIMARY KEY (`admittanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admittance`
--

LOCK TABLES `admittance` WRITE;
/*!40000 ALTER TABLE `admittance` DISABLE KEYS */;
/*!40000 ALTER TABLE `admittance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `allergies`
--

DROP TABLE IF EXISTS `allergies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allergies` (
  `admittanceID` int(11) NOT NULL,
  `allergyName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allergies`
--

LOCK TABLES `allergies` WRITE;
/*!40000 ALTER TABLE `allergies` DISABLE KEYS */;
/*!40000 ALTER TABLE `allergies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consent_status`
--

DROP TABLE IF EXISTS `consent_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consent_status` (
  `admittanceID` int(11) NOT NULL,
  `consentStatus` int(2) DEFAULT NULL,
  `legalGuardian` varchar(45) DEFAULT NULL,
  `guardianPhone` int(11) DEFAULT NULL,
  `decisionMaker` varchar(45) DEFAULT NULL,
  `decisionPhone` int(11) DEFAULT NULL,
  `medicalPOA` varchar(45) DEFAULT NULL,
  `medicalNumber` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consent_status`
--

LOCK TABLES `consent_status` WRITE;
/*!40000 ALTER TABLE `consent_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `consent_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discharge`
--

DROP TABLE IF EXISTS `discharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discharge` (
  `dischargeID` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `attendingPhysician` varchar(45) DEFAULT NULL,
  `roomNumber` int(11) DEFAULT NULL,
  `patientNumber` int(11) DEFAULT NULL,
  `dateOfAdmission` date DEFAULT NULL,
  `dateOfDischarge` date DEFAULT NULL,
  `provisionalDiagnosis` varchar(45) DEFAULT NULL,
  `finalDiagnosis` varchar(45) DEFAULT NULL,
  `briefHistory` varchar(45) DEFAULT NULL,
  `findings` varchar(45) DEFAULT NULL,
  `courseOfTreatment` varchar(45) DEFAULT NULL,
  `dischargeCondition` varchar(45) DEFAULT NULL,
  `rehabPotential` varchar(45) DEFAULT NULL,
  `followUp` varchar(45) DEFAULT NULL,
  `dateFiled` date DEFAULT NULL,
  `approvedBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dischargeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discharge`
--

LOCK TABLES `discharge` WRITE;
/*!40000 ALTER TABLE `discharge` DISABLE KEYS */;
/*!40000 ALTER TABLE `discharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emergency_contact`
--

DROP TABLE IF EXISTS `emergency_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emergency_contact` (
  `ermergencyContactID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `primaryPhoneNumber` int(11) DEFAULT NULL,
  `secondaryPhoneNumber` int(11) DEFAULT NULL,
  `relationship` varchar(45) DEFAULT NULL,
  `admittanceID` int(11) NOT NULL,
  PRIMARY KEY (`ermergencyContactID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emergency_contact`
--

LOCK TABLES `emergency_contact` WRITE;
/*!40000 ALTER TABLE `emergency_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `emergency_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref_barangay`
--

DROP TABLE IF EXISTS `ref_barangay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_barangay` (
  `barangayID` int(11) NOT NULL,
  `barangayName` varchar(45) DEFAULT NULL,
  `barangayContact` int(11) DEFAULT NULL,
  PRIMARY KEY (`barangayID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_barangay`
--

LOCK TABLES `ref_barangay` WRITE;
/*!40000 ALTER TABLE `ref_barangay` DISABLE KEYS */;
INSERT INTO `ref_barangay` VALUES (0,'Barangay A',1223),(1,'Barangay B',123),(2,'Barangay C',123);
/*!40000 ALTER TABLE `ref_barangay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref_civil_status`
--

DROP TABLE IF EXISTS `ref_civil_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_civil_status` (
  `civilStatusID` int(11) NOT NULL AUTO_INCREMENT,
  `civilStatusName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`civilStatusID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_civil_status`
--

LOCK TABLES `ref_civil_status` WRITE;
/*!40000 ALTER TABLE `ref_civil_status` DISABLE KEYS */;
INSERT INTO `ref_civil_status` VALUES (0,'Single'),(1,'Married'),(2,'Widowed'),(3,'Separated');
/*!40000 ALTER TABLE `ref_civil_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref_hospital`
--

DROP TABLE IF EXISTS `ref_hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_hospital` (
  `hospitalID` int(11) NOT NULL AUTO_INCREMENT,
  `hospitalName` varchar(45) DEFAULT NULL,
  `hospitalContact` int(11) DEFAULT NULL,
  PRIMARY KEY (`hospitalID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_hospital`
--

LOCK TABLES `ref_hospital` WRITE;
/*!40000 ALTER TABLE `ref_hospital` DISABLE KEYS */;
INSERT INTO `ref_hospital` VALUES (0,'QMMC',6310899),(1,'Dummy Hospital A',6310931),(2,'Dummy Hospital B',6310907);
/*!40000 ALTER TABLE `ref_hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref_privilege`
--

DROP TABLE IF EXISTS `ref_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_privilege` (
  `privilegeID` int(11) NOT NULL AUTO_INCREMENT,
  `privilegeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`privilegeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_privilege`
--

LOCK TABLES `ref_privilege` WRITE;
/*!40000 ALTER TABLE `ref_privilege` DISABLE KEYS */;
INSERT INTO `ref_privilege` VALUES (0,'Super User');
/*!40000 ALTER TABLE `ref_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplies`
--

DROP TABLE IF EXISTS `supplies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplies` (
  `supplyID` int(11) NOT NULL AUTO_INCREMENT,
  `supplyName` varchar(45) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `hospitalID` varchar(45) NOT NULL,
  PRIMARY KEY (`supplyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplies`
--

LOCK TABLES `supplies` WRITE;
/*!40000 ALTER TABLE `supplies` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(31) DEFAULT NULL,
  `password` varchar(31) DEFAULT NULL,
  `contactNumber` int(11) DEFAULT NULL,
  `privilegeID` int(11) NOT NULL,
  `hospitalID` int(11) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'SuperUser','81dc9bdb52d04dc2036dbd8313ed055',9260751,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-25 23:11:56
