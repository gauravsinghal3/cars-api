create table car(
    id LONG not null primary key,
    name VARCHAR(100) not null,
    manufacture_name VARCHAR(100) not null,
    model VARCHAR(100) not null,
    manufacture_year int not null,
    color VARCHAR(50) not null);


create table user(
    id LONG not null primary key,
    username VARCHAR(100) not null,
    password VARCHAR(30) not null);