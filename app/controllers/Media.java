package controllers;

import models.Media;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {
    
    public static Result addMedia() {
    	Media media = Form.form(Media.class).bindFromRequest().get();
    	media.save();
        return redirect(routes.Application.index());
    }
    
    public static Result getMedia() {
    	List <Media> media = new Model.Finder(int.class, Media.class).all();
        return ok(toJson(media));
    }

    // Functions to add:
    // Get all fines on a specific media
    // Change "checked out" status on a specific media
}
