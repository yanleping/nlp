# 文章详情表
CREATE TABLE `article_detail` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `author` varchar(50) DEFAULT NULL COMMENT '作者名',
  `title` varchar(100) DEFAULT NULL COMMENT '文章标题 ',
  `digest` varchar(500) DEFAULT NULL COMMENT '首都文字',
  `content` text COMMENT '正文内容',
  `wordCount` int(8) DEFAULT NULL COMMENT '字数',
  PRIMARY KEY (`id`),
  KEY `author_index` (`author`) USING BTREE,
  KEY `title_index` (`title`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 文本相似度查询表
CREATE TABLE `text_similarity` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `text1_id` bigint(11) DEFAULT NULL COMMENT '文本1的id',
  `text2_id` bigint(11) DEFAULT NULL COMMENT '文本2的id',
  `similarityValue` decimal(10,10) DEFAULT NULL COMMENT '相似度的值',
  PRIMARY KEY (`id`),
  KEY `text1_index` (`text1_id`) USING BTREE,
  KEY `text2_index` (`text2_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;