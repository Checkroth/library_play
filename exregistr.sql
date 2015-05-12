drop table Student;
drop sequence student_seq;

create table Student (
	sid integer primary key, 
	name varchar(128) not null, 
	gpa numeric
);

create sequence student_seq;
