package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

@Entity
@Table(name = "Reserved")
public class Reserved extends Model {

//    create table Reserved (
//        patron_id   char(10),
//        call_num    varchar(32),
//        wait_num    integer,
//        primary key(call_num, wait_num, patron_id),
//        foreign key (patron_id) references Patron(card_num),
//        foreign key (call_num) references Media(call_num)
//    );

    @Id
    @javax.persistence.Column(columnDefinition="char(10)")
    public String patron_id;

    @Required
    @javax.persistence.Column(columnDefinition="varchar(32)")
    public String call_num;

    @Required
    @javax.persistence.Column(columnDefinition="integer")
    public Integer wait_num;



    @ManyToOne
    public Media media;

    @ManyToOne
    public Patron patron;
}