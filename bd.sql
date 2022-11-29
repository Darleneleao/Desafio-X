-- Database: cadastro

-- DROP DATABASE IF EXISTS cadastro;

CREATE DATABASE cadastro
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'pt_BR.UTF-8'
    LC_CTYPE = 'pt_BR.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- SCHEMA: sistema

-- DROP SCHEMA IF EXISTS sistema ;

CREATE SCHEMA IF NOT EXISTS sistema
    AUTHORIZATION postgres;

-- Table: sistema.cliente

-- DROP TABLE IF EXISTS sistema.cliente;

CREATE TABLE IF NOT EXISTS sistema.cliente
(
    id integer serial,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    cnpj character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    telefone character varying COLLATE pg_catalog."default" NOT NULL,
    uf character varying COLLATE pg_catalog."default" NOT NULL,
    localizacao character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS sistema.cliente
    OWNER to postgres;

-- Table: sistema.venda

-- DROP TABLE IF EXISTS sistema.venda;

CREATE TABLE IF NOT EXISTS sistema.venda
(
    id integer serial,
    id_cliente integer NOT NULL,
    data date NOT NULL,
    status character varying COLLATE pg_catalog."default" NOT NULL,
    valor double precision NOT NULL,
    CONSTRAINT venda_pkey PRIMARY KEY (id),
    CONSTRAINT fk_idcliente FOREIGN KEY (id_cliente)
        REFERENCES sistema.cliente (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS sistema.venda
    OWNER to postgres;