package models;


import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.Id;
import java.sql.Date;

public class CheckedOut extends Model {

//  create table Checked_Out (
//      patron_id   char(10),
//      call_num    varchar(32),
//      copy_num    integer,
//      due_date    date not null,
//      primary key(call_num, copy_num, patron_id),
//      foreign key (patron_id) references Patron(card_num),
//      foreign key (call_num, copy_num) references Media(call_num, copy_num)
//      on delete cascade
//  );

    @Id

    @javax.persistence.Column(columnDefinition="char(10)")
    public Patron patron;

    @Required
    @javax.persistence.Column(columnDefinition="varchar(32)")
    public Media media;

    @Required
    @javax.persistence.Column(columnDefinition="integer")
    public Integer copy_number;

    @Required
    @javax.persistence.Column(columnDefinition="date")
    public Date due_date;




}