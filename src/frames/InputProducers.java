package frames;
import java.awt.Dimension;
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
import javax.swing.JTextField;

import entities.Details;
import entities.Show;

public class InputProducers extends JFrame implements ActionListener{

	private JPanel mainPanel;
	private JTextField director = new JTextField("<κενό>"), scriptWriter = new JTextField("<κενό>");
	private ArrayList<JTextField> actors = new ArrayList<JTextField>();
	private Show myShow;
	private JFrame parent;
	private String frameTitle;
	private int counter;

	public InputProducers(JFrame parent, String frameTitle, Show show, int amountOfActors){

		this.parent = parent;
		counter = amountOfActors;
		this.frameTitle = frameTitle;
		myShow = show;
		mainPanel = createBasicPanel();

		this.getContentPane().add(mainPanel);
		this.setUp();
	}
	
	public InputProducers(JFrame parent, String frameTitle, Show show){

		this.parent = parent;
		counter = 1;
		this.frameTitle = frameTitle;
		myShow = show;
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

		director.setText(director.getText());
		director.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		temp1.add(director);

		JLabel lbl2 = new JLabel("Σεναριογράφος:");
		lbl2.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		temp1.add(lbl2);

		scriptWriter.setText(scriptWriter.getText());;
		scriptWriter.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		temp1.add(scriptWriter);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		temp1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(temp1,gbc);

		for(int i=1;i<=counter;i++)
		{
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 10, 0);
			panel.add(addActorPanel(i),gbc);
		}

		JButton addActorBtn = new JButton("Προσθήκη Ηθοποιού");
		addActorBtn.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		addActorBtn.addActionListener(this);
		
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridy++;
		gbc.gridx=1;
		gbc.gridwidth = 3;
		panel.add(addActorBtn, gbc);

		gbc.gridx=0;
		gbc.gridwidth = 4;
		gbc.gridy++;
		JButton okBtn = new JButton("OK"),cancel = new JButton("Cancel");
		okBtn.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		cancel.setFont(new Font("Myriad Pro",Font.PLAIN,17));
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2,15,0));
		okBtn.addActionListener(this);
		temp.add(okBtn);
		cancel.addActionListener(this);
		temp.add(cancel);
		temp.setMaximumSize(new Dimension(200, 30));
		temp.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
		gbc.insets = new Insets(5, 0, 0, 0);
		panel.add(temp,gbc);

		return panel;
	}

	private JPanel addActorPanel(int i)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2, 10, 0));
		JLabel actor = new JLabel("Ηθοποιός #"+i+":");
		actor.setFont(new Font("Myriad Pro",Font.PLAIN,20));
		JTextField actorJTF = new JTextField("<κενό>");
		this.actors.add(actorJTF);
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
		// TODO Need to fix not to erase the new actors that are added.

		if(e.getActionCommand().equals("Προσθήκη Ηθοποιού"))
		{
			counter++;
			mainPanel = createBasicPanel();
			this.setContentPane(mainPanel);
			
			this.setUp();
			mainPanel.revalidate();
		}
		else if(e.getActionCommand().equals("OK"))
		{
			Details det = new Details();
			det.setDirector(director.getText());
			det.setScriptWriter(scriptWriter.getText());
			for(JTextField actorName:actors)
				det.addActor(actorName.getText());
			myShow.setMyDetails(det);
			
			parent.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("Cancel"))
		{
			parent.setVisible(true);
			this.dispose();
		}
	}
}
