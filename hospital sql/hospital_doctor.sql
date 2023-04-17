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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `DOCTOR_NUMBER` char(6) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `AGE` int DEFAULT NULL,
  `SEX` char(1) DEFAULT NULL,
  `TITLE` varchar(20) DEFAULT NULL,
  `POSITION` varchar(10) DEFAULT NULL,
  `DEPARTMENT` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`DOCTOR_NUMBER`),
  UNIQUE KEY `DOCTOR NUMBER_UNIQUE` (`DOCTOR_NUMBER`),
  KEY `DEPARTMENT_idx` (`DEPARTMENT`),
  CONSTRAINT `DEPARTMENT` FOREIGN KEY (`DEPARTMENT`) REFERENCES `department` (`NAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('000001','Doctor1',30,'M','Resident','staff','Surgery'),('000002','Doctor2',33,'M','Attending','staff','Clinical Laboratory'),('000003','Doctor3',34,'F','Attending','staff','Obstetrics and Gynecology'),('000004','Doctor4',35,'M','Attending','Director','Surgery'),('000005','Doctor5',40,'M','Attending','Director','Clinical Laboratory'),('000006','Doctor6',45,'M','Attending','Director','Internal Medicine'),('000007','Doctor7',37,'F','Attending','Director','Obstetrics and Gynecology'),('000008','Doctor8',33,'F','Attending','staff','Internal Medicine'),('000009','Doctor9',30,'M','Resident','staff','Internal Medicine'),('000010','Doctor10',42,'F','Attending','Director','Pediatrics'),('000011','Doctor11',36,'M','Attending','staff','Pediatrics');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-17 10:28:48
