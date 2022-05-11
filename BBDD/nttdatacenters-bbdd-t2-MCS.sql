-- Funcion para saber el instituto segun el alumno.

delimiter $$ 
create function mostrar_alumno_instituto (nombre_alumno varchar(100))



returns varchar(100) 
deterministic
begin
	
	declare instituto varchar(100) ;
	
	set instituto = (select i.nombre 
	from persona p inner join alumno a ON p.DNI = a.DNI inner join instituto i on i.nombre  = a.instituto 
	where p.nombre = nombre_alumno);
	
	
	return instituto; 
	
end $$


-- Procedimiento que al llamarlo muestra en distintas consultas la cuenta de todos los alumnos usando al funcion de arriba.

delimiter $$ 
create procedure mostrar_cuenta_alumnos_alixar()

begin 
	
	declare done bool default false;
	declare salida varchar(100);
	declare resultado varchar (100);
	
	
	declare c1 cursor for 
	select p.nombre from persona p inner join alumno a on a.DNI = p.DNI;
	
	declare continue handler for not found set done = true;
	
	open c1;

	while(not done) do
	fetch c1 into resultado;
	set salida  = mostrar_alumno_instituto (resultado);
	if( salida like "IES Alixar")
	then 
	select c.*
	from persona p inner join cuenta c on p.DNI = c.dni where p.nombre = resultado;
	end if;
	end while;
	close c1;

	
end $$

delimiter ;

-- Llamada al procedimiento, cabe recalcar que solo ejecutaremos una vez el procedimiento y la funcion porque no se eliminan cuando se crear,
-- y es necesario para usar el procedimiento solamente llamarlo tras la primera vez.

call mostrar_cuenta_alumnos_alixar;
