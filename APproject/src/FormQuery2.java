import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormQuery2 {
	private static JPanel formQuery2=null;
	private static HintTextField textField=new HintTextField("Number Of Publications",20);

	private FormQuery2(){}
	
	
	public static JPanel getFormQuery2() {
		
		if(formQuery2==null)
		{
			formQuery2 = new JPanel();
			formQuery2.setLayout(new BoxLayout(formQuery2, BoxLayout.PAGE_AXIS));
			textField.setMaximumSize(textField.getPreferredSize());
			formQuery2.add(textField);
			
			formQuery2.add(Box.createVerticalStrut(20));
			JPanel starter = new JPanel();
			JButton start = new JButton("Start"),reset = new JButton("Reset");
			starter.add(start);
			starter.add(reset);
			formQuery2.add(starter);
			formQuery2.revalidate();
			formQuery2.repaint();

		}
		
		
		return formQuery2;
	}
	public static void resetForm()
	{
		textField.reset();
	}

}
