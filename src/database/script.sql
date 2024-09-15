create database compta;

\c compta

create table role(
    id serial primary key,
    code_role varchar(255)
);


insert into role(code_role) values ('ADMIN');
insert into role(code_role) values ('USER');


create table utilisateur(
    id serial primary key,
    idRole int references role(id),
    username varchar(255),
    email varchar(255),
    password text
);


insert into utilisateur(idRole,username,email,password) values (1,'admin','admin@gmail.com','tesst');


create table actif(
    id serial primary key,
    date_acquisition date,
    actif_valeur decimal(15,2),
    actif_nom varchar(255)
);

create table passif(
    id serial primary key,
    date_acquisition date,
    passif_valeur decimal(15,2),
    passif_nom varchar(255)
);

