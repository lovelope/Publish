/*
Navicat MySQL Data Transfer

Source Server         : myuser
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : publish

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-07-02 21:35:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mesNo` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(4096) NOT NULL,
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `stuNo` varchar(20) NOT NULL,
  PRIMARY KEY (`mesNo`),
  KEY `stuNo` (`stuNo`),
  CONSTRAINT `stuNo` FOREIGN KEY (`stuNo`) REFERENCES `student` (`stuNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuNo` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `job` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(4) NOT NULL,
  PRIMARY KEY (`stuNo`),
  KEY `stuNo` (`stuNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
