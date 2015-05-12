package models;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "Patron")
public class Patron extends Model {

//	create table Patron (
//		card_num	char(10) primary key,
//		name		varchar(128) not null,
//		street_num	varchar(64),
//		city		varchar(32),
//		state		char(2),
//		zip			char(5),
//		library		varchar(64) not null,
//		foreign key (library) references Library(name)
//	);

	@Id
	@javax.persistence.Column(columnDefinition="char(10)")
	public String card_num;

	@Required
	@javax.persistence.Column(columnDefinition="varchar(128)")
	public String name;

	@javax.persistence.Column(columnDefinition="varchar(64)")
	public String street_num;

	@javax.persistence.Column(columnDefinition="varchar(32)")
	public String city;

	@javax.persistence.Column(columnDefinition="char(2)")
	public String state;

	@javax.persistence.Column(columnDefinition="char(5)")
	public Integer zip;

	@Required
	@ManyToOne
	public Library library;
}