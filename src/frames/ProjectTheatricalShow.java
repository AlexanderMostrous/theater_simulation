package frames;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entities.Show;
import utility.DataHolder;
import utility.SpecialButton;

public class ProjectTheatricalShow extends JFrame implements ActionListener{

	private JFrame parent; 
	public ProjectTheatricalShow(JFrame parent,String frameTitle){

		this.parent = parent;
		basicUI(frameTitle);

	}

	public void basicUI(String frameTitle){		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		if(!DataHolder.shows.isEmpty())
		{
			for(Show s:DataHolder.shows)
				panel.add(createShowPanel(s));
			panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		else
		{
			JLabel noShowsAvailableLabel = new JLabel("��� �������� ��������� ����.");
			noShowsAvailableLabel.setFont(new Font("Myriad Pro",Font.PLAIN,20));
			panel.add(noShowsAvailableLabel);
			panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		}

		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1, 2, 30, 0));

		JButton menuBtn = new JButton("�������� �����");
		menuBtn.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		menuBtn.addActionListener(this);
		temp.add(menuBtn);

		JButton addNewShowBtn = new JButton("�������� ���� �����");
		addNewShowBtn.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		addNewShowBtn.addActionListener(this);
		temp.add(addNewShowBtn);
		
		temp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.add(temp);

		JScrollPane jsp = new JScrollPane(panel);

		this.setContentPane(jsp);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setTitle(frameTitle);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public JPanel createShowPanel(Show show)
	{
		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 5, 5);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel lbl1 = new JLabel("������ �����:");
		lbl1.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(lbl1, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx++;
		gbc.insets = new Insets(10, 5, 5, 10);
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel titleLbl = new JLabel(show.getTitle());
		titleLbl.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		panel.add(titleLbl, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 10, 5, 5);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel lbl2 = new JLabel("���������� ������� ��������:");
		lbl2.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(lbl2, gbc);

		gbc.gridx++;
		gbc.insets = new Insets(5, 5, 5, 10);
		gbc.gridwidth = 3;
		JLabel startDateLbl = new JLabel(show.getStartDate());
		startDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(startDateLbl, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 10, 5, 5);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel lbl3 = new JLabel("���������� ����� ��������:");
		lbl3.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(lbl3, gbc);

		gbc.gridx++;
		gbc.insets = new Insets(5, 5, 5, 10);
		gbc.gridwidth = 3;
		JLabel endDateLbl = new JLabel(show.getEndDate());
		endDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(endDateLbl, gbc);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 0, 20, 0));

		SpecialButton wresProvolwnBtn = new SpecialButton("���� ��������",show);
		wresProvolwnBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		wresProvolwnBtn.addActionListener(this);
		bottomPanel.add(wresProvolwnBtn, gbc);

		SpecialButton detailsBtn = new SpecialButton("������������",show);
		detailsBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		detailsBtn.addActionListener(this);
		bottomPanel.add(detailsBtn, gbc);

		SpecialButton ticketsBtn = new SpecialButton("������ ����������",show);
		ticketsBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		ticketsBtn.addActionListener(this);
		bottomPanel.add(ticketsBtn, gbc);

		SpecialButton modifyBtn = new SpecialButton("����������� �����",show);
		modifyBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		modifyBtn.addActionListener(this);
		bottomPanel.add(modifyBtn, gbc);

		SpecialButton deleteBtn = new SpecialButton("�������� �����",show);
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

		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("���� ��������"))
		{
			SpecialButton button = (SpecialButton)e.getSource();
			new ProjectPerformanceDetailsOnAShow(this,button.getShow());
			this.setVisible(false);
		}
		else if(e.getActionCommand().equals("������������"))
		{
			SpecialButton button = (SpecialButton)e.getSource();
			new ProjectProducers(this, "������� �����������",button.getShow());
			this.setVisible(false);
		}
		else if(e.getActionCommand().equals("������ ����������"))
		{

		}
		else if(e.getActionCommand().equals("����������� �����"))
		{
			SpecialButton button = (SpecialButton)e.getSource();
			new AddNewShow(this,"����������� �����",button.getShow());
			this.dispose();
		}
		else if(e.getActionCommand().equals("�������� �����"))
		{
			SpecialButton button = (SpecialButton)e.getSource();
			new DeleteShowPrompt(button.getShow(),this);
			this.setVisible(false);
		}
		else if(e.getActionCommand().equals("�������� �����"))
		{
			new MainMenu();
			this.dispose();
		}
		else if(e.getActionCommand().equals("�������� ���� �����"))
		{
			new AddNewShow(this,"�������� ���� �����");
			this.dispose();
		}
	}


}