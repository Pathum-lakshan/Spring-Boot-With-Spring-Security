-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema springSecurity
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema springSecurity
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springSecurity` DEFAULT CHARACTER SET utf8 ;
USE `springSecurity` ;

-- -----------------------------------------------------
-- Table `springSecurity`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springSecurity`.`user` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `username` VARCHAR(150) NOT NULL,
                                                       `password` VARCHAR(16) NOT NULL,
                                                       `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                       `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                       `delete` TINYINT(1) NOT NULL DEFAULT 1,
                                                       PRIMARY KEY (`id`),
                                                       UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                       UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
