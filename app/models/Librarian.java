package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "Librarian")
public class Librarian extends Model {
	@Id
	@javax.persistence.Column(columnDefinition='char(10)')
	public String id_number;

	@Required
	@javax.persistence.Column(columnDefinition='varchar(128)')
	public String name;

	@Required
	public Date dob;

	@javax.persistence.Column(columnDefinition='varchar(64)')
	public String title;

	// Relational field using library as a varchar for foreign key
	// This is probably not right
	@OneToOne
	@javax.persistence.Column(columnDefinition='varchar(64)')
	public Library library;
}


    // mappedBy is the name of the field in NewEn that contains the foreign key
	// This should go in Library.java model?
    // @OneToOne(mappedBy = "Librarian")
    // public List<Librarian> librarians;