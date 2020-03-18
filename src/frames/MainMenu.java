package frames;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import project_panels.ProjectTheatricalShowPanel;

public abstract class MainMenu extends JFrame{

	public static JFrame mainFrame;
	//public static ArrayList<JPanel> tabbedPaneComponents;Array list that stores all main components (panels) filling the tabbed pane.
	public static JTabbedPane tabbedPane;
	
	public static void createMainMenu()
	{		
		//tabbedPaneComponents = new ArrayList<JPanel>();
		mainFrame = new JFrame();
		preparePane(initializeMainPanel());
	}
		
	private static JPanel initializeMainPanel()
	{//TODO Window size should stay the same and not resize in case of content swap
		JPanel outerPanel = new JPanel();
		tabbedPane = new JTabbedPane();

		tabbedPane.addTab("Plays", new ProjectTheatricalShowPanel());	
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);//Use alt+# as a user to navigate through tabs
		
		JPanel panel2 = makeTextPanel("Fill with ticket functionality");
		tabbedPane.addTab("Tickets", panel2);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);//Use alt+# as a user to navigate through tabs
		
		outerPanel.add(tabbedPane);
		return outerPanel;
	}
	
	public static void swapTabComponent(JPanel newPanel)
	{
		int indexOfTab = tabbedPane.getSelectedIndex();
		newPanel.setPreferredSize(tabbedPane.getComponentAt(indexOfTab).getPreferredSize());
		tabbedPane.insertTab(tabbedPane.getTitleAt(indexOfTab), tabbedPane.getIconAt(indexOfTab), newPanel, null, indexOfTab);
		tabbedPane.removeTabAt(indexOfTab+1);		
		refresh(newPanel);
		tabbedPane.setSelectedIndex(indexOfTab);
	}
	
	private static void refresh(JPanel aPanel)
	{
		aPanel.repaint();
		aPanel.revalidate();
	}
	
	private static void preparePane(JPanel aPanel)
	{
		mainFrame.setContentPane(aPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setTitle("Main Menu");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static JPanel makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
