/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.11
Source Server Version : 50626
Source Host           : 192.168.0.11:3306
Source Database       : note

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-12-09 00:52:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `enable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '2015-12-09 00:37:50', '分类1', '分类1', '2015-12-09 00:38:00', '1', '');
INSERT INTO `category` VALUES ('2', '2015-12-09 00:38:06', '分类2', '分类2', '2015-12-09 00:38:12', '1', '');
INSERT INTO `category` VALUES ('3', '2015-12-09 00:38:23', '分类3', '分类3', '2015-12-09 00:38:19', '1', '');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `tags` tinyblob,
  `title` varchar(255) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `title_pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('1', null, '<p>1123</p>\r\n\r\n<pre>\r\n<code class=\"language-java\">int a=2;</code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '2015-12-09 00:46:56', 0xACED0005757200145B4C6A6176612E6C616E672E496E74656765723BFE97ADA00183E21B020000787000000002737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000017371007E000200000002, 'q', '2015-12-09 00:46:56', '1', 'images/zanwutupian.gif');
INSERT INTO `note` VALUES ('2', '2', '<p>112322212312312312</p>\r\n\r\n<pre>\r\n<code class=\"language-java\">int a=2;</code></pre>\r\n\r\n<p>&nbsp;</p>\r\n', '2015-12-09 00:50:14', 0xACED0005757200145B4C6A6176612E6C616E672E496E74656765723BFE97ADA00183E21B020000787000000002737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000017371007E000200000002, 'q11111', '2015-12-09 00:50:14', '1', 'images/zanwutupian.gif');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `enable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', '2015-12-08 23:01:16', '描述', '标签1', '2015-12-08 23:01:24', '1', '');
INSERT INTO `tag` VALUES ('2', '2015-12-09 00:17:55', '描述2', '标签2', '2015-12-09 00:18:06', '1', '');
INSERT INTO `tag` VALUES ('3', '2015-12-09 00:18:26', '描述3', '标签3', '2015-12-09 00:18:35', '1', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(32) DEFAULT NULL,
  `enable` bit(1) NOT NULL,
  `github` varchar(255) DEFAULT NULL,
  `lastest_login_ip` varchar(32) DEFAULT NULL,
  `lastest_login_time` datetime DEFAULT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `nick_name` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `reg_time` datetime NOT NULL,
  `roles` int(11) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nick_name` (`nick_name`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'baixiaozheng@163.com', '', null, '127.0.0.1', '2015-12-09 00:49:47', '18962640879', 'baixiaozheng', '96e79218965eb72c92a549dd5a330112', null, '白效正', '2015-11-25 01:03:56', '1', null);
