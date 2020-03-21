package project_panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utility.TimeData;

public class CalendarPanel extends JPanel implements ActionListener{

	//private String months[] = TimeData.Months;
	private String dayAcronyms[] = TimeData.DayAcronyms;
	private JLabel monthLabel = new JLabel(),chosenDateLabel = new JLabel(), myMainDateLabel;
	private String initialDateString;
	private Calendar calendar;
	
	
	public CalendarPanel(JLabel initialDateLabel)
	{
		myMainDateLabel = initialDateLabel;
		initialDateString = initialDateLabel.getText();//This string holds the initial label in case that the user need to restore their new date to their prior one.
		chosenDateLabel.setText(myMainDateLabel.getText());
		instantiateCalendar();
		basicUI();
	}
	
	private void basicUI()
	{
		JPanel  chosenDatePanel = getChosenDatePanel(), monthChangePanel = getMonthChangePanel(), calendarGridPanel = getCalendarGridPanel(), buttonsPanel = getButtonsPanel();
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(20, 20, 0, 20);
		this.add(chosenDatePanel,gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 0, 20);
		this.add(monthChangePanel,gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(20, 20, 0, 20);
		this.add(calendarGridPanel,gbc);
		i++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.ipady = 5;		
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.insets = new Insets(10, 20, 20, 20);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(buttonsPanel,gbc);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}
	
	private JPanel getChosenDatePanel()
	{
		JPanel chosenDatePanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(0,5,0,5);
		gbc.gridy=0;
		gbc.gridx=0;
		JLabel setDateLbl = new JLabel("Set date:");
		setDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		chosenDatePanel.add(setDateLbl, gbc);
		
		gbc.gridx=1;
		this.chosenDateLabel.setFont(new Font("Myriad Pro",Font.PLAIN,25));
		chosenDatePanel.add(this.chosenDateLabel, gbc);

		return chosenDatePanel;
	}

	private JPanel getCalendarGridPanel()    
	{
		JPanel calendarGridPanel = new JPanel(new GridLayout(7,7,0,0));
		
		SimpleDateFormat monthLabelDateFormat = new SimpleDateFormat("MMMM");			
		this.monthLabel.setText(monthLabelDateFormat.format(calendar.getTime())); 
		this.monthLabel.setFont(new Font("Myriad Pro",Font.PLAIN,21));
		Date initialDate = calendar.getTime();//The state of the calendar is stored so that after many applied changes on calendar, it will be restored.
		
		int firstDayOfTheMonth = this.firstDayOfTheMonth();
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int currentMonth = calendar.get(Calendar.MONTH);
		calendar.add(Calendar.DAY_OF_MONTH, firstDayOfTheMonth*(-1));
		
		for(int i=0;i<7;i++)
		{
			JLabel label = new JLabel(this.dayAcronyms[i],SwingConstants.CENTER);
			label.setFont(new Font("Serif", Font.BOLD, 16));
			calendarGridPanel.add(label);
		}
		
		JButton btn;
		for(int i=0;i<42;i++)
		{
			if(currentMonth!=calendar.get(Calendar.MONTH))				
				calendarGridPanel.add(new JLabel(""+calendar.get(Calendar.DAY_OF_MONTH),SwingConstants.CENTER));
			else
			{
				btn = new JButton(""+calendar.get(Calendar.DAY_OF_MONTH));
				btn.addActionListener(this);
				calendarGridPanel.add(btn);
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		calendar.setTime(initialDate);

		return calendarGridPanel;
	}
	
	private JPanel getButtonsPanel()
	{
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1,0,10,10));
		
		JButton okBtn = new JButton("Confirm");
		okBtn.addActionListener(this);
		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(this);
		
		buttonsPanel.add(okBtn);
		buttonsPanel.add(resetBtn);
		
		return buttonsPanel;
	}
	
	private JPanel getMonthChangePanel()
	{
		JPanel monthBarPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JButton previousMonth = new JButton("<"), nextMonth = new JButton(">");
		previousMonth.addActionListener(this);
		nextMonth.addActionListener(this);
		monthLabel = new JLabel();		
		int j = 0;
		
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx=j;
		monthBarPanel.add(previousMonth, gbc);
		j++;
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx=j;
		monthBarPanel.add(monthLabel, gbc);
		j++;
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx=j;
		monthBarPanel.add(nextMonth, gbc);

		return monthBarPanel;
	}

	private int firstDayOfTheMonth()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEE");

		switch(sdf.format(calendar.getTime()))
		{
		case "Sun":
			return 0;
		case "Mon":
			return 1;
		case "Tue":
			return 2;
		case "Wed":
			return 3;
		case "Thu":
			return 4;
		case "Fri":
			return 5;
		case "Sat":
			return 6;
		}
		return -1;
	}

	private void instantiateCalendar()
	{
		calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	}

	private void refresh()
	{
		this.removeAll();
		this.basicUI();
		this.revalidate();
		this.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("<"))
		{//TODO Need to test if the below procedure is correct
			calendar.add(Calendar.MONTH, -1);
			refresh();
		}
		else if(e.getActionCommand().equals(">"))
		{
			calendar.add(Calendar.MONTH, 1);
			refresh();
		}
		else if(e.getActionCommand().equals("Confirm"))
		{
			myMainDateLabel.setText(chosenDateLabel.getText());
		}
		else if(e.getActionCommand().equals("Reset"))
		{
			myMainDateLabel.setText(initialDateString);
			chosenDateLabel.setText(initialDateString);
		}
		else//A number button was clicked.
		{
			Integer dayNumber = Integer.valueOf(e.getActionCommand());
			calendar.set(Calendar.DAY_OF_MONTH,dayNumber);
			SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd-MMM-yyyy");					
			this.chosenDateLabel.setText(sdf.format(calendar.getTime()));
		}
	}
}
