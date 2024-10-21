create table respuestas (
    id BIGINT not null auto_increment,
    mensaje varchar(255) not null,
    topico_id bigint,
    fecha_creacion datetime not null,
    autor_id bigint,
    solucion varchar(255) not null,

    primary key(id)

);