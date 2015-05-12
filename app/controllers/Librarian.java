package controllers;

// import models.Librarian;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Librarian extends Controller {

    public static Result addLibrarian() {
    	Librarian librarian = Form.form(Librarian.class).bindFromRequest().get();
    	librarian.save();
        return redirect(routes.Application.index());
    }
    
    public static Result getLibrarians(String library) {
    	// List <Librarian> librarians = Librarian.findBy("library"=library);
     //    return ok(toJson(librarians));
        return ok();
    }



    // Functions to add:
    // Remove librarian
    // Change librarian's library?
}
