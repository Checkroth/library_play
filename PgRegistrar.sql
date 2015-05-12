drop table Checked_Out;
drop table Fine;
drop table Reserved;
drop table Media;
drop table Patron;
drop table Librarian;
drop table Library;

create table Library (
	name		varchar(64) primary key,
	street_num	varchar(64) not null,
	city		varchar(32) not null,
	state		char(2) not null,
	zip		char(5) not null
);

create table Librarian (
	id_number	char(10) primary key,
	name		varchar(128) not null,
	dob		date not null,
	title		varchar(64),
	library		varchar(64) not null,
	foreign key (library) references Library(name)
);

create table Patron (
	card_num	char(10) primary key,
	name		varchar(128) not null,
	street_num      varchar(64),
        city            varchar(32),
        state           char(2),
        zip             char(5),
	library		varchar(64) not null,
	foreign key (library) references Library(name)
);

create table Media (
	call_num	varchar(32),
	title		varchar(128),
	author		varchar(64),
	publisher	varchar(64),
	city		varchar(64),
	year		date,
	available	boolean,
	copy_num	integer,
	media_type	varchar(16),
	library		varchar(64) not null,
	primary key(call_num, copy_num),
	foreign key (library) references Library(name)
);

create table Checked_Out (
	patron_id	char(10),
	call_num        varchar(32),
	copy_num	integer,
	due_date	date not null,
	primary key(call_num, copy_num, patron_id),
	foreign key (patron_id) references Patron(card_num),
	foreign key (call_num, copy_num) references Media(call_num, copy_num)
	on delete cascade
);

create table Fine (
	patron_id       char(10),
        call_num        varchar(32),
	copy_num	integer,
	amount		integer,
	primary key(call_num, copy_num, patron_id),
	foreign key (patron_id) references Patron(card_num),
        foreign key (call_num, copy_num) references Media(call_num, copy_num)
);

create table Reserved (
        patron_id       char(10),
        call_num        varchar(32),
        wait_num	integer,
	primary key(call_num, wait_num, patron_id),
	foreign key (patron_id) references Patron(card_num)
);
