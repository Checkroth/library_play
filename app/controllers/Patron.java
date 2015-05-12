package controllers;

// import models.Patron;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Patron extends Controller {
    
    public static Result addPatron() {
    	Patron patron = Form.form(Patron.class).bindFromRequest().get();
    	patron.save();
        return redirect(routes.Application.index());
    }
    
    public static Result getPatrons(String library) {
    	List <Patron> patrons = new Model.Finder(int.class, Patron.class).all();
        return ok(toJson(patrons));
    }

    // Functions to add:
    // Remove patron
    // Change patron library (?)
    // Get all fines on a specific patron
    // Get all media a patron currently has checked out
}
