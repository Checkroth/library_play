package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@Required
	@javax.persistence.Column(columnDefinition="date")
	public Date dob;

	@javax.persistence.Column(columnDefinition="varchar(64)")
	public String title;

	@Required
	@javax.persistence.Column(columnDefinition="varchar(64)")
	public String home_library;





	// TODO Relational field using library as a varchar for foreign key
	// This is probably not right
	@OneToOne
	@javax.persistence.Column(columnDefinition="varchar(64)")
	public Library library;


}
    // TODO mappedBy is the name of the field in NewEn that contains the foreign key
	// This should go in Library.java model?
    // @OneToOne(mappedBy = "Librarian")
    // public List<Librarian> librarians;