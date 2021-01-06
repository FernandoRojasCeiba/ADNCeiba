update cita
set cedula = :cedula,
    nombre = :nombre,
	apellido = :apellido,
	fecha_cita = :fechaCita,
	tipo_cita = :tipoCita,
	valor = :valor
where id = :id