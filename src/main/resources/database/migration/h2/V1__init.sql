CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` bit NOT NULL DEFAULT b'1' COMMENT '性别：枚举0女，1男',
  `vip` bit DEFAULT b'0' COMMENT '是否是VIP',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(32) DEFAULT NULL COMMENT 'E-MAIL',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)