-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: db_seguimiento
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
-- Table structure for table `characteristic`
--

DROP TABLE IF EXISTS `characteristic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `characteristic` (
  `characteristic_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`characteristic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characteristic`
--

LOCK TABLES `characteristic` WRITE;
/*!40000 ALTER TABLE `characteristic` DISABLE KEYS */;
/*!40000 ALTER TABLE `characteristic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `characterization`
--

DROP TABLE IF EXISTS `characterization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `characterization` (
  `characterization_id` int NOT NULL,
  `characteristic_id` int NOT NULL,
  `student_id` int NOT NULL,
  `status` tinyint NOT NULL,
  `user_id_creation` int NOT NULL,
  `creation_date` datetime NOT NULL,
  `modification_date` datetime DEFAULT NULL,
  `user_id_modification` int DEFAULT NULL,
  `creation_user_id` int NOT NULL,
  `modification_user_id` int DEFAULT NULL,
  PRIMARY KEY (`characterization_id`),
  KEY `FK_characterization_characteristic_id_idx` (`characteristic_id`),
  KEY `FK_characterization_student_id_idx` (`student_id`),
  KEY `FK_characterization_user_id_idx` (`user_id_creation`),
  CONSTRAINT `FK_characterization_characteristic_id` FOREIGN KEY (`characteristic_id`) REFERENCES `characteristic` (`characteristic_id`),
  CONSTRAINT `FK_characterization_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `FK_characterization_user_id` FOREIGN KEY (`user_id_creation`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characterization`
--

LOCK TABLES `characterization` WRITE;
/*!40000 ALTER TABLE `characterization` DISABLE KEYS */;
/*!40000 ALTER TABLE `characterization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `grade_id` int NOT NULL,
  `description` varchar(45) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FK_course_grade_id_idx` (`grade_id`),
  CONSTRAINT `FK_course_grade_id` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,1,NULL),(2,2,NULL),(3,3,'A'),(4,3,'B'),(5,4,'A'),(6,4,'B'),(7,5,'A'),(8,5,'B'),(9,6,'A'),(10,6,'B'),(11,7,'A'),(12,7,'B'),(13,8,'A'),(14,8,'B'),(15,9,'A'),(16,9,'B'),(17,10,'A'),(18,10,'B'),(19,11,'A'),(20,11,'B'),(21,12,'A'),(22,12,'B'),(23,13,'A'),(24,14,'B'),(25,14,'A');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependency`
--

DROP TABLE IF EXISTS `dependency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dependency` (
  `dependency_id` int NOT NULL AUTO_INCREMENT,
  `dependency_name` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`dependency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependency`
--

LOCK TABLES `dependency` WRITE;
/*!40000 ALTER TABLE `dependency` DISABLE KEYS */;
INSERT INTO `dependency` VALUES (1,'RECTORIA'),(2,'VICERECTORIA'),(3,'TALENTO HUMANO'),(4,'COORDINACIÓN ACADÉMICA'),(5,'COORDINACIÓN DE CONVIVENCIA'),(6,'PSICOLOGIA'),(7,'ADMINISTRACIÓN'),(8,'SECRETARÍA'),(9,'ESTUDIANTADO');
/*!40000 ALTER TABLE `dependency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `person_id` int NOT NULL,
  `employeetype_id` int NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FK_person_id_person_id2_idx` (`person_id`),
  KEY `FK_employeetype_id_employeetype_id_idx` (`employeetype_id`),
  CONSTRAINT `FK_employeetype_id_employeetype_id` FOREIGN KEY (`employeetype_id`) REFERENCES `employeetype` (`employeeType_id`),
  CONSTRAINT `FK_person_id_person_id2` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,4);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeetype`
--

DROP TABLE IF EXISTS `employeetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeetype` (
  `employeeType_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `employee_type_id` int NOT NULL,
  PRIMARY KEY (`employeeType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeetype`
--

LOCK TABLES `employeetype` WRITE;
/*!40000 ALTER TABLE `employeetype` DISABLE KEYS */;
INSERT INTO `employeetype` VALUES (1,'RECTOR',0),(2,'VICERECTOR',0),(3,'COORDINADOR TALENTO HUMANO',0),(4,'COORDINADOR ACADÉMICO',0),(5,'COORDINADOR DE CONVIVENCIA',0),(6,'PSICOLOGO',0),(7,'DOCENTE',0),(8,'SERVICIOS GENERALES',0);
/*!40000 ALTER TABLE `employeetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `grade_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `abbreviation` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,'PREJARDIN','PRE JR'),(2,'JARDIN','JR'),(3,'TRANSICIÓN','TR'),(4,'PRIMERO','1'),(5,'SEGUNDO','2'),(6,'TERCERO','3'),(7,'CUARTO','4'),(8,'QUINTO','5'),(9,'SEXTO','6'),(10,'SEPTIMO','7'),(11,'OCTAVO','8'),(12,'NOVENO','9'),(13,'DECIMO','10'),(14,'UNDECIMO','11');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identificationtype`
--

DROP TABLE IF EXISTS `identificationtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `identificationtype` (
  `identificationtype_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`identificationtype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identificationtype`
--

LOCK TABLES `identificationtype` WRITE;
/*!40000 ALTER TABLE `identificationtype` DISABLE KEYS */;
INSERT INTO `identificationtype` VALUES (1,'CEDULA DE CIUDADANIA'),(2,'CEDULA DE EXTRANJERIA'),(3,'TARJETA DE IDENTIDAD'),(4,'REGISTRO CIVIL');
/*!40000 ALTER TABLE `identificationtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `observation`
--

DROP TABLE IF EXISTS `observation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `observation` (
  `observation_id` int NOT NULL AUTO_INCREMENT,
  `student_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `dependency_id` int NOT NULL,
  `reason_id` int NOT NULL,
  `observation` varchar(255) COLLATE utf8mb3_spanish_ci NOT NULL,
  `recomendation` varchar(255) COLLATE utf8mb3_spanish_ci NOT NULL,
  `creation_date` datetime NOT NULL,
  `modification_date` datetime DEFAULT NULL,
  `relationship_id` int DEFAULT NULL,
  `identificationtype_id` int DEFAULT NULL,
  `identification_number_visitor` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `visitor_name` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `evidence` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `creation_user_id` int NOT NULL,
  `modification_user_id` int DEFAULT NULL,
  PRIMARY KEY (`observation_id`),
  KEY `FK_observation_student_id_idx` (`student_id`),
  KEY `FK_observation_employee_id_idx` (`employee_id`),
  KEY `FK_observation_dependency_idx` (`dependency_id`),
  KEY `FK_observation_relationship_idx` (`relationship_id`),
  KEY `FK_observation_documenttype_id_idx` (`identificationtype_id`),
  KEY `FK_observation_reason_idx` (`reason_id`),
  KEY `FK_observation_creation_user_id_idx` (`creation_user_id`),
  KEY `FK_observation_modification_user_id_idx` (`modification_user_id`),
  CONSTRAINT `FK_observation_creation_user_id` FOREIGN KEY (`creation_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_observation_dependency` FOREIGN KEY (`dependency_id`) REFERENCES `dependency` (`dependency_id`),
  CONSTRAINT `FK_observation_documenttype_id` FOREIGN KEY (`identificationtype_id`) REFERENCES `identificationtype` (`identificationtype_id`),
  CONSTRAINT `FK_observation_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FK_observation_modification_user_id` FOREIGN KEY (`modification_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_observation_reason` FOREIGN KEY (`reason_id`) REFERENCES `reason` (`reason_id`),
  CONSTRAINT `FK_observation_relationship` FOREIGN KEY (`relationship_id`) REFERENCES `relationship` (`relationship_id`),
  CONSTRAINT `FK_observation_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `observation`
--

LOCK TABLES `observation` WRITE;
/*!40000 ALTER TABLE `observation` DISABLE KEYS */;
INSERT INTO `observation` VALUES (1,NULL,1,4,1,'OBSERVATION 1','RECOMENDACION 1','2023-02-27 13:37:59',NULL,NULL,NULL,NULL,NULL,'EVIDENCIA',1,NULL),(2,NULL,1,4,1,'OBSERVATION 2','RECOMENDACION 2','2023-02-28 13:37:59',NULL,NULL,NULL,NULL,NULL,'EVIDENCIA 2',1,NULL),(3,NULL,1,4,1,'OBSERV66ATION 1','RECOM66ENDACION 1','2023-02-28 13:32:41',NULL,NULL,NULL,NULL,NULL,'EVIDE66NCIA',1,NULL),(4,NULL,1,4,1,'OBSERV66ATION 1','RECOM66ENDACION 1','2023-02-28 13:33:11',NULL,NULL,NULL,NULL,NULL,'EVIDE66NCIA',1,NULL),(5,NULL,1,4,1,'OBSERV66ATION 1','RECOM66ENDACION 1','2023-02-28 13:39:38',NULL,NULL,NULL,NULL,NULL,'EVIDE66NCIA',1,NULL),(6,NULL,1,4,1,'OBSE535346ATION 1','RECOM6353453CION 1','2023-03-01 08:39:24',NULL,NULL,NULL,NULL,NULL,'EVIDE66NCIA',1,NULL);
/*!40000 ALTER TABLE `observation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `person_id` int NOT NULL AUTO_INCREMENT,
  `identification_type_Id` int NOT NULL,
  `identification_number` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `first_name` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `middle_name` varchar(45) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `last_name` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `second_last_name` varchar(45) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `person_type_id` int NOT NULL,
  `date_of_birth` datetime NOT NULL,
  `email` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creation_user_id` int DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  `modification_user_id` int DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `fk_person_person_type_idx` (`person_type_id`),
  KEY `FK_person_identification_type_idx` (`identification_type_Id`),
  CONSTRAINT `FK_person_identification_type` FOREIGN KEY (`identification_type_Id`) REFERENCES `identificationtype` (`identificationtype_id`),
  CONSTRAINT `FK_person_person_type` FOREIGN KEY (`person_type_id`) REFERENCES `persontype` (`persontype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,1,'1234','HAROLD','MATEUS','ERASO','IBARRA',1,'1990-02-01 00:00:00','harolderaso@filipense.edu.co','2023-02-11 00:00:00',1,NULL,NULL,1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persontype`
--

DROP TABLE IF EXISTS `persontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persontype` (
  `persontype_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`persontype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persontype`
--

LOCK TABLES `persontype` WRITE;
/*!40000 ALTER TABLE `persontype` DISABLE KEYS */;
INSERT INTO `persontype` VALUES (1,'EMPLEADO'),(2,'ESTUDIANTE'),(3,'PADRE DE FAMILIA');
/*!40000 ALTER TABLE `persontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reason`
--

DROP TABLE IF EXISTS `reason`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reason` (
  `reason_id` int NOT NULL AUTO_INCREMENT,
  `dependency_id` int NOT NULL,
  `description` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `student_employee` tinyint NOT NULL,
  PRIMARY KEY (`reason_id`),
  KEY `FK_reason_dependence_id_idx` (`dependency_id`),
  CONSTRAINT `FK_reason_dependency_id` FOREIGN KEY (`dependency_id`) REFERENCES `dependency` (`dependency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reason`
--

LOCK TABLES `reason` WRITE;
/*!40000 ALTER TABLE `reason` DISABLE KEYS */;
INSERT INTO `reason` VALUES (1,4,'RAZON1',1),(2,4,'RAZON2',1),(3,4,'RAZON3',1);
/*!40000 ALTER TABLE `reason` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relationship`
--

DROP TABLE IF EXISTS `relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relationship` (
  `relationship_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`relationship_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relationship`
--

LOCK TABLES `relationship` WRITE;
/*!40000 ALTER TABLE `relationship` DISABLE KEYS */;
INSERT INTO `relationship` VALUES (1,'PADRE'),(2,'MADRE'),(3,'TIO/A'),(4,'HERMANO/A'),(5,'ABUELO/A'),(6,'ACUDIENTE');
/*!40000 ALTER TABLE `relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolyear`
--

DROP TABLE IF EXISTS `schoolyear`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schoolyear` (
  `schoolyear_id` int NOT NULL AUTO_INCREMENT,
  `year` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`schoolyear_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear`
--

LOCK TABLES `schoolyear` WRITE;
/*!40000 ALTER TABLE `schoolyear` DISABLE KEYS */;
INSERT INTO `schoolyear` VALUES (1,'2022'),(2,'2023'),(3,'2024'),(4,'2025'),(5,'2026'),(6,'2027'),(7,'2028'),(8,'2029'),(9,'2030');
/*!40000 ALTER TABLE `schoolyear` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolyear_course`
--

DROP TABLE IF EXISTS `schoolyear_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schoolyear_course` (
  `schoolyear_course_id` int NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`schoolyear_course_id`),
  KEY `FK_schoolyear_id_school_year_idx` (`schoolyear_id`),
  KEY `FK_grade_id_course_idx` (`course_id`),
  CONSTRAINT `FK_grade_id_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `FK_schoolyear_id_school_year` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear` (`schoolyear_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_course`
--

LOCK TABLES `schoolyear_course` WRITE;
/*!40000 ALTER TABLE `schoolyear_course` DISABLE KEYS */;
INSERT INTO `schoolyear_course` VALUES (1,2,1),(2,2,2),(3,2,3),(4,2,4),(5,2,5),(6,2,6),(7,2,7),(8,2,8),(9,2,9),(10,2,10),(11,2,11),(12,2,12),(13,2,13),(14,2,14),(15,2,15),(16,2,16),(17,2,17),(18,2,18),(19,2,19),(20,2,20),(21,2,21),(22,2,22),(23,2,23),(24,2,24),(25,2,25);
/*!40000 ALTER TABLE `schoolyear_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolyear_grade`
--

DROP TABLE IF EXISTS `schoolyear_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schoolyear_grade` (
  `schoolyear_grade_id` int NOT NULL AUTO_INCREMENT,
  `grade_id` int NOT NULL,
  `school_year` int NOT NULL,
  PRIMARY KEY (`schoolyear_grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_grade`
--

LOCK TABLES `schoolyear_grade` WRITE;
/*!40000 ALTER TABLE `schoolyear_grade` DISABLE KEYS */;
INSERT INTO `schoolyear_grade` VALUES (1,1,2);
/*!40000 ALTER TABLE `schoolyear_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `person_id` int NOT NULL,
  `schoolyear_grade_id` int NOT NULL,
  `student_code` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `user_id` int DEFAULT NULL,
  `dependency_id` int DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_person_id_idx` (`person_id`),
  KEY `FK_schoolyear_grade_id_schoolyear_grade_idx` (`schoolyear_grade_id`),
  CONSTRAINT `FK_person_id_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FK_schoolyear_grade_id_schoolyear_grade` FOREIGN KEY (`schoolyear_grade_id`) REFERENCES `schoolyear_course` (`schoolyear_course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,1,1,'123',1,8,NULL,NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) COLLATE utf8mb3_spanish_ci NOT NULL,
  `person_id` int NOT NULL,
  `dependency_id` int NOT NULL,
  `username` varchar(255) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_user_dependency_id_idx` (`dependency_id`),
  CONSTRAINT `FK_user_dependency_id` FOREIGN KEY (`dependency_id`) REFERENCES `dependency` (`dependency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'1234',1,4,'CC1234');
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

-- Dump completed on 2023-03-24 13:40:52
