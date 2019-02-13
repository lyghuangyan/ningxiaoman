/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 13/02/2019 16:41:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for att
-- ----------------------------
DROP TABLE IF EXISTS `att`;
CREATE TABLE `att`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_no` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time1` datetime(0) NULL DEFAULT NULL,
  `time2` datetime(0) NULL DEFAULT NULL,
  `time3` datetime(0) NULL DEFAULT NULL,
  `time4` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of att
-- ----------------------------
INSERT INTO `att` VALUES (9, 20627, '杨宗煜', '总公司', '2019-01-18 08:00:00', '2019-01-18 12:00:11', '2019-01-18 13:23:38', '2019-01-18 17:30:00');
INSERT INTO `att` VALUES (10, 20627, '杨宗煜', '总公司', '2019-01-19 07:57:50', '2019-01-19 12:00:00', '2019-01-19 13:30:00', '2019-01-19 17:30:00');
INSERT INTO `att` VALUES (11, 20628, '高力士', '总公司', '2019-01-20 08:00:00', '2019-01-20 12:00:00', '2019-01-20 13:30:00', '2019-01-20 17:58:53');

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_no` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attendance_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (1, 20627, '杨宗煜', '总公司', '2019-01-18 12:00:11');
INSERT INTO `attendance` VALUES (2, 20627, '杨宗煜', '总公司', '2019-01-18 13:23:38');
INSERT INTO `attendance` VALUES (3, 20627, '杨宗煜', '总公司', '2019-01-19 07:57:50');
INSERT INTO `attendance` VALUES (4, 20627, '杨宗煜', '总公司', '2019-01-19 07:58:53');
INSERT INTO `attendance` VALUES (5, 20628, '高力士', '总公司', '2019-01-20 17:58:53');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '123123', '123123', NULL);
INSERT INTO `user` VALUES (4, '333', '22', '33');
INSERT INTO `user` VALUES (5, 'admin', '12123', '44');
INSERT INTO `user` VALUES (7, '44', '66', '44');
INSERT INTO `user` VALUES (8, '464', '5454', '646');
INSERT INTO `user` VALUES (9, '4646', '3434464', '46');
INSERT INTO `user` VALUES (10, 'd', 'd', 'd');
INSERT INTO `user` VALUES (11, 'w', 'w', 'w');
INSERT INTO `user` VALUES (12, 'dww', 'dw', 'd');
INSERT INTO `user` VALUES (13, 'ewe', 'wew', 'q');
INSERT INTO `user` VALUES (14, 'aea', 'wae', 'aea');
INSERT INTO `user` VALUES (15, 'faf', 'afa', '232');
INSERT INTO `user` VALUES (16, '232', '121', '2242');
INSERT INTO `user` VALUES (17, '5353', '6363', '6363');
INSERT INTO `user` VALUES (18, '3', '131', '131');
INSERT INTO `user` VALUES (19, '424', '525', '2525');
INSERT INTO `user` VALUES (20, '446', '242', '131');
INSERT INTO `user` VALUES (21, '535', '63', '636');
INSERT INTO `user` VALUES (22, 'admin', 'admin', 'adminm');

SET FOREIGN_KEY_CHECKS = 1;
