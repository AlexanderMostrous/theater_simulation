package entities;

import java.util.ArrayList;

public class Details {

	private String myDirector, myScriptWriter, myDescription;
	private ArrayList<String> actors;
	
	public Details(){
		
		myDirector = "";
		myScriptWriter = "";
		myDescription = "";
		actors = new ArrayList<String>();
	}
	
	public Details(String aDirector, String aScriptWriter,String aDescription){
		
		myDirector = aDirector;
		myScriptWriter = aScriptWriter;
		myDescription = aDescription;
		actors = new ArrayList<String>();
	}

	public String getDirector() {
		return myDirector;
	}

	public void setDirector(String director) {
		this.myDirector = director;
	}

	public String getScriptWriter() {
		return myScriptWriter;
	}

	public void setScriptWriter(String scriptWriter) {
		this.myScriptWriter = scriptWriter;
	}

	public ArrayList<String> getActors() {
		return actors;
	}
	
	public void addActor(String actor){
		actors.add(actor);
	}

	public String getDescription() {
		return myDescription;
	}

	public void setDescription(String myDescription) {
		this.myDescription = myDescription;
	}
	
	
}
