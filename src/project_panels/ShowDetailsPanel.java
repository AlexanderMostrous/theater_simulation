package project_panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import entities.Play;
import entities.Show;
import frames.MainMenu;
import utility.JTableUtilities;

public class ShowDetailsPanel extends JPanel implements ActionListener{

	private Play myPlay;
	
	public ShowDetailsPanel(Play aPlay) 
	{
		myPlay = aPlay;
		setBasicUI();
	}
	
	public void setBasicUI(){//TODO This panel can be way more beautiful
		
		JPanel 
		outerPanel = new JPanel(),
		titlePanel = getPlayTitlePanel(),
		timeTablePanel = getAllShowsDetailsPanel(),
		buttonsPanel = getUtilityPanel();
		
		outerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridheight = 2;
		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.WEST;
		outerPanel.add(titlePanel,gbc);
		i+=10;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridheight = GridBagConstraints.RELATIVE;
		gbc.weighty = 0.9;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		outerPanel.add(timeTablePanel,gbc);
		i+=1;
		
		gbc.gridx = j;
		gbc.gridy = i;		
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.EAST;
		outerPanel.add(buttonsPanel,gbc);
		
		this.setLayout(new BorderLayout());
		this.add(outerPanel,BorderLayout.LINE_START);
	}
	
	private JPanel getPlayTitlePanel()
	{
		JPanel playPanel = new JPanel();
		playPanel.setLayout(new GridLayout(1,2,5,0));
		
		JLabel titleLbl = new JLabel();
		
		titleLbl.setText("Play Title:");
		titleLbl.setFont(new Font("Myriad Pro",Font.PLAIN,25));
		playPanel.add(titleLbl);
		
		JLabel titleLabel = new JLabel(myPlay.getTitle());
		titleLabel.setFont(new Font("Myriad Pro",Font.PLAIN,30));
		playPanel.add(titleLabel);
		
		return playPanel;
	}
	
	private JPanel getAllShowsDetailsPanel()
	{
		JPanel detailsOfAllShowsPanel = new JPanel();
		detailsOfAllShowsPanel.setLayout(new GridLayout(0, 1, 0, 10));
		ArrayList<Show> listOfAllShows = this.myPlay.getMyShows();//TODO The case that there are no shows logged yet must be considered
		
		for(Show s:listOfAllShows)
		{
			detailsOfAllShowsPanel.add(getOneShowDetailsPanel(s));
		}
		
		return detailsOfAllShowsPanel;
	}
	
	private JPanel getUtilityPanel()
	{
		JPanel utilityPanel = new JPanel();
		
		utilityPanel.setLayout(new FlowLayout());

		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		utilityPanel.add(okBtn);

		JButton newShowBtn = new JButton("New show");
		newShowBtn.addActionListener(this);
		utilityPanel.add(newShowBtn);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		utilityPanel.add(cancelButton);
		
		return utilityPanel;
	}
	
	private JPanel getOneShowDetailsPanel(Show aShow)
	{
		JPanel detailsOfOneShowPanel = new JPanel();
		detailsOfOneShowPanel.setLayout(new GridLayout(1, 0, 2, 0));
		
		JLabel datelbl1 = new JLabel("Date:");		
		datelbl1.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		detailsOfOneShowPanel.add(datelbl1);
		
		JLabel datelbl2 = new JLabel(aShow.getDate());
		datelbl2.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		detailsOfOneShowPanel.add(datelbl2);
		
		JLabel timebl1 = new JLabel("Time:");		
		timebl1.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		detailsOfOneShowPanel.add(timebl1);
		
		JLabel timebl2 = new JLabel(aShow.getTime());
		timebl2.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		detailsOfOneShowPanel.add(timebl2);
		
		return detailsOfOneShowPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getActionCommand().equals("OK"))
		{			
			MainMenu.swapTabComponent(new ProjectTheatricalShowPanel());
		}
		else if(e.getActionCommand().equals("New show"))
		{
			MainMenu.swapTabComponent(new AddNewShowPanel(this.myPlay));
		}
		else if(e.getActionCommand().equals("Cancel"))
		{
			MainMenu.swapTabComponent(new ProjectTheatricalShowPanel());
		}
	}
}
