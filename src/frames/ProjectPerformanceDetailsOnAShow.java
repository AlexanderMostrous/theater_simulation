package frames;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import entities.Performance;
import entities.Show;
import utility.JTableUtilities;

public class ProjectPerformanceDetailsOnAShow  extends JFrame implements ActionListener{

	private Show myShow;
	private JFrame parent;
	private ArrayList<Performance> newlyAddedPerformances;

	public ProjectPerformanceDetailsOnAShow(JFrame parent, Show aShow){

		this.parent = parent;
		myShow = aShow;
		basicUI();

	}

	public ProjectPerformanceDetailsOnAShow(JFrame parent, Show aShow, ArrayList<Performance> newlyAddedPerformances){

		this.newlyAddedPerformances = newlyAddedPerformances;
		this.parent = parent;
		myShow = aShow;
		basicUI();

	}
	public void basicUI(){		

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
		JLabel titleLabel = new JLabel(myShow.getTitle());
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


		this.setContentPane(panel);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Παραστάσεις");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("OK"))
		{
			for(Performance p:this.newlyAddedPerformances)
				myShow.addPerformance(p);

			parent.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("Ακύρωση"))
		{
			parent.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("+"))
		{
			new AddPerformanceOnShow(this,myShow);
			this.setVisible(false);
		}
	}

	public JPanel createTimeTablePanel(){
		String[] columnNames = {"Ημερομηνία","Ώρα"};

		String[][] data = {{"κενή ημερομηνία","κενή ώρα"},{"κενή ημερομηνία","κενή ώρα"}};
		int rows=0;
		if(myShow.getMyPerformances().size()>0)
			rows += myShow.getMyPerformances().size();
		if(this.newlyAddedPerformances!=null)
			rows += this.newlyAddedPerformances.size();

		if(rows>0)//It means that data DO exist.
		{
			data = new String[rows][2];
			int i=0;
			if(myShow.getMyPerformances().size()>0)
			{
				for(Performance p:myShow.getMyPerformances())
				{
					data[i][0] = p.getDate();
					data[i][1] = p.getTime();
					i++;
				}
			}
			if(this.newlyAddedPerformances!=null)
				for(Performance p:this.newlyAddedPerformances)
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

	public JFrame getParentFrame()
	{
		return parent;
	}
}

