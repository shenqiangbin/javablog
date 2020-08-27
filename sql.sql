/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : javablog

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-11-18 11:36:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for loginfo
-- ----------------------------
DROP TABLE IF EXISTS `loginfo`;
CREATE TABLE `loginfo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) DEFAULT '',
  `level` varchar(255) DEFAULT '',
  `content` varchar(3000) DEFAULT '',
  `ip` varchar(55) DEFAULT '',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
