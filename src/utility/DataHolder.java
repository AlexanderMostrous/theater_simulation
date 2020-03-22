package utility;

import java.util.ArrayList;

import entities.*;

public abstract class DataHolder {

	public static ArrayList<Play> plays = new ArrayList<Play>();
	
	public static void createDummyShowList(){

		Play play1 = new Play("Hamlet");
		play1.addShow(new Show(play1,"28/3/18", "17:30"));
		play1.addShow(new Show(play1,"20/3/18", "18:30"));
		play1.addShow(new Show(play1,"10/2/18", "18:30"));
		plays.add(play1);
		
		Play play2 = new Play("Long Day's Journey Into Night");
		play2.addShow(new Show(play2,"12/4/18", "17:30"));
		play2.addShow(new Show(play2,"1/3/18", "20:00"));
		play2.addShow(new Show(play2,"10/1/18", "21:30"));
		plays.add(play2);
		
		Play play3 = new Play("Who's Afraid of Virginia Woolf?");
		play3.addShow(new Show(play3,"5/5/18", "21:30"));
		play3.addShow(new Show(play3,"6/4/18", "17:30"));
		play3.addShow(new Show(play3,"1/7/18", "22:00"));
		plays.add(play3);
		
		Play play4 = new Play("Death of a Salesman");
		play4.addShow(new Show(play4,"3/7/18", "20:00"));
		play4.addShow(new Show(play4,"5/7/18", "22:00"));
		play4.addShow(new Show(play4,"17/8/18", "19:45"));
		plays.add(play4);
		
		Play play5 = new Play("Oedipus Rex");
		play5.addShow(new Show(play5,"28/8/18", "19:45"));
		play5.addShow(new Show(play5,"14/9/18", "17:30"));
		play5.addShow(new Show(play5,"30/9/18", "20:00"));
		play5.addShow(new Show(play5,"17/8/18", "19:45"));
		play5.addShow(new Show(play5,"1/11/18", "18:30"));
		plays.add(play5);
		
	}

}
