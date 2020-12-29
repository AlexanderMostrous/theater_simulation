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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import entities.Details;
import entities.Play;
import frames.MainMenu;
import utility.DataHolder;

public class AddNewPlayPanel extends JPanel implements ActionListener{
	
	//private Play myPlay;
	private JTextField playTitleTxtFld, directorTxtFld, scriptWriterTxtFld, actor1TxtFld, actor2TxtFld, actor3TxtFld, actor4TxtFld, actor5TxtFld;
	private JTextArea playDescriptionTxtArea;
	
	public AddNewPlayPanel()
	{	
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
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(5, 5, 20, 5);
		//gbc.weighty = 0.9;	
		JPanel mainPanel = this.getMainPanel();
		aggregatorPanel.add(mainPanel, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.insets = new Insets(20, 5, 0, 5);
		gbc.weightx = 1;
		//gbc.weighty = 0.1;		
		JPanel buttonsPanel = getUtilityPanel();
		aggregatorPanel.add(buttonsPanel, gbc);

		
		String text = "Add a new play";
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
	
	//TODO For the actors a dynamic solution should be implemented
	private JPanel getMainPanel()
	{
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		LineBorder standardBorder = (LineBorder) BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JLabel playTitleLbl, descriptionLbl, directorLbl, scriptWriterLbl, actor1Lbl, actor2Lbl, actor3Lbl, actor4Lbl, actor5Lbl;
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(10, 5, 5, 5);
		playTitleLbl = new JLabel("Play Title:");
		playTitleLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(playTitleLbl, gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);//TODO The size of the title textfield should be adaptive
		playTitleTxtFld = new JTextField("");
		playTitleTxtFld.setBorder(standardBorder);
		playTitleTxtFld.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		mainPanel.add(playTitleTxtFld, gbc);
		j = 0;
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.insets = new Insets(5, 5, 5, 5);
		descriptionLbl = new JLabel("Description:");
		descriptionLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(descriptionLbl,gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);
		playDescriptionTxtArea = new JTextArea("", 5, 30);		
		playDescriptionTxtArea.setBorder(standardBorder);
		playDescriptionTxtArea.setFont(new Font("Myriad Pro",Font.PLAIN,21));
		playDescriptionTxtArea.setLineWrap(true);
		playDescriptionTxtArea.setWrapStyleWord(true);
		mainPanel.add(playDescriptionTxtArea, gbc);
		i++;
		j=0;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(5, 5, 5, 5);
		directorLbl = new JLabel("Director:");
		directorLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(directorLbl, gbc);
		j++;
		
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);
		directorTxtFld = new JTextField("");
		directorTxtFld.setBorder(standardBorder);
		directorTxtFld.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		mainPanel.add(directorTxtFld, gbc);
		j=0;
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;		
		gbc.insets = new Insets(5, 5, 5, 5);
		scriptWriterLbl = new JLabel("Script Writer:");
		scriptWriterLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(scriptWriterLbl, gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;		
		gbc.insets = new Insets(5, 5, 5, 5);
		scriptWriterTxtFld = new JTextField("");
		scriptWriterTxtFld.setBorder(standardBorder);
		scriptWriterTxtFld.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		mainPanel.add(scriptWriterTxtFld, gbc);
		j=0;
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;	
		gbc.insets = new Insets(5, 5, 5, 5);
		actor1Lbl = new JLabel("Actor 1:");
		actor1Lbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(actor1Lbl, gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;		
		gbc.insets = new Insets(5, 5, 5, 5);
		actor1TxtFld = new JTextField("");
		actor1TxtFld.setBorder(standardBorder);
		actor1TxtFld.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		mainPanel.add(actor1TxtFld, gbc);
		j=0;
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;	
		gbc.insets = new Insets(5, 5, 5, 5);
		actor2Lbl = new JLabel("Actor 2:");
		actor2Lbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(actor2Lbl, gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;		
		gbc.insets = new Insets(5, 5, 5, 5);
		actor2TxtFld = new JTextField("");
		actor2TxtFld.setBorder(standardBorder);
		actor2TxtFld.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		mainPanel.add(actor2TxtFld, gbc);
		j=0;
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;	
		gbc.insets = new Insets(5, 5, 5, 5);
		actor3Lbl = new JLabel("Actor 3:");
		actor3Lbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(actor3Lbl, gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;		
		gbc.insets = new Insets(5, 5, 5, 5);
		actor3TxtFld = new JTextField("");
		actor3TxtFld.setBorder(standardBorder);
		actor3TxtFld.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		mainPanel.add(actor3TxtFld, gbc);
		j=0;
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;	
		gbc.insets = new Insets(5, 5, 5, 5);
		actor4Lbl = new JLabel("Actor 4:");
		actor4Lbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(actor4Lbl, gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;		
		gbc.insets = new Insets(5, 5, 5, 5);
		actor4TxtFld = new JTextField("");
		actor4TxtFld.setBorder(standardBorder);
		actor4TxtFld.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		mainPanel.add(actor4TxtFld, gbc);
		j=0;
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;	
		gbc.insets = new Insets(5, 5, 10, 5);
		actor5Lbl = new JLabel("Actor 5:");
		actor5Lbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(actor5Lbl, gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;		
		gbc.insets = new Insets(5, 5, 10, 5);
		actor5TxtFld = new JTextField("");
		actor5TxtFld.setBorder(standardBorder);
		actor5TxtFld.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		mainPanel.add(actor5TxtFld, gbc);
		j=0;
		i++;
		
		return mainPanel;
	}
		
	public JPanel getUtilityPanel()
	{
		JPanel utilityPanel = new JPanel();		
		utilityPanel.setLayout(new GridLayout(1,0,10,10));
		
		JButton addShowBtn = new JButton("Save");
		addShowBtn.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		addShowBtn.addActionListener(this);
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		cancelBtn.addActionListener(this);

		utilityPanel.add(addShowBtn);
		utilityPanel.add(cancelBtn);
		
		return utilityPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Save"))
		{
			//TODO Actors functionality should be implemented
			Play newPlay = new Play(playTitleTxtFld.getText());
			Details newDetails = new Details(directorTxtFld.getText(), scriptWriterTxtFld.getText(), playDescriptionTxtArea.getText());
			newPlay.setMyDetails(newDetails);
			DataHolder.plays.add(newPlay);//TODO DB Functionality
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}
		else if(e.getActionCommand().equals("Cancel"))
		{
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}
	}
}
