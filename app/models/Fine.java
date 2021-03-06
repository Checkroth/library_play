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

	@Id
	@Required
	@javax.persistence.Column(columnDefinition="char(10)")
	public String patron_id;

	@Required
	@javax.persistence.Column(columnDefinition="varchar(32)")
	public String call_num;

	@Required
	public Integer copy_num;

	@javax.persistence.Column(columnDefinition="integer")
	public Integer amount;

    public static Finder<String, Fine> find = new Model.Finder(String.class, Fine.class);
}

	// // Comp Key 1
	// @OneToMany(mappedBy = "card_num")
	// public Patron patron;

	// // Comp Key 2
	// @Required
	// @OneToMany(mappedBy = "call_num, card_num")
	// public Media media;
