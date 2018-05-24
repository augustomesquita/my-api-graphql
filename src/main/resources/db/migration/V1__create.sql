-- Cria tabelas no banco.
CREATE TABLE movie (
    id bigserial unique primary key,
    name varchar(255) NOT NULL,
    director varchar(255) NOT NULL
);

create table _user (
	id bigserial unique primary key,
        name varchar(255),
        age integer
        --movie_fk bigint,

        --foreign key(movie_fk) references movie(id)
);


-- Insere filmes no banco.
INSERT INTO movie VALUES (1, 'Filme_1', 'Diretor_1');
INSERT INTO movie VALUES (2, 'Filme_2', 'Diretor_2');
INSERT INTO movie VALUES (3, 'Filme_3', 'Diretor_3');
INSERT INTO movie VALUES (4, 'Filme_4', 'Diretor_4');
INSERT INTO movie VALUES (5, 'Filme_5', 'Diretor_5');


-- Insere usuários no banco.
INSERT INTO _user VALUES (1, 'Augusto', 26);
INSERT INTO _user VALUES (2, 'Edgard', 22);
INSERT INTO _user VALUES (3, 'Vanessa', 23);
INSERT INTO _user VALUES (4, 'Leitão', 28);
INSERT INTO _user VALUES (5, 'Afonso', 31);
INSERT INTO _user VALUES (6, 'Jéssica', 22);
INSERT INTO _user VALUES (7, 'Fabiana', 24);