package utility;

import java.util.ArrayList;

import entities.*;

public abstract class DataHolder {

	public static ArrayList<Play> plays = new ArrayList<Play>();
	
	public static void createDummyShowList(){

		Play show1 = new Play("Hamlet", "03/06/18", "12/07/18");
		show1.addShow(new Show(show1,"28/3/18", "17:30"));
		show1.addShow(new Show(show1,"20/3/18", "18:30"));
		show1.addShow(new Show(show1,"10/2/18", "18:30"));
		plays.add(show1);
		
		Play show2 = new Play("Long Day's Journey Into Night", "9/4/18","25/4/18");
		show2.addShow(new Show(show1,"12/4/18", "17:30"));
		show2.addShow(new Show(show1,"1/3/18", "20:00"));
		show2.addShow(new Show(show1,"10/1/18", "21:30"));
		plays.add(show2);
		
		Play show3 = new Play("Who's Afraid of Virginia Woolf?", "04/07/18", "4/08/18");
		show3.addShow(new Show(show1,"5/5/18", "21:30"));
		show3.addShow(new Show(show1,"6/4/18", "17:30"));
		show3.addShow(new Show(show1,"1/7/18", "22:00"));
		plays.add(show3);
		
		Play show4 = new Play("Death of a Salesman", "17/4/18","2/6/18");
		show4.addShow(new Show(show1,"3/7/18", "20:00"));
		show4.addShow(new Show(show1,"5/7/18", "22:00"));
		show4.addShow(new Show(show1,"17/8/18", "19:45"));
		plays.add(show4);
		
		Play show5 = new Play("Oedipus Rex", "05/08/18", "20/08/18");
		show5.addShow(new Show(show1,"28/8/18", "19:45"));
		show5.addShow(new Show(show1,"14/9/18", "17:30"));
		show5.addShow(new Show(show1,"30/9/18", "20:00"));
		show5.addShow(new Show(show1,"17/8/18", "19:45"));
		show5.addShow(new Show(show1,"1/11/18", "18:30"));
		plays.add(show5);
		
	}

}
