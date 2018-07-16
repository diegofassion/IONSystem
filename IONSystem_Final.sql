-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: ion
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `Cod_Cliente` int(11) NOT NULL,
  `Nome` varchar(80) DEFAULT NULL,
  `Sexo` varchar(10) DEFAULT NULL,
  `Data_Nasc` date DEFAULT NULL,
  `RG` varchar(12) DEFAULT NULL,
  `CPF` varchar(14) DEFAULT NULL,
  `Telefone` varchar(14) DEFAULT NULL,
  `Endereco` varchar(50) DEFAULT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  `Bairro` varchar(30) DEFAULT NULL,
  `Cidade` varchar(40) DEFAULT NULL,
  `Estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cod_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Diego Fassion','Masculino','1936-01-18','  .   .   - ','   .   .   -  ','(12)31231-2312','','  .   -   ','','','Acre'),(2,'Fabio Capelini','Masculino','1990-12-12','12.312.312-3','123.123.123-12','(14)34343-4343','Rua dos testes','17.522-000','Castelo Branco','Marília','Espírito Santo'),(3,'Leonardo Gomes','Masculino','1995-01-02','  .   .   - ','   .   .   -  ','(  )     -    ','','  .   -   ','','','Acre'),(4,'Editado Gomes','Masculino','1999-01-12','  .   .   - ','   .   .   -  ','(  )     -    ','','  .   -   ','','','Acre'),(5,'Malavéia','Masculino','1998-12-12','  .   .   - ','   .   .   -  ','(  )     -    ','','  .   -   ','','','Acre'),(6,'Cliente Editado','Masculino','1999-01-12','  .   .   - ','   .   .   -  ','(  )     -    ','','  .   -   ','','','Acre');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamento`
--

DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento` (
  `Cod_Equipamento` int(11) NOT NULL,
  `Cod_Cliente` int(11) DEFAULT NULL,
  `Marca` varchar(20) DEFAULT NULL,
  `Modelo` varchar(20) DEFAULT NULL,
  `Serie` varchar(20) DEFAULT NULL,
  `Tipo_Equip` varchar(45) DEFAULT NULL,
  `Descricao` varchar(100) DEFAULT NULL,
  `Observacao` varchar(100) DEFAULT NULL,
  `Cod_Tipo_Equip` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Equipamento`),
  KEY `Cod_Tipo_Equip_idx` (`Cod_Tipo_Equip`),
  CONSTRAINT `Cod_Tipo_Equip` FOREIGN KEY (`Cod_Tipo_Equip`) REFERENCES `tipo_equipamento` (`Cod_Tipo_Equipamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamento`
--

LOCK TABLES `equipamento` WRITE;
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
INSERT INTO `equipamento` VALUES (1,1,'Dell','VPN123','123123123',NULL,'','',2),(2,3,'AS','adsasd','',NULL,'','',1),(3,5,'DELL','VPN123-123','asçdlk1312312',NULL,'asdfsadf,sa.dfm.','.safm.sadfm.sadmf.,sdfm.,sd',2),(4,1,'Sony','VPP-13A25PBS','-0423-0592-032',NULL,'.,mxv,mx.cmxz.vmsalfdkdslkjfl','alkjsdaljaklsjflkasjfl',2);
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `Cod_Funcionario` int(11) NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `Sexo` varchar(10) DEFAULT NULL,
  `Data_Nasc` date DEFAULT NULL,
  `RG` varchar(12) DEFAULT NULL,
  `CPF` varchar(14) DEFAULT NULL,
  `Telefone` varchar(14) DEFAULT NULL,
  `Endereco` varchar(50) DEFAULT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  `Bairro` varchar(30) DEFAULT NULL,
  `Cidade` varchar(40) DEFAULT NULL,
  `Estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cod_Funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Bonzão','Masculino','1999-01-11','  .   .   - ','   .   .   -  ','(  )     -    ','','  .   -   ','','','Acre'),(2,'Maomeno kkkkk','Masculino','1999-01-02','  .   .   - ','   .   .   -  ','(  )     -    ','','  .   -   ','','','Acre'),(3,'Fábio Capelini','Masculino','1990-01-12','  .   .   - ','234.234.234-23','(  )     -    ','','  .   -   ','','','Acre');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_os_peca`
--

DROP TABLE IF EXISTS `item_os_peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_os_peca` (
  `Cod_os1` int(11) NOT NULL,
  `Cod_Peca` int(11) NOT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  `Preco` float DEFAULT NULL,
  PRIMARY KEY (`Cod_os1`,`Cod_Peca`),
  KEY `Cod_orc_idx` (`Cod_os1`),
  KEY `Cod_Peca_idx` (`Cod_Peca`),
  CONSTRAINT `Cod_OS1` FOREIGN KEY (`Cod_os1`) REFERENCES `os` (`Cod_Os`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Cod_Peca` FOREIGN KEY (`Cod_Peca`) REFERENCES `peca` (`Cod_Peca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_os_peca`
--

LOCK TABLES `item_os_peca` WRITE;
/*!40000 ALTER TABLE `item_os_peca` DISABLE KEYS */;
INSERT INTO `item_os_peca` VALUES (1,1,'Fonte ATX',55),(2,1,'FonteATX',55);
/*!40000 ALTER TABLE `item_os_peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_os_serv`
--

DROP TABLE IF EXISTS `item_os_serv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_os_serv` (
  `Cod_os2` int(11) NOT NULL,
  `Cod_Serv` int(11) NOT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  `Preco` float DEFAULT NULL,
  PRIMARY KEY (`Cod_os2`,`Cod_Serv`),
  KEY `Cod_Servico_idx` (`Cod_Serv`),
  CONSTRAINT `Cod_OS2` FOREIGN KEY (`Cod_os2`) REFERENCES `os` (`Cod_Os`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Cod_Serv` FOREIGN KEY (`Cod_Serv`) REFERENCES `servico` (`Cod_Servico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_os_serv`
--

LOCK TABLES `item_os_serv` WRITE;
/*!40000 ALTER TABLE `item_os_serv` DISABLE KEYS */;
INSERT INTO `item_os_serv` VALUES (1,1,'Formatação Completa',80),(2,1,'Backup de Dados',80);
/*!40000 ALTER TABLE `item_os_serv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `os`
--

DROP TABLE IF EXISTS `os`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `os` (
  `Cod_Os` int(11) NOT NULL,
  `Cod_Cliente` int(11) NOT NULL,
  `Cod_Funcionario` int(11) NOT NULL,
  `Cod_Equipamento` int(11) NOT NULL,
  `Data_Ent` date NOT NULL,
  `Data_Saida` date DEFAULT NULL,
  `Situacao` varchar(45) NOT NULL,
  `Valor_Servicos` float NOT NULL,
  `Valor_Pecas` float NOT NULL,
  `Valor_Outros` float NOT NULL,
  `Valor_Total` float NOT NULL,
  PRIMARY KEY (`Cod_Os`),
  KEY `Equipamento_idx` (`Cod_Equipamento`),
  KEY `Funcionario_idx` (`Cod_Funcionario`),
  KEY `Cliente_idx` (`Cod_Cliente`),
  CONSTRAINT `Cliente` FOREIGN KEY (`Cod_Cliente`) REFERENCES `cliente` (`Cod_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Equipamento` FOREIGN KEY (`Cod_Equipamento`) REFERENCES `equipamento` (`Cod_Equipamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Funcionario` FOREIGN KEY (`Cod_Funcionario`) REFERENCES `funcionario` (`Cod_Funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os`
--

LOCK TABLES `os` WRITE;
/*!40000 ALTER TABLE `os` DISABLE KEYS */;
INSERT INTO `os` VALUES (1,2,2,2,'1900-01-01','1900-01-01','Aguardando Autorização do Orçamento',109,605,0,714),(2,4,1,4,'1900-01-01','1900-01-01','Aguardando Autorização do Orçamento',29,0,0,29);
/*!40000 ALTER TABLE `os` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peca`
--

DROP TABLE IF EXISTS `peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peca` (
  `Cod_Peca` int(11) NOT NULL,
  `Descricao` varchar(45) NOT NULL,
  `Preco` float NOT NULL,
  PRIMARY KEY (`Cod_Peca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peca`
--

LOCK TABLES `peca` WRITE;
/*!40000 ALTER TABLE `peca` DISABLE KEYS */;
INSERT INTO `peca` VALUES (1,'Fonte ATX',55),(2,'Placa Mãe',550);
/*!40000 ALTER TABLE `peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `Cod_Servico` int(11) NOT NULL,
  `Descricao` varchar(45) NOT NULL,
  `Preco` float NOT NULL,
  PRIMARY KEY (`Cod_Servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'Formatação Completa',80),(2,'Backup dos dados',29);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_equipamento`
--

DROP TABLE IF EXISTS `tipo_equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_equipamento` (
  `Cod_Tipo_Equipamento` int(11) NOT NULL,
  `Descricao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cod_Tipo_Equipamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_equipamento`
--

LOCK TABLES `tipo_equipamento` WRITE;
/*!40000 ALTER TABLE `tipo_equipamento` DISABLE KEYS */;
INSERT INTO `tipo_equipamento` VALUES (1,'Desktop'),(2,'Notebook'),(3,'Tablet'),(4,'Impressora'),(5,'Teclado');
/*!40000 ALTER TABLE `tipo_equipamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-29 23:04:12
