-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: conciertosperu
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `artistas`
--

DROP TABLE IF EXISTS `artistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistas` (
  `idArtistas` int NOT NULL,
  `Nombre_Grupo` varchar(45) DEFAULT NULL,
  `Fecha_creacion` date DEFAULT NULL,
  `Tipo_musica` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idArtistas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistas`
--

LOCK TABLES `artistas` WRITE;
/*!40000 ALTER TABLE `artistas` DISABLE KEYS */;
INSERT INTO `artistas` VALUES (1,'Grupo 5','1992-04-08','cumbia'),(2,'Hermanos Yaipen','1982-04-10','cumbia'),(3,'Corazon Serrano','1922-04-10','cumbia'),(4,'Daft Punk','1993-05-10','Electro Dance'),(5,'Pintura Roja','1973-05-10','Chicha'),(6,'Ola Azul','1963-05-10','Salsa'),(7,'Zaperoko','2003-05-10','Salsa'),(8,'Papilom','1933-05-10','Cumbia'),(9,'Good Boys','2013-05-10','Pop'),(10,'Elctro Merge','2023-05-10','Electro');
/*!40000 ALTER TABLE `artistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concierto`
--

DROP TABLE IF EXISTS `concierto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concierto` (
  `idConcierto` int NOT NULL,
  `Fecha_evento` varchar(45) DEFAULT NULL,
  `proveedores_idProveedores` int NOT NULL,
  `artistas_idArtistas` int NOT NULL,
  PRIMARY KEY (`idConcierto`),
  KEY `fk_Concierto_proveedores_idx` (`proveedores_idProveedores`),
  KEY `fk_Concierto_artistas1_idx` (`artistas_idArtistas`),
  CONSTRAINT `fk_Concierto_artistas1` FOREIGN KEY (`artistas_idArtistas`) REFERENCES `artistas` (`idArtistas`),
  CONSTRAINT `fk_Concierto_proveedores` FOREIGN KEY (`proveedores_idProveedores`) REFERENCES `proveedores` (`idProveedores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concierto`
--

LOCK TABLES `concierto` WRITE;
/*!40000 ALTER TABLE `concierto` DISABLE KEYS */;
INSERT INTO `concierto` VALUES (1,'04-04-2023',1,3),(2,'05-04-2023',2,4),(3,'06-04-2023',5,6),(4,'07-04-2023',4,10),(6,'08-04-2023',6,2),(7,'09-04-2023',4,8),(8,'10-04-2023',8,4),(9,'11-04-2023',10,1),(10,'12-04-2023',5,9);
/*!40000 ALTER TABLE `concierto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `integrantes`
--

DROP TABLE IF EXISTS `integrantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `integrantes` (
  `idIntegrantes` int NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Edad` int DEFAULT NULL,
  `Anhios_exp` int DEFAULT NULL,
  `rol` varchar(40) DEFAULT NULL,
  `artistas_idArtistas` int NOT NULL,
  PRIMARY KEY (`idIntegrantes`),
  KEY `fk_integrantes_artistas1_idx` (`artistas_idArtistas`),
  CONSTRAINT `fk_integrantes_artistas1` FOREIGN KEY (`artistas_idArtistas`) REFERENCES `artistas` (`idArtistas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integrantes`
--

LOCK TABLES `integrantes` WRITE;
/*!40000 ALTER TABLE `integrantes` DISABLE KEYS */;
INSERT INTO `integrantes` VALUES (1,'Elmer Yaipen',55,25,'baterista',2),(2,'David Ramos',65,30,'cantante',3),(3,'Cristina Fernández',62,20,'cantante',1),(4,'Fernando Torres',72,40,'trompetista',4),(5,'Fernando Torres',32,10,'baterista',4),(6,'Alexander Gomez',22,5,'guitarrista',5),(7,'Pedro Castillo',52,25,'violinista',5),(8,'Diana Torres',32,10,'cantante',6),(9,'Julio Alejos',45,20,'trompetista',7),(10,'Julio Alejos',20,6,'pianista',8);
/*!40000 ALTER TABLE `integrantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `idProveedores` int NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Telefono` int DEFAULT NULL,
  `Elemento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProveedores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Otto Kuns',980347768,'embutidos'),(2,'Christian Gonzales',980776328,'pop corn'),(3,'Alexia Jauregui',980353286,'chese tris'),(4,'Sebastian Segura',980353123,'Salchipapa'),(5,'Called Math',980353456,'Galletas'),(6,'Mr beast',980353789,'Rosquitas'),(7,'Willy Wonka',980353692,'Chocolate'),(8,'Hector Lavoe',980353482,'Vodka'),(9,'Andi Bee',980353712,'Gaseosas'),(10,'Black Widow',980353601,'Monster');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-04 21:21:45
