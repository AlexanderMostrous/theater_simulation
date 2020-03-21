package entities;

public class Show {

	private Play myPlay;
	private String date, time;
	
	public Show(Play aPlay, String aDate, String aTime){
		
		myPlay = aPlay;
		date = aDate;
		time = aTime;	
	}

	public Play getMyPlay() {
		return myPlay;
	}

	public void setMyPlay(Play aPlay) {
		this.myPlay = aPlay;
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
