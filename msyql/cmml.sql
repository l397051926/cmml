CREATE TABLE `user_info` (
  `id` bigint(5) NOT NULL AUTO_INCREMENT COMMENT 'key',
  `user_name` varchar(125) NOT NULL COMMENT '用户名字',
  `password` varchar(125) NOT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `is_lock` tinyint(4) DEFAULT '0' COMMENT '是否锁定 1 锁定 0放开',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_id` bigint(5) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_id` bigint(5) DEFAULT NULL COMMENT '修改人id',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记 1删除 0未删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;