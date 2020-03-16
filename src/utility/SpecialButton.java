package utility;

import javax.swing.JButton;
import entities.Show;

public class SpecialButton extends JButton{

	private Show myShow;
	
	public SpecialButton(String text,Show aShow){
		super(text);
		this.myShow = aShow;
	}
	
	public Show getShow() {
		return myShow;
	}
	public void setShow(Show myShow) {
		this.myShow = myShow;
	}
	
	
}
