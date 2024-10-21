create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(200) not null,
    fecha_creacion datetime not null,
    estatus varchar(100) not null,
    autor_id bigint,
    curso_id bigint,

    primary key(id)

);