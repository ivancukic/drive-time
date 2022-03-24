-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: drive-time
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drivers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(145) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivers`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` VALUES (1,'Mikica','1990-12-25'),(2,'Eryn Guerra','2021-10-13'),(4,'Leona Truong','1989-01-04'),(5,'Christian Parks','1984-01-05'),(6,'Harleigh Malone','1954-06-25'),(7,'Christian James','1982-12-20'),(9,'Cadence Redman','2012-01-12'),(10,'Daryl Barrett','2004-01-04'),(11,'Brendan Snyder','1997-12-09'),(13,'Keegan Hood','1989-01-17');
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publiclines`
--

DROP TABLE IF EXISTS `publiclines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publiclines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_of_line` varchar(45) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `total_time` time DEFAULT NULL,
  `num_drivers` int DEFAULT NULL,
  `shift_one` varchar(145) DEFAULT NULL,
  `shift_two` varchar(145) DEFAULT NULL,
  `shift_three` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publiclines`
--

LOCK TABLES `publiclines` WRITE;
/*!40000 ALTER TABLE `publiclines` DISABLE KEYS */;
INSERT INTO `publiclines` VALUES (1,'47/31','04:00:00','20:00:00','16:00:00',2,'Mikica','Eryn Guerra',NULL),(2,'48/5','05:00:00','17:00:00','12:00:00',2,'Leona Truong','Christian Parks',NULL),(9,'48/8','05:00:00','17:00:00','12:00:00',2,'Driver 1','Driver 2',NULL),(10,'48/9','05:00:00','01:00:00','20:00:00',3,'Eryn Guerra','Christian Parks','Mikica'),(11,'48/11','23:00:00','01:00:00','02:00:00',1,'Mikica','',''),(12,'48/12','22:00:00','01:00:00','03:00:00',1,'Eryn Guerra',NULL,NULL),(13,'48/13','12:00:00','20:00:00','08:00:00',1,'Harleigh Malone',NULL,NULL),(14,'45/1','06:00:00','18:00:00','12:00:00',2,'Daryl Barrett','Brendan Snyder',NULL),(15,'45/2','05:00:00','12:00:00','07:00:00',1,'Keegan Hood',NULL,NULL),(16,'45/3','04:00:00','01:00:00','21:00:00',3,'Mikica','Eryn Guerra','Leona Truong');
/*!40000 ALTER TABLE `publiclines` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-20 12:26:08
