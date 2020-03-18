package entities;
import java.util.ArrayList;

public class Play {

	private String title, startDate, endDate;
	private ArrayList<Show> myShows = new ArrayList<>();
	private Details myDetails = new Details();
	
	public Play(String title)
	{
		this.title = title;
	}
	
	public Play(String title, String startDate, String endDate)
	{
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Play(String title, String startDate, String endDate,Show aShow)
	{
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.myShows.add(aShow);
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	
}
