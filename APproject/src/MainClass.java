import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.xml.crypto.Data;

public class MainClass {
	public static Query currentQuery = new Query();
	public static Database precomputedDatabase;
	
	public static void main(String[] args) {
		System.out.println("Starting precomputation");
		Database myprecomputedDatabase  = new Database();
		myprecomputedDatabase.precompute();
		precomputedDatabase = myprecomputedDatabase;
		System.out.println("precomputation ended");
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				DisplayWindow DW = new DisplayWindow("DBLP QUERY ENGINE");
				DW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				DW.setVisible(true);
				
				
			}
		});
		
	}
}
