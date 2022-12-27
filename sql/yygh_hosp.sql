/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : yygh_hosp

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 27/12/2022 14:14:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hospital_set
-- ----------------------------
DROP TABLE IF EXISTS `hospital_set`;
CREATE TABLE `hospital_set`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `hosname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院名称',
  `hoscode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院编号',
  `api_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'api基础路径',
  `sign_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签名秘钥',
  `contacts_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `contacts_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人手机',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_hoscode`(`hoscode` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医院设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital_set
-- ----------------------------
INSERT INTO `hospital_set` VALUES (2, '北京协和医院', '1000_0', 'http://localhost:9998/', '674c4139707728439a6510eae12deea9', '22', '22', 0, '2021-12-01 11:36:01', '2021-12-12 17:39:48', 0);
INSERT INTO `hospital_set` VALUES (3, '北京协和医院111', '1000_1', 'http://localhost:9998/', '674c4139707728439a6510eae12deea9', '22', '22', 1, '2021-12-01 11:36:01', '2021-12-12 17:39:48', 0);
INSERT INTO `hospital_set` VALUES (4, '北京协和医院2', '1000_2', 'http://localhost:9998/', '674c4139707728439a6510eae12deea9', '22', '22', 1, '2021-12-01 11:36:01', '2021-12-12 17:39:48', 0);
INSERT INTO `hospital_set` VALUES (5, '北京协和医院3', '1000_3', 'http://localhost:9998/', '674c4139707728439a6510eae12deea9', '22', '22', 0, '2021-12-01 11:36:01', '2021-12-12 17:07:28', 0);
INSERT INTO `hospital_set` VALUES (6, '北京协和医院4', '1000_4', 'http://localhost:9998/', '545f43299a7a9102dec7559e99d43f2a', '22', '22', 1, '2021-12-12 18:05:20', '2021-12-12 18:05:20', 0);

SET FOREIGN_KEY_CHECKS = 1;
