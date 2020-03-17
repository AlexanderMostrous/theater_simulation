package frames;
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

import entities.Play;
import utility.DataHolder;

public class AddNewShow extends JFrame implements ActionListener{

	private JButton plus1, plus2;
	private JLabel chosen1 = new JLabel(""),chosen2 = new JLabel("");
	private JTextField titleTxtField = new JTextField();
	private Play myShow;
	private JFrame parent;
	
	public AddNewShow(JFrame frame,String frameTitle){
		parent = frame;
		myShow = null;
		basicUI(frameTitle);

	}

	public AddNewShow(JFrame frame,String frameTitle,Play play){
		parent = frame;
		myShow = play;
		chosen1.setText(play.getStartDate());
		chosen2.setText(play.getEndDate());
		titleTxtField.setText(play.getTitle());
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
		titleLbl.setText("������ �����:");
		titleLbl.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(titleLbl, gbc);

		gbc.gridx++;
		gbc.gridwidth = 3;
		titleTxtField.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(titleTxtField, gbc);

		JPanel temp1 = new JPanel();
		temp1.setLayout(new GridLayout(2, 4, 15, 0));

		JLabel dateFromLbl = new JLabel("���������� ������� �����������: ");
		dateFromLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		temp1.add(dateFromLbl);

		plus1 = new JButton("+");
		plus1.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		plus1.addActionListener(this);
		plus1.setMaximumSize(new Dimension(40, 40));
		temp1.add(plus1);

		JLabel dateToLbl = new JLabel("���������� ����� �����������: ");
		dateToLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		temp1.add(dateToLbl);

		plus2 = new JButton("+");
		plus2.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		plus2.addActionListener(this);
		plus2.setMaximumSize(new Dimension(40, 40));
		temp1.add(plus2);

		JLabel c1 = new JLabel("���������� ����������:"),c2 = new JLabel("���������� ����������:");
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
			addSyntelestes.setText("�������� �����������");
		else
			addSyntelestes.setText("����������� �����������");

		addSyntelestes.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		addSyntelestes.addActionListener(this);
		temp2.add(addSyntelestes);

		JButton cancelButton = new JButton("�������");
		cancelButton.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		cancelButton.addActionListener(this);
		temp2.add(cancelButton);

		temp2.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

		gbc.gridx=0;
		gbc.gridwidth = 4;
		gbc.gridy++;	

		panel.add(temp2, gbc);

		this.setContentPane(panel);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(frameTitle);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("OK"))
		{
			if(!this.titleTxtField.getText().equals(""))
			{
				if(myShow.equals(null))//It's a new show that the user is trying to add.
				{
					DataHolder.plays.add(new Play(this.titleTxtField.getText(), this.chosen1.getText(), this.chosen2.getText()));
				}
				else
				{//It's former show that the user is trying to modify.
					DataHolder.plays.set(DataHolder.plays.indexOf(myShow),new Play(this.titleTxtField.getText(), this.chosen1.getText(), this.chosen2.getText()));
				}


				if(this.parent instanceof ProjectTheatricalShow)
					new ProjectTheatricalShow(this,"������� ��������� �����");
				else if(this.parent instanceof MainMenu)
					//new MainMenu();
				this.dispose();
			}
			else
				;//DO NOTHING! THIS MEANS THAT THE USER DIDNT EVEN PROVIDE FOR A TITLE.
		}
		else if(e.getActionCommand().equals("�������� �����������")||e.getActionCommand().equals("����������� �����������"))
		{
			new InputProducers(this,e.getActionCommand(),myShow);
		}
		else if(e.getActionCommand().equals("�������"))
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
		}
	}
}
