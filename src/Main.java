import entities.Play;
import entities.Show;
import frames.MainMenu;
import frames.TestingFrame;
import utility.DataHolder;

public class Main {

	public static void main(String[] args)
	{
		
		DataHolder.createDummyShowList();		
		MainMenu.createMainMenu();
		
		/*
		Play aPlay = new Play("Long Day's Journey Into Night");
		aPlay.addShow(new Show(aPlay,"Mon, 02-Mar-2020", "17:30"));
		aPlay.addShow(new Show(aPlay,"Tue, 03-Mar-2020", "20:00"));
		aPlay.addShow(new Show(aPlay,"Wed, 04-Mar-2020", "21:30"));
		aPlay.addShow(new Show(aPlay,"Thu, 05-Mar-2020", "19:45"));
		aPlay.addShow(new Show(aPlay,"Fri, 06-Mar-2020", "17:30"));
		aPlay.addShow(new Show(aPlay,"Sat, 07-Mar-2020", "20:00"));
		aPlay.addShow(new Show(aPlay,"Sun, 08-Mar-2020", "19:45"));
		aPlay.addShow(new Show(aPlay,"Mon, 09-Mar-2020", "18:30"));
		
		new TestingFrame(aPlay);*/
	}
}
