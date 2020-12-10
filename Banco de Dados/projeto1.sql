create database projeto1;
show databases;
use projeto1;

create table salasdeteatro(
	email varchar (50) not null,
    senha varchar(50) not null,
    cnpj int primary key,
    nome varchar(50) not null,
    cidade varchar(50) not null
);

create table promo(
	cnpj int primary key,
    endereco varchar (50) not null,
    peca varchar(50) not null,
    preco varchar(50) not null,
    data varchar(100) not null
);

create table sitesdevenda(
	email varchar (50) not null,
    senha varchar(50) not null,
    endereco int (50),
    nome varchar (50) not null,
    telefone varchar (5)
);

