import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.Tool;

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
	private Dimension getScreensize()
	{
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

}
