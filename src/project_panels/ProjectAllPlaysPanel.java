package project_panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entities.Play;
import utility.DataHolder;

public class ProjectAllPlaysPanel extends JPanel implements ActionListener{

	
	public ProjectAllPlaysPanel()
	{
			basicUI();
	}
	
	public void basicUI(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(screenSize);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		int i = 0,j = 0;

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		if(!DataHolder.plays.isEmpty())
		{
			for(Play s:DataHolder.plays)				
				panel.add(new PlayPanel(s));			
			panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		else
		{
			JLabel noShowsAvailableLabel = new JLabel("No available plays yet.");
			noShowsAvailableLabel.setFont(new Font("Myriad Pro",Font.PLAIN,20));
			panel.add(noShowsAvailableLabel);
			panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		}

		JScrollPane jsp = new JScrollPane(panel);
		
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = j;
		gbc.gridy = i;
		gbc.gridwidth = 100;
		gbc.gridheight = 600;
		Dimension dim = new Dimension((int)(this.getPreferredSize().width*0.99),this.getPreferredSize().height*9/10);
		jsp.setPreferredSize(dim);
		this.add(jsp,gbc);
		
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new GridLayout(1, 2, 30, 0));

		JButton menuBtn = new JButton("Main Menu");
		menuBtn.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		menuBtn.addActionListener(this);
		outerPanel.add(menuBtn);

		JButton addNewShowBtn = new JButton("Add a new Play");
		addNewShowBtn.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		addNewShowBtn.addActionListener(this);
		outerPanel.add(addNewShowBtn);
		
		outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		outerPanel.setPreferredSize(new Dimension((int)(this.getPreferredSize().width*0.99),this.getPreferredSize().height*1/10));
		
		gbc.gridy = gbc.gridheight;
		gbc.gridheight = 50;
		this.add(outerPanel,gbc);
	}

	@Override
	public Dimension getPreferredSize() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return new Dimension((int)(screenSize.getWidth()*2/3),(int)(screenSize.getHeight()*2/3));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
