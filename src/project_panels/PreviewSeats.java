package project_panels;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PreviewSeats extends JPanel implements ActionListener{
	
	private JPanel mainPanel;
	private boolean[][] map;
	
	public PreviewSeats(){
	this.mainPanel = new JPanel();
	createTheaterMap();

	this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	
	
	JButton okBtn = new JButton("OK");
	JButton cancel = new JButton("Cancel");
	JPanel temp = new JPanel();
	temp.setLayout(new GridLayout(1,2,10,0));
	okBtn.addActionListener(this);
	temp.add(okBtn);
	cancel.addActionListener(this);
	temp.add(cancel);
	temp.setMaximumSize(new Dimension(200, 30));
	temp.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
	this.mainPanel.add(temp);
	this.mainPanel.add(createGrid());
	
	this.getContentPane().add(mainPanel);
	this.setUp();
	}
	
	public JPanel createGrid(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(28,30));
		
		SpecialButton btn;
		int columnCounter, rowCounter = 0;
		boolean emptyRow = false;
		for(int i=0;i<28;i++)
		{
			columnCounter = 1;
			for(int j=0;j<30;j++)
			{				
				if(map[i][j])
				{
					btn = new SpecialButton();
					btn.setText(""+getLetter(rowCounter)+columnCounter);
					columnCounter++;
					btn.setFont(new Font("Myriad Pro",Font.PLAIN,19));
					btn.setMargin(new Insets(5, 5, 5, 5));
					btn.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							
							Object m = e.getSource();
							if(m instanceof SpecialButton)
							{
								if(((SpecialButton) m).isTaken())
									if(((SpecialButton) m).getForeground()==Color.RED)
										((SpecialButton) m).setForeground(Color.BLACK);
									else
										((SpecialButton) m).setForeground(Color.RED);
								else
									if(((SpecialButton) m).getForeground()==Color.YELLOW)
										((SpecialButton) m).setForeground(Color.BLACK);
									else
										((SpecialButton) m).setForeground(Color.YELLOW);
							}
							else
								System.out.println("BUG");
						}
					});
					panel.add(btn);
					emptyRow = false;
				}
				else
					panel.add(new JLabel());
			}
			if(!emptyRow)
				rowCounter++;
			emptyRow = true;
		}
		
		return panel;
	}
	
	
	public void setUp(){
		this.setTitle("Εποπτεία Θέσεων");
		this.pack();
		this.setVisible(true);
		this.setResizable(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	private void createTheaterMap(){
		map = new boolean[28][30];
		
		for(int i=0;i<28;i++)
			for(int j=0;j<30;j++)
				if(
						
						i<1||
						(i>3 & i<5)||
						i==10||
						i==11||
						i>26||
						j<2||
						j==5||
						j==24||
						(j>13 && j<16)||
						(i>15 && i<18)||
						(i>21 && i<25)||
						j>27)
				{
					map[i][j] = false;
				}
				else
					map[i][j] = true;
		for(int i=1;i<4;i++)
		{
			map[i][2] = false;
			map[i][3] = false;
			map[i][4] = false;
			map[i][25] = false;
			map[i][26] = false;
			map[i][27] = false;
		}
		for(int i=5;i<8;i++)
		{
			map[i][2] = false;
			map[i][27] = false;
		}
		map[5][3] = false;
		map[5][26] = false;
		
		for(int i=12;i<16;i++)
		{
			map[i][1] = true;
			map[i][28] = true;
		}
		map[12][1] = false;
		map[12][28] = false;
		for(int i=18;i<22;i++)
		{
			map[i][1] = true;
			map[i][28] = true;
		}
		map[20][0] = true;
		map[21][0] = true;
		map[20][29] = true;
		map[21][29] = true;
	}
	
private String getLetter(int index){

		switch(index){
		case 1:
			return "A";
		case 2:
			return "B";
		case 3:
			return "C";
		case 4:
			return "D";
		case 5:
			return "E";
		case 6:
			return "F";
		case 7:
			return "G";
		case 8:
			return "H";
		case 9:
			return "I";
		case 10:
			return "J";
		case 11:
			return "K";
		case 12:
			return "L";
		case 13:
			return "M";
		case 14:
			return "N";
		case 15:
			return "O";
		case 16:
			return "P";
		case 17:
			return "Q";
		case 18:
			return "R";
		case 19:
			return "S";
			

		}
		return "...";
	}
	
public class SpecialButton extends JButton{

	private boolean taken;
	
	public void setTaken(boolean t)
	{
		this.taken = t;
	}
	
	public boolean isTaken()
	{
		return this.taken;
	}
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getActionCommand().equals("OK"))
	{
		//TODO Handle 1
	}
	else if(e.getActionCommand().equals("Cancel"))
	{
		//TODO Handle 2
	}
}
}
