-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: javablog
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `resourceitem`
--

DROP TABLE IF EXISTS `resourceitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourceitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) DEFAULT NULL COMMENT '资源名字',
  `url` varchar(400) DEFAULT NULL COMMENT '资源地址',
  `status` int(11) DEFAULT NULL COMMENT '0：删除，1：未删除',
  `createtime` datetime DEFAULT NULL,
  `createuser` int(11) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `updateuser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='资源项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourceitem`
--

LOCK TABLES `resourceitem` WRITE;
/*!40000 ALTER TABLE `resourceitem` DISABLE KEYS */;
INSERT INTO `resourceitem` VALUES (1,'官方Java教程','https://www.ibm.com/developerworks/cn/java',1,'2018-05-31 00:00:00',1,NULL,NULL),(2,'精选内容：developerWorks 上最受欢迎的 Java 内容','https://www.ibm.com/developerworks/cn/java/j-top-java-content-2017/index.html',1,'2018-05-31 00:00:00',1,NULL,NULL),(3,'Java快速入门','http://www.cnblogs.com/happyframework/p/3332243.html',1,'2018-05-31 00:00:00',1,NULL,NULL),(4,'W3C School 的 Java 基础教程','http://www.runoob.com/java/java-tutorial.html',1,'2018-05-31 00:00:00',1,NULL,NULL),(5,'Java 编程入门','https://www.ibm.com/developerworks/cn/java/intro-to-java-course/index.html',1,'2018-05-31 00:00:00',1,NULL,NULL),(6,'W3C School 的 Eclipse 教程','http://www.runoob.com/eclipse/eclipse-tutorial.html',1,'2018-05-31 00:00:00',1,NULL,NULL),(7,'test','test',1,'2018-05-31 00:00:00',1,NULL,NULL);
/*!40000 ALTER TABLE `resourceitem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-14 17:03:33
