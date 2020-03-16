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
import javax.swing.SwingConstants;

import entities.Performance;
import entities.Show;
import utility.SpecialButton;

public class ChoosePerformance extends JFrame implements ActionListener{

	private JFrame parent;
	private Show myShow;
	
	public ChoosePerformance(JFrame parent,String frameTitle,Show aShow)
	{
		this.parent = parent;
		this.myShow = aShow;
		JPanel layer1Panel = new JPanel();
		layer1Panel.setLayout(new GridLayout(0,1,5,0));
		
		JPanel helpPanel = new JPanel();
		helpPanel.setLayout(new GridLayout(1,2,5,0));
		
		JLabel lbl1 = new JLabel("Τίτλος Έργου:");
		lbl1.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		helpPanel.add(lbl1);
		
		JLabel titleLbl = new JLabel(myShow.getTitle());
		titleLbl.setFont(new Font("Myriad Pro",Font.PLAIN,23));
		helpPanel.add(titleLbl);
		
		helpPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		layer1Panel.add(helpPanel);
		
		for(Performance p:this.myShow.getMyPerformances())
			layer1Panel.add(createShowPanel(p));
		
		
		JButton cancelButton = new JButton("Ακύρωση");
		cancelButton.addActionListener(this);
		layer1Panel.add(cancelButton);
		
		this.setContentPane(layer1Panel);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setTitle(frameTitle);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public JPanel createShowPanel(Performance performance)
	{
		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 10, 5, 5);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel lbl2 = new JLabel("Ημερομηνία Παράστασης:");
		lbl2.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(lbl2, gbc);

		gbc.gridx++;
		gbc.insets = new Insets(5, 5, 5, 10);
		gbc.gridwidth = 3;
		JLabel startDateLbl = new JLabel(performance.getDate());
		startDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(startDateLbl, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 10, 5, 5);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel lbl3 = new JLabel("Ώρα Παράστασης:");
		lbl3.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(lbl3, gbc);

		gbc.gridx++;
		gbc.insets = new Insets(5, 5, 5, 10);
		gbc.gridwidth = 3;
		JLabel endDateLbl = new JLabel(performance.getTime());
		endDateLbl.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		panel.add(endDateLbl, gbc);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 0, 20, 0));

		SpecialButton chooseBtn = new SpecialButton("Επιλογή",myShow);
		chooseBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		chooseBtn.addActionListener(this);
		bottomPanel.add(chooseBtn, gbc);
		


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

		if(e.getActionCommand().equals("Επιλογή"))
		{
			SpecialButton button = (SpecialButton)e.getSource();
			//TODO Here I must create the new ticket handler.
		}
		else if(e.getActionCommand().equals("Ακύρωση"))
		{
			parent.setVisible(true);
			this.dispose();
		}
		
	}

}
