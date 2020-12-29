package project_panels;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import entities.Play;
import entities.Show;
import frames.MainMenu;
import utility.DataHolder;
import utility.SaveFunctionality;

public class AddNewShowPanel extends JPanel implements ActionListener{

	private Play myPlay;
	private JLabel selectedDateLbl, selectedTimeLbl;
	public AddNewShowPanel(Play aPlay)
	{
		myPlay = aPlay;		
		basicUI();
	}

	public void basicUI()
	{		
		JPanel aggregatorPanel = new JPanel();
		aggregatorPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 2, 5);
		gbc.weighty = 0.9;	
		JPanel mainPanel = this.getMainPanel();
		aggregatorPanel.add(mainPanel, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(2, 5, 0, 5);
		gbc.weightx = 1;
		gbc.weighty = 0.1;		
		JPanel buttonsPanel = getUtilityPanel();
		aggregatorPanel.add(buttonsPanel, gbc);

		
		String text = "PlayTitle: "+myPlay.getTitle();
		TitledBorder b = BorderFactory.createTitledBorder(text);
		b.setTitleFont(new Font("Myriad Pro",Font.PLAIN,30));
		aggregatorPanel.setBorder(b);
		
		//Reset and independent use of the above gbc starts
		
		i = 0; j = 0;		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 2, 5);
		//gbc.weighty = 0.9;	
		this.setLayout(new GridBagLayout());
		
		this.add(aggregatorPanel,gbc);
	}
	
	private JPanel getMainPanel()
	{
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel chooseDateLbl, chooseTimeLbl;
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(5, 5, 2, 5);
		chooseDateLbl = new JLabel("Pick date:");
		chooseDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(chooseDateLbl, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(2, 5, 0, 5);
		selectedDateLbl = new JLabel("No date picked yet.");
		selectedDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(selectedDateLbl, gbc);
		i = 0;
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);
		JPanel datePanel = new CalendarPanel(selectedDateLbl);
		mainPanel.add(datePanel,gbc);
		i+=5;
		j = 0;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 5, 2, 5);
		chooseTimeLbl = new JLabel("Pick time:");
		chooseTimeLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(chooseTimeLbl, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.EAST;
		selectedTimeLbl = new JLabel("No time picked yet.");
		selectedTimeLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(selectedTimeLbl, gbc);
		j++;
		i--;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(2, 5, 5, 5);
		JPanel timePanel = new TimePanel(selectedTimeLbl);
		mainPanel.add(timePanel, gbc);
		
		
		String text = "Add a new show";
		
		TitledBorder b = BorderFactory.createTitledBorder(text);
		b.setTitleFont(new Font("Myriad Pro",Font.PLAIN,25));
		mainPanel.setBorder(b);
		
		return mainPanel;
	}
		
	public JPanel getUtilityPanel()
	{
		JPanel utilityPanel = new JPanel();		
		utilityPanel.setLayout(new GridLayout(1,0,10,10));
		
		JButton addShowBtn = new JButton("Add show");
		addShowBtn.addActionListener(this);
		JButton cancelBtn = new JButton("Discard");
		cancelBtn.addActionListener(this);

		utilityPanel.add(addShowBtn);
		utilityPanel.add(cancelBtn);
		
		return utilityPanel;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Add show"))
		{
			myPlay.addShow(new Show(selectedDateLbl.getText(), selectedTimeLbl.getText()));
			SaveFunctionality.save();
			selectedDateLbl.getText();
			MainMenu.swapTabComponent(new ShowDetailsPanel(myPlay));
		}
		else if(e.getActionCommand().equals("Discard"))
		{
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}
	}
}
