package project_panels;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;

import entities.Show;
import frames.MainMenu;

public class PreviewSeatsPanel extends JPanel implements ActionListener{

	private double utilisableWidthRatio = 0.8, utilisableHeightRatio = 0.8;
	private int panelWidth  = 1300, utilisableWidth = (int)(panelWidth*utilisableWidthRatio);
	private int panelHeight =  700, utilisableHeight = (int)(panelHeight*utilisableHeightRatio);

	private final int ROWS = 10;
	private final int COLUMNS = 10;
	private final char LETTERS[] = {'A','B','C','D','E','F','G','H','I','J','K'};
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private Show myShow;
	/*
	 * This Panel is set up with the logic of North, Middle, South, and the
	 * Middle Panel is divided into West, Center, East
	 * 
	 */
	public PreviewSeatsPanel(Show aShow)
	{
		this.myShow = aShow;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(panelWidth, panelHeight));
		basicUI();
	}

	public void basicUI()
	{
		JPanel aggregatorPanel = new JPanel();
		JPanel nPanel = new JPanel(), sPanel = new JPanel();
		aggregatorPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		int i = 0, j = 0;//i for rows, j for columns

		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.BOTH;		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weighty = 0.1;
		gbc.weightx = 1;
		String titleText = ""+myShow.getMyPlay().getTitle()+" --- "+myShow.getDate()+" "+myShow.getTime();
		JLabel label = new JLabel(titleText);
		label.setFont(new Font("Serif", Font.BOLD, 30));
		nPanel.add(label);
		aggregatorPanel.add(nPanel, gbc);
		i++;

		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;		
		gbc.weighty = 0.8;
		aggregatorPanel.add(getMiddlePanel(), gbc);
		i++;

		gbc.gridy = i;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.SOUTH;
		sPanel = getUtilityPanel();
		sPanel.setPreferredSize(nPanel.getPreferredSize());
		aggregatorPanel.add(sPanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		this.setLayout(new GridBagLayout());
		this.add(aggregatorPanel,gbc);
	}

	private JPanel getMiddlePanel()
	{
		JPanel middlePanel = new JPanel();
		JPanel wPanel = new JPanel(), ePanel, cPanel;
		middlePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		int i = 0, j = 0;//i for rows, j for columns

		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		middlePanel.add(wPanel, gbc);
		j++;

		gbc.gridx = j;
		gbc.gridy = i;
		cPanel = getMainPanel();
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0;
		middlePanel.add(cPanel, gbc);
		j++;

		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0.5;
		ePanel = getEastPanel();
		middlePanel.add(ePanel, gbc);

		//middlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		return 	middlePanel;
	}
	private JPanel getEastPanel()
	{
		JPanel eastPanel = new JPanel();		
		eastPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		int i = 0, j = 0;//i for rows, j for columns

			
		
		JLabel bookedLbl = new JLabel("Booked");
		bookedLbl.setFont(new Font("Serif", Font.BOLD, 25));
		
		gbc.gridx = j;
		gbc.gridy = i;		
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.NONE;
		//gbc.weightx = 1;
		gbc.weighty = 0.5;
		eastPanel.add(bookedLbl, gbc);
		i++;
		
		JLabel unbookedLbl = new JLabel("Un-Booked");
		unbookedLbl.setFont(new Font("Serif", Font.BOLD, 25));
				
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.NONE;
		//gbc.weightx = 1;
		gbc.weighty = 0.5;
		eastPanel.add(unbookedLbl, gbc);
		
		
		return eastPanel;
	}
	private JPanel getMainPanel()
	{
		int buttonWidth = (int)(utilisableWidth/14.5);
		int buttonHeight = (int)(utilisableHeight/14.5);
		JPanel mainPanel = new JPanel();		
		mainPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();		
		int i, j;//i for rows, j for columns - For gbc usage only		

		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		i = 0;
		int pos = 0;

		while(i<ROWS*2)
		{
			j = 0;
			gbc.gridx = j;
			while(j<COLUMNS*2)
			{
				String text = myShow.getSeats()[pos].getName();
				JButton btn = new JButton(text);
				btn.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
				btn.setFont(new Font("Serif", Font.BOLD, 19));
				btn.addActionListener(this);
				if(myShow.getSeats()[pos].isBooked())
				{
					btn.setForeground(Color.YELLOW);
					btn.setBackground(Color.RED);
				}
				mainPanel.add(btn, gbc);
				buttons.add(btn);
				pos++;
				j++;
				gbc.gridx = j;

				if(j<COLUMNS*2-1)// Omit last empty label
				{
					JLabel lbl = new JLabel();
					lbl.setPreferredSize(new Dimension(buttonWidth/2,buttonHeight/2));
					mainPanel.add(lbl, gbc);					
				}			
				j++;
				gbc.gridx = j;
			}			
			gbc.gridx = 0;
			i++;
			gbc.gridy = i;
			if(i<ROWS*2-1)// Omit last empty label
			{						
				JLabel lbl = new JLabel();
				lbl.setPreferredSize(new Dimension(buttonWidth/2,buttonHeight/2));
				mainPanel.add(lbl, gbc);
			}
			i++;
			gbc.gridy = i;
		}

		//mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		return mainPanel;
	}

	private JPanel getUtilityPanel()
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
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getActionCommand().equals("OK"))
		{			
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}		
		else if(e.getActionCommand().equals("Cancel"))
		{
			MainMenu.swapTabComponent(new ProjectAllPlaysPanel());
		}
		else
		{
			JButton myButton = null;
			for(int i = 0; i<buttons.size();i++)
			{
				if(buttons.get(i).getText().equals(e.getActionCommand()))
				{
					myButton = buttons.get(i);
					break;
				}			
			}
			myButton.setForeground(Color.YELLOW);
			myButton.setBackground(Color.RED);
		}
	}
}
