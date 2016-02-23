SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `ADVANSE` ;
CREATE SCHEMA IF NOT EXISTS `ADVANSE` 
DEFAULT CHARACTER SET utf8;
USE `ADVANSE` ;

-- -----------------------------------------------------
-- Table `ADVANSE`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ADVANSE`.`students` (
  `sID`			INT(11) NOT NULL AUTO_INCREMENT,
  `fullName` 	VARCHAR(250) NOT NULL,
  `password`	VARCHAR(250) NOT NULL,
  PRIMARY KEY (`sID`)
  /*UNIQUE KEY `fullName` (`username` ASC));*/
);
  
-- -----------------------------------------------------
-- Table `ADVANSE`.`courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ADVANSE`.`courses` (
  `cID`				INT(11) NOT NULL AUTO_INCREMENT,
  `course`			VARCHAR(100) NOT NULL,
  `units`			INT(11) NOT NULL,
  `maxStudent` 		INT(11) NOT NULL,
  `numOfEnrollees`	INT(11) NOT NULL,
  PRIMARY KEY (`cID`)
);

INSERT INTO `ADVANSE`.`courses` (cID, course, units, maxStudent, numOfEnrollees) 
	VALUES (1,"SOFTWENG",	3,5, 0),
		   (2,"THESIS",		6,3, 0),
		   (3,"PE",			3,5, 0),
		   (4,"ELECTIVE",	1,10,0),
		   (5,"THESIS",		3,5, 0);

-- -----------------------------------------------------
-- Table `ADVANSE`.`enrolledCourses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ADVANSE`.`enrolledCourses`(
  `cID`	INT(11) NOT NULL,
  `sID`	INT(11) NOT NULL,
  FOREIGN KEY (`cID`) REFERENCES courses(`cID`),
  FOREIGN KEY (`SID`) REFERENCES students(`sID`)
)
  
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
