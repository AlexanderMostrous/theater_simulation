package project_panels;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Show;
import utility.DataHolder;

public class AddNewShowPanel extends JPanel implements ActionListener{

	private JButton plus1, plus2;
	private JLabel chosen1 = new JLabel(""),chosen2 = new JLabel("");
	private JTextField titleTxtField = new JTextField();
	private Show myShow;
	private JFrame parent;
	
	public AddNewShowPanel(JFrame frame,String frameTitle){
		parent = frame;
		myShow = null;
		basicUI(frameTitle);
	}
	public AddNewShowPanel(){
		
		parent = null;
		myShow = null;
		basicUI
	}

	public AddNewShowPanel(JFrame frame,String frameTitle,Show show){
		parent = frame;
		myShow = show;
		chosen1.setText(show.getStartDate());
		chosen2.setText(show.getEndDate());
		titleTxtField.setText(show.getTitle());
		basicUI(frameTitle);
	}

	public void basicUI(String frameTitle){		

		JPanel panel = new JPanel();
		JLabel titleLbl = new JLabel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets = new Insets(15, 10, 15, 10);
		gbc.gridwidth = 1;
		titleLbl.setText("Τίτλος Έργου:");
		titleLbl.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(titleLbl, gbc);

		gbc.gridx++;
		gbc.gridwidth = 3;
		titleTxtField.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(titleTxtField, gbc);

		JPanel temp1 = new JPanel();
		temp1.setLayout(new GridLayout(2, 4, 15, 0));

		JLabel dateFromLbl = new JLabel("Ημερομηνία Έναρξης Παραστάσεων: ");
		dateFromLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		temp1.add(dateFromLbl);

		plus1 = new JButton("+");
		plus1.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		plus1.addActionListener(this);
		plus1.setMaximumSize(new Dimension(40, 40));
		temp1.add(plus1);

		JLabel dateToLbl = new JLabel("Ημερομηνία Λήξης Παραστάσεων: ");
		dateToLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		temp1.add(dateToLbl);

		plus2 = new JButton("+");
		plus2.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		plus2.addActionListener(this);
		plus2.setMaximumSize(new Dimension(40, 40));
		temp1.add(plus2);

		JLabel c1 = new JLabel("Επιλεγμένη Ημερομηνία:"),c2 = new JLabel("Επιλεγμένη Ημερομηνία:");
		c1.setFont(new Font("Myriad Pro",Font.PLAIN,17));c2.setFont(new Font("Myriad Pro",Font.PLAIN,17));

		temp1.add(c1);
		temp1.add(chosen1);
		temp1.add(c2);
		temp1.add(chosen2);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 4;
		gbc.gridx=0;
		gbc.gridy++;
		panel.add(temp1, gbc);

		JPanel temp2 = new JPanel();
		temp2.setLayout(new GridLayout(1, 0, 30, 0));

		JButton okBtn = new JButton("OK");
		okBtn.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		okBtn.addActionListener(this);
		temp2.add(okBtn);

		JButton addSyntelestes = new JButton();
		if(myShow==null)
			addSyntelestes.setText("Εισαγωγή Συντελεστών");
		else
			addSyntelestes.setText("Τροποποίηση Συντελεστών");

		addSyntelestes.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		addSyntelestes.addActionListener(this);
		temp2.add(addSyntelestes);

		JButton cancelButton = new JButton("Ακύρωση");
		cancelButton.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		cancelButton.addActionListener(this);
		temp2.add(cancelButton);

		temp2.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

		gbc.gridx=0;
		gbc.gridwidth = 4;
		gbc.gridy++;	

		panel.add(temp2, gbc);

	}

	public JPanel getPanel(){
		
		return this;
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("OK"))
		{
			if(!this.titleTxtField.getText().equals(""))
			{
				if(myShow.equals(null))//It's a new show that the user is trying to add.
				{
					DataHolder.shows.add(new Show(this.titleTxtField.getText(), this.chosen1.getText(), this.chosen2.getText()));
				}
				else
				{//It's former show that the user is trying to modify.
					DataHolder.shows.set(DataHolder.shows.indexOf(myShow),new Show(this.titleTxtField.getText(), this.chosen1.getText(), this.chosen2.getText()));
				}


				/*if(this.parent instanceof ProjectTheatricalShow)
					new ProjectTheatricalShow(this,"Προβολή Θεατρικών Έργων");
				else if(this.parent instanceof MainMenu)
					new MainMenu();*/
				//this.dispose();
			}
			else
				;//DO NOTHING! THIS MEANS THAT THE USER DIDNT EVEN PROVIDE FOR A TITLE.
		}
		/*else if(e.getActionCommand().equals("Εισαγωγή Συντελεστών")||e.getActionCommand().equals("Τροποποίηση Συντελεστών"))
		{
			new InputProducers(this,e.getActionCommand(),myShow);
		}
		else if(e.getActionCommand().equals("Ακύρωση"))
		{
			parent.setVisible(true);
			this.dispose();
		}
		else if(e.getSource().equals(plus1))
		{
			this.setVisible(false);
			new CalendarFrame(this, chosen1);
		}
		else if(e.getSource().equals(plus2))
		{
			this.setVisible(false);
			new CalendarFrame(this, chosen2);
		}*/
	}
}
