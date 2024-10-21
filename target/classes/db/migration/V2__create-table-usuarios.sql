create table usuarios (

    id BIGINT not null auto_increment,
    nombre varchar(255) not null,
    email varchar(255) not null unique,
    username varchar(255) not null unique,
    password varchar(255) not null,

    primary key(id)

);