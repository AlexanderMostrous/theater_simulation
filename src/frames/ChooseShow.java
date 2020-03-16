package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Show;
import utility.DataHolder;
import utility.SpecialButton;

public class ChooseShow extends JFrame implements ActionListener{

	private JFrame parent;
	public ChooseShow(JFrame parent,String frameTitle){
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for(Show show:DataHolder.shows)
		 panel.add(createShowPanel(show));
		
		this.setContentPane(panel);
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
		JLabel lbl1 = new JLabel("Τίτλος Έργου:");
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
		JLabel lbl2 = new JLabel("Ημερομηνία Έναρξης Προβολών:");
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
		JLabel lbl3 = new JLabel("Ημερομηνία Λήξης Προβολών:");
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

		SpecialButton chooseBtn = new SpecialButton("Επιλογή",show);
		chooseBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		chooseBtn.addActionListener(this);
		bottomPanel.add(chooseBtn, gbc);
		
		SpecialButton detailsBtn = new SpecialButton("Λεπτομέρειες",show);
		detailsBtn.setFont(new Font("Myriad Pro",Font.PLAIN,18));
		detailsBtn.addActionListener(this);
		bottomPanel.add(detailsBtn, gbc);

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
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Επιλογή"))
		{
			SpecialButton button = (SpecialButton)e.getSource();
			new ChoosePerformance(this,"Επιλογή Παράστασης",button.getShow());
			this.setVisible(false);
		}
		else if(e.getActionCommand().equals("Λεπτομέρειες"))
		{
			SpecialButton button = (SpecialButton)e.getSource();
			new ProjectProducers(this, "Προβολή Λεπτομερειών Θεατρικού Έργου",button.getShow());
			this.setVisible(false);
		}
	}
}
