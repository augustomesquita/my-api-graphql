-- Cria tabelas no banco.
CREATE TABLE movie (
    id bigserial unique primary key,
    name varchar(255) NOT NULL,
    director varchar(255) NOT NULL
);

create table _user (
	id bigserial unique primary key,
        name varchar(255),
        age integer,
        movie_id bigint,
        foreign key(movie_id) references movie(id)
);


-- Insere filmes no banco.
INSERT INTO movie (name, director) VALUES ('Filme 1', 'Diretor 1');
INSERT INTO movie (name, director) VALUES ('Filme 2', 'Diretor 2');
INSERT INTO movie (name, director) VALUES ('Filme 3', 'Diretor 3');
INSERT INTO movie (name, director) VALUES ('Filme 4', 'Diretor 4');
INSERT INTO movie (name, director) VALUES ('Filme 5', 'Diretor 5');


-- Insere usuários no banco.
INSERT INTO _user (name, age, movie_id) VALUES ('Augusto', 26, 1);
INSERT INTO _user (name, age, movie_id) VALUES ('Edgard',  22, 2);
INSERT INTO _user (name, age, movie_id) VALUES ('Vanessa', 23, 3);
INSERT INTO _user (name, age, movie_id) VALUES ('Leitão',  28, 4);
INSERT INTO _user (name, age, movie_id) VALUES ('Afonso',  27, 5);
INSERT INTO _user (name, age, movie_id) VALUES ('Fabiana', 24, 1);
INSERT INTO _user (name, age, movie_id) VALUES ('Marcelo', 25, 2);
INSERT INTO _user (name, age, movie_id) VALUES ('José Gilson', 25, 2);