package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Play;
import project_panels.DeletePlayPanel;
import project_panels.PreviewSeatsPanel;
import project_panels.ShowDetailsPanel;

public class TestingFrame extends JFrame {

	public TestingFrame(Play aPlay)
	{
		JPanel outerPanel = basicUI(aPlay);

		this.setContentPane(outerPanel);

		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Testing Panel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel basicUI(Play aPlay)
	{
		JPanel panel = new ShowDetailsPanel(aPlay);

		return panel;
	}
}
