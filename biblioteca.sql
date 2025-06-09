CREATE DATABASE  IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `idAutor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idAutor`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (10,'Agatha Christie'),(1,'Antoine de Saint Exupéry'),(9,'Dan Brown'),(18,'Edgar Allan Poe'),(16,'Ernest Hemingway'),(2,'Gabriel García Márquez'),(3,'George Orwell'),(11,'Harper Lee'),(7,'Isabel Allende'),(5,'J K Rowling'),(17,'Jane Austen'),(14,'Julio Cortázar'),(13,'Mario Vargas Llosa'),(12,'Miguel de Cervantes'),(19,'Oscar Wilde'),(8,'Paulo Coelho'),(15,'Ray Bradbury'),(6,'Stephen King'),(4,'Suzanne Collins'),(20,'Virginia Woolf');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (11,'Aventura'),(8,'Biografía'),(5,'Ciencia Ficción'),(12,'Clásico'),(9,'Ensayo'),(4,'Fantasía Juvenil'),(1,'Historia'),(3,'Infantil Fantasía'),(6,'Misterio'),(2,'Novela'),(13,'Poesía'),(7,'Romance'),(10,'Terror');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Raul','Jimenez Aguero','9519832345'),(2,'Regard Isard','Batriz','9513246501');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_prestamo`
--

DROP TABLE IF EXISTS `detalle_prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_prestamo` (
  `idDetalle` int NOT NULL AUTO_INCREMENT,
  `idPrestamo` int NOT NULL,
  `idCliente` int NOT NULL,
  `idLibro` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`idDetalle`),
  KEY `fk_ClientePrestamo_idx` (`idCliente`),
  KEY `fk_LibroPrestamo_idx` (`idLibro`),
  KEY `fk_PrestamoHisotiral_idx` (`idPrestamo`),
  CONSTRAINT `fk_ClientePrestamo` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `fk_LibroPrestamo` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`),
  CONSTRAINT `fk_PrestamoHisotiral` FOREIGN KEY (`idPrestamo`) REFERENCES `prestamo` (`idPrestamo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_prestamo`
--

LOCK TABLES `detalle_prestamo` WRITE;
/*!40000 ALTER TABLE `detalle_prestamo` DISABLE KEYS */;
INSERT INTO `detalle_prestamo` VALUES (1,4,1,5,2),(2,4,1,6,6),(3,5,1,7,4),(4,5,1,6,2),(5,5,1,5,2),(6,6,2,7,7),(7,6,2,7,3);
/*!40000 ALTER TABLE `detalle_prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editorial` (
  `idEditorial` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idEditorial`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
INSERT INTO `editorial` VALUES (6,'Alfaguara'),(7,'Anagrama'),(10,'Destino'),(4,'Minotauro'),(5,'Planeta'),(3,'RBa Molino'),(2,'Salamandra'),(9,'Seix Barral'),(1,'Sudamericana'),(8,'Tusquets');
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `idLibro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(200) NOT NULL,
  `idAutor` int NOT NULL,
  `idEditorial` int NOT NULL,
  `idCategoria` int NOT NULL,
  `cantidad` int NOT NULL,
  `anioEdicion` int NOT NULL,
  PRIMARY KEY (`idLibro`),
  KEY `idAutor` (`idAutor`),
  KEY `idEditorial` (`idEditorial`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`),
  CONSTRAINT `libro_ibfk_2` FOREIGN KEY (`idEditorial`) REFERENCES `editorial` (`idEditorial`),
  CONSTRAINT `libro_ibfk_3` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'El Principito',1,2,3,20,1943),(2,'Cien años de soledad',2,1,2,15,1967),(3,'Crónica de una muerte anunciada',2,1,2,8,1981),(4,'El amor en los tiempos del cólera',2,1,2,12,1985),(5,'1984',3,4,5,25,1949),(6,'Rebelión en la granja',3,4,5,18,1945),(7,'Los juegos del hambre',4,4,4,22,2008),(8,'En llamas',4,4,4,18,2009),(9,'Sinsajo',4,4,4,16,2010),(10,'Harry Potter y la piedra filosofal',5,2,4,30,1997),(11,'Harry Potter y la cámara secreta',5,2,4,25,1998),(12,'Harry Potter y el prisionero de Azkaban',5,2,4,20,1999),(13,'Harry Potter y el cáliz de fuego',5,2,4,18,2000),(14,'Harry Potter y la Orden del Fénix',5,2,4,15,2003),(15,'El resplandor',6,5,10,14,1977),(16,'Carrie',6,5,10,12,1974),(17,'It',6,5,10,10,1986),(18,'Cementerio de mascotas',6,5,10,8,1983),(19,'La casa de los espíritus',7,6,2,16,1982),(20,'De amor y de sombra',7,6,2,14,1984),(21,'Eva Luna',7,6,2,13,1987),(22,'Paula',7,6,8,11,1994),(23,'El alquimista',8,5,2,35,1988),(24,'Brida',8,5,2,20,1990),(25,'El zahir',8,5,2,18,2005),(26,'Veronika decide morir',8,5,2,16,1998),(27,'El código Da Vinci',9,5,6,28,2003),(28,'Ángeles y demonios',9,5,6,22,2000),(29,'Inferno',9,5,6,20,2013),(30,'El símbolo perdido',9,5,6,18,2009),(31,'Asesinato en el Orient Express',10,3,6,15,1934),(32,'Diez negritos',10,3,6,18,1939),(33,'El misterio de la guía de ferrocarriles',10,3,6,12,1957),(34,'Muerte en el Nilo',10,3,6,14,1937),(35,'Matar a un ruiseñor',11,7,2,20,1960),(36,'Don Quijote de la Mancha',12,9,12,8,1605),(37,'La ciudad y los perros',13,9,2,10,1963),(38,'Conversación en La Catedral',13,9,2,8,1969),(39,'La tía Julia y el escribidor',13,9,2,12,1977),(40,'La guerra del fin del mundo',13,9,1,9,1981),(41,'Rayuela',14,8,2,14,1963),(42,'Bestiario',14,8,2,10,1951),(43,'Final del juego',14,8,2,8,1956),(44,'Las armas secretas',14,8,2,11,1959),(45,'Fahrenheit 451',15,4,5,22,1953),(46,'Crónicas marcianas',15,4,5,18,1950),(47,'El hombre ilustrado',15,4,5,16,1951),(48,'El viejo y el mar',16,9,2,15,1952),(49,'Por quién doblan las campanas',16,9,2,12,1940),(50,'Adiós a las armas',16,9,2,14,1929);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multa`
--

DROP TABLE IF EXISTS `multa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `multa` (
  `idMulta` int NOT NULL AUTO_INCREMENT,
  `idPrestamo` int NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `pagado` enum('SI','NO') NOT NULL DEFAULT 'NO',
  `fechaMulta` date NOT NULL,
  PRIMARY KEY (`idMulta`),
  KEY `idPrestamo` (`idPrestamo`),
  CONSTRAINT `multa_ibfk_1` FOREIGN KEY (`idPrestamo`) REFERENCES `prestamo` (`idPrestamo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multa`
--

LOCK TABLES `multa` WRITE;
/*!40000 ALTER TABLE `multa` DISABLE KEYS */;
INSERT INTO `multa` VALUES (1,6,500.00,'SI','2025-06-09');
/*!40000 ALTER TABLE `multa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamo` (
  `idPrestamo` int NOT NULL AUTO_INCREMENT,
  `cantidadTotal` int NOT NULL,
  `fechaPrestamo` date NOT NULL,
  `fechaDevolucion` date NOT NULL,
  `status` enum('Entregado','Pendiente','Multa') NOT NULL DEFAULT 'Pendiente',
  PRIMARY KEY (`idPrestamo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (4,8,'2025-06-08','2025-07-08','Entregado'),(5,8,'2025-06-08','2025-06-06','Multa'),(6,10,'2025-06-08','2025-03-05','Multa');
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `TipoRol` varchar(60) NOT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE KEY `TipoRol_UNIQUE` (`TipoRol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (7,'Acomodador'),(1,'Administrador'),(2,'Bibliotecario');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `rol` int NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `correo_UNIQUE` (`correo`),
  KEY `fk_roles_idx` (`rol`),
  CONSTRAINT `fk_roles` FOREIGN KEY (`rol`) REFERENCES `roles` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (41,'Sarai','Gomez Lopez','9511204876','gisarai581@gmail.com','9aLenmGjsL1dWv2h9JdRmg==',1),(42,'Carmen','Garcia','9518754364','21160651@itoaxaca.edu.mx','3lmAprNQJDTFkm7ATJexlA==',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-09  2:18:37
