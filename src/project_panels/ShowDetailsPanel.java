package project_panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entities.Play;
import entities.Show;
import frames.MainMenu;

public class ShowDetailsPanel extends JPanel implements ActionListener{

	private Play myPlay;
	
	public ShowDetailsPanel(Play aPlay) 
	{
		myPlay = aPlay;
		setBasicUI();
	}
	
	public void setBasicUI(){//TODO If shows are too many, a JScrollPane should be implemented 
		
		JPanel outerPanel = new JPanel(), titlePanel = getTitlePanel(), showsPanel = getAllShowsDetailsPanel(), buttonsPanel = getUtilityPanel();
		
		outerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weighty = 0;
		gbc.insets = new Insets(0, 0, 10, 0);
		outerPanel.add(titlePanel,gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.weighty = 0.2;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(0, 0, 10, 0);
		outerPanel.add(showsPanel,gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;	
		gbc.weighty = 0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 0, 0, 0);
		outerPanel.add(buttonsPanel,gbc);
		
		//TODO titlePanel and buttonsPanel must combine to a single panel, under titlePanel
		this.setLayout(new GridBagLayout());
		GridBagConstraints outergbc = new GridBagConstraints();
		
		i = 0;
		j = 0;
		
		outergbc.gridx = j;
		outergbc.gridy = i;
		outergbc.anchor = GridBagConstraints.NORTHWEST;
		outergbc.fill = GridBagConstraints.VERTICAL;
		outergbc.weightx = 1;
		outergbc.weighty = 1;

		//this.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		this.add(outerPanel,outergbc);
	}
	
	private JPanel getTitlePanel()
	{
		JPanel titlePanel = new JPanel();		
		titlePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(0, 0, 0, 0);
		JLabel titleLabel = new JLabel("PlayTitle: ");
		titleLabel.setFont(new Font("Myriad Pro",Font.PLAIN,25));
		titlePanel.add(titleLabel,gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(0, 0, 0, 0);
		JLabel titleContextLabel = new JLabel(myPlay.getTitle());
		titleContextLabel.setFont(new Font("Myriad Pro",Font.PLAIN,30));
		titlePanel.add(titleContextLabel,gbc);

		return titlePanel;
	}
	
	private JPanel getAllShowsDetailsPanel()
	{
		JPanel detailsOfAllShowsPanel = new JPanel();
		detailsOfAllShowsPanel.setLayout(new GridLayout(0, 1, 0, 10));
		ArrayList<Show> listOfAllShows = this.myPlay.getMyShows();//TODO The case that there are no shows logged yet must be considered
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(0, 0, 10, 0);
		
		for(Show s:listOfAllShows)
		{
			detailsOfAllShowsPanel.add(getOneShowDetailsPanel(s));
		}
		
		return detailsOfAllShowsPanel;
	}
	
	private JPanel getUtilityPanel()
	{
		JPanel utilityPanel = new JPanel();
		
		utilityPanel.setLayout(new GridLayout(1, 0, 10, 0));

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
		detailsOfOneShowPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(0, 0, 0, 5);
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		detailsOfOneShowPanel.add(getDatePanel(aShow),gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(0, 5, 0, 0);
		gbc.anchor = GridBagConstraints.EAST;
		detailsOfOneShowPanel.add(getTimePanel(aShow),gbc);
		
		detailsOfOneShowPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		return detailsOfOneShowPanel;
	}
	
	private JPanel getDatePanel(Show aShow)
	{
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(0, 0, 0, 7);
		gbc.anchor = GridBagConstraints.WEST;
		JLabel datelbl1 = new JLabel("Date:");		
		datelbl1.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		datePanel.add(datelbl1,gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(0, 0, 0, 0);
		JLabel datelbl2 = new JLabel(aShow.getDate());
		datelbl2.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		datePanel.add(datelbl2,gbc);
		
		return datePanel;
	}
	
	private JPanel getTimePanel(Show aShow)
	{
		JPanel timePanel = new JPanel();
		timePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(0, 0, 0, 5);
		gbc.anchor = GridBagConstraints.WEST;
		JLabel timebl1 = new JLabel("Time:");		
		timebl1.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		timePanel.add(timebl1,gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(0, 5, 0, 0);
		JLabel timebl2 = new JLabel(aShow.getTime());
		timebl2.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		timePanel.add(timebl2,gbc);
		
		return timePanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getActionCommand().equals("OK"))
		{			
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}
		else if(e.getActionCommand().equals("New show"))
		{
			MainMenu.swapTabComponent(new AddNewShowPanel(this.myPlay));
		}
		else if(e.getActionCommand().equals("Cancel"))
		{
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}
	}
}
