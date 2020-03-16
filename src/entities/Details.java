package entities;

import java.util.ArrayList;

public class Details {

	private String director, scriptWriter;
	private ArrayList<String> actors;
	
	public Details(){
		
		director = "<кень>";
		scriptWriter = "<кень>";
		actors = new ArrayList<String>();
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getScriptWriter() {
		return scriptWriter;
	}

	public void setScriptWriter(String scriptWriter) {
		this.scriptWriter = scriptWriter;
	}

	public ArrayList<String> getActors() {
		return actors;
	}
	
	public void addActor(String actor){
		actors.add(actor);
	}
	
}
