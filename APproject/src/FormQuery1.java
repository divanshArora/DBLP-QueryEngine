import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.Pageable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormQuery1  {

	private static JPanel customYearHelper = null;
	private static JPanel sinceYearHelper=null;
	private static JPanel combo3Panel= new JPanel();
	static JPanel formQuery1 = null;
	static HintTextField textField = new HintTextField("Name/Title",20);
	private static String searchBy,sortBy,yearStart,yearEnd;
	private static HintTextField start =new HintTextField("Start",5);
	private static HintTextField end = new HintTextField("End",5);
	private static HintTextField enterYear = new HintTextField("Enter Year",10);
	private FormQuery1(){}
	public static JPanel getFormQuery1 () {
		if(formQuery1==null)
		{
			formQuery1 = new JPanel();
			formQuery1.setLayout(new BoxLayout(formQuery1,BoxLayout.PAGE_AXIS));
			String[] selectByList = {"Search By:","Author","Title Tag"};
			JComboBox<String > combo2 = new JComboBox<>(selectByList);
			combo2.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent event) {
					
					if(event.getStateChange() == ItemEvent.SELECTED)
					{
						if(combo2.getSelectedIndex()==1)
						{
							searchBy = "author";
						}
						else if(combo2.getSelectedIndex()==2) {
							searchBy ="title";
						}
					}
				}
			});
			combo2.setMaximumSize(combo2.getPreferredSize());
			formQuery1.add(combo2);
			formQuery1.add(Box.createVerticalStrut(20));
			textField.setMaximumSize(textField.getPreferredScrollableViewportSize());
			formQuery1.add(textField);
			
			String[] yearSelectList = {"Year Mode","Custom Range","Since Year"};
			JComboBox<String> combo3  = new JComboBox<>(yearSelectList);
			
			combo3.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED)
					{
						
							yearHelper(combo3.getSelectedIndex());
						
						formQuery1.revalidate();
						formQuery1.repaint();
					}
					
				}
			});
			
			String sortByList[] = {"Sort By:","Relevance","Date"};
			JComboBox< String > combo4 = new JComboBox<>(sortByList);
			
			combo4.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					if(arg0.getStateChange()==ItemEvent.SELECTED)
					{
						if (combo4.getSelectedIndex()==1) {
							sortBy = "relevance";
						}
						else if(combo4.getSelectedIndex()==2) {
							sortBy = "date";
							
						}
					}
					
				}
			});
			
			
			combo4.setMaximumSize(combo4.getPreferredSize());
			formQuery1.add(Box.createVerticalStrut(20));
			formQuery1.add(combo4);
			combo3.setMaximumSize(combo3.getPreferredSize());
			formQuery1.add(Box.createVerticalStrut(20));
			combo3Panel.add(combo3);
			formQuery1.add(combo3Panel); // ADDING CUSTOM YEAR
			formQuery1.add(Box.createVerticalStrut(20));
//			formQuery1.setMaximumSize(formQuery1.getPreferredSize());
			formQuery1.add(Box.createVerticalStrut(20));
			JPanel starter = new JPanel();
			JButton starterButton = new JButton("Start"),reset = new JButton("Reset");
			starterButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(searchBy+sortBy+start.getText()+end.getText()+enterYear.getText());
				}
			});
			
			
			//ADD ACTION LISTENERS
			starter.add(starterButton);
			starter.add(reset);
			formQuery1.add(starter);
			formQuery1.revalidate();
			formQuery1.repaint();

		}
		return formQuery1;
	}
	public static void resetForm()
	{
		textField.reset();
	}

	private static void yearHelper(int select)
	{
		System.out.println("custom = "+customYearHelper + "since = "+ sinceYearHelper );
		if(select ==0)
		{
			if(sinceYearHelper!=null){
				combo3Panel.remove(sinceYearHelper);
				sinceYearHelper = null;
			}
			if(customYearHelper!=null)
			{
				combo3Panel.remove(customYearHelper);
				customYearHelper= null;
			}
			start.reset();
			end.reset();
			enterYear.reset();
		}
		else if(select==1)
		{
			if(sinceYearHelper!=null)
			{
				//System.out.println("since helper "+sinceYearHelper);
				combo3Panel.remove(sinceYearHelper);
				sinceYearHelper=null;
				enterYear.reset();
			}
			if(customYearHelper==null)
			{
				customYearHelper = new JPanel();
				
				//customYearHelper.setLayout(new BoxLayout(customYearHelper, BoxLayout.PAGE_AXIS));
				//customYearHelper.add(new JLabel("Custom Range"));
				customYearHelper.setLayout(new FlowLayout());
				
				customYearHelper.add(start);
				customYearHelper.add(new JLabel("-"));
				
				
				
				customYearHelper.add(end);
				//customYearHelper.setMaximumSize(customYearHelper.getPreferredSize());
				customYearHelper.setMaximumSize(customYearHelper.getPreferredSize());
				combo3Panel.add(customYearHelper);

			}
		}
		else if(select==2){
			if(customYearHelper!=null)
			{
				combo3Panel.remove(customYearHelper);
				customYearHelper=null;
				start.reset();end.reset();
			}
			if(sinceYearHelper==null)
			{
				sinceYearHelper = new JPanel();
				sinceYearHelper.setLayout(new BoxLayout(sinceYearHelper, BoxLayout.PAGE_AXIS));

				enterYear.setMaximumSize(enterYear.getPreferredSize());
				sinceYearHelper.add(enterYear );
				sinceYearHelper.setMaximumSize(sinceYearHelper.getPreferredSize());
				
				combo3Panel.add(sinceYearHelper);

			}
			
		}
	}
}
