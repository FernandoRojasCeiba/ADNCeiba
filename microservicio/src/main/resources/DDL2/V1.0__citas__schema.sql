create table cita (
 id int(11) not null auto_increment,
 cedula varchar(100) not null,
 nombre varchar(45) not null,
 apellido varchar(45) not null,
 fecha_cita datetime null,
 primary key (id)
);