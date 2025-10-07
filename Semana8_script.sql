CREATE DATABASE IF NOT EXISTS Cine_db; 
USE cinedb;

CREATE TABLE cartelera (
id INT AUTO_INCREMENT PRIMARY KEY, 
titulo varchar (150),
director varchar (50),
anio INT NOT NULL, 
duracion int,
genero ENUM ('Comedia', 'Drama', 'Acción', 'horror', 'CienciaFiccion','Romance' )
);

SELECT * FROM cartelera;




INSERT  INTO cartelera (titulo, director, anio, duracion, genero) values ('Parasite', 'Bong Joon-ho', 2019, 132, 'Drama');
INSERT  INTO cartelera (titulo, director, anio, duracion, genero) values ('Interstellar', 'Christopher nolan', 2014, 169, 'CienciaFiccion');
INSERT  INTO cartelera (titulo, director, anio, duracion, genero) values ('Alien: El Octavo pasajero', 'Ridley Scott', 1979, 117, 'CienciaFiccion');
INSERT  INTO cartelera (titulo, director, anio, duracion, genero) values ('Dune', 'Denis Villevenue', 2021, 155, 'CienciaFiccion');
