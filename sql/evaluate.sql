/*
Navicat MySQL Data Transfer

Source Server         : zy
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : health

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-08-05 17:36:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `evaluate_time` datetime DEFAULT NULL,
  `evaluate_map` varchar(100) DEFAULT NULL,
  `tem` varchar(10) DEFAULT NULL,
  `tem_describe` varchar(255) DEFAULT NULL,
  `rate` varchar(10) DEFAULT NULL,
  `rate_describe` varchar(255) DEFAULT NULL,
  `press_h` varchar(10) DEFAULT NULL,
  `press_l` varchar(10) DEFAULT NULL,
  `press_describe` varchar(255) DEFAULT NULL,
  `score` varchar(10) DEFAULT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  `t_desc` varchar(100) DEFAULT NULL,
  `p_desc` varchar(100) DEFAULT NULL,
  `r_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1', '2017-08-05 14:37:55', 'Chengdu', '36.12', '体温正常的描述', '95', '心率正常的描述', '138', '73', '平时注意劳逸结合，保证足够睡眠；</br>\r\n	注意调整心态，保持情绪稳定，避免压力过大；</br>\r\n	注意饮食以低钠、低脂肪为主，并且避免摄入含胆固醇过多的食物；</br>\r\n	适当运动，促进血液循环，降低胆固醇的生成，使体重保持在理想范围以内；</br>\r\n	根据病情合理使用降压药物，以使血压维持在正常或接近正常水平，防止病情进展以致心脑血管疾病发生。\r\n', '88', 'Jack', '体温正常', '血压偏高', '心率正常');
INSERT INTO `evaluate` VALUES ('2', '2017-08-05 14:37:55', 'Chengdu', '36.95', '体温正常的描述', '73', '心率正常的描述', '140', '70', '平时注意劳逸结合，保证足够睡眠；</br>\r\n	注意调整心态，保持情绪稳定，避免压力过大；</br>\r\n	注意饮食以低钠、低脂肪为主，并且避免摄入含胆固醇过多的食物；</br>\r\n	适当运动，促进血液循环，降低胆固醇的生成，使体重保持在理想范围以内；</br>\r\n	根据病情合理使用降压药物，以使血压维持在正常或接近正常水平，防止病情进展以致心脑血管疾病发生。\r\n', '88', 'Alice', '体温正常', '血压偏高', '心率正常');
INSERT INTO `evaluate` VALUES ('3', '2017-08-05 14:37:55', 'Chengdu', '36.12', '体温正常的描述', '95', '心率正常的描述', '138', '73', '平时注意劳逸结合，保证足够睡眠；</br>\r\n	注意调整心态，保持情绪稳定，避免压力过大；</br>\r\n	注意饮食以低钠、低脂肪为主，并且避免摄入含胆固醇过多的食物；</br>\r\n	适当运动，促进血液循环，降低胆固醇的生成，使体重保持在理想范围以内；</br>\r\n	根据病情合理使用降压药物，以使血压维持在正常或接近正常水平，防止病情进展以致心脑血管疾病发生。\r\n', '88', 'Jack', '体温正常', '血压偏高', '心率正常');
