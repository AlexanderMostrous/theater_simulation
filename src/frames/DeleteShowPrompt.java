package frames;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Show;
import utility.DataHolder;

public class DeleteShowPrompt extends JFrame implements ActionListener{

	Show myShow;
	JFrame parent;
	public DeleteShowPrompt(Show show, JFrame aFrame)
	{
		parent = aFrame;
		this.myShow = show;
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		JLabel lbl1 = new JLabel("Είστε σίγουροι για τη διαγραφή του έργου;");
		lbl1.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(lbl1,gbc);
		
		gbc.gridx=0;
		gbc.gridy++;
		gbc.insets = new Insets(0, 0, 10, 0);
		JLabel lbl2 = new JLabel("Θα διαγραφούν μαζί και όλες οι προβολές του.");
		lbl2.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		panel.add(lbl2,gbc);
		
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1, 2, 10, 0));
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		temp.add(okBtn);

		JButton cancelButton = new JButton("Ακύρωση");
		cancelButton.addActionListener(this);
		temp.add(cancelButton);
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		gbc.gridy++;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(temp,gbc);
		
		this.setContentPane(panel);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setTitle("Οριστική Διαγραφή Έργου");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("OK"))
		{
			DataHolder.shows.remove(myShow);
			new ProjectTheatricalShow(parent,"Προβολή Έργων");
			parent.dispose();
			this.dispose();
		}
		else if(e.getActionCommand().equals("Ακύρωση"))
		{
			parent.setVisible(true);
			this.dispose();
		}
	}
}
