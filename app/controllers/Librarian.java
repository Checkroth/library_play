package controllers;

import models.Librarian;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result addLibrarian() {
    	Librarian librarian = Form.form(Librarian.class).bindFromRequest().get();
    	librarian.save();
        return redirect(routes.Application.index());
    }
    
    public static Result getLibrarians() {
    	List <Librarian> librarians = new Model.Finder(int.class, Librarian.class).all();
        return ok(toJson(librarians));
    }

    // Functions to add:
    // Remove librarian
    // Change librarian's library?
}
