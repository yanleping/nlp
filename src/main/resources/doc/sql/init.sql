drop table if exists article;

drop table if exists similarity;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   id                   bigint not null auto_increment comment 'id',
   wid                  bigint comment '文章id',
   author               varchar(200) comment '作者',
   title                varchar(500) comment '标题',
   digest               varchar(1000) comment '文章缩略',
   context              text comment '文章内容',
   word_count           int comment '文章字数',
   create_time          datetime comment '创建时间',
   primary key (id)
);

/*==============================================================*/
/* Table: similarity                                            */
/*==============================================================*/
create table similarity
(
   id                   bigint not null comment 'id',
   current_work_id      bigint comment '当前文章id',
   target_work_id       bigint comment '目标文章id',
   similarity           decimal(20) comment '相似度',
   primary key (id)
);
