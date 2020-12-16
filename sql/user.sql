/*
Navicat MySQL Data Transfer

Source Server         : MySQL80
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : xxx

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-16 13:53:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(50) NOT NULL,
  `userPassword` varchar(50) DEFAULT NULL,
  `userBalance` double DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userSex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userLocation` varchar(50) DEFAULT NULL,
  `userDocumentType` varchar(50) DEFAULT NULL,
  `userIdentificationNumber` varchar(50) DEFAULT NULL,
  `userNickName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('111', '111', '10000', '欢哥', '女', 'xxxx', '身份证', '197829874293298203', 'hg');
INSERT INTO `user` VALUES ('123', '123', '0.1', '胡雅晖', '男', '多多马', '身份证', '431025111111111111', 'hyh');
