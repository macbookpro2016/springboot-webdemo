-- Asset.asset definition

CREATE TABLE `asset` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` enum('京东金融','民生','东方财富','负债','招商','公积金','支付宝','华泰','总额','除公积金总') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `num` double(9,2) DEFAULT NULL,
  `create_time` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO Asset.asset (category,num,create_time) VALUES
	 ('京东金融',17.1,'202307'),
	 ('京东金融',17.1,'202308'),
	 ('总额',71.3,'202307'),
	 ('总额',72.6,'202308'),
	 ('除公积金总',47.2,'202307'),
	 ('除公积金总',48.4,'202308'),
	 ('负债',-1.3,'202307'),
	 ('负债',-0.6,'202308'),
	 ('支付宝',4.4,'202307'),
	 ('支付宝',4.6,'202308');
INSERT INTO Asset.asset (category,num,create_time) VALUES
	 ('招商',5.7,'202307'),
	 ('招商',4.0,'202308'),
	 ('民生',12.0,'202307'),
	 ('民生',22.2,'202308'),
	 ('华泰',8.5,'202307'),
	 ('华泰',0.0,'202308'),
	 ('东方财富',0.8,'202307'),
	 ('东方财富',1.1,'202308'),
	 ('公积金',24.1,'202307'),
	 ('公积金',24.2,'202308');
