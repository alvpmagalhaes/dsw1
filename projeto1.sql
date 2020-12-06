create database projeto1;
show databases;
use projeto1;

create table SiteVendaDeIngressos(
	nome varchar (50) not null,
    email varchar(50) not null,
    senha nvarchar(50) not null,
    url varchar(50),
    telefone varchar(50)
);

create table SalasDeTeatro(
	CNPJ int primary key,
    nome varchar (50) not null,
    email varchar(50) not null,
    senha nvarchar(50) not null,
    cidade varchar(100) not null
);

create table CadastroPromocoes(
	CNPJ int primary key,
    nome_peca varchar (50) not null,
    url varchar(50),
    preco int (10),
    dia int (2),
    horario varchar (5)
);