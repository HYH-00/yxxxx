/*
Navicat MySQL Data Transfer

Source Server         : MySQL80
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : xxx

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-16 13:53:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wechatmoments
-- ----------------------------
DROP TABLE IF EXISTS `wechatmoments`;
CREATE TABLE `wechatmoments` (
  `userId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userNickName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `date` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `wechatmomentsId` int NOT NULL AUTO_INCREMENT,
  `fabulous` int DEFAULT '0',
  PRIMARY KEY (`wechatmomentsId`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

-- ----------------------------
-- Records of wechatmoments
-- ----------------------------
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'test', '2020/12/13', '1', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx', '2020/12/14', '2', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx', '2020/12/14', '3', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx', '2020/12/14', '4', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx', '2020/12/14', '5', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx', '2020/12/14', '6', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx', '2020/12/14', '7', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx8', '2020/12/14', '8', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx9', '2020/12/14', '9', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx10', '2020/12/14', '10', '0');
INSERT INTO `wechatmoments` VALUES ('123', 'hyh', 'xxx11', '2020/12/14', '11', '0');
