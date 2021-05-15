-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `flightid` int NOT NULL AUTO_INCREMENT,
  `flightName` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `source` varchar(100) NOT NULL,
  `destination` varchar(100) NOT NULL,
  `flightDate` varchar(100) NOT NULL,
  `totalSeat` varchar(100) NOT NULL,
  `abvailableSeat` varchar(100) NOT NULL,
  PRIMARY KEY (`flightid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (6,'AirIndia','2000','Mumbai','Goa','2021-05-21','20','16'),(13,'Indigo','2000','Patna','Delhi','2021-05-13','20','16'),(15,'Emirates','3500','Patna','Delhi','2021-05-21','20','20'),(16,'Emirates','3500','Patna','Delhi','2021-05-21','20','20'),(17,'Emirates','3500','Patna','Delhi','2021-05-21','20','11'),(18,'Emirates','3500','Patna','Delhi','2021-05-21','20','20');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `passenger_id` int NOT NULL AUTO_INCREMENT,
  `flightid` int NOT NULL,
  `userid` int NOT NULL,
  `passenger_name` varchar(45) NOT NULL,
  `passenger_age` varchar(45) NOT NULL,
  `passenger_mobile` varchar(45) NOT NULL,
  `passenger_email` varchar(45) NOT NULL,
  `seat` varchar(20) NOT NULL,
  PRIMARY KEY (`passenger_id`),
  KEY `flightid_idx` (`flightid`),
  KEY `userid_idx` (`userid`),
  CONSTRAINT `flightid` FOREIGN KEY (`flightid`) REFERENCES `flight` (`flightid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (12,6,3,'fnlnjlad','23','854692696','s@gmail.com','3'),(13,6,3,'fkkndkan;','23','971518686','s@gmail.com','2'),(14,6,3,'sfdgjsg','23','145235412','s@gmail.com','2'),(15,13,3,'Anshika','23','89898684','ans@gmail.com','4'),(20,6,3,'Harsh','23','9999555548','Har@gmail.com','5'),(21,17,3,'mnflmsflmfa','23','52378639714971','s@gmail.com','4'),(22,6,3,'Suraj','25','7777882525','sur@gmail.com','6'),(23,6,3,'Suraj','25','7777882525','sur@gmail.com','6'),(24,17,3,'Rahul','23','7787487837745','saroj@gmail.com','5');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobileNo` varchar(100) NOT NULL,
  `userPass` varchar(100) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'saroj','Bihar','saroj@gmail.com','9953621953','aaa123'),(5,'saroj','delhi','saroj@gmail.com','999999999','1234'),(6,'Aman Sahu','Bhopal','aman@gmail.com','7982566784','aman111'),(8,'Sanjay','Bhagalpur','sanjay@yahoo.com','9959256547','san123'),(9,'Sanjay','Bhagalpur','sanjay@yahoo.com','9959256547','san123'),(10,'Sachin','Varanasi','sachu@gmail.com','888889999','sac123'),(11,'Sachin','Varanasi','sachu@gmail.com','888889999','sac123'),(12,'Sanjay','Bhagalpur','sanjay@yahoo.com','9959256547','san123'),(13,'Sachin','Varanasi','sachu@gmail.com','888889999','sac123');
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

-- Dump completed on 2021-05-14 12:42:17
