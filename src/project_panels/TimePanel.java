package project_panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimePanel extends JPanel implements ItemListener{

	private static JComboBox<String> hoursCB;
	private static JComboBox<String> minutesCB;
	private JLabel myInitialTimeLabel;
	
	public TimePanel(JLabel initialTimeLabel)
	{
		myInitialTimeLabel = initialTimeLabel;
		basicUI();
	}
	
	private void basicUI()
	{
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		hoursCB = new JComboBox<String>(getHoursList());
		minutesCB = new JComboBox<String>(getMinutesList());

		int i = 0, j = 0;//i for rows, j for columns
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.insets = new Insets(20, 20, 20, 2);
		this.add(hoursCB,gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.anchor = GridBagConstraints.CENTER;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20, 5, 20, 2);
		this.add(new JLabel(":"),gbc);
		j++;
		
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(20, 5, 20, 20);
		this.add(minutesCB,gbc);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		//this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));	
		//this.add(outerPanel);
		
	}
	
	private String[] getHoursList()
	{
		String hours[] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		
		return hours;
	}
	
	private String[] getMinutesList()
	{
		String minutes[] = {"00","05","10","15","20","25","30","35","40","45","50","55"};
		
		return minutes;
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource().equals(this.hoursCB))
		{
			
		}
		else if(e.getSource().equals(this.minutesCB))
		{
			
		}
	}
	


}
