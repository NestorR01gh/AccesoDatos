CREATE DATABASE pelis;
USE pelis;

CREATE TABLE pelis (
id INT NOT NULL AUTO_INCREMENT,
imdbId VARCHAR(15) NOT NULL,
titol VARCHAR(50) NOT NULL,
anyo INT NOT NULL,
estrena VARCHAR(50) NOT NULL,
genere VARCHAR(50) NOT NULL,
argument TEXT NOT NULL,
PRIMARY KEY (id));
