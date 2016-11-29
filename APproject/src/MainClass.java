import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainClass {
	
	public static void main(String[] args) {
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				DisplayWindow DW = new DisplayWindow("DBLP QUERY ENGINE");
				DW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				DW.setVisible(true);
				
				
			}
		});
		
	}
}
