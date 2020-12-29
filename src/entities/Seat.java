package entities;

import java.io.Serializable;

public class Seat implements Serializable{

	private String name;
	private boolean booked;
	private String bookedBy;

	public Seat(String name)
	{
		this.name = name;
		this.booked = false;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
	
	public String getName()	{
		return this.name;
	}
}
