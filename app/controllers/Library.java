package controllers;
// import models.Library;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import views.html.*;
import java.util.List;

import static play.libs.Json.toJson;

public class Library extends Controller {

    public static Result addLibrary() {
    	Library library = Form.form(Library.class).bindFromRequest().get();
    	library.save();
        return redirect(routes.Application.index());
    }
    
    
    public static Result getLibraries() {
    	List <Library> libraries = new Model.Finder(int.class, Library.class).all();
        return ok(toJson(libraries));
    }

    // Functions to add:
    // Get all patrons for specific library
    // Get all librarians for a specific library
    // Get all media in a specific library
    // Remove a library? (Probably not necessary for the scope of this application
    
}
