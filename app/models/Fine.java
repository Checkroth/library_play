package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "Fine")
public class Fine extends Model {

//	create table Fine (
//		patron_id	char(10),
//		call_num	varchar(32),
//		copy_num	integer,
//		amount		integer,
//		primary key(call_num, copy_num, patron_id),
//		foreign key (patron_id) references Patron(card_num),
//		foreign key (call_num, copy_num) references Media(call_num, copy_num)
//	);

	//TODO: Need to more appropriately study this model and how I could construct it with the play framework


	// Comp Key 1
	@Id
	@javax.persistence.Column(columnDefinition="char(10)")
	public String patron_id;

	// Comp Key 2
	@Required
	@javax.persistence.Column(columnDefinition="varchar(32)")
	public String call_num;

	// Comp Key 2
	@Required
	@javax.persistence.Column(columnDefinition="integer")
	public Integer copy_num;

	@javax.persistence.Column(columnDefinition="integer")
	public Integer amount;




	@ManyToOne
	public Media media;
}
