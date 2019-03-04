/*
Navicat MySQL Data Transfer

Source Server         : zy
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : health

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-07-25 12:23:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for press
-- ----------------------------
DROP TABLE IF EXISTS `press`;
CREATE TABLE `press` (
  `user_id` varchar(10) DEFAULT NULL,
  `user_press_h` varchar(10) DEFAULT NULL,
  `user_press_l` varchar(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of press
-- ----------------------------
INSERT INTO `press` VALUES ('Alice', '123', '66', '2017-07-11 15:39:19', '1');
INSERT INTO `press` VALUES ('Jack', '119', '72', '2017-07-11 15:44:58', '2');
INSERT INTO `press` VALUES ('Rose', '122', '70', '2017-07-11 15:46:12', '3');
INSERT INTO `press` VALUES ('Rose', '121', '68', '2017-07-11 16:13:19', '4');
INSERT INTO `press` VALUES ('Alice', '128', '71', '2017-07-12 16:13:51', '5');
INSERT INTO `press` VALUES ('Jack', '125', '70', '2017-07-12 16:16:02', '6');
INSERT INTO `press` VALUES ('Jack', '125', '74', '2017-07-12 16:19:26', '7');
INSERT INTO `press` VALUES ('Jack', '119', '69', '2017-07-13 16:37:46', '8');
INSERT INTO `press` VALUES ('Rose', '106', '70', '2017-07-13 16:38:21', '9');
INSERT INTO `press` VALUES ('Alice', '126', '72', '2017-07-13 16:38:54', '10');
INSERT INTO `press` VALUES ('Mike', '112', '68', '2017-07-13 16:39:30', '11');
INSERT INTO `press` VALUES ('Jack', '112', '68', '2017-07-14 16:40:04', '12');
INSERT INTO `press` VALUES ('Jack', '125', '70', '2017-07-14 16:43:31', '13');
INSERT INTO `press` VALUES ('Mike', '121', '66', '2017-07-14 16:56:31', '14');
INSERT INTO `press` VALUES ('Alice', '123', '68', '2017-07-14 16:56:54', '15');
INSERT INTO `press` VALUES ('Rose', '104', '74', '2017-07-15 16:57:12', '16');
INSERT INTO `press` VALUES ('Rose', '111', '78', '2017-07-15 16:57:30', '17');
INSERT INTO `press` VALUES ('Mike', '112', '77', '2017-07-15 16:57:43', '18');
INSERT INTO `press` VALUES ('Mike', '110', '69', '2017-07-16 16:58:03', '19');
INSERT INTO `press` VALUES ('Jack', '123', '68', '2017-07-16 16:58:24', '20');
INSERT INTO `press` VALUES ('Alice', '121', '71', '2017-07-16 16:58:38', '21');
INSERT INTO `press` VALUES ('Mike', '126', '69', '2017-07-17 16:58:55', '22');
INSERT INTO `press` VALUES ('Rose', '118', '70', '2017-07-17 16:59:09', '23');
INSERT INTO `press` VALUES ('Alice', '116', '69', '2017-07-18 16:59:23', '24');
INSERT INTO `press` VALUES ('Mike', '121', '70', '2017-07-18 17:00:01', '25');
INSERT INTO `press` VALUES ('Rose', '107', '77', '2017-07-18 17:00:18', '26');
INSERT INTO `press` VALUES ('Jack', '109', '67', '2017-07-18 17:00:33', '27');
INSERT INTO `press` VALUES ('Jack', '121', '74', '2017-07-18 18:37:42', '28');
INSERT INTO `press` VALUES ('Jack', '121', '74', '2017-07-18 18:37:52', '29');
INSERT INTO `press` VALUES ('Jack', '121', '74', '2017-07-18 18:38:01', '30');
INSERT INTO `press` VALUES ('Jack', '121', '74', '2017-07-18 18:38:11', '31');
INSERT INTO `press` VALUES ('Jack', '125', '71', '2017-07-18 18:38:21', '32');
INSERT INTO `press` VALUES ('Jack', '131', '72', '2017-07-18 18:38:30', '33');
INSERT INTO `press` VALUES ('Jack', '131', '72', '2017-07-18 18:38:40', '34');
INSERT INTO `press` VALUES ('Jack', '125', '70', '2017-07-18 18:38:49', '35');
INSERT INTO `press` VALUES ('Jack', '142', '74', '2017-07-18 18:38:59', '36');
INSERT INTO `press` VALUES ('Jack', '142', '74', '2017-07-18 18:39:09', '37');
INSERT INTO `press` VALUES ('Jack', '142', '74', '2017-07-18 18:39:18', '38');
INSERT INTO `press` VALUES ('Jack', '139', '73', '2017-07-18 18:39:27', '39');
INSERT INTO `press` VALUES ('Jack', '123', '70', '2017-07-18 18:44:42', '40');
INSERT INTO `press` VALUES ('Jack', '122', '69', '2017-07-18 18:44:51', '41');
INSERT INTO `press` VALUES ('Jack', '114', '68', '2017-07-19 01:04:01', '42');
INSERT INTO `press` VALUES ('Jack', '116', '71', '2017-07-19 01:05:27', '43');
INSERT INTO `press` VALUES ('Jack', '134', '69', '2017-07-19 01:07:38', '44');
INSERT INTO `press` VALUES ('Jack', '123', '70', '2017-07-19 11:20:21', '45');
INSERT INTO `press` VALUES ('Jack', '123', '70', '2017-07-19 11:24:31', '46');
INSERT INTO `press` VALUES ('Jack', '121', '73', '2017-07-19 11:24:45', '47');
INSERT INTO `press` VALUES ('Jack', '121', '71', '2017-07-19 11:25:00', '48');
INSERT INTO `press` VALUES ('Jack', '139', '71', '2017-07-19 11:25:14', '49');
INSERT INTO `press` VALUES ('Jack', '127', '71', '2017-07-19 11:25:43', '50');
INSERT INTO `press` VALUES ('Jack', '125', '75', '2017-07-19 11:26:49', '51');
INSERT INTO `press` VALUES ('Jack', '129', '73', '2017-07-19 11:52:56', '52');
INSERT INTO `press` VALUES ('Jack', '108', '67', '2017-07-19 11:54:09', '53');
INSERT INTO `press` VALUES ('Jack', '134', '72', '2017-07-19 11:54:23', '54');
INSERT INTO `press` VALUES ('Jack', '121', '73', '2017-07-19 11:54:52', '55');
INSERT INTO `press` VALUES ('Rose', '140', '72', '2017-07-19 11:55:54', '56');
INSERT INTO `press` VALUES ('Alice', '140', '70', '2017-07-19 11:56:22', '57');
INSERT INTO `press` VALUES ('Jack', '126', '70', '2017-07-19 11:58:00', '58');
INSERT INTO `press` VALUES ('Jack', '136', '72', '2017-07-19 11:58:40', '59');
INSERT INTO `press` VALUES ('Jack', '129', '73', '2017-07-19 11:59:11', '60');
INSERT INTO `press` VALUES ('Jack', '123', '70', '2017-07-19 13:57:18', '61');
INSERT INTO `press` VALUES ('Jack', '122', '69', '2017-07-19 13:58:33', '62');
INSERT INTO `press` VALUES ('Jack', '129', '73', '2017-07-19 13:59:23', '63');
INSERT INTO `press` VALUES ('Jack', '129', '73', '2017-07-19 13:59:52', '64');
INSERT INTO `press` VALUES ('Jack', '124', '70', '2017-07-19 14:00:30', '65');
INSERT INTO `press` VALUES ('Jack', '126', '70', '2017-07-19 14:00:44', '66');
INSERT INTO `press` VALUES ('Jack', '121', '72', '2017-07-19 14:18:06', '67');
INSERT INTO `press` VALUES ('Jack', '130', '71', '2017-07-19 14:18:21', '68');
INSERT INTO `press` VALUES ('Jack', '130', '69', '2017-07-19 14:18:35', '69');
INSERT INTO `press` VALUES ('Jack', '123', '69', '2017-07-19 14:19:03', '70');
INSERT INTO `press` VALUES ('Jack', '140', '69', '2017-07-19 14:19:18', '71');
INSERT INTO `press` VALUES ('Jack', '123', '73', '2017-07-19 14:19:32', '72');
INSERT INTO `press` VALUES ('Jack', '138', '73', '2017-07-19 14:19:46', '73');
INSERT INTO `press` VALUES ('Jack', '122', '70', '2017-07-19 14:20:00', '74');
INSERT INTO `press` VALUES ('Jack', '138', '73', '2017-07-19 14:20:15', '75');
INSERT INTO `press` VALUES ('Jack', '138', '73', '2017-07-19 14:20:29', '76');
INSERT INTO `press` VALUES ('Jack', '136', '72', '2017-07-19 14:20:43', '77');
INSERT INTO `press` VALUES ('Jack', '136', '72', '2017-07-19 14:20:58', '78');
INSERT INTO `press` VALUES ('Jack', '138', '73', '2017-07-19 14:21:12', '79');

-- ----------------------------
-- Table structure for rate
-- ----------------------------
DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate` (
  `user_id` varchar(10) DEFAULT NULL,
  `user_rate` varchar(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate
-- ----------------------------
INSERT INTO `rate` VALUES ('Alice', '74', '2017-07-11 15:39:14', '1');
INSERT INTO `rate` VALUES ('Jack', '91', '2017-07-11 15:44:53', '2');
INSERT INTO `rate` VALUES ('Rose', '71', '2017-07-11 15:46:07', '3');
INSERT INTO `rate` VALUES ('Mike', '72', '2017-07-11 16:13:14', '4');
INSERT INTO `rate` VALUES ('Alice', '75', '2017-07-12 16:13:46', '5');
INSERT INTO `rate` VALUES ('Jack', '78', '2017-07-12 16:15:57', '6');
INSERT INTO `rate` VALUES ('Jack', '64', '2017-07-13 16:19:21', '7');
INSERT INTO `rate` VALUES ('Jack', '64', '2017-07-13 16:37:42', '8');
INSERT INTO `rate` VALUES ('Rose', '99', '2017-07-14 16:38:16', '9');
INSERT INTO `rate` VALUES ('Alice', '98', '2017-07-14 16:38:49', '10');
INSERT INTO `rate` VALUES ('Mike', '76', '2017-07-14 16:39:26', '11');
INSERT INTO `rate` VALUES ('Jack', '77', '2017-07-14 16:39:59', '12');
INSERT INTO `rate` VALUES ('Jack', '98', '2017-07-14 16:43:26', '13');
INSERT INTO `rate` VALUES ('Alice', '88', '2017-07-15 16:49:21', '14');
INSERT INTO `rate` VALUES ('Rose', '86', '2017-07-15 16:49:33', '15');
INSERT INTO `rate` VALUES ('Alice', '80', '2017-07-16 16:49:50', '16');
INSERT INTO `rate` VALUES ('Mike', '95', '2017-07-16 16:50:09', '17');
INSERT INTO `rate` VALUES ('Rose', '82', '2017-07-16 16:50:53', '18');
INSERT INTO `rate` VALUES ('Alice', '97', '2017-07-17 16:51:08', '19');
INSERT INTO `rate` VALUES ('Mike', '84', '2017-07-17 16:51:21', '20');
INSERT INTO `rate` VALUES ('Mike', '85', '2017-07-17 16:51:38', '21');
INSERT INTO `rate` VALUES ('Alice', '73', '2017-07-18 16:51:53', '22');
INSERT INTO `rate` VALUES ('Jack', '89', '2017-07-18 16:53:04', '23');
INSERT INTO `rate` VALUES ('Rose', '95', '2017-07-18 16:54:22', '24');
INSERT INTO `rate` VALUES ('Mike', '79', '2017-07-18 16:54:37', '25');
INSERT INTO `rate` VALUES ('Jack', '73', '2017-07-18 17:00:29', '26');
INSERT INTO `rate` VALUES ('Jack', '127', '2017-07-18 18:37:47', '27');
INSERT INTO `rate` VALUES ('Jack', '104', '2017-07-18 18:38:06', '28');
INSERT INTO `rate` VALUES ('Jack', '117', '2017-07-18 18:38:16', '29');
INSERT INTO `rate` VALUES ('Jack', '115', '2017-07-18 18:38:25', '30');
INSERT INTO `rate` VALUES ('Jack', '112', '2017-07-18 18:38:35', '31');
INSERT INTO `rate` VALUES ('Jack', '92', '2017-07-18 18:38:44', '32');
INSERT INTO `rate` VALUES ('Jack', '72', '2017-07-18 18:38:54', '33');
INSERT INTO `rate` VALUES ('Jack', '77', '2017-07-18 18:39:04', '34');
INSERT INTO `rate` VALUES ('Jack', '82', '2017-07-18 18:39:13', '35');
INSERT INTO `rate` VALUES ('Jack', '78', '2017-07-18 18:39:23', '36');
INSERT INTO `rate` VALUES ('Jack', '64', '2017-07-18 18:44:37', '37');
INSERT INTO `rate` VALUES ('Jack', '61', '2017-07-18 18:44:47', '38');
INSERT INTO `rate` VALUES ('Jack', '77', '2017-07-19 01:03:56', '39');
INSERT INTO `rate` VALUES ('Jack', '79', '2017-07-19 01:05:22', '40');
INSERT INTO `rate` VALUES ('Jack', '97', '2017-07-19 01:07:34', '41');
INSERT INTO `rate` VALUES ('Jack', '78', '2017-07-19 11:20:16', '42');
INSERT INTO `rate` VALUES ('Jack', '71', '2017-07-19 11:24:41', '43');
INSERT INTO `rate` VALUES ('Jack', '91', '2017-07-19 11:24:55', '44');
INSERT INTO `rate` VALUES ('Jack', '94', '2017-07-19 11:25:09', '45');
INSERT INTO `rate` VALUES ('Jack', '74', '2017-07-19 11:25:24', '46');
INSERT INTO `rate` VALUES ('Jack', '72', '2017-07-19 11:25:38', '47');
INSERT INTO `rate` VALUES ('Jack', '72', '2017-07-19 11:26:07', '48');
INSERT INTO `rate` VALUES ('Jack', '79', '2017-07-19 11:26:44', '49');
INSERT INTO `rate` VALUES ('Jack', '72', '2017-07-19 11:26:59', '50');
INSERT INTO `rate` VALUES ('Jack', '73', '2017-07-19 11:52:51', '51');
INSERT INTO `rate` VALUES ('Jack', '75', '2017-07-19 11:54:04', '52');
INSERT INTO `rate` VALUES ('Jack', '72', '2017-07-19 11:54:19', '53');
INSERT INTO `rate` VALUES ('Jack', '72', '2017-07-19 11:54:33', '54');
INSERT INTO `rate` VALUES ('Jack', '96', '2017-07-19 11:55:02', '55');
INSERT INTO `rate` VALUES ('Jack', '96', '2017-07-19 11:55:26', '56');
INSERT INTO `rate` VALUES ('Jack', '75', '2017-07-19 11:57:55', '57');
INSERT INTO `rate` VALUES ('Jack', '89', '2017-07-19 11:58:35', '58');
INSERT INTO `rate` VALUES ('Jack', '75', '2017-07-19 11:58:49', '59');
INSERT INTO `rate` VALUES ('Jack', '73', '2017-07-19 11:59:07', '60');
INSERT INTO `rate` VALUES ('Jack', '79', '2017-07-19 13:57:14', '61');
INSERT INTO `rate` VALUES ('Jack', '71', '2017-07-19 13:58:28', '62');
INSERT INTO `rate` VALUES ('Jack', '73', '2017-07-19 13:59:18', '63');
INSERT INTO `rate` VALUES ('Jack', '73', '2017-07-19 13:59:47', '64');
INSERT INTO `rate` VALUES ('Jack', '71', '2017-07-19 14:00:25', '65');
INSERT INTO `rate` VALUES ('Jack', '70', '2017-07-19 14:00:40', '66');
INSERT INTO `rate` VALUES ('Jack', '72', '2017-07-19 14:18:01', '67');
INSERT INTO `rate` VALUES ('Jack', '72', '2017-07-19 14:18:15', '68');
INSERT INTO `rate` VALUES ('Jack', '77', '2017-07-19 14:18:30', '69');
INSERT INTO `rate` VALUES ('Jack', '77', '2017-07-19 14:18:58', '70');
INSERT INTO `rate` VALUES ('Jack', '78', '2017-07-19 14:19:13', '71');
INSERT INTO `rate` VALUES ('Jack', '70', '2017-07-19 14:19:27', '72');
INSERT INTO `rate` VALUES ('Jack', '77', '2017-07-19 14:19:41', '73');
INSERT INTO `rate` VALUES ('Jack', '76', '2017-07-19 14:19:56', '74');
INSERT INTO `rate` VALUES ('Jack', '76', '2017-07-19 14:20:10', '75');
INSERT INTO `rate` VALUES ('Jack', '72', '2017-07-19 14:20:24', '76');
INSERT INTO `rate` VALUES ('Jack', '74', '2017-07-19 14:20:39', '77');
INSERT INTO `rate` VALUES ('Jack', '97', '2017-07-19 14:20:53', '78');
INSERT INTO `rate` VALUES ('Jack', '95', '2017-07-19 14:21:07', '79');

-- ----------------------------
-- Table structure for tem
-- ----------------------------
DROP TABLE IF EXISTS `tem`;
CREATE TABLE `tem` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_tem` varchar(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  `tem` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tem
-- ----------------------------
INSERT INTO `tem` VALUES ('1', '3698', '2017-07-09 08:38:30', 'Alice', '2719');
INSERT INTO `tem` VALUES ('2', '3698', '2017-07-09 15:45:19', 'Rose', '2897');
INSERT INTO `tem` VALUES ('3', '3695', '2017-07-10 15:45:24', 'Rose', '2958');
INSERT INTO `tem` VALUES ('4', '3660', '2017-07-11 15:46:23', 'Alice', '2910');
INSERT INTO `tem` VALUES ('5', '3620', '2017-07-11 15:46:28', 'Alice', '2988');
INSERT INTO `tem` VALUES ('6', '3617', '2017-07-12 16:09:38', 'Jack', '2736');
INSERT INTO `tem` VALUES ('7', '3647', '2017-07-12 16:13:01', 'Rose', '2679');
INSERT INTO `tem` VALUES ('8', '3610', '2017-07-12 16:13:35', 'Alice', '2726');
INSERT INTO `tem` VALUES ('9', '3680', '2017-07-13 16:14:19', 'Mike', '2770');
INSERT INTO `tem` VALUES ('10', '3671', '2017-07-13 13:33:27', 'Jack', '3101');
INSERT INTO `tem` VALUES ('11', '3680', '2017-07-14 16:34:01', 'Alice', '2802');
INSERT INTO `tem` VALUES ('12', '3641', '2017-07-15 12:00:31', 'Alice', '3001');
INSERT INTO `tem` VALUES ('13', '3631', '2017-07-15 16:35:12', 'Mike', '2731');
INSERT INTO `tem` VALUES ('14', '3629', '2017-07-15 16:37:20', 'Jack', '2619');
INSERT INTO `tem` VALUES ('15', '3620', '2017-07-15 16:38:04', 'Rose', '2682');
INSERT INTO `tem` VALUES ('16', '3636', '2017-07-16 16:38:37', 'Alice', '2726');
INSERT INTO `tem` VALUES ('17', '3617', '2017-07-16 16:39:17', 'Mike', '2785');
INSERT INTO `tem` VALUES ('18', '3617', '2017-07-16 16:39:47', 'Jack', '2807');
INSERT INTO `tem` VALUES ('19', '3603', '2017-07-17 16:40:17', 'Rose', '2779');
INSERT INTO `tem` VALUES ('20', '3607', '2017-07-17 16:43:15', 'Jack', '2830');
INSERT INTO `tem` VALUES ('21', '3621', '2017-07-17 16:43:53', 'Mike', '2931');
INSERT INTO `tem` VALUES ('22', '3641', '2017-07-18 16:46:20', 'Mike', '2831');
INSERT INTO `tem` VALUES ('23', '3682', '2017-07-18 16:47:05', 'Jack', '2833');
INSERT INTO `tem` VALUES ('24', '3620', '2017-07-18 18:43:58', 'Jack', '2932');
INSERT INTO `tem` VALUES ('25', '3691', '2017-07-19 01:04:15', 'Rose', '3047');
INSERT INTO `tem` VALUES ('26', '3679', '2017-07-19 01:04:20', 'Rose', '3073');
INSERT INTO `tem` VALUES ('27', '3648', '2017-07-19 01:05:36', 'Rose', '3080');
INSERT INTO `tem` VALUES ('28', '3686', '2017-07-19 01:06:25', 'Rose', '3080');
INSERT INTO `tem` VALUES ('29', '3625', '2017-07-19 01:07:07', 'Jack', '3098');
INSERT INTO `tem` VALUES ('30', '3669', '2017-07-19 11:20:12', 'Jack', '3204');
INSERT INTO `tem` VALUES ('31', '3669', '2017-07-19 11:24:50', 'Jack', '3164');
INSERT INTO `tem` VALUES ('32', '3631', '2017-07-19 11:25:04', 'Jack', '3264');
INSERT INTO `tem` VALUES ('33', '3645', '2017-07-19 11:25:33', 'Jack', '3575');
INSERT INTO `tem` VALUES ('34', '3625', '2017-07-19 11:25:48', 'Jack', '3614');
INSERT INTO `tem` VALUES ('35', '3625', '2017-07-19 11:26:02', 'Jack', '3636');
INSERT INTO `tem` VALUES ('36', '3651', '2017-07-19 11:26:54', 'Jack', '3453');
INSERT INTO `tem` VALUES ('37', '3638', '2017-07-19 11:52:46', 'Jack', '3465');
INSERT INTO `tem` VALUES ('38', '3686', '2017-07-19 11:53:38', 'Jack', '3195');
INSERT INTO `tem` VALUES ('39', '3607', '2017-07-19 11:54:00', 'Jack', '3235');
INSERT INTO `tem` VALUES ('40', '3610', '2017-07-19 11:54:14', 'Jack', '3235');
INSERT INTO `tem` VALUES ('41', '3697', '2017-07-19 11:54:28', 'Jack', '3230');
INSERT INTO `tem` VALUES ('42', '3695', '2017-07-19 11:56:06', 'Alice', '3264');
INSERT INTO `tem` VALUES ('43', '3675', '2017-07-19 11:57:34', 'Jack', '3291');
INSERT INTO `tem` VALUES ('44', '3680', '2017-07-19 11:58:30', 'Jack', '3317');
INSERT INTO `tem` VALUES ('45', '3685', '2017-07-19 11:58:44', 'Jack', '3317');
INSERT INTO `tem` VALUES ('46', '3637', '2017-07-19 11:59:02', 'Jack', '3333');
INSERT INTO `tem` VALUES ('47', '3637', '2017-07-19 13:59:14', 'Jack', '3037');
INSERT INTO `tem` VALUES ('48', '3610', '2017-07-19 14:00:21', 'Jack', '3286');
INSERT INTO `tem` VALUES ('49', '3682', '2017-07-19 14:00:49', 'Jack', '3282');
INSERT INTO `tem` VALUES ('50', '3670', '2017-07-19 14:17:56', 'Jack', '2858');
INSERT INTO `tem` VALUES ('51', '3642', '2017-07-19 14:18:11', 'Jack', '2880');
INSERT INTO `tem` VALUES ('52', '3657', '2017-07-19 14:18:25', 'Jack', '2897');
INSERT INTO `tem` VALUES ('53', '3667', '2017-07-19 14:18:39', 'Jack', '2910');
INSERT INTO `tem` VALUES ('54', '3642', '2017-07-19 14:18:54', 'Jack', '2919');
INSERT INTO `tem` VALUES ('55', '3675', '2017-07-19 14:19:08', 'Jack', '2936');
INSERT INTO `tem` VALUES ('56', '3680', '2017-07-19 14:19:22', 'Jack', '2947');
INSERT INTO `tem` VALUES ('57', '3648', '2017-07-19 14:19:37', 'Jack', '2954');
INSERT INTO `tem` VALUES ('58', '3670', '2017-07-19 14:19:51', 'Jack', '2963');
INSERT INTO `tem` VALUES ('59', '3625', '2017-07-19 14:20:05', 'Jack', '2967');
INSERT INTO `tem` VALUES ('60', '3675', '2017-07-19 14:20:20', 'Jack', '2973');
INSERT INTO `tem` VALUES ('61', '3670', '2017-07-19 14:20:34', 'Jack', '2980');
INSERT INTO `tem` VALUES ('62', '3685', '2017-07-19 14:20:48', 'Jack', '2995');
INSERT INTO `tem` VALUES ('63', '3612', '2017-07-19 14:29:02', 'Jack', '2995');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(10) DEFAULT NULL,
  `id` varchar(10) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `relation` varchar(20) DEFAULT NULL,
  `no` int(10) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('Jack', 'root', 'root', '爸爸', '1');
INSERT INTO `user` VALUES ('Jack', 'Jack', '123456', '本人', '2');
INSERT INTO `user` VALUES ('Alice', 'Alice', '123456', '本人', '3');
INSERT INTO `user` VALUES ('Mike', 'Mike', '123456', '本人', '4');
INSERT INTO `user` VALUES ('Rose', 'Rose', '123456', '本人', '5');
