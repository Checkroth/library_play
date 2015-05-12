package models;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import java.util.List;

@Entity
@Table(name = "Library")
public class Library extends Model {

//	create table Library (
//		name		varchar(64) primary key,
//		street_num	varchar(64) not null,
//		city		varchar(32) not null,
//		state		char(2) not null,
//		zip			char(5) not null
//	);

	// This is just for aut-generate numbers I think
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_seq")

	@Id
	@javax.persistence.Column(columnDefinition="varchar(64)")
	public String name;

	@Required
	@javax.persistence.Column(columnDefinition="varchar(64)")
	public String street_num;

	@Required
	@javax.persistence.Column(columnDefinition="varchar(32)")
	public String city;

	@Required
	@javax.persistence.Column(columnDefinition="char(2)")
	public String state;

	@Required
	@javax.persistence.Column(columnDefinition="char(9)")
	public Integer zip;




    @OneToOne(mappedBy = "Librarian")
    public List<Librarian> librarians;

    @OneToMany(mappedBy = "Patron")
    public List<Patron> patrons;

    @OneToMany(mappedBy = "Media")
    public List<Media> media;
}