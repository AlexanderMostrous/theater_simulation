package entities;

import java.util.ArrayList;

public class Play {

	private String title, startDate, endDate;
	private ArrayList<Show> myPerformances = new ArrayList<>();
	private Details myDetails = new Details();
	public Play()
	{
		
	}
	
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
	
	public Play(String title, String startDate, String endDate,Show aPerformance)
	{
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.myPerformances.add(aPerformance);
	}

	public Details getMyDetails() {
		return myDetails;
	}

	public void setMyDetails(Details myDetails) {
		this.myDetails = myDetails;
	}

	public ArrayList<Show> getMyPerformances() {
		return myPerformances;
	}

	public void addPerformance(Show aPerformance) {
		this.myPerformances.add(aPerformance);
	}
	
	public void removePerformance(Show aPerformance){
		this.myPerformances.remove(aPerformance);
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
