package entities;

import java.util.ArrayList;

public class Show {

	private String title, startDate, endDate;
	private ArrayList<Performance> myPerformances = new ArrayList<>();
	private Details myDetails = new Details();
	public Show()
	{
		
	}
	
	public Show(String title)
	{
		this.title = title;
	}
	
	public Show(String title, String startDate, String endDate)
	{
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Show(String title, String startDate, String endDate,Performance aPerformance)
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

	public ArrayList<Performance> getMyPerformances() {
		return myPerformances;
	}

	public void addPerformance(Performance aPerformance) {
		this.myPerformances.add(aPerformance);
	}
	
	public void removePerformance(Performance aPerformance){
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
