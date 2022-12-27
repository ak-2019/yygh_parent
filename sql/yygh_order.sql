/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : yygh_order

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 27/12/2022 14:14:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint NULL DEFAULT NULL,
  `out_trade_no` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单交易号',
  `hoscode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院编号',
  `hosname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院名称',
  `depcode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室编号',
  `depname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室名称',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生职称',
  `schedule_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排班编号（医院自己的排班主键）',
  `reserve_date` date NULL DEFAULT NULL COMMENT '安排日期',
  `reserve_time` tinyint NULL DEFAULT 0 COMMENT '安排时间（0：上午 1：下午）',
  `patient_id` bigint NULL DEFAULT NULL COMMENT '就诊人id',
  `patient_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊人名称',
  `patient_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊人手机',
  `hos_record_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约记录唯一标识（医院预约记录主键）',
  `number` int NULL DEFAULT NULL COMMENT '预约号序',
  `fetch_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建议取号时间',
  `fetch_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '取号地点',
  `amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '医事服务费',
  `quit_time` datetime NULL DEFAULT NULL COMMENT '退号时间',
  `order_status` tinyint NULL DEFAULT NULL COMMENT '订单状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_out_trade_no`(`out_trade_no` ASC) USING BTREE,
  INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
  INDEX `idx_hoscode`(`hoscode` ASC) USING BTREE,
  INDEX `idx_hos_schedule_id`(`schedule_id` ASC) USING BTREE,
  INDEX `idx_hos_record_id`(`hos_record_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (12, 9, '167084773124254', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '63832e663af58f0f5dacdba1', '2022-12-13', 0, 8, '张三', '12345678912', NULL, NULL, NULL, NULL, 100, '2022-12-12 15:30:00', 0, '2022-12-12 20:22:11', '2022-12-12 20:22:11', 0);
INSERT INTO `order_info` VALUES (13, 9, '167085221575319', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '63832e663af58f0f5dacdba1', '2022-12-13', 0, 8, '张三', '12345678912', NULL, NULL, NULL, NULL, 100, '2022-12-12 00:00:00', 0, '2022-12-12 21:36:55', '2022-12-12 21:36:55', 0);
INSERT INTO `order_info` VALUES (14, 9, '167085270506182', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '63832e663af58f0f5dacdba1', '2022-12-13', 0, 8, '张三', '12345678912', NULL, NULL, NULL, NULL, 100, '2022-12-12 00:00:00', 0, '2022-12-12 21:45:05', '2022-12-12 21:45:05', 0);
INSERT INTO `order_info` VALUES (15, 9, '167085283564674', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '63832e663af58f0f5dacdba1', '2022-12-13', 0, 8, '张三', '12345678912', NULL, NULL, NULL, NULL, 100, '2022-12-12 00:00:00', 0, '2022-12-12 21:47:15', '2022-12-12 21:47:15', 0);
INSERT INTO `order_info` VALUES (16, 9, '167085294663135', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '63832e663af58f0f5dacdba1', '2022-12-13', 0, 8, '张三', '12345678912', '11', 12, '2022-12-1309:00前', '一层114窗口', 100, '2022-12-12 00:00:00', 0, '2022-12-12 21:49:06', '2022-12-12 21:49:07', 0);
INSERT INTO `order_info` VALUES (17, 9, '16718538823647', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '1', '2022-12-27', 0, 8, '张三', '12345678912', '12', 13, '2022-12-2709:00前', '一层114窗口', 100, '2022-12-26 00:00:00', 0, '2022-12-24 11:51:22', '2022-12-24 11:51:22', 0);
INSERT INTO `order_info` VALUES (18, 9, '167185706877057', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '1', '2022-12-27', 0, 8, '张三', '12345678912', '13', 14, '2022-12-2709:00前', '一层114窗口', 100, '2022-12-26 00:00:00', -1, '2022-12-24 12:44:28', '2022-12-24 12:44:29', 0);

-- ----------------------------
-- Table structure for payment_info
-- ----------------------------
DROP TABLE IF EXISTS `payment_info`;
CREATE TABLE `payment_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_trade_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对外业务编号',
  `order_id` bigint NULL DEFAULT NULL COMMENT '订单id',
  `payment_type` tinyint(1) NULL DEFAULT NULL COMMENT '支付类型（微信 支付宝）',
  `trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易编号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `subject` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易内容',
  `payment_status` tinyint NULL DEFAULT NULL COMMENT '支付状态',
  `callback_time` datetime NULL DEFAULT NULL COMMENT '回调时间',
  `callback_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调信息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_out_trade_no`(`out_trade_no` ASC) USING BTREE,
  INDEX `idx_order_id`(`order_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_info
-- ----------------------------
INSERT INTO `payment_info` VALUES (10, '167185706877057', 18, 2, '4200001640202212246357990058', 100.00, '2022-12-27|北京协和医院|多发性硬化专科门诊|医师', 2, '2022-12-24 15:50:08', '{transaction_id=4200001640202212246357990058, nonce_str=1fX5URr9Qw73u2dm, trade_state=SUCCESS, bank_type=OTHERS, openid=oHwsHuNUTL1OKsgWS9AvD80fYm0U, sign=05DFE8AAE4B199177B2F7A41726420BD, return_msg=OK, fee_type=CNY, mch_id=1558950191, cash_fee=1, out_trade_no=167185706877057, cash_fee_type=CNY, appid=wx74862e0dfcf69954, total_fee=1, trade_state_desc=支付成功, trade_type=NATIVE, result_code=SUCCESS, attach=, time_end=20221224155007, is_subscribe=N, return_code=SUCCESS}', '2022-12-24 15:35:07', '2022-12-24 15:50:08', 0);

-- ----------------------------
-- Table structure for refund_info
-- ----------------------------
DROP TABLE IF EXISTS `refund_info`;
CREATE TABLE `refund_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对外业务编号',
  `order_id` bigint NULL DEFAULT NULL COMMENT '订单编号',
  `payment_type` tinyint NULL DEFAULT NULL COMMENT '支付类型（微信 支付宝）',
  `trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易编号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款金额',
  `subject` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易内容',
  `refund_status` tinyint NULL DEFAULT NULL COMMENT '退款状态',
  `callback_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调信息',
  `callback_time` datetime NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_out_trade_no`(`out_trade_no` ASC) USING BTREE,
  INDEX `idx_order_id`(`order_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退款信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of refund_info
-- ----------------------------
INSERT INTO `refund_info` VALUES (1, '167185706877057', 18, 2, '50301004452022122428984453434', 100.00, '2022-12-27|北京协和医院|多发性硬化专科门诊|医师', 2, '{\"transaction_id\":\"4200001640202212246357990058\",\"nonce_str\":\"I5IfFblRgee7XgZs\",\"out_refund_no\":\"tk167185706877057\",\"sign\":\"3448D31FE3B151B5AC7AFFDBAC7871AC\",\"return_msg\":\"OK\",\"mch_id\":\"1558950191\",\"refund_id\":\"50301004452022122428984453434\",\"cash_fee\":\"1\",\"out_trade_no\":\"167185706877057\",\"coupon_refund_fee\":\"0\",\"refund_channel\":\"\",\"appid\":\"wx74862e0dfcf69954\",\"refund_fee\":\"1\",\"total_fee\":\"1\",\"result_code\":\"SUCCESS\",\"coupon_refund_count\":\"0\",\"cash_refund_fee\":\"1\",\"return_code\":\"SUCCESS\"}', '2022-12-24 16:15:38', '2022-12-24 16:15:37', '2022-12-24 16:15:38', 0);

SET FOREIGN_KEY_CHECKS = 1;
