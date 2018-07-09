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

drop table if exists project;
create table project (
	id int(11) not null auto_increment,
    name nvarchar(300) not null comment '项目名称',
    startTime datetime default null comment '项目开始时间',
    endTime datetime default null comment '项目结束时间',
    createTime datetime default null comment '记录创建时间',
    createUser varchar(100) default null comment '记录创建人',
    updateTime datetime default null comment '记录更新时间',
    updateUser datetime default null comment '记录更新人',
    status int(11) not null default 1 comment '记录状态：1-未删除，0-删除',
    primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='项目表';


drop table if exists module;
create table module(
	id int(11) not null auto_increment,
    projectid int(11) not null comment '项目id',
    code varchar(100) not null unique comment '模块编号',
    name nvarchar(300) not null comment '模块名称',
    parentCode varchar(100) not null comment '父模块编号',
    createTime datetime default null comment '记录创建时间',
    createUser varchar(100) default null comment '记录创建人',
    updateTime datetime default null comment '记录更新时间',
    updateUser datetime default null comment '记录更新人',
    status int(11) not null default 1 comment '记录状态：1-未删除，0-删除',
    primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='项目模块表';

drop table if exists task;
create table task(
	id int(11) not null auto_increment,
   
	title nvarchar(100) not null comment '任务标题',
    taskType int not null comment '类型：0-需求 1-BUG',
    taskStatus int not null comment '任务状态： 0-未开始，1-处理中，2-处理完成，3-处理不了',
    
    projectId int not null comment '所属项目',
    moduleId int not null comment '所属模块',
   
	demandor varchar(100) not null comment '提出人',
    assignTo varchar(100) not null comment '分配人',
	solver varchar(100) not null comment '解决人',
    
    content nvarchar(1000) not null comment '任务内容',
    
	putTime datetime not null comment '提出时间',
    
    scheduledStart datetime not null comment '预计开始时间',
    scheduledEnd datetime not null comment '预计结束时间',
   
    createTime datetime default null comment '记录创建时间',
    createUser varchar(100) default null comment '记录创建人',
    updateTime datetime default null comment '记录更新时间',
    updateUser datetime default null comment '记录更新人',
    status int(11) not null default 1 comment '记录状态：1-未删除，0-删除',
    primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='任务表';

drop table if exists taskLine;
create table taskLine(
	id int(11) not null auto_increment,
	taskId int(11) not null comment '任务id',
    lineType int(11) not null comment '任务线类型：0-开始 9-结束 1-暂停 2-普通记录 3-总结 4-SQL',
    createTime datetime default null comment '记录创建时间',
    createUser varchar(100) default null comment '记录创建人',
    updateTime datetime default null comment '记录更新时间',
    updateUser datetime default null comment '记录更新人',
    status int(11) not null default 1 comment '记录状态：1-未删除，0-删除',
    primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='任务线表';





select column_name,data_type,column_comment from information_schema.columns where  table_name = 'task';
select CONCAT('private String ',column_name,';') as b from information_schema.columns where  table_name = 'task';



drop table if exists user;
create table user(
	id int(11) not null auto_increment,
	usercode varchar(50) not null unique,
    password varchar(50) not null,
    createTime datetime default null comment '记录创建时间',
    createUser varchar(100) default null comment '记录创建人',
    updateTime datetime default null comment '记录更新时间',
    updateUser datetime default null comment '记录更新人',
    status int(11) not null default 1 comment '记录状态：1-未删除，0-删除',
    primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用戶表';


drop table if exists role;
create table role(
	id int(11) not null auto_increment,
	roleCode varchar(50) not null unique,
    roleName varchar(50) not null,
    createTime datetime default null comment '记录创建时间',
    createUser varchar(100) default null comment '记录创建人',
    updateTime datetime default null comment '记录更新时间',
    updateUser datetime default null comment '记录更新人',
    status int(11) not null default 1 comment '记录状态：1-未删除，0-删除',
    primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色表';

drop table if exists role;
create table userRole(
	id int(11) not null auto_increment,
    userCode varchar(50) not null,
	roleCode varchar(50) not null,    
    createTime datetime default null comment '记录创建时间',
    createUser varchar(100) default null comment '记录创建人',
    updateTime datetime default null comment '记录更新时间',
    updateUser datetime default null comment '记录更新人',
    status int(11) not null default 1 comment '记录状态：1-未删除，0-删除',
    primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用戶-角色表';
