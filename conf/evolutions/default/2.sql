# --- !Ups

INSERT into students(name,stream,section,email)
 VALUES ('VED','CSE','A','vedprak22@gmail.com');
 VALUES ('abc','CSE','A','vedprak22@gmail.com');

# --- !Downs

DELETE FROM students;