# 文章详情表
CREATE TABLE `aticle_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `author` varchar(50) DEFAULT NULL COMMENT '作者名',
  `title` varchar(100) DEFAULT NULL COMMENT '文章标题 ',
  `digest` varchar(500) DEFAULT NULL COMMENT '首都文字',
  `content` text COMMENT '正文内容',
  `cordCount` int(8) DEFAULT NULL COMMENT '字数',
  PRIMARY KEY (`id`),
  KEY `author_index` (`author`) USING BTREE,
  KEY `title_index` (`title`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;