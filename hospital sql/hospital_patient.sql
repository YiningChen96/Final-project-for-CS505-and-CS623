-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `PATIENT_NUMBER` int NOT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `AGE` int DEFAULT NULL,
  `SEX` char(1) DEFAULT NULL,
  `PHONE_NUMBER` char(10) DEFAULT NULL,
  `ADDRESS` varchar(45) DEFAULT NULL,
  `BED_NUMBER` char(2) DEFAULT NULL,
  `DIAGNOSIS` varchar(45) DEFAULT NULL,
  `RESPONSIBLE_DOCTOR_NUMBER` char(6) DEFAULT NULL,
  `RESPONSIBLE_DOCTOR_NAME` varchar(30) DEFAULT NULL,
  `RESPONSIBLE_NURSE_NUMBER` char(6) DEFAULT NULL,
  `RESPONSIBLE_NURSE_NAME` varchar(30) DEFAULT NULL,
  `DEPARTMENT` varchar(30) DEFAULT NULL,
  `WARD` char(4) DEFAULT NULL,
  PRIMARY KEY (`PATIENT_NUMBER`),
  UNIQUE KEY `PATIENT NUMBER_UNIQUE` (`PATIENT_NUMBER`),
  KEY `RESPONSIBLE_DOCTOR_NUMBER_idx` (`RESPONSIBLE_DOCTOR_NUMBER`),
  KEY `RESPONSIBLE_NURSE_NUMBER_idx` (`RESPONSIBLE_NURSE_NUMBER`),
  KEY `DEPARTMENT_idx` (`DEPARTMENT`),
  CONSTRAINT `DEPARTMENT5` FOREIGN KEY (`DEPARTMENT`) REFERENCES `department` (`NAME`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RESPONSIBLE_DOCTOR_NUMBER` FOREIGN KEY (`RESPONSIBLE_DOCTOR_NUMBER`) REFERENCES `doctor` (`DOCTOR_NUMBER`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RESPONSIBLE_NURSE_NUMBER` FOREIGN KEY (`RESPONSIBLE_NURSE_NUMBER`) REFERENCES `nurse` (`NURSE_NUMBER`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Patient1',50,'F','7000000001','122-1 PACE STREET','1','Heart attack','000006','Doctor6','000010','Nurse10','Internal Medicine','01'),(2,'Patient2',30,'M','7000000002','22-1 PACE STREET','1','pneumonia','000008','Doctor8','000010','Nurse10','Internal Medicine','02'),(3,'Patient3',40,'M','7000000003','122-5 PACE STREET','1','Heart attack','000008','Doctor8','000007','Nurse7','Internal Medicine','03'),(4,'Patient4',34,'M','7000000005','15-1 FRANKLIN STREET','1','headache','000009','Doctor9','000007','Nurse7','Internal Medicine','04'),(5,'Patient5',33,'F','7000001001','33-2 BARCLAY STREET','1','pneumonia','000009','Doctor9','000003','Nurse3','Internal Medicine','05'),(6,'Patient6',45,'F','7001100001','27-9 SUN STREET','1','cervical polyp','000007','Doctor7','000004','Nurse4','Obstetrics and Gynecology','01'),(7,'Patient7',45,'F','7011100001','99-9 OAK STREET','1','endocervicitis','000007','Doctor7','000008','Nurse8','Obstetrics and Gynecology','02'),(8,'Patient8',52,'F','7000000033','67-2 OAK STREET','1','endocervicitis','000003','Doctor3','000008','Nurse8','Obstetrics and Gynecology','03'),(9,'Patient9',60,'F','7000000041','2-3 FRANKLIN STREET','1','cut','000004','Doctor4','000009','Nurse9','Surgery','01'),(10,'Patient10',67,'M','7000005001','34-1 38TH','1','scrap','000004','Doctor1','000011','Nurse11','Surgery','02'),(11,'Patient11',5,'M','7000300001','23-1 19TH','1','cold','000010','Doctor10','000001','Nurse1','Pediatrics','03'),(12,'Patient12',7,'F','7000000009','57-9 NORTHERN STREET','1','fever','000011','Doctor11','000005','Nurse5','Pediatrics','01');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-17 10:28:47
