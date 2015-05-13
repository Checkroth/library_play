
package models;

import javax.persistence.*;

import models.Keys.MediaKey;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import java.sql.Date;

@Entity
@Table(name = "Media")
public class Media extends Model {

//	create table Media (
//		call_num	varchar(32),
//		title		varchar(128),
//		author		varchar(64),
//		publisher	varchar(64),
//		city		varchar(64),
//		year		date,
//		available	boolean,
//		copy_num	integer,
//		media_type	varchar(16),
//		library		varchar(64) not null,
//		primary key(call_num, copy_num),
//		foreign key (library) references Library(name)
//	);

	// @EmbeddedId
	// public MediaKey mediaKey;

	@Id
	@javax.persistence.Column(columnDefinition="varchar(32)")
	public String call_num;

	@Required
	public Integer copy_num;

	@javax.persistence.Column(columnDefinition="varchar(128)")
	public String title;

	@javax.persistence.Column(columnDefinition="varchar(64)")
	public String author;

	@javax.persistence.Column(columnDefinition="varchar(64)")
	public String publisher;

	@javax.persistence.Column(columnDefinition="varchar(64)")
	public String city;

	@javax.persistence.Column(columnDefinition="date")
	public Date year;

	@javax.persistence.Column(columnDefinition="boolean")
	public Boolean available;

	@javax.persistence.Column(columnDefinition="varchar(16)")
	public String media_type;

	public String library;

    public static Finder<String, Media> find = new Model.Finder(String.class, Media.class);

}