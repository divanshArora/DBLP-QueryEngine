import java.awt.EventQueue;

public class mainClass {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DisplayWindow sampleDW = new DisplayWindow("DBLP QUERY ENGINE");
				sampleDW.setVisible(true);
			}
		});
		
	}

}
