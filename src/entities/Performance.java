package entities;

public class Performance {

	private Show myShow;
	private String date, time;
	
	public Performance(Show aShow, String aDate, String aTime){
		
		myShow = aShow;
		date = aDate;
		time = aTime;	
	}

	public Show getMyShow() {
		return myShow;
	}

	public void setMyShow(Show myShow) {
		this.myShow = myShow;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
