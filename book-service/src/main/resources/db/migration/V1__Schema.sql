CREATE TABLE book
(
    id          INT PRIMARY KEY     NOT NULL,
    isbn        VARCHAR(255) UNIQUE NOT NULL,
    title       VARCHAR(255)        NOT NULL,
    genre       VARCHAR(255)        NOT NULL,
    description VARCHAR(1024)       NOT NULL,
    author      VARCHAR(255)        NOT NULL,
    status      VARCHAR(255)        NOT NULL
);

CREATE SEQUENCE book_id_sequence START 60 INCREMENT 50;

create table users
(
    id       bigserial primary key,
    username varchar(255) not null unique,
    password varchar(255) not null
);