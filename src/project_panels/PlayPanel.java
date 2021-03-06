package project_panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Play;
import frames.MainMenu;
import utility.SpecialButton;

public class PlayPanel extends JPanel implements ActionListener{

	
	public PlayPanel(Play aShow)
	{
		createPlayPanel(aShow);
	}
	
	public void createPlayPanel(Play play)
	{
		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 5, 5);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel lbl1 = new JLabel("Play title:");
		lbl1.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(lbl1, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx++;
		gbc.insets = new Insets(10, 5, 5, 10);
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel titleLbl = new JLabel(play.getTitle());
		titleLbl.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		panel.add(titleLbl, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 10, 5, 5);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel lbl2 = new JLabel("Play start date:");
		lbl2.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(lbl2, gbc);

		gbc.gridx++;
		gbc.insets = new Insets(5, 5, 5, 10);
		gbc.gridwidth = 3;
		JLabel startDateLbl = new JLabel("Mock Date");//TODO A complete date system should be implemented
		startDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(startDateLbl, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 10, 5, 5);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel lbl3 = new JLabel("Play finish date:");
		lbl3.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(lbl3, gbc);

		gbc.gridx++;
		gbc.insets = new Insets(5, 5, 5, 10);
		gbc.gridwidth = 3;
		JLabel endDateLbl = new JLabel("Mock Date");
		endDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(endDateLbl, gbc);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 0, 20, 0));

		SpecialButton wresProvolwnBtn = new SpecialButton("Shows",play);
		wresProvolwnBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		wresProvolwnBtn.addActionListener(this);
		bottomPanel.add(wresProvolwnBtn, gbc);

		SpecialButton detailsBtn = new SpecialButton("Details",play);
		detailsBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		detailsBtn.addActionListener(this);
		bottomPanel.add(detailsBtn, gbc);

		SpecialButton ticketsBtn = new SpecialButton("Book Tickets",play);
		ticketsBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		ticketsBtn.addActionListener(this);
		bottomPanel.add(ticketsBtn, gbc);

		SpecialButton modifyBtn = new SpecialButton("Modify Play",play);
		modifyBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		modifyBtn.addActionListener(this);
		bottomPanel.add(modifyBtn, gbc);

		SpecialButton deleteBtn = new SpecialButton("Delete Play",play);
		deleteBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		deleteBtn.addActionListener(this);
		bottomPanel.add(deleteBtn, gbc);

		bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 0, 5, 0);
		gbc.gridwidth = 4;
		panel.add(bottomPanel,gbc);

		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.add(panel);	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		SpecialButton button = (SpecialButton)e.getSource();
		
		if(e.getActionCommand().equals("Shows"))
		{			
			MainMenu.swapTabComponent(new ShowDetailsPanel(button.getPlay()));
		}
		else if(e.getActionCommand().equals("Details"))
		{			
			MainMenu.swapTabComponent(new PlayDetailsPanel(button.getPlay()));
		}
		else if(e.getActionCommand().equals("Book Tickets"))
		{			
			//TODO Tickets functionality should be implemented. 
		}
		else if(e.getActionCommand().equals("Modify Play"))
		{			
			MainMenu.swapTabComponent(new EditPlayPanel(button.getPlay()));
		}
		else if(e.getActionCommand().equals("Delete Play"))
		{			
			MainMenu.swapTabComponent(new DeletePlayPanel(button.getPlay()));
		}
	}
}
