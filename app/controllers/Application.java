package controllers;

import models.Student;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(""));
    }
    
    public static Result addStudent() {
    	Student student = Form.form(Student.class).bindFromRequest().get();
    	student.save();
        return redirect(routes.Application.index());
    }
    
    
    public static Result getStudents() {
    	List <Student> students = new Model.Finder(int.class, Student.class).all();
        return ok(toJson(students));
    }
    
    
    public static Result studTab() {
    	List <Student> students = new Model.Finder(int.class, Student.class).all();
    	String table = "<table border=1px solid>"
    			+ "<tr>"
//    			+ "<th>Id</th>"
    			+ "<th>Name</th>"
    			+ "<th>GPA</th>"
    			+ "</tr>";
    	for(Student student: students) {
    		table += "<tr>";
//    		table += "<td>" + student.sid + "</td>";
    		table += "<td>" + student.name + "</td>";
    		table += "<td>" + student.gpa + "</td>";
    		table += "</tr>";    		
    	}
    	table += "</table>";
    	return ok(table);
    }

}
