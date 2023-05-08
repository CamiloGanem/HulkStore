CREATE DATABASE  IF NOT EXISTS `hulkstore`;
USE `hulkstore`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: hulkstore
-- ------------------------------------------------------
-- Server version	8.0.27


--
-- Table structure for table `hs_carrito_compras`
--

DROP TABLE IF EXISTS `hs_carrito_compras`;
CREATE TABLE `hs_carrito_compras` (
  `id_carrito_compra` int NOT NULL COMMENT 'Identificacion del registro ',
  `id_producto` int DEFAULT NULL COMMENT 'Identificacion del registros producto ',
  `id_empleado` int DEFAULT NULL COMMENT 'Identificacion del registro del empleado',
  `cantidad_carrito` int NOT NULL,
  PRIMARY KEY (`id_carrito_compra`),
  KEY `FK_CARRITO_EMPLEADO` (`id_empleado`),
  KEY `FK_CARRITO_PRODUCTO` (`id_producto`),
  CONSTRAINT `FK_CARRITO_EMPLEADO` FOREIGN KEY (`id_empleado`) REFERENCES `hs_empleados` (`id_empleado`),
  CONSTRAINT `FK_CARRITO_PRODUCTO` FOREIGN KEY (`id_producto`) REFERENCES `hs_productos` (`id_producto`),
  CONSTRAINT `id_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `hs_empleados` (`id_empleado`),
  CONSTRAINT `id_producto` FOREIGN KEY (`id_producto`) REFERENCES `hs_productos` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `hs_carrito_compras`
--

LOCK TABLES `hs_carrito_compras` WRITE;
/*!40000 ALTER TABLE `hs_carrito_compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `hs_carrito_compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hs_carrito_compras_seq`
--

DROP TABLE IF EXISTS `hs_carrito_compras_seq`;
CREATE TABLE `hs_carrito_compras_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `hs_carrito_compras_seq`
--

LOCK TABLES `hs_carrito_compras_seq` WRITE;

INSERT INTO `hs_carrito_compras_seq` VALUES (301);

UNLOCK TABLES;

--
-- Table structure for table `hs_empleados`
--

DROP TABLE IF EXISTS `hs_empleados`;

CREATE TABLE `hs_empleados` (
  `id_empleado` int NOT NULL AUTO_INCREMENT COMMENT 'Identifiacion del registro del empleado',
  `iden_empleado` varchar(20) COLLATE utf8_spanish2_ci NOT NULL COMMENT 'Numero de identificaicon del empleado',
  `primer_nom_empleado` varchar(50) COLLATE utf8_spanish2_ci NOT NULL COMMENT 'Primer nombre del empleado',
  `segundo_nom_empleado` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Segundo nombre del empleado',
  `primer_apell_empleado` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `fecha_nac_empleado` date NOT NULL COMMENT 'Fecha de nacimiento del empleado',
  `segundo_apell_empleado` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `Identificacion_UNIQUE` (`iden_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=453 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;


--
-- Dumping data for table `hs_empleados`
--

LOCK TABLES `hs_empleados` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `hs_empleados_seq`
--

DROP TABLE IF EXISTS `hs_empleados_seq`;
CREATE TABLE `hs_empleados_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `hs_empleados_seq`
--

LOCK TABLES `hs_empleados_seq` WRITE;

INSERT INTO `hs_empleados_seq` VALUES (551);

UNLOCK TABLES;

--
-- Table structure for table `hs_productos`
--

DROP TABLE IF EXISTS `hs_productos`;
CREATE TABLE `hs_productos` (
  `id_producto` int NOT NULL AUTO_INCREMENT COMMENT 'Identificacion del registro del producto',
  `codigo_producto` varchar(45) COLLATE utf8_spanish2_ci NOT NULL COMMENT 'Codigo unico del producto',
  `nombre_producto` varchar(50) COLLATE utf8_spanish2_ci NOT NULL COMMENT 'Nombre del producto',
  `descripcion_producto` text COLLATE utf8_spanish2_ci COMMENT 'Descripcion del producto',
  `precio_producto` decimal(10,2) NOT NULL COMMENT 'Precio del producto',
  `cantidad_producto` int NOT NULL DEFAULT '0' COMMENT 'Cantidad en inventario del producto',
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `hs_codigo_producto_UNIQUE` (`codigo_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Table structure for table `hs_productos_seq`
--

DROP TABLE IF EXISTS `hs_productos_seq`;

CREATE TABLE `hs_productos_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;


--
-- Dumping data for table `hs_productos_seq`
--

LOCK TABLES `hs_productos_seq` WRITE;
INSERT INTO `hs_productos_seq` VALUES (151);
UNLOCK TABLES;

--
-- Table structure for table `hs_usuarios`
--

DROP TABLE IF EXISTS `hs_usuarios`;
CREATE TABLE `hs_usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `primer_nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `rol` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=403 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `hs_usuarios`
--

LOCK TABLES `hs_usuarios` WRITE;

INSERT INTO `hs_usuarios` VALUES (202,'Ganem','camilo@gmail.com','$2a$10$AK20KUKmbdC3qa/kmLvNbOKTtyE6QPl5B95CAvo5eX2ljSmb6KB4m','Camilo','ADMIN');

UNLOCK TABLES;

--
-- Table structure for table `hs_usuarios_seq`
--

DROP TABLE IF EXISTS `hs_usuarios_seq`;
CREATE TABLE `hs_usuarios_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;


--
-- Dumping data for table `hs_usuarios_seq`
--

LOCK TABLES `hs_usuarios_seq` WRITE;

INSERT INTO `hs_usuarios_seq` VALUES (501);

UNLOCK TABLES;
