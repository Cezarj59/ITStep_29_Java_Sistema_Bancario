CREATE DATABASE bancoJava2;

CREATE TABLE contaCorrente(
	id int PRIMARY KEY AUTO_INCREMENT,
    senha varchar(30) NOT NULL DEFAULT "",
    login varchar(30) NOT NULL DEFAULT "",
    nome varchar(80) NOT NULL DEFAULT "",
    agencia varchar(10) NOT NULL DEFAULT "",
    conta varchar(30) NOT NULL DEFAULT "",
    saldo double NOT NULL DEFAULT 0   
);

CREATE TABLE contaPJ(
	id int PRIMARY KEY AUTO_INCREMENT,
    senha varchar(30) NOT NULL DEFAULT "",
    login varchar(30) NOT NULL DEFAULT "",
    nome varchar(80) NOT NULL DEFAULT "",
    agencia varchar(10) NOT NULL DEFAULT "",
    conta varchar(30) NOT NULL DEFAULT "",
    saldo double NOT NULL DEFAULT 0   
);

CREATE TABLE contaPoupanca(
	id int PRIMARY KEY AUTO_INCREMENT,
    senha varchar(30) NOT NULL DEFAULT "",
    login varchar(30) NOT NULL DEFAULT "",
    nome varchar(80) NOT NULL DEFAULT "",
    agencia varchar(10) NOT NULL DEFAULT "",
    conta varchar(30) NOT NULL DEFAULT "",
    saldo double NOT NULL DEFAULT 0   
);
