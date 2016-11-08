import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.Tool;

public class DisplayWindow extends JFrame{
	
	private static final long serialVersionUID = 1L; //To make serealizable
	private JPanel leftPanel,rightPanel;
	private int numberOfQueries = 3;
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
		
		Query [] qList =  {new QueryType1("Query1", leftPanel)};
		
		JComboBox<Query> queryList = new JComboBox<Query>(qList);
		leftPanel.add(queryList);
		queryList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<Query> cb= (JComboBox<Query>)(e.getSource());
				int index = cb.getSelectedIndex();
				qList[index].attach();
			}
		});
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
