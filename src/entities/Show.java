package entities;

import java.io.Serializable;

public class Show implements Serializable{

	private Play myPlay;
	private String date, time;


	private final int ROWS = 10;
	private final int COLUMNS = 10;
	private final char LETTERS[] = {'A','B','C','D','E','F','G','H','I','J','K'};

	private Seat[] seats = new Seat[ROWS*COLUMNS];
	public Show(Play aPlay, String aDate, String aTime){

		myPlay = aPlay;
		date = aDate;
		time = aTime;	
		createSeats();
	}

	public Show(String aDate, String aTime){

		myPlay = null;
		date = aDate;
		time = aTime;
		createSeats();
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
	
	public Seat[] getSeats()
	{
		return this.seats;
	}

	private void createSeats(){
		String text = "";
		int pos = 0;
		for(int i=0;i<ROWS;i++)
		{
			for(int j=0;j<COLUMNS;j++){
				text = ""+LETTERS[i]+(j+1);
				this.seats[pos] = new Seat(text);
				pos++;
			}
		}
	}
	
	
}
