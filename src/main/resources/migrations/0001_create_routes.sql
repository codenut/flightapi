--liquibase formatted sql

--changeset mval:1
CREATE TABLE `routes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `origin` varchar(64) DEFAULT NULL,
  `destination` varchar(64) DEFAULT NULL,
  `airline` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--rollback DROP TABLE routes;

