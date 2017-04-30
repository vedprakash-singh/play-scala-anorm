# --- !Ups

CREATE TABLE students (
    name varchar(255) NOT NULL,
    stream varchar(255) NOT NULL,
    section varchar(255) NOT NULL,
    email varchar(255) NOT NULL
);

# --- !Downs

DROP TABLE students;