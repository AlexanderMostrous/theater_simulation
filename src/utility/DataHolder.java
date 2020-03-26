package utility;

import java.util.ArrayList;

import entities.*;

public abstract class DataHolder {

	public static ArrayList<Play> plays = new ArrayList<Play>();
	
	public static void createDummyShowList(){

		Play play1 = new Play("Hamlet");
		play1.addShow(new Show(play1,"Mon, 02-Mar-2020", "17:30"));
		play1.addShow(new Show(play1,"Tue, 03-Mar-2020", "20:00"));
		play1.addShow(new Show(play1,"Wed, 04-Mar-2020", "21:30"));
		plays.add(play1);
		
		Play play2 = new Play("Long Day's Journey Into Night");
		play2.addShow(new Show(play2,"Thu, 05-Mar-2020", "19:45"));
		play2.addShow(new Show(play2,"Fri, 06-Mar-2020", "17:30"));
		play2.addShow(new Show(play2,"Sat, 07-Mar-2020", "19:00"));
		play2.addShow(new Show(play2,"Sat, 07-Mar-2020", "20:00"));
		play2.addShow(new Show(play2,"Sat, 07-Mar-2020", "21:00"));
		play2.addShow(new Show(play2,"Sat, 07-Mar-2020", "22:00"));
		play2.addShow(new Show(play2,"Sat, 07-Mar-2020", "23:00"));
		plays.add(play2);
		
		Play play3 = new Play("Who's Afraid of Virginia Woolf?");
		play3.addShow(new Show(play3,"Sun, 08-Mar-2020", "19:45"));
		play3.addShow(new Show(play3,"Mon, 09-Mar-2020", "18:30"));
		play3.addShow(new Show(play3,"Mon, 02-Mar-2020", "17:30"));
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
