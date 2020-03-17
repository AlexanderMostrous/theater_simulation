package project_panels;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import entities.Play;
import entities.Show;
import utility.JTableUtilities;

public class ShowDetailsPanel extends JPanel implements ActionListener{

	private Play myPlay;
	private ArrayList<Show> newlyAddedShows;
	
	public ShowDetailsPanel(Play aPlay) 
	{
		myPlay = aPlay;
		setBasicUI();
	}
	
	public void setBasicUI(){		

		JPanel panel = new JPanel();
		JLabel titleLbl = new JLabel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridy=0;
		gbc.gridx=0;
		gbc.insets = new Insets(15, 10, 15, 10);

		gbc.gridwidth = 1;
		titleLbl.setText("Τίτλος Έργου:");
		titleLbl.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(titleLbl, gbc);


		gbc.gridwidth = 3;
		gbc.gridx++;
		JLabel titleLabel = new JLabel(myPlay.getTitle());
		titleLabel.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(titleLabel, gbc);

		gbc.gridwidth = 4;
		gbc.gridy++;
		gbc.gridx=0;
		JPanel timeTablePanel = this.createTimeTablePanel();

		panel.add(timeTablePanel, gbc);


		JPanel rightPanel = this.createAddShowPanel();
		gbc.gridwidth = 4;
		gbc.gridy++;
		panel.add(rightPanel, gbc);		

		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1, 2, 10, 0));

		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		temp.add(okBtn);

		JButton cancelButton = new JButton("Ακύρωση");
		cancelButton.addActionListener(this);
		temp.add(cancelButton, gbc);


		gbc.gridwidth = 4;
		gbc.gridy++;
		gbc.gridx=0;
		gbc.insets = new Insets(0, 10, 15, 10);
		panel.add(temp, gbc);
	}
	
	public JPanel createTimeTablePanel(){
		String[] columnNames = {"Ημερομηνία","Ώρα"};

		String[][] data = {{"κενή ημερομηνία","κενή ώρα"},{"κενή ημερομηνία","κενή ώρα"}};
		int rows=0;
		if(myPlay.getMyPerformances().size()>0)
			rows += myPlay.getMyPerformances().size();
		if(this.newlyAddedShows!=null)
			rows += this.newlyAddedShows.size();

		if(rows>0)//It means that data DO exist.
		{
			data = new String[rows][2];
			int i=0;
			if(myPlay.getMyPerformances().size()>0)
			{
				for(Show p:myPlay.getMyPerformances())
				{
					data[i][0] = p.getDate();
					data[i][1] = p.getTime();
					i++;
				}
			}
			if(this.newlyAddedShows!=null)
				for(Show p:this.newlyAddedShows)
				{
					data[i][0] = p.getDate();
					data[i][1] = p.getTime();
					i++;
				}
		}



		JPanel panel = new JPanel(), tempPanel = new JPanel();
		JTable table = new JTable(data, columnNames);
		JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
		table.setFont(new Font("Myriad Pro", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("Myriad Pro", Font.PLAIN, 20));

		panel.setLayout(new BorderLayout());

		tempPanel.setLayout(new BorderLayout());
		tempPanel.add(table.getTableHeader(), BorderLayout.CENTER);
		tempPanel.add(table, BorderLayout.SOUTH);
		String text = "Τρέχουσες Παραστάσεις";

		tempPanel.setBorder(BorderFactory.createTitledBorder(null,
				text, 
				TitledBorder.DEFAULT_JUSTIFICATION ,
				TitledBorder.DEFAULT_POSITION, 
				new Font("Myriad Pro", Font.PLAIN, 18), 
				Color.BLACK));
		panel.add(tempPanel, BorderLayout.CENTER);


		return panel;
	}
	public JPanel createAddShowPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		JLabel lbl = new JLabel("Προσθήκη Νέας Παράστασης");
		lbl.setFont(new Font("Myriad Pro",Font.PLAIN,18));

		JButton btn = new JButton("+");
		btn.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		btn.addActionListener(this);
		gbc.gridx=0;
		gbc.gridy=0;
		panel.add(lbl, gbc);
		gbc.gridx++;
		gbc.insets = new Insets(10, 10, 10, 10);
		panel.add(btn,gbc);

		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
