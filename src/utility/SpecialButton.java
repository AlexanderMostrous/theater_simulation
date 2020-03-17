package utility;

import javax.swing.JButton;
import entities.Play;

public class SpecialButton extends JButton{

	private Play myPlay;
	
	public SpecialButton(String text,Play aPlay)
	{
		super(text);
		this.myPlay = aPlay;
	}
	
	public Play getPlay()
	{
		return myPlay;
	}
	
	public void setPlay(Play aPlay)
	{
		this.myPlay = aPlay;
	}
}
