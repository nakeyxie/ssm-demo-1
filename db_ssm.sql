/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-11-29 14:30:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_title` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '文章标题',
  `article_create_date` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '创建时间',
  `article_content` text COLLATE utf8_bin NOT NULL COMMENT '文章内容',
  `is_top` int(4) NOT NULL DEFAULT '0' COMMENT '是否置顶，1为置顶，默认为0',
  `add_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '添加人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('2', '个人简介', '20171128073932', 0x3C703E0A09E4B880E4B8AA4A415641E88F9CE9B89FEFBC81EFBC81EFBC810A3C2F703E, '0', '仁者');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `path` varchar(150) NOT NULL DEFAULT '' COMMENT '图片地址',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '图片类型',
  `time` varchar(100) NOT NULL DEFAULT '' COMMENT '添加时间',
  `url` varchar(200) NOT NULL DEFAULT '' COMMENT '点击图片的跳转链接',
  `grade` int(11) NOT NULL DEFAULT '1' COMMENT '图片类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('5', 'upload/20170425_1714107.jpg', '1', '2017-04-25 17:15:44', 'url', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户姓名',
  `password` varchar(100) NOT NULL COMMENT '用户密码',
  `imagename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '仁者', 'f1f659145d985b19a583bd62152e6e11', '20171128114216.gif');
