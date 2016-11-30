import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Query {
	//http://stackoverflow.com/questions/16450293/how-do-i-make-the-output-come-in-different-columns
	private int QueryNumber;
	private String textField;
	private String searchBy,sortBy,yearStart,yearEnd;
	private int numberOfPublications;
	

	
	
	
	
	
	
	public int getQueryNumber() {
		return QueryNumber;
	}
	public void setQueryNumber(int queryNumber) {
		QueryNumber = queryNumber;
	}
	public String getTextField() {
		return textField;
	}
	public void setTextField(String textField) {
		this.textField = textField;
	}
	public String getSearchBy() {
		return searchBy;
	}
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getYearStart() {
		return yearStart;
	}
	public void setYearStart(String yearStart) {
		this.yearStart = yearStart;
	}
	public String getYearEnd() {
		return yearEnd;
	}
	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}
	public int getNumberOfPublications() {
		return numberOfPublications;
	}
	public void setNumberOfPublications(int numberOfPublications) {
		this.numberOfPublications = numberOfPublications;
	}
	
	public boolean isValid(Query q){

		return true;
		
		
	}
	
	
	
}
