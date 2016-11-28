
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
import javax.swing.JSplitPane;

public class DisplayWindow extends JFrame {

	ArrayList<JPanel> forms = new ArrayList<>();
	private CardLayout card = new CardLayout(20, 20);

	public DisplayWindow(String title) {
		setTitle(title);
		setSize(1024, 400);
		setMinimumSize(new Dimension(200, 120));
		JPanel graphicPane = new JPanel();
		JPanel dataPane = new JPanel();
		initLeftPane(graphicPane);// --------------> intializing left pane

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
						// Query 1 selected show query 1 card
						card.show(subCard, "1");
						FormQuery2.resetForm();
					} else if (combo1.getSelectedIndex() == 2) {
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

	public void initForm1(JPanel panel) {

	}

}
