package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "Fine")
public class Fine extends Model {
create table Fine (
	patron_id       char(10) not null,
    call_num        varchar(32) not null,
	amount		integer,
	primary key (patron_id, call_num),
	foreign key (patron_id) references Patron(card_num),
        foreign key (call_num) references Media(call_num)
);
	// Need to more appropriately study this model and how I could construct it with the play framework


	// Comp Key 1
	@Required
	@javax.persistence.Column(columnDefinition='char(10)')
	public String patron_id;

	// Comp Key 2
	@Required
	@javax.persistence.Column(columnDefinition='varchar(32)')
	public String call_num;

	public Integer amount;

	@ManyToOne
	@required
	@javax.persistence.Column(columnDefinition='varchar(64)')
	public Media media;
}
