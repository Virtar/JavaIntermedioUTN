-- MySQL Script generated by MySQL Workbench
-- Sat Nov 18 17:08:31 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `pass` VARCHAR(255) NOT NULL,
  `rol_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_rol_idx` (`rol_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_rol`
    FOREIGN KEY (`rol_id`)
    REFERENCES `mydb`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tecnico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tecnico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `mail` VARCHAR(255) NULL,
  `numTel` VARCHAR(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`especialidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tecnico_especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tecnico_especialidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tecnico_id` INT NOT NULL,
  `especialidad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tecnico_has_especialidad_especialidad1_idx` (`especialidad_id` ASC) VISIBLE,
  INDEX `fk_tecnico_has_especialidad_tecnico1_idx` (`tecnico_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_tecnico_has_especialidad_tecnico1`
    FOREIGN KEY (`tecnico_id`)
    REFERENCES `mydb`.`tecnico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tecnico_has_especialidad_especialidad1`
    FOREIGN KEY (`especialidad_id`)
    REFERENCES `mydb`.`especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razonSocial` VARCHAR(255) NOT NULL,
  `CUIT` VARCHAR(20) NOT NULL,
  `mail` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`incidente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`incidente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `alias` VARCHAR(255) NOT NULL,
  `fechaEstimada` DATE NOT NULL,
  `fechaDesde` DATE NOT NULL,
  `fechaHasta` DATE NULL,
  `resuelto` TINYINT NOT NULL DEFAULT 0,
  `consideraciones` TEXT NULL,
  `cliente_id` INT NOT NULL,
  `tecnico_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_incidente_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `fk_incidente_tecnico1_idx` (`tecnico_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_incidente_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `mydb`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_incidente_tecnico1`
    FOREIGN KEY (`tecnico_id`)
    REFERENCES `mydb`.`tecnico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`servicio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cliente_servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente_servicio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cliente_id` INT NOT NULL,
  `servicio_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_has_servicio_servicio1_idx` (`servicio_id` ASC) VISIBLE,
  INDEX `fk_cliente_has_servicio_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_has_servicio_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `mydb`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_has_servicio_servicio1`
    FOREIGN KEY (`servicio_id`)
    REFERENCES `mydb`.`servicio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipoProblema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tipoProblema` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `tiempoEstimado(Dias)` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`problema_especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`problema_especialidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipoProblema_id` INT NOT NULL,
  `especialidad_id` INT NOT NULL,
  INDEX `fk_tipoProblema_has_especialidad_especialidad1_idx` (`especialidad_id` ASC) VISIBLE,
  INDEX `fk_tipoProblema_has_especialidad_tipoProblema1_idx` (`tipoProblema_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_tipoProblema_has_especialidad_tipoProblema1`
    FOREIGN KEY (`tipoProblema_id`)
    REFERENCES `mydb`.`tipoProblema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipoProblema_has_especialidad_especialidad1`
    FOREIGN KEY (`especialidad_id`)
    REFERENCES `mydb`.`especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`incidente_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`incidente_detalle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255) NOT NULL,
  `incidente_id` INT NOT NULL,
  `servicio_id` INT NOT NULL,
  `tipoProblema_id` INT NOT NULL,
  INDEX `fk_servicio_has_incidente_incidente1_idx` (`incidente_id` ASC) VISIBLE,
  INDEX `fk_servicio_has_incidente_servicio1_idx` (`servicio_id` ASC) VISIBLE,
  INDEX `fk_servicio_has_incidente_tipoProblema1_idx` (`tipoProblema_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_servicio_has_incidente_servicio1`
    FOREIGN KEY (`servicio_id`)
    REFERENCES `mydb`.`servicio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicio_has_incidente_incidente1`
    FOREIGN KEY (`incidente_id`)
    REFERENCES `mydb`.`incidente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicio_has_incidente_tipoProblema1`
    FOREIGN KEY (`tipoProblema_id`)
    REFERENCES `mydb`.`tipoProblema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
