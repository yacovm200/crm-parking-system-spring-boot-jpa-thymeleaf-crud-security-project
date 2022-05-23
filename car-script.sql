CREATE DATABASE IF NOT EXISTS `parking`;
USE `parking`;


CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `license` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `users` VALUES 
	(1,'David','Adams','2356584'),
	(2,'John','Doe','123213-das'),
	(3,'Ajay','Rao','685-sdw-12');

CREATE TABLE `details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entry_date` date DEFAULT NULL,
  `entry_time` time DEFAULT NULL,
  `exit_date` date DEFAULT NULL,
  `exit_time` time DEFAULT NULL,
  `user_id` int(11),
  PRIMARY KEY (`id`),
  FOREIGN KEY (user_id) REFERENCES users(id)
  ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

  INSERT INTO `details` VALUES 
	(1,"2021-05-11","11:59:59","2021-05-06","14:29:59",1),
	(2,"2020-12-13","23:22:22",null,null,2),
    (3,"2020-12-14","14:59:59",null,null,3);


CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `license` varchar(45) DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `entry_time` time DEFAULT NULL,
  `exit_date` date DEFAULT NULL,
  `exit_time` time DEFAULT NULL,
  `user_id` int(11),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `role` varchar(64) DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `login` (`user_name`,`password`,`role`,`enabled`) VALUES
 ('yacov','$2a$10$Rrjev5RiL.RR.YOM5OvZwudwpTnKuOcnFvXXVyNLZwzpDa.vQe6P2','ROLE_USER', 1),
 ('admin','$2a$10$.yAL9Ro9qH9SfyfDl7Izh.jF0Gtv3U4MYZkwrsTItbgAp2hw3LOSe','ROLE_ADMIN', 1);

