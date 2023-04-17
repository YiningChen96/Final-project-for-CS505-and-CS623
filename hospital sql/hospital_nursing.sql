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
-- Table structure for table `nursing`
--

DROP TABLE IF EXISTS `nursing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nursing` (
  `PATIENT_NUMBER` int NOT NULL,
  `PATIENT_NAME` varchar(30) DEFAULT NULL,
  `NURSE_NUMBER` char(6) NOT NULL,
  `NURSE_NAME` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`PATIENT_NUMBER`,`NURSE_NUMBER`),
  KEY `NURSE_NUMBER_idx` (`NURSE_NUMBER`),
  CONSTRAINT `NURSE_NUMBER` FOREIGN KEY (`NURSE_NUMBER`) REFERENCES `nurse` (`NURSE_NUMBER`),
  CONSTRAINT `PATIENT_NUMBER` FOREIGN KEY (`PATIENT_NUMBER`) REFERENCES `patient` (`PATIENT_NUMBER`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nursing`
--

LOCK TABLES `nursing` WRITE;
/*!40000 ALTER TABLE `nursing` DISABLE KEYS */;
INSERT INTO `nursing` VALUES (1,'Patient1','000007','Nurse7'),(1,'Patient1','000010','Nurse10'),(2,'Patient2','000003','Nurse3'),(2,'Patient2','000010','Nurse10'),(3,'Patient3','000007','Nurse7'),(4,'Patient4','000003','Nurse3'),(5,'Patient5','000003','Nurse3'),(5,'Patient5','000010','Nurse10'),(6,'Patient6','000004','Nurse4'),(6,'Patient6','000008','Nurse8'),(7,'Patient7','000004','Nurse4'),(7,'Patient7','000008','Nurse8'),(8,'Patient8','000008','Nurse8'),(9,'Patient9','000009','Nurse9'),(9,'Patient9','000011','Nurse11'),(10,'Patient10','000009','Nurse9'),(11,'Patient11','000001','Nurse1'),(12,'Patient12','000005','Nurse5');
/*!40000 ALTER TABLE `nursing` ENABLE KEYS */;
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
