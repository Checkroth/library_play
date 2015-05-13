package controllers;

import models.Fine;
import models.Librarian;
import models.Library;
import models.Media;
import models.Patron;
import models.Reserved;
import play.*;
import play.data.format.Formatters;
import play.data.Form;
import play.data.DynamicForm;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;
import java.util.Locale;
import java.text.ParseException;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(""));
    }

    public static Result addFine() {
    	Fine fine = Form.form(Fine.class).bindFromRequest().get();
    	fine.save();
        return redirect(routes.Application.index());
    }
    
    public static Result getFines() {
    	DynamicForm data = Form.form().bindFromRequest();
    	String card_number = data.get("card_num");
    	// Need to find a way to just get the fines related to employee with this card number
    	List<Fine> fines = Fine.find.where().ilike("patron", card_number).findList();
        return ok(toJson(fines));
    }


    public static Result addLibrary() {
    	Library library = Form.form(Library.class).bindFromRequest().get();
    	library.save();
        return redirect(routes.Application.index());
    }
    
    
    public static Result getLibraries() {
        // Could potentially return a list with buttons that show this library's 'media' or 'patrons' or 'librarians'
        // This would make the front page significantly cleaner
        // This would also involve looping through every library and building the HTML forms with hidden fields
        // From within this controller, which is hideous
    	List<Library> libraries = new Model.Finder(int.class, Library.class).all();
        return ok(toJson(libraries));
    }


	public static Result addLibrarian() {

        Librarian librarian = Form.form(Librarian.class).bindFromRequest().get();
        librarian.save();
        return redirect(routes.Application.index());
    }
    
    public static Result getLibrarians() {
        DynamicForm data = Form.form().bindFromRequest();
        String library = data.get("library");

        List<Librarian> librarians = Librarian.find.where().ilike("library", library).findList();

    	// List<Librarian> librarians = new Model.Finder(String.class, Librarian.class).all();
        // List<Librarian> librarians = Librarian.all();
     	return ok(toJson(librarians));
    }

    public static Result addMedia() {
    	Media media = Form.form(Media.class).bindFromRequest().get();
    	media.save();
        return redirect(routes.Application.index());
    }
    
    public static Result getMedia() {
    	DynamicForm data = Form.form().bindFromRequest();
    	String library = data.get("library");
        // Filter media by relationship with library
    	List<Media> media = Media.find.where().ilike("library", library).findList();
        return ok(toJson(media));
    }

    public static Result checkOut() {
        Reserved reserved_media = Form.form(Reserved.class).bindFromRequest().get();
        reserved_media.save();
        // Need to also take the media and set it to 'reserved' or whatever (I think?)
        return redirect(routes.Application.index());
    }

    public static Result addPatron() {
    	Patron patron = Form.form(Patron.class).bindFromRequest().get();
    	patron.save();
        return redirect(routes.Application.index());
    }
    
    public static Result getPatrons() {
    	DynamicForm data = Form.form().bindFromRequest();
    	String library = data.get("library");
        // Filter list by relationship with library
    	List<Patron> patrons = Patron.find.where().ilike("library", library).findList();
        return ok(toJson(patrons));
    }

    public static Result getMediaStatus() {
        // return ok("test");
        DynamicForm data = Form.form().bindFromRequest();
        String media = data.get("call_num");
        try {
            Media found_media = Media.find.byId(media);
        if(found_media.available){
            return ok(media + " is Available");
        }
        else {
            return ok(media + " is Reserved");
        }
        }
        catch (Exception e){
            return ok("No media with that ID exists");
        }


    }
    
//     public static Result addStudent() {
//     	Student student = Form.form(Student.class).bindFromRequest().get();
//     	student.save();
//         return redirect(routes.Application.index());
//     }
    
    
//     public static Result getStudents() {
//     	List <Student> students = new Model.Finder(int.class, Student.class).all();
//         return ok(toJson(students));
//     }
    
    
//     public static Result studTab() {
//     	List <Student> students = new Model.Finder(int.class, Student.class).all();
//     	String table = "<table border=1px solid>"
//     			+ "<tr>"
// //    			+ "<th>Id</th>"
//     			+ "<th>Name</th>"
//     			+ "<th>GPA</th>"
//     			+ "</tr>";
//     	for(Student student: students) {
//     		table += "<tr>";
// //    		table += "<td>" + student.sid + "</td>";
//     		table += "<td>" + student.name + "</td>";
//     		table += "<td>" + student.gpa + "</td>";
//     		table += "</tr>";    		
//     	}
//     	table += "</table>";
//     	return ok(table);
//     }

}
