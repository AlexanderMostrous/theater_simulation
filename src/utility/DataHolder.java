package utility;

import java.util.ArrayList;

import entities.*;

public abstract class DataHolder {

	public static ArrayList<Show> shows = new ArrayList<Show>();
	
	public static void createDummyShowList(){

		Show show1 = new Show("Phantom of the opera", "03/06/18", "12/07/18");
		show1.addPerformance(new Performance(show1,"28/3/18", "17:30"));
		show1.addPerformance(new Performance(show1,"20/3/18", "18:30"));
		show1.addPerformance(new Performance(show1,"10/2/18", "18:30"));
		shows.add(show1);
		
		Show show2 = new Show("Stand Up Comedy", "9/4/18","25/4/18");
		show2.addPerformance(new Performance(show1,"12/4/18", "17:30"));
		show2.addPerformance(new Performance(show1,"1/3/18", "20:00"));
		show2.addPerformance(new Performance(show1,"10/1/18", "21:30"));
		shows.add(show2);
		
		Show show3 = new Show("Jack of all Trades", "04/07/18", "4/08/18");
		show3.addPerformance(new Performance(show1,"5/5/18", "21:30"));
		show3.addPerformance(new Performance(show1,"6/4/18", "17:30"));
		show3.addPerformance(new Performance(show1,"1/7/18", "22:00"));
		shows.add(show3);
		
		Show show4 = new Show("Η Χιονάτη και οι 7 Νάνοι", "17/4/18","2/6/18");
		show4.addPerformance(new Performance(show1,"3/7/18", "20:00"));
		show4.addPerformance(new Performance(show1,"5/7/18", "22:00"));
		show4.addPerformance(new Performance(show1,"17/8/18", "19:45"));
		shows.add(show4);
		
		Show show5 = new Show("A Star", "05/08/18", "20/08/18");
		show5.addPerformance(new Performance(show1,"28/8/18", "19:45"));
		show5.addPerformance(new Performance(show1,"14/9/18", "17:30"));
		show5.addPerformance(new Performance(show1,"30/9/18", "20:00"));
		show5.addPerformance(new Performance(show1,"17/8/18", "19:45"));
		show5.addPerformance(new Performance(show1,"1/11/18", "18:30"));
		shows.add(show5);
		
	}

}
