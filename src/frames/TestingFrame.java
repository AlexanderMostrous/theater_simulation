package frames;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import entities.Show;
import project_panels.ShowPanel;
import utility.DataHolder;

public class TestingFrame extends JFrame {

	public TestingFrame()
	{
		JPanel outerPanel = basicUI("Some Title");
		
		this.setContentPane(outerPanel);
		
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Κεντρικό Μενού");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
public JPanel basicUI(String panelTitle){
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		if(!DataHolder.shows.isEmpty())
		{
			for(Show s:DataHolder.shows)
			{
				
				panel.add(new ShowPanel(s));
			}
			panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		else
		{
			JLabel noShowsAvailableLabel = new JLabel("Δεν υπάρχουν διαθέσιμα έργα.");
			noShowsAvailableLabel.setFont(new Font("Myriad Pro",Font.PLAIN,20));
			panel.add(noShowsAvailableLabel);
			panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		}

		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1, 2, 30, 0));

		JButton menuBtn = new JButton("Κεντρικό Μενού");
		menuBtn.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		temp.add(menuBtn);

		JButton addNewShowBtn = new JButton("Προσθήκη Νέου Έργου");
		addNewShowBtn.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		
		temp.add(addNewShowBtn);
		
		temp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.add(temp);

		JScrollPane jsp = new JScrollPane(panel);
		JPanel aPanel = new JPanel();
		aPanel.add(jsp);
		
		return aPanel;
	}
/*
	@Override
	public Dimension getPreferredSize() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return new Dimension((int)(screenSize.getWidth()/2+100),(int)(screenSize.getHeight()/4));
	}
	*/
}
