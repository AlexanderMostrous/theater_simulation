package frames;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utility.TimeData;


public class CalendarFrame extends JFrame implements ActionListener{

	private String months[] = TimeData.Months;
	private String dayAcronyms[] = TimeData.DayAcronyms, myName = "Επιλoγή Ημερομηνίας";
	private JLabel monthLabel,dateLabel = new JLabel();
	private JPanel mainPanel;
	private Calendar calendar;
	private JFrame parent, myFrame;
	private JLabel parentDateLabel;
	
	public CalendarFrame(JFrame parentFrame,JLabel parentDateLabel){
		this.dateLabel.setText(parentDateLabel.getText());
		this.parent = parentFrame;
		this.parentDateLabel = parentDateLabel;
		
		myFrame = this;
		instantiateCalendar();
		
		this.mainPanel = initMainPanel();
		
		
		this.getContentPane().add(mainPanel);
		
		this.setUp();
	}

	public CalendarFrame(JFrame parentFrame){
		this.dateLabel = new JLabel();
		this.parent = parentFrame;
		
		myFrame = this;
		instantiateCalendar();
		
		this.mainPanel = initMainPanel();
		this.getContentPane().add(mainPanel);
		
		this.setUp();
	}
	private JPanel initMainPanel() {

		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridwidth = 4;
		gbc.gridx=0;
		gbc.insets = new Insets(5,5,10,5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy=0;
		mainPanel.add(createMonthBar(), gbc);

		gbc.gridwidth = 4;
		gbc.gridx=0;
		gbc.insets = new Insets(0,5,5,5);
		gbc.gridy++;
		mainPanel.add(createCalendarGrid(), gbc);
		
		
		gbc.insets = new Insets(10,0,10,0);
		gbc.gridy++;
		mainPanel.add(createChosenDate(), gbc);
		
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2,10,10));
		
		gbc.gridwidth = 4;
		gbc.gridx=0;
		gbc.gridy++;
		gbc.insets = new Insets(10,5,10,5);
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		JButton cancelBtn = new JButton("Ακύρωση");
		cancelBtn.addActionListener(this);

		temp.add(okBtn);
		temp.add(cancelBtn);
		mainPanel.add(temp, gbc);
		
		return mainPanel;
	}
	
	private JPanel createChosenDate(){
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(0,5,0,5);
		gbc.gridy=0;
		gbc.gridx=0;
		mainPanel.add(new JLabel("Επιλεγμένη Ημερομηνία:"), gbc);
		
		gbc.gridx=1;
		mainPanel.add(this.dateLabel, gbc);

		return mainPanel;

	}


	private int firstDayOfTheMonth(){

		SimpleDateFormat sdf = new SimpleDateFormat("EEE");

		switch(sdf.format(calendar.getTime())){

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

	private void instantiateCalendar(){
		calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	}

	private JPanel createCalendarGrid(){
		JPanel calendarGridPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.monthLabel.setText(months[calendar.get(Calendar.MONTH)]);//Converts the integer-month in the equal String in Greek 

		int firstDayOfTheMonth = this.firstDayOfTheMonth();
		YearMonth yearMonthObject = YearMonth.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		
		gbc.fill = GridBagConstraints.BOTH;
		int i=0,j,currentDay=1;
		while(i<7)
		{
			j=0;
			gbc.gridy=i;
			while(j<7 && currentDay<=daysInMonth)
			{
				gbc.gridx=j;
				if(i==0)
				{
					JLabel label = new JLabel(this.dayAcronyms[j],SwingConstants.CENTER);
					label.setFont(new Font("Serif", Font.BOLD, 16));
					calendarGridPanel.add(label, gbc);
				}
				else if(i==1)
				{
					if(j<firstDayOfTheMonth)
						calendarGridPanel.add(new JLabel(), gbc);
					else
					{
						JButton aButton = new JButton(""+currentDay);
						aButton.addActionListener(new CalendarButtonListener());
						calendarGridPanel.add(aButton, gbc);
						currentDay++;
					}
				}
				else
				{
					JButton aButton = new JButton(""+currentDay);
					aButton.addActionListener(new CalendarButtonListener());
					calendarGridPanel.add(aButton, gbc);
					currentDay++;
				}
				j++;
			}
			i++;
		}
		return calendarGridPanel;
	}

	private JPanel createMonthBar(){
		JPanel monthBarPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JButton previousMonth = new JButton("<<"), nextMonth = new JButton(">>");
		monthLabel = new JLabel();

		previousMonth.addActionListener(new ChangeMonthButtonListener());
		nextMonth.addActionListener(new ChangeMonthButtonListener());

		gbc.weightx = 1;
		gbc.gridx=0;
		monthBarPanel.add(previousMonth, gbc);

		gbc.gridx=1;
		monthBarPanel.add(monthLabel, gbc);

		gbc.gridx=2;
		monthBarPanel.add(nextMonth, gbc);

		return monthBarPanel;
	}

	public void setUp(){
		this.setTitle(myName);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public class CalendarButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
			dateLabel.setText(""+e.getActionCommand()+"/"+sdf.format(calendar.getTime()));
		}

	}

	public String getChosenDate(){
		return dateLabel.getText();
	}
	
	public class ChangeMonthButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {


			if(e.getActionCommand().equals("<<"))
			{
				calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
			}
			else if(e.getActionCommand().equals(">>"))
			{
				calendar.add(Calendar.MONTH, 1);
			}

			mainPanel = initMainPanel();
			myFrame.setContentPane(mainPanel);
			
			((CalendarFrame) myFrame).setUp();
			mainPanel.revalidate();
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK"))
		{
			this.parentDateLabel.setText(this.dateLabel.getText());
			parent.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("Ακύρωση"))
		{
			parent.setVisible(true);
			this.dispose();
		}
	}
}