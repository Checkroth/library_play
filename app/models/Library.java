package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "Library")
public class Library extends Model {

	// This is just for aut-generate numbers I think
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_seq")
	@Id
	@javax.persistence.Column(columnDefinition='varchar(64)')
	public String name;

	@Required
	@javax.persistence.Column(columnDefinition='varchar(64)')
	public String street_num;

	@Required
	@javax.persistence.Column(columnDefinition='varchar(32)')
	public String city;

	@Required
	@javax.persistence.Column(columnDefinition='char(2)')
	public String state;

	@Required
	@javax.persistence.Column(columnDefinition='char(9)')
	public Integer zip;

    @OneToOne(mappedBy = "Librarian")
    public List<Librarian> librarians;

    @OneToMany(mappedBy = "Patron")
    public List<Patron> patrons;

    @OneToMany(mappedBy = "Media")
    public List<Media> media;

}
