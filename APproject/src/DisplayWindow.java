import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayWindow extends JFrame{
	
	private static final long serialVersionUID = 1L; //To make serealizable
	private JPanel leftPanel,rightPanel;
	
	public DisplayWindow(String title) {
		setTitle(title);
		setLocationByPlatform(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		initializeAllPanels();
		add(leftPanel);
		add(rightPanel);
		
		// test comment 
		// another comment
		
		pack();

	}
	public DisplayWindow() {
		super("");
	}
	
	private void initializeAllPanels() {
		initializeLeftPanel();
		initializeRightPanel();
	}
	
	private void initializeLeftPanel()
	{
		leftPanel = new JPanel();
	}
	private void initializeRightPanel()
	{
		rightPanel = new JPanel();
	}
	//Added comment

}
