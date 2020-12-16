/*
Navicat MySQL Data Transfer

Source Server         : MySQL80
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : xxx

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-16 13:53:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `wechatmomentsId` int DEFAULT NULL,
  `respondents` varchar(50) DEFAULT NULL,
  `recipient` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  KEY `wechatmomentsId` (`wechatmomentsId`),
  CONSTRAINT `wechatmomentsId` FOREIGN KEY (`wechatmomentsId`) REFERENCES `wechatmoments` (`wechatmomentsId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', 'oh', '1', 'cg', 'hyh');
INSERT INTO `comment` VALUES ('2', 'kasjdh', '2', 'cg', 'hyh');
INSERT INTO `comment` VALUES ('3', 'kkkk', '2', 'cg', 'hyh');
INSERT INTO `comment` VALUES ('4', 'cgnp', '2', 'cg', 'hyh');
INSERT INTO `comment` VALUES ('5', 'oh', '2', 'cg', 'hyh');
INSERT INTO `comment` VALUES ('15', 'hjh', '2', 'hyh', 'hyh');
INSERT INTO `comment` VALUES ('16', 'test', '3', 'hyh', 'hyh');
INSERT INTO `comment` VALUES ('17', '好家伙', '2', 'hg', 'hyh');
INSERT INTO `comment` VALUES ('18', '洵哥hh', '11', 'hyh', 'hyh');
