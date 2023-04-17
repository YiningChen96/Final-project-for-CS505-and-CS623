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
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS `nurse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nurse` (
  `NURSE_NUMBER` char(6) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `AGE` int DEFAULT NULL,
  `SEX` char(1) DEFAULT NULL,
  `TITLE` varchar(20) DEFAULT NULL,
  `POSOTION` varchar(10) DEFAULT NULL,
  `DEPARTMENT` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`NURSE_NUMBER`),
  UNIQUE KEY `NURSE NUMBER_UNIQUE` (`NURSE_NUMBER`),
  KEY `DEPARTMENT_idx` (`DEPARTMENT`),
  KEY `DEPARTMENT2_idx` (`DEPARTMENT`),
  CONSTRAINT `DEPARTMENT3` FOREIGN KEY (`DEPARTMENT`) REFERENCES `department` (`NAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nurse`
--

LOCK TABLES `nurse` WRITE;
/*!40000 ALTER TABLE `nurse` DISABLE KEYS */;
INSERT INTO `nurse` VALUES ('000001','Nurse1',22,'F','Licensed Nurse','staff','Pediatrics'),('000002','Nurse2',23,'F','Licensed Nurse','staff','Clinical Laboratory'),('000003','Nurse3',23,'F','Licensed Nurse','staff','Internal Medicine'),('000004','Nurse4',25,'F','Licensed Nurse','staff','Obstetrics and Gynecology'),('000005','Nurse5',30,'F','Registered Nurse','Head Nurse','Pediatrics'),('000006','Nurse6',33,'F','Registered Nurse','Head Nurse','Clinical Laboratory'),('000007','Nurse7',34,'F','Registered Nurse','Head Nurse','Internal Medicine'),('000008','Nurse8',30,'F','Registered Nurse','Head Nurse','Obstetrics and Gynecology'),('000009','Nurse9',30,'F','Licensed Nurse','staff','Surgery'),('000010','Nurse10',27,'F','Licensed Nurse','staff','Internal Medicine'),('000011','Nurse11',29,'F','Licensed Nurse','staff','Surgery'),('000012','Nurse12',36,'F','Registered Nurse','Head Nurse','Surgery');
/*!40000 ALTER TABLE `nurse` ENABLE KEYS */;
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
