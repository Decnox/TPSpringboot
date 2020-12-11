CREATE TABLE repository (name varchar(50) PRIMARY KEY NOT NULL, owner varchar(50) NOT NULL, issues int, forks int,  time BIGINT default 0);

CREATE TABLE statistiques (id serial , repo_name varchar(50), entry_type varchar(32),datetime varchar(32), value integer);