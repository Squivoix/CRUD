CREATE DATABASE Biblioteca;

USE Biblioteca;

CREATE TABLE books
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    isbn VARCHAR(20) NOT NULL,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    publisher VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    observations VARCHAR(350),
    borrowed BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE users
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    profile INT NOT NULL
);

CREATE TABLE borrows
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_book INT NOT NULL,
	id_user INT NOT NULL,
	date_borrow DATETIME NOT NULL DEFAULT NOW(),
	date_devolution DATETIME NOT NULL DEFAULT (NOW() + INTERVAL 7 DAY),
	date_effective DATETIME,
    is_returned BOOLEAN DEFAULT FALSE
);

INSERT INTO users (name, email, password, profile) VALUES ("admin", "admin", "admin", 5);
INSERT INTO users (name, email, password, profile) VALUES ("victor", "victor", "123", 1);

INSERT INTO books (isbn, title, author, publisher, year, observations) VALUES ("85-85961-35-X", "A doutrina do coração", "Annie Besant", "Teosófica", 2012, "118 páginas");
INSERT INTO books (isbn, title, author, publisher, year, observations) VALUES ("978-85-254-3218-6", "Sapiens - Uma breve história da humanidade", "Yuval Noah Harari", "L&PM", 1976, "459 páginas");
INSERT INTO books (isbn, title, author, publisher, year, observations) VALUES ("978-85-8057-226-1", "A culpa é das estrelas", "John Green", "Intrínseca LTDA", 2012, "283 páginas");
INSERT INTO books (isbn, title, author, publisher, year, observations) VALUES ("978-85-910837-0-1", "Os guarinis e a rosa dos ventos", "J. C. M. Oliveira J.", "Idealiza", 2010, "279 páginas");
INSERT INTO books (isbn, title, author, publisher, year, observations) VALUES ("978-85-01-91200-8", "O encontro marcado", "Fernando Sabino", "Record", 2013, "365 páginas");
INSERT INTO books (isbn, title, author, publisher, year, observations) VALUES ("85-351-0534-4", "Relações perigosas", "Choderlos de Laclos", "Nova Cultural", 1995, "320 páginas");
INSERT INTO books (isbn, title, author, publisher, year, observations) VALUES ("978-85-01-04445-7", "O diário de Anne Frank", "", "Record", 2014, "349 páginas");
INSERT INTO books (isbn, title, author, publisher, year, observations) VALUES ("978-85-01-04066-4", "Doze contos peregrinos", "Gabriel García Marquez", "Record", 2014, "255 páginas");

SELECT * FROM books ORDER BY id ASC;

SELECT * FROM books;
SELECT * FROM users;
SELECT * FROM borrows;

DROP DATABASE Biblioteca;