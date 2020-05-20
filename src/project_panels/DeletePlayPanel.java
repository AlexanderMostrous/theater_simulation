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
import javax.swing.SwingConstants;

import entities.Play;
import frames.MainMenu;
import utility.DataHolder;

public class DeletePlayPanel extends JPanel implements ActionListener{

	private Play myPlay;
	private JPanel myInsidePanel;
	
	public DeletePlayPanel(Play aPlay)
	{
		myPlay = aPlay;
		basicUI();
	}
	
	public void basicUI()
	{		
		JPanel outerPanel = new JPanel();
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridwidth = 1;
		//gbc.fill = GridBagConstraints.VERTICAL;
		//gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 10, 10, 5);
		//gbc.weighty = 0.9;
		myInsidePanel = this.getFirstPromptPanel();
		outerPanel.add(myInsidePanel, gbc);	
		outerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		this.add(outerPanel,gbc);
	}
	
	private JPanel getFirstPromptPanel()
	{
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel promptLbl;
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		//gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 5, 0);
		promptLbl = new JLabel("<html>You are about to delete the play:<br/>"+ myPlay.getTitle()+".<br/>Are you sure?</html>");
		promptLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		promptLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(promptLbl, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 0, 0, 0);
		mainPanel.add(getFirstPromptUtilityPanel(), gbc);
		
		
		return mainPanel;
	}
	
	private JPanel getFinalPromptPanel()
	{
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel promptLbl;
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		//gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 5, 0);
		promptLbl = new JLabel("<html>Deletion of play:<br/>"+ myPlay.getTitle()+".<br/>Will result in deletion of all it's shows.<br/>Do you still confirm this action?</html>");
		promptLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		promptLbl.setFont(new Font("Myriad Pro",Font.PLAIN,22));
		mainPanel.add(promptLbl, gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 0, 0, 0);
		mainPanel.add(getFinalPromptUtilityPanel(), gbc);
		
		
		return mainPanel;
	}
		
	public JPanel getFirstPromptUtilityPanel()
	{
		JPanel utilityPanel = new JPanel();		
		utilityPanel.setLayout(new GridLayout(1,0,10,10));
		
		JButton addShowBtn = new JButton("Yes");
		addShowBtn.addActionListener(this);
		JButton cancelBtn = new JButton("No");
		cancelBtn.addActionListener(this);

		utilityPanel.add(addShowBtn);
		utilityPanel.add(cancelBtn);
		
		return utilityPanel;
	}
	
	public JPanel getFinalPromptUtilityPanel()
	{
		JPanel utilityPanel = new JPanel();		
		utilityPanel.setLayout(new GridLayout(1,0,10,10));
		
		JButton addShowBtn = new JButton("Confirm");
		addShowBtn.addActionListener(this);
		JButton cancelBtn = new JButton("Abort");
		cancelBtn.addActionListener(this);

		utilityPanel.add(addShowBtn);
		utilityPanel.add(cancelBtn);
		
		return utilityPanel;
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Yes"))
		{
			myInsidePanel.removeAll();
			myInsidePanel.add(getFinalPromptPanel());
			//myInsidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			myInsidePanel.repaint();
			myInsidePanel.revalidate();
		}
		else if(e.getActionCommand().equals("No"))
		{
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}
		else if(e.getActionCommand().equals("Confirm"))
		{
			DataHolder.plays.remove(this.myPlay);			
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}
		else if(e.getActionCommand().equals("Abort"))
		{
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}		
	}
}
