package models;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import java.sql.Date;

@Entity
@Table(name = "Librarian")
public class Librarian extends Model {

//	create table Librarian (
//		id_number	char(10) primary key,
//		name		varchar(128) not null,
//		dob			date not null,
//		title		varchar(64),
//		library		varchar(64) not null,
//		foreign key (library) references Library(name)
//	);

	@Id
	@javax.persistence.Column(columnDefinition="char(10)")
	public String id_number;

	@Required
	@javax.persistence.Column(columnDefinition="varchar(128)")
	public String name;

	@javax.persistence.Column(columnDefinition="date")
	public Date dob;

	@javax.persistence.Column(columnDefinition="varchar(64)")
	public String title;

	public String library;

    public static Finder<String, Librarian> find = new Model.Finder(String.class, Librarian.class);

}