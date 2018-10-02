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
CREATE VIEW activity_list AS
SELECT
	name
FROM Activity
ORDER BY name;

CREATE TABLE Booking(
  id INT AUTO_INCREMENT PRIMARY KEY,
  date VARCHAR(13) NOT NULL,
  time VARCHAR(13) NOT NULL,
  activity_id INT,

  FOREIGN KEY(activity_id) REFERENCES Activity(id)
);


