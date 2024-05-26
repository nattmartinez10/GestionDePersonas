CREATE DATABASE personas_crud;
USE personas_crud;

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    tipo VARCHAR(30) NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    segundo_nombre VARCHAR(30) NOT NULL,
    apellidos VARCHAR(60) NOT NULL,
    f_nacimiento VARCHAR(30) NOT NULL,
    genero VARCHAR(30) NOT NULL,
    correo VARCHAR(60) NOT NULL,
    celular VARCHAR(10) NOT NULL,
    foto LONGBLOB,
    PRIMARY KEY (id)
);


