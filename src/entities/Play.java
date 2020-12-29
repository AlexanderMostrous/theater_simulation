package entities;
import java.io.Serializable;
import java.util.ArrayList;

public class Play implements Serializable{

	private String title;
	private ArrayList<Show> myShows = new ArrayList<>();
	private Details myDetails = new Details();
	
	public Play(String title)
	{
		this.title = title;
	}

	public Details getMyDetails() {
		return myDetails;
	}

	public void setMyDetails(Details myDetails) {
		this.myDetails = myDetails;
	}

	public ArrayList<Show> getMyShows() {
		return myShows; 
	}

	public void addShow(Show aShow) {
		if(aShow.getMyPlay()==null)
			aShow.setMyPlay(this);
		this.myShows.add(aShow);
	}
	
	public void removeShow(Show aShow){
		this.myShows.remove(aShow);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
