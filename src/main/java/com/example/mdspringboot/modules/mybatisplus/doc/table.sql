CREATE TABLE `test` (
                        `id` bigint(20) NOT NULL,
                        `user_name` varchar(255) DEFAULT NULL,
                        `pass_word` varchar(255) DEFAULT NULL,
                        `create_time` datetime DEFAULT NULL,
                        `is_deleted` int(255) DEFAULT NULL,
                        `update_time` datetime DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
                        `id` int(11) DEFAULT NULL,
                        `user_name` varchar(255) DEFAULT NULL,
                        `pass_word` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `base_staff` (
                              `id` bigint(20) NOT NULL COMMENT '主键',
                              `name` varchar(255) DEFAULT NULL COMMENT '名称',
                              `age` int(11) DEFAULT NULL COMMENT '年龄',
                              `sex` int(11) DEFAULT NULL COMMENT '性别',
                              `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                              `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
                              `create_dept` bigint(20) DEFAULT NULL COMMENT '创建部门',
                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                              `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
                              `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                              `status` int(2) DEFAULT NULL COMMENT '状态',
                              `is_deleted` int(2) DEFAULT '0' COMMENT '是否已删除',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='基础表-人员';