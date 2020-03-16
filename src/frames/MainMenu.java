package frames;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import project_panels.AddNewShowPanel;
import project_panels.ProjectTheatricalShowPanel;

public class MainMenu extends JFrame{

	
	
	public MainMenu(){
		
		/*
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2,10,10));
		
		
		JButton shows = new JButton("������� �����");
		shows.setPreferredSize(new Dimension(140, 80));
		shows.addActionListener(this);
		panel.add(shows);
		
		JButton addShow = new JButton("�������� �����");
		addShow.setPreferredSize(new Dimension(140, 80));
		addShow.addActionListener(this);
		panel.add(addShow);
		
		JButton tickets  = new JButton("������ ����������");
		tickets.setPreferredSize(new Dimension(140, 80));
		tickets.setMargin(new Insets(10, 10, 10, 10));
		tickets.addActionListener(this);
		panel.add(tickets);
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		*/
		preparePane(setMainPanel());
	}
	
	/*
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("������� �����"))
		{
			new ProjectTheatricalShow(this,"������� ��������� �����");
			this.setVisible(false);
		}	
		else if(e.getActionCommand().equals("�������� �����"))
		{
			new AddNewShow(this,"�������� ���� �����");
			this.setVisible(false);
		}
		else if(e.getActionCommand().equals("������ ����������"))
		{
			this.setVisible(false);
			new ChooseShow(this, "������� ��������� �����");
			
		}
	}
	*/
	private JPanel setMainPanel()
	{
		JPanel outerPanel = new JPanel();
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Movies", new ProjectTheatricalShowPanel("Fill with list of movies"));	
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);//Use alt+# as a user to navigate through tabs

		JComponent panel2 = makeTextPanel("Fill with ticket functionality");
		tabbedPane.addTab("Tickets", panel2);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);//Use alt+# as a user to navigate through tabs
		
		outerPanel.add(tabbedPane);
		return outerPanel;
	}
	
	private void preparePane(JPanel aPanel)
	{
		this.setContentPane(aPanel);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("�������� �����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
