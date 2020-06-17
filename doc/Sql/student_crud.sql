/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : student_crud

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 17/06/2020 04:34:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for scrud_grader
-- ----------------------------
DROP TABLE IF EXISTS `scrud_grader`;
CREATE TABLE `scrud_grader`  (
  `grader_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `grader_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级名',
  `grader_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级描述',
  `is_deleted` int(2) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`grader_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scrud_grader
-- ----------------------------
INSERT INTO `scrud_grader` VALUES (1, '一班', '测试1', 0);
INSERT INTO `scrud_grader` VALUES (2, '二班', '测试2', 0);
INSERT INTO `scrud_grader` VALUES (3, '三班', '测试3', 0);
INSERT INTO `scrud_grader` VALUES (4, '四班', '测试4', 0);
INSERT INTO `scrud_grader` VALUES (5, '五班', '测试5', 0);

-- ----------------------------
-- Table structure for scrud_student
-- ----------------------------
DROP TABLE IF EXISTS `scrud_student`;
CREATE TABLE `scrud_student`  (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `stu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `stu_gender` int(2) NULL DEFAULT 0 COMMENT '学生性别',
  `grader_id` int(11) NULL DEFAULT NULL COMMENT '班级ID',
  `is_deleted` int(2) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scrud_student
-- ----------------------------
INSERT INTO `scrud_student` VALUES (1, '夏无', 0, 3, 0);
INSERT INTO `scrud_student` VALUES (2, '夏天', 1, 2, 0);
INSERT INTO `scrud_student` VALUES (3, '吴岩', 1, 2, 0);
INSERT INTO `scrud_student` VALUES (4, '昊天', 0, 3, 0);
INSERT INTO `scrud_student` VALUES (5, '吴浩', 0, 2, 0);
INSERT INTO `scrud_student` VALUES (6, '浩克', 0, 3, 0);

SET FOREIGN_KEY_CHECKS = 1;
