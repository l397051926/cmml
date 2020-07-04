CREATE TABLE `user_info` (
  `id` bigint(5) NOT NULL AUTO_INCREMENT COMMENT 'key',
  `user_name` varchar(125) NOT NULL COMMENT '用户名字',
  `password` varchar(125) NOT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `is_lock` tinyint(4) DEFAULT '0' COMMENT '是否锁定 1 锁定 0放开',
  `create_time` datetime DEFAULT NULL  COMMENT '创建时间',
  `create_id` bigint(5) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_id` bigint(5) DEFAULT NULL COMMENT '修改人id',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记 1删除 0未删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role`  (
  `id` bigint(5) NOT NULL AUTO_INCREMENT COMMENT 'key',
  `role_group_id` bigint(5) COMMENT '角色组id',
  `role_name` varchar(255) COMMENT '角色名字',
  `description` varchar(255) COMMENT '描述信息',
  `create_time` datetime(0)  COMMENT '创建时间',
  `create_id` bigint(5) COMMENT '创建人id',
  `update_time` datetime(0) COMMENT ON UPDATE CURRENT_TIMESTAMP '更新时间',
  `update_id` bigint(5) COMMENT '更新人id',
  `del_flag` tinyint(4) COMMENT '删除标志',
  PRIMARY KEY (`id`)
);

CREATE TABLE `roule_group`  (
  `id` bigint(5) NOT NULL AUTO_INCREMENT COMMENT 'key',
  `group_name` varchar(255) COMMENT '角色组名字',
  `description` varchar(255) COMMENT '描述',
  `parent_id` bigint(5) COMMENT '父节点id',
  `create_time` datetime(0) COMMENT '创建时间',
  `create_id` bigint(0) COMMENT '创建人id',
  `update_time` datetime(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_id` bigint(0) COMMENT '修改人id',
  `del_flag` tinyint(4) DEFAULT 0 COMMENT '删除标识符 0 未删除 1 已删除',
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_role_relation`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'key',
  `user_id` bigint(0) COMMENT '用户id',
  `roule_id` bigint(0) COMMENT '角色id',
  PRIMARY KEY (`id`)
);

CREATE TABLE `priority_info`  (
  `id` bigint(5) NOT NULL COMMENT 'key',
  `priority_name` varchar(255) COMMENT '权限名字',
  `description` varchar(255) COMMENT '描述',
  `parent_id` bigint(5) COMMENT '父节点id',
  `create_time` datetime(0) COMMENT '创建时间',
  `create_id` bigint(5) COMMENT '创建人id',
  `update_time` datetime(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_id` bigint(5) COMMENT '修改人id',
  `del_flag` tinyint(4) DEFAULT 0 COMMENT '删除标识符 0未删除 1删除',
  PRIMARY KEY (`id`)
);

CREATE TABLE `role_priority_relation`  (
  `id` bigint(5) NOT NULL COMMENT 'key',
  `role_id` bigint(5) COMMENT '角色id',
  `priority_id` bigint(5) COMMENT '权限id',
  PRIMARY KEY (`id`)
);