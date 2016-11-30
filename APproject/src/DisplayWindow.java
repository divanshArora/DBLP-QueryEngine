
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisplayWindow extends JFrame {

	ArrayList<JPanel> forms = new ArrayList<>();
	private CardLayout card = new CardLayout(20, 20);
	public static JPanel tableCard;
	public static JTable table;
	public static Query currentQuery;
	public DisplayWindow(String title) {
		setTitle(title);
		setSize(1024, 400);
		setMinimumSize(new Dimension(200, 120));
		JPanel graphicPane = new JPanel();
		JPanel dataPane = new JPanel();
		//dataPane.setLayout(new BoxLayout(dataPane, BoxLayout.PAGE_AXIS));
		initLeftPane(graphicPane);// --------------> intializing left pane
		initRightPane(dataPane);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(graphicPane);
		splitPane.setRightComponent(dataPane);
		splitPane.setOneTouchExpandable(true);

		Dimension minimumSize = new Dimension(200, 120);
		graphicPane.setMinimumSize(minimumSize);
		dataPane.setMinimumSize(minimumSize);
		graphicPane.add(new JPanel());
		dataPane.add(new JPanel());
		add(splitPane);

	}

	public void initLeftPane(JComponent leftPane) {

		leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.Y_AXIS));
		currentQuery = new Query();
		String[] queryList = { "Select Query", "Query1", "Query2" };
		JComboBox<String> combo1 = new JComboBox<>(queryList);
		combo1.setAlignmentX(CENTER_ALIGNMENT);
		combo1.setMaximumSize(combo1.getPreferredSize());
		JPanel subCard = new JPanel();
		forms.add(FormQuery1.getFormQuery1());
		subCard.setLayout(card);
		subCard.add("0", new JPanel());
		subCard.add("1", FormQuery1.getFormQuery1());
		subCard.add("2", FormQuery2.getFormQuery2());
		
		
		combo1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					if (combo1.getSelectedIndex() == 0) {
						card.show(subCard, "0");
						FormQuery1.resetForm();
						FormQuery2.resetForm();
					}
					if (combo1.getSelectedIndex() == 1) {
						currentQuery.setQueryNumber(1);
						// Query 1 selected show query 1 card
						card.show(subCard, "1");
						FormQuery2.resetForm();
					} else if (combo1.getSelectedIndex() == 2) {
						currentQuery.setQueryNumber(2);
						card.show(subCard, "2");
						FormQuery1.resetForm();
					}
				}

			}
		});

		leftPane.add(combo1);
		leftPane.add(subCard);

		// Create the card layout pane

	}
		
	public void initRightPane(JComponent rightPane)
	{
		 tableCard = new JPanel();
		tableCard.setLayout(card);
	
		Object[] heading = {"S.No", "Authors","number of pubs"};
		table = new JTable(new DefaultTableModel(heading, 1));
		rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.PAGE_AXIS));
		table.setFillsViewportHeight(true);
		JScrollPane tableType1 = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableCard.add(tableType1,"tableType1");
		table = new JTable(new DefaultTableModel(heading, 1));
		JScrollPane tableType2 = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableCard.add(tableType2,"tableType2");
	}
	
	
	
	

}
