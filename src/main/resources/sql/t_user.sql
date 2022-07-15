/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.31.205
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 192.168.31.205:3306
 Source Schema         : spring_boot_demo

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 25/09/2021 20:16:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `sex` varchar(8) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (3, 'bob', '333666', 32, ' 男');
INSERT INTO `t_user` VALUES (4, 'ruby', '333333', 25, ' 女');
INSERT INTO `t_user` VALUES (5, 'test', '11', 11, '11');
INSERT INTO `t_user` VALUES (6, 'jimmy', '000000', 33, '男');

SET FOREIGN_KEY_CHECKS = 1;
