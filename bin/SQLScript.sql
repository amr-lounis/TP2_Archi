CREATE DATABASE IF NOT EXISTS bdd;
USE `bdd`;
CREATE TABLE IF NOT EXISTS `universite`(
id_universite	INTEGER AUTO_INCREMENT PRIMARY KEY,
nom				varchar(40),
TypePackage		varchar(40)
);
CREATE TABLE IF NOT EXISTS `etudiant` (
matricule	INTEGER AUTO_INCREMENT PRIMARY KEY,
nom			varchar(40),
prenom		varchar(40),
email	 	varchar(250),
pwd			varchar(40),
nbLivreMensuel_Autorise		INTEGER,
nbLivreEmprunte				INTEGER,
id_universite	INTEGER
);
INSERT INTO `bdd`.`universite` (`nom`, `TypePackage`) VALUES ('Universite Alger 1', 'Premium');
INSERT INTO `bdd`.`etudiant` (`nom`, `prenom`, `email`, `pwd`, `nbLivreMensuel_Autorise`, `nbLivreEmprunte`, `id_universite`) VALUES ('lounis', 'amar', 'email', 'password', '1', '1', '1');