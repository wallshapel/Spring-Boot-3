-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: curso_java
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(75) DEFAULT NULL,
  `nombre` varchar(75) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `telefono` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,'karoll@gmail.com','Karoll','$argon2id$v=19$m=1024,t=2,p=2$pgiSz4q7ftJgwJrwTZnn7A$/RyGYvejKGOITs0jGNbrnlXLfASWzHE45epFEf+Rw7Q','3004345685'),(3,'grace@gmail.com','Grace','$argon2id$v=19$m=1024,t=2,p=2$pgiSz4q7ftJgwJrwTZnn7A$/RyGYvejKGOITs0jGNbrnlXLfASWzHE45epFEf+Rw7Q','3256854124'),(4,'yeimi@gmail.com','Yeimy','$argon2id$v=19$m=1024,t=2,p=2$pgiSz4q7ftJgwJrwTZnn7A$/RyGYvejKGOITs0jGNbrnlXLfASWzHE45epFEf+Rw7Q','6541258452'),(5,'ruby@gmail.com','Ruby','$argon2id$v=19$m=1024,t=2,p=2$pgiSz4q7ftJgwJrwTZnn7A$/RyGYvejKGOITs0jGNbrnlXLfASWzHE45epFEf+Rw7Q','5425165894'),(6,'catalina@gmail.com','Catalina','$argon2id$v=19$m=1024,t=2,p=2$pgiSz4q7ftJgwJrwTZnn7A$/RyGYvejKGOITs0jGNbrnlXLfASWzHE45epFEf+Rw7Q','5632541252'),(7,'yulia@gmail.com','Yulia','$argon2id$v=19$m=1024,t=2,p=2$pgiSz4q7ftJgwJrwTZnn7A$/RyGYvejKGOITs0jGNbrnlXLfASWzHE45epFEf+Rw7Q','6854125452'),(8,'natalia@gmail.com','Natalia','$argon2id$v=19$m=1024,t=2,p=2$pgiSz4q7ftJgwJrwTZnn7A$/RyGYvejKGOITs0jGNbrnlXLfASWzHE45epFEf+Rw7Q','6963254125'),(10,'yesli@gmail.com','Yesli','$argon2id$v=19$m=1024,t=2,p=2$pgiSz4q7ftJgwJrwTZnn7A$/RyGYvejKGOITs0jGNbrnlXLfASWzHE45epFEf+Rw7Q','6541256321'),(14,'claudia@gmail.com','claudia','$argon2id$v=19$m=1024,t=2,p=2$pgiSz4q7ftJgwJrwTZnn7A$/RyGYvejKGOITs0jGNbrnlXLfASWzHE45epFEf+Rw7Q','3004349095');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'curso_java'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-07  1:10:38
