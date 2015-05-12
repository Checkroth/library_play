package models;


import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Checked_Out")
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
    @OneToMany(mappedBy = "card_num")
    public Patron patron;

    // Takes care of both call_num and copy_num
    @Required
    @Id
    @OneToOne(mappedBy = "call_num, copy_num")
    public Media media;

    @Required
    @javax.persistence.Column(columnDefinition="date")
    public Date due_date;
}