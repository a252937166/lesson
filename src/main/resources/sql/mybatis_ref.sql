/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : lesson

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 07/09/2019 22:19:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mybatis_ref
-- ----------------------------
DROP TABLE IF EXISTS `mybatis_ref`;
CREATE TABLE `mybatis_ref`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `string_col` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `boolean_col` tinyint(1) NULL DEFAULT NULL,
  `date_col` datetime(0) NULL DEFAULT NULL,
  `time_col` timestamp(0) NULL DEFAULT NULL,
  `int_col` int(255) NULL DEFAULT NULL,
  `long_col` bigint(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mybatis_ref
-- ----------------------------
INSERT INTO `mybatis_ref` VALUES (1, 'string列', 0, '2019-09-07 13:46:33', '2019-09-07 21:28:39', 10, 100000000);
INSERT INTO `mybatis_ref` VALUES (2, 'string列2', 1, '2019-09-07 21:58:35', '2019-09-07 21:58:38', 21, 100000000);
INSERT INTO `mybatis_ref` VALUES (3, 'string列3', 0, '2019-09-07 21:57:46', '2019-09-07 21:57:55', 0, 100000000);
INSERT INTO `mybatis_ref` VALUES (4, 'string列4', 1, '2019-09-07 21:57:49', '2019-09-07 21:57:59', 1, 100000000);
INSERT INTO `mybatis_ref` VALUES (5, 'string列5', 0, '2019-09-07 21:57:57', '2019-09-07 21:58:01', 2, 100000000);

SET FOREIGN_KEY_CHECKS = 1;
