
--Archivo SQL para inicializar la base de datos H2

--- Crear tabla USUARIO
INSERT INTO USUARIO (username, nombre, email, edad, clave) VALUES ('Carlos','Carlos Rojas Quintanilla', 'carlos.rojas.ti@hotmail.com', 41, '1234'); 

--- Crear tabla PRODUCTO
INSERT INTO PRODUCTO (nombre, precio, stock) VALUES ('Laptop', 1200000, 10);
INSERT INTO PRODUCTO (nombre, precio, stock) VALUES ('Mouse', 15000, 50);