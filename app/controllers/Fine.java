package controllers;

// import models.Fine;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Fine extends Controller {
    
    public static Result addFine() {
//      Student student = Form.form(Student.class).bindFromRequest().get();

    	Fine fine = Form.form(Fine.class).bindFromRequest().get();
    	fine.save();
        return redirect(routes.Application.index());
    }
    
    public static Result getFines(String patron) {
    	List <Fine> fines = new Model.Finder(int.class, Fine.class).all();
        return ok(toJson(fines));
    }

    // Add functions:
    // Get fines for specific patron
    // Get fines for specific media
    // Remove fine
}
