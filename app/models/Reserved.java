package models;

import javax.persistence.*;

import models.Keys.ReservedKey;
import play.data.validation.Constraints.*;
import play.db.ebean.Model;

@Entity
@Table(name = "Reserved")
public class Reserved extends Model {

//  create table Reserved (
//      patron_id   char(10),
//      call_num    varchar(32),
//      wait_num    integer,
//      primary key(call_num, wait_num, patron_id),
//      foreign key (patron_id) references Patron(card_num),
//      foreign key (call_num) references Media(call_num)
//  );

    @EmbeddedId
    public ReservedKey reservedKey;

    @Id
    @Required
    @javax.persistence.Column(columnDefinition="integer")
    public int wait_num;
}