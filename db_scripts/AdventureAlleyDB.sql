DROP DATABASE IF EXISTS AdventureAlleyDB;
CREATE DATABASE AdventureAlleyDB;
USE AdventureAlleyDB;

DROP USER IF EXISTS 'groot'@'localhost';
CREATE USER 'groot'@'localhost' IDENTIFIED BY 'iamgroot';
GRANT ALL ON * TO 'groot'@'localhost';

CREATE TABLE Activity (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    age_restriction INT,
    description TEXT NOT NULL
);