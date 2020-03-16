package frames;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entities.Performance;
import entities.Show;
import utility.TimeData;

public class AddPerformanceOnShow  extends JFrame implements ActionListener{

	private JComboBox<String> hourComboBox, minuteComboBox;
	
	private Show myShow;
	private JFrame parent;
	private JLabel chosenDateLabel = new JLabel("");
	private JComboBox<String> someHourComboBox,someMinuteComboBox;

	private ArrayList<Performance> newlyAddedPerformances = new ArrayList<Performance>();
	
	
	public AddPerformanceOnShow(JFrame parent, Show myShow){

		this.parent = parent;
		this.myShow = myShow;
		
		basicUI();

	}

	public void basicUI(){		

		JPanel panel = new JPanel();
		JLabel titleLbl = new JLabel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		int j = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridy = j;
		gbc.insets = new Insets(15, 10, 15, 10);

		gbc.gridwidth = 1;
		titleLbl.setText("Τίτλος Έργου:");
		titleLbl.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(titleLbl, gbc);


		gbc.gridwidth = 3;
		JLabel titleLabel = new JLabel(myShow.getTitle());
		titleLabel.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(titleLabel, gbc);
		j++;

		gbc.gridwidth = 2;
		gbc.gridy = j;
		JPanel leftPanel = this.createLeftPanel();

		panel.add(leftPanel, gbc);


		JPanel rightPanel = this.createRightPanel();

		panel.add(rightPanel, gbc);		

		gbc.gridwidth = 4;
		gbc.weightx = 1;
		
		gbc.gridy++;
		
		JButton addBtn = new JButton("Προσθήκη");
		addBtn.addActionListener(this);
		panel.add(addBtn,gbc);
		gbc.gridy++;
		

		
		gbc.gridwidth = 2;
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		panel.add(okBtn, gbc);



		JButton cancelBtn = new JButton("Ακύρωση");
		cancelBtn.addActionListener(this);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(cancelBtn, gbc);

		this.setContentPane(panel);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Προσθήκη Παράστασης");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel createLeftPanel(){
		JPanel timePanel = new JPanel();
		
		timePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		timePanel.add(new JLabel("Ώρα:",SwingConstants.RIGHT),gbc);
		this.hourComboBox = createHourComboBox();
		gbc.gridx++;
		gbc.insets = new Insets(10, 10, 10, 10);

		timePanel.add(hourComboBox,gbc);
		this.minuteComboBox = createMinuteComboBox();
		gbc.gridx++;
		timePanel.add(minuteComboBox,gbc);
		
		return timePanel;
	}
	public JPanel createRightPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel lbl = new JLabel("Επιλογή Ημερομηνίας");
		
		JButton btn = new JButton("+");
		btn.addActionListener(this);
		gbc.gridx=0;
		gbc.gridy=0;
		panel.add(lbl, gbc);
		gbc.gridx++;
		gbc.insets = new Insets(10, 10, 10, 10);
		panel.add(btn,gbc);
		
		gbc.gridx=0;
		gbc.gridy++;
		chosenDateLabel.setText(chosenDateLabel.getText());
		panel.add(chosenDateLabel, gbc);
		
		return panel;
	}
	
	private JComboBox<String> createHourComboBox(){

		someHourComboBox = new JComboBox<String>(TimeData.Hours);

		return someHourComboBox;
	}

	private JComboBox<String> createMinuteComboBox(){

		someMinuteComboBox = new JComboBox<String>(TimeData.Minutes);
		return someMinuteComboBox;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("OK"))
		{
			if(!chosenDateLabel.getText().equals("")){
			Performance aPerformance = new Performance(
					myShow,
					chosenDateLabel.getText(),
					""+someHourComboBox.getSelectedItem().toString()+":"+someMinuteComboBox.getSelectedItem().toString());
			this.newlyAddedPerformances.add(aPerformance);

			new ProjectPerformanceDetailsOnAShow(((ProjectPerformanceDetailsOnAShow) parent).getParentFrame(), myShow,this.newlyAddedPerformances);
			}
			else
			{
				if(!this.newlyAddedPerformances.isEmpty())
					new ProjectPerformanceDetailsOnAShow(((ProjectPerformanceDetailsOnAShow) parent).getParentFrame(), myShow,this.newlyAddedPerformances);
				else
					new ProjectPerformanceDetailsOnAShow(((ProjectPerformanceDetailsOnAShow) parent).getParentFrame(), myShow,null);
			}
			
			parent.dispose();
			this.dispose();
		}
		else if(e.getActionCommand().equals("Ακύρωση"))
		{
			parent.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("+"))
		{
			new CalendarFrame(this,chosenDateLabel);
			this.setVisible(false);
		}
		else if(e.getActionCommand().equals("Προσθήκη"))
		{
			Performance aPerformance = new Performance(
					myShow,
					chosenDateLabel.getText(),
					""+someHourComboBox.getSelectedItem().toString()+":"+someMinuteComboBox.getSelectedItem().toString());
			this.newlyAddedPerformances.add(aPerformance);
			chosenDateLabel.setText("");
		}
	}

}
