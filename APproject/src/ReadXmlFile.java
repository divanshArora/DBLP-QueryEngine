import java.io.IOException;
import java.security.KeyStore.Entry.Attribute;
//import java.util.jar.Attributes;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;


public class ReadXmlFile
{
	
	public void search()
	{
		//Finding publications by a given author name
		//Finding publications by title tags.
		
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory factory = SAXParserFactory.newInstance();  // obtain and configure a sax based parser
		
		
		
		// obtain object for SAX parser
		SAXParser saxParser = null;
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
			// TODO Auto-generated catch block
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		/*
		 * default handler for SAX handler class 
		 *all three methods are written in handler's body
		 */
		  
		
		Parse parsing = new Parse(); 
		
		try {
			saxParser.parse("dblp.xml",parsing);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
}

class Parse extends DefaultHandler{
	
	boolean article = false;
	boolean authName = false;
	boolean title = false;
	boolean numPages = false;
	boolean year = false;
	boolean volume = false;
	boolean journal = false;
	boolean number = false;
	boolean url = false;
	boolean ee = false;
	int count =0;
	
	// this method is called every time the parser gets an open tag '<'
	// identifies which tag is being open at time by assigning an open flag 
	
	
	public void startElement(String uri, String localName, String qName, Attributes attribute) throws SAXException
	{
		if(qName.equalsIgnoreCase("article"))
		{
			count++;
			article=true;
		}
		else if(qName.equalsIgnoreCase("author"))
		{
			authName=true;
		}
		else if(qName.equalsIgnoreCase("title"))
		{
			title=true;
		}
		else if(qName.equalsIgnoreCase("pages"))
		{
			numPages=true;
		}
		else if(qName.equalsIgnoreCase("year"))
		{
			year=true;
		}
		else if(qName.equalsIgnoreCase("volume"))
		{
			volume=true;
		}
		else if(qName.equalsIgnoreCase("journal"))
		{
			journal=true;
		}
		else if(qName.equalsIgnoreCase("number"))
		{
			number=true;
		}
		else if(qName.equalsIgnoreCase("url"))
		{
			url=true;
		}
		else if(qName.equalsIgnoreCase("ee"))
		{
			ee=true;
		}
	}
	
	
	
	/*public void endElement(String uri, String localName, String qName) throws SAXException
	{
		
		
	}*/
	
	//  print data stored in b/w '<' and '>' tags
	
	public void characters(char ch[], int start, int length) throws SAXException
	{
		if(article)
		{
			article=false;
		}
		if(authName)
		{
			authName=false;
		}
		if(title)
		{
			title= false;
		}
		if(numPages)
		{
			numPages=false;
		}
		if(year)
		{
			year=false;
		}
		if(volume)
		{
			volume=false;
		}
		if(journal)
		{
			journal=false;
		}
		if(number)
		{
			number=false;
		}
		if(url)
		{
			url=false;
		}
		if(ee)
		{
			ee=false;
		}
		
	}
	
	public void endDocument()throws SAXException
	{
		System.out.println(count);
	}
	
}






