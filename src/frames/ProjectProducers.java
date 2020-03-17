package frames;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Play;

public class ProjectProducers extends JFrame implements ActionListener{

	private JPanel mainPanel;
	private JLabel director = new JLabel(), scriptWriter = new JLabel();
	private ArrayList<JTextField> actors = new ArrayList<JTextField>();
	private Play myShow;
	private JFrame parent;
	private String frameTitle;

	public ProjectProducers(JFrame parent, String frameTitle, Play play){

		this.parent = parent;
		this.frameTitle = frameTitle;
		myShow = play;
		mainPanel = createBasicPanel();

		this.getContentPane().add(mainPanel);
		this.setUp();
	}

	public JPanel createBasicPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel temp1 = new JPanel();
		temp1.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lbl1 = new JLabel("Σκηνοθέτης:");
		lbl1.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		temp1.add(lbl1);

		director.setText(myShow.getMyDetails().getDirector());
		director.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		temp1.add(director);

		JLabel lbl2 = new JLabel("Σεναριογράφος:");
		lbl2.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		temp1.add(lbl2);

		scriptWriter.setText(myShow.getMyDetails().getScriptWriter());
		scriptWriter.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		temp1.add(scriptWriter);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		temp1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(temp1,gbc);

		for(int i=1;i<=myShow.getMyDetails().getActors().size();i++)
		{
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 10, 0);
			panel.add(addActorPanel(myShow.getMyDetails().getActors().get(i)),gbc);
		}

		gbc.gridx=0;
		gbc.gridwidth = 4;
		gbc.gridy++;
		JButton okBtn = new JButton("OK");
		okBtn.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2,15,0));
		okBtn.addActionListener(this);
		temp.add(okBtn);
		temp.setMaximumSize(new Dimension(200, 30));
		temp.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
		gbc.insets = new Insets(5, 0, 0, 0);
		panel.add(temp,gbc);

		return panel;
	}

	private JPanel addActorPanel(String actorName)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2, 10, 0));
		JLabel actor = new JLabel("Ηθοποιός:");
		actor.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		JLabel actorJTF = new JLabel(actorName);
		actorJTF.setFont(new Font("Myriad Pro",Font.PLAIN,20));

		panel.add(actor);
		panel.add(actorJTF);

		panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		return panel;
	}

	public void setUp(){
		this.setTitle(frameTitle);
		this.pack();
		this.setVisible(true);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("OK"))
		{
			parent.setVisible(true);
			this.dispose();
		}

	}
}
