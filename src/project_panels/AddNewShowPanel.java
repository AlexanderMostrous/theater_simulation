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
		
		this.setLayout(new GridBagLayout());
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
		this.add(chooseDateLbl, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(2, 5, 0, 5);
		selectedDateLbl = new JLabel("No date picked yet.");
		selectedDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		this.add(selectedDateLbl, gbc);
		i = 0;
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);
		JPanel datePanel = new CalendarPanel(selectedDateLbl);
		this.add(datePanel,gbc);
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
		this.add(chooseTimeLbl, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(5, 5, 5, 5);
		selectedTimeLbl = new JLabel("No time picked yet.");
		selectedTimeLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		this.add(selectedTimeLbl, gbc);
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
		this.add(timePanel, gbc);
		
		//widgetsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		
		String text = "PlayTitle: "+myPlay.getTitle();
		//text.setFont(new Font("Myriad Pro",Font.PLAIN,30));
		TitledBorder b = BorderFactory.createTitledBorder(text);
		b.setTitleFont(new Font("Myriad Pro",Font.PLAIN,30));
		this.setBorder(b);
		//this.add(outerPanel);
		//return widgetsPanel;
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
	
	private JPanel getWidgetsPanel()
	{
		JPanel widgetsPanel = new JPanel();
		widgetsPanel.setLayout(new GridBagLayout());
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
		widgetsPanel.add(chooseDateLbl, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(2, 5, 0, 5);
		selectedDateLbl = new JLabel("No date picked yet.");
		selectedDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		widgetsPanel.add(selectedDateLbl, gbc);
		i = 0;
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);
		JPanel datePanel = new CalendarPanel(selectedDateLbl);
		widgetsPanel.add(datePanel,gbc);
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
		widgetsPanel.add(chooseTimeLbl, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(5, 5, 5, 5);
		selectedTimeLbl = new JLabel("No time picked yet.");
		selectedTimeLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		widgetsPanel.add(selectedTimeLbl, gbc);
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
		widgetsPanel.add(timePanel, gbc);
		
		//widgetsPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		
		String text = "PlayTitle: "+myPlay.getTitle();
		//text.setFont(new Font("Myriad Pro",Font.PLAIN,30));
		TitledBorder b = BorderFactory.createTitledBorder(text);
		b.setTitleFont(new Font("Myriad Pro",Font.PLAIN,30));
		widgetsPanel.setBorder(b);
		//this.add(outerPanel);
		return widgetsPanel;
	}
	
	private JPanel getButtonsPanel()
	{
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1,0,10,10));
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(this);
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(this);

		buttonsPanel.add(okBtn);
		buttonsPanel.add(resetBtn);
		buttonsPanel.add(cancelBtn);
		
		return buttonsPanel;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Save"))
		{
			
		}
		else if(e.getActionCommand().equals("Abort"))
		{
			
		}
	}
}
