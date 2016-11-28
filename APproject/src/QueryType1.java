import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class QueryType1 extends Query implements ActionListener{
	String arr[] = {"By name","By title"};
	public QueryType1(String attribute, JPanel leftPanel) {
		this.attribute = attribute;
		this.leftPanel = leftPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JComboBox< String > cb = (JComboBox<String>)e.getSource();
		int index = cb.getSelectedIndex();
		System.out.println(index);
		JComboBox<String> secondCombo = new JComboBox<>(arr);
		leftPanel.add(secondCombo);
		leftPanel.revalidate();
		
	}
	
	@Override
	public String toString() {
		return this.attribute;
	}
	
}
