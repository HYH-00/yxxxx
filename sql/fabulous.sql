/*
Navicat MySQL Data Transfer

Source Server         : MySQL80
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : xxx

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-16 13:53:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fabulous
-- ----------------------------
DROP TABLE IF EXISTS `fabulous`;
CREATE TABLE `fabulous` (
  `fabulousId` int NOT NULL AUTO_INCREMENT,
  `wechatmomentsId` int DEFAULT NULL,
  `userNick` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fabulousId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fabulous
-- ----------------------------
INSERT INTO `fabulous` VALUES ('1', '2', 'cg');
INSERT INTO `fabulous` VALUES ('2', '3', 'cg');
INSERT INTO `fabulous` VALUES ('3', '2', 'hjh');
INSERT INTO `fabulous` VALUES ('4', '2', 'kk');
INSERT INTO `fabulous` VALUES ('8', '11', 'hyh');
