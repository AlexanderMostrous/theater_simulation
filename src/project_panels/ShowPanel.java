package project_panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Show;
import utility.SpecialButton;

public class ShowPanel extends JPanel implements ActionListener{

	
	public ShowPanel(Show aShow)
	{
		createShowPanel(aShow);
	}
	
	public void createShowPanel(Show show)
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

		this.add(panel);	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{/*
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
		}*/
	}
}
