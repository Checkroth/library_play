package models;

import javax.persistence.*;

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

	// Comp Key 1
	@Id
	@OneToMany(mappedBy = "card_num")
	public Patron patron;

	// Comp Key 2
	@Id
	@Required
	@OneToMany(mappedBy = "call_num, card_num")
	public Media media;

	@javax.persistence.Column(columnDefinition="integer")
	public Integer amount;

    public static Finder<String, Fine> find = new Model.Finder(String.class, Fine.class);
}