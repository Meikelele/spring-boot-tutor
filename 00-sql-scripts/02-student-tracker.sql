create database if not exists `student_tracker`;
use `student_tracker`;


-- usuwanie tabeli student jesli istnieje 
drop table if exists `student`;

create table `student` (
	`id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,
    PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;