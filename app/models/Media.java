
package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "Media")
public class Media extends Model {
	// Comp Key 1
	@Required
	@javax.persistence.Column(columnDefinition='char(32)')
	public String call_num;

	@javax.persistence.Column(columnDefinition='varchar(128)')
	public String title;

	@javax.persistence.Column(columnDefinition='varchar(64)')
	public String author;

	@javax.persistence.Column(columnDefinition='varchar(64)')
	public String publisher;

	@javax.persistence.Column(columnDefinition='varchar(64)')
	public String city;

	public Date year;

	public Boolean available;

	// Comp Key 2
	@Required
	public Integer copy_num;

	@javax.persistence.Column(columnDefinition='varchar(16)')
	public String media_type;

	@ManyToOne
	@required
	@javax.persistence.Column(columnDefinition='varchar(64)')
	public Library library;

}
