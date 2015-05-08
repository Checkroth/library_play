package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "Patron")
public class Patron extends Model {
	@Id
	@javax.persistence.Column(columnDefinition='char(10)')
	public String card_num;

	@Required
	@javax.persistence.Column(columnDefinition='varchar(128)')
	public String name;

	@javax.persistence.Column(columnDefinition='varchar(64)')
	public String street_num;

	@javax.persistence.Column(columnDefinition='varchar(32)')
	public String city;

	@javax.persistence.Column(columnDefinition='char(2)')
	public String state;

	@javax.persistence.Column(columnDefinition='char(9)')
	public Integer zip;

	@ManyToOne
	@required
	@javax.persistence.Column(columnDefinition='varchar(64)')
	public Library library;

}
