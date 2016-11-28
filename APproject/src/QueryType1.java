import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QueryType1 {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("dblp.xml"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
		String line = br.readLine();
		String name = "Sanjeev Saxena";
		while (line != null) {
			if (line.length() > 16) {
				if (line.substring(0, 3).equals("<au")) {
					if (line.substring(8, line.length() - 9).equals(name)) {
						bw.write(line);
					}
				}
			}
			line = br.readLine();
		}
		bw.close();
		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);

	}

}
