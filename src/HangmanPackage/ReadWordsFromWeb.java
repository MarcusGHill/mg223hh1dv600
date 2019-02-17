package HangmanPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 


public class ReadWordsFromWeb {
 private String webpage = "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html";
private BufferedReader br = null;
private ArrayList<String> result = new ArrayList<String>();
private ArrayList<String> resultTemp = new ArrayList<String>();
private URL url;
private  ArrayList<String> sb = new ArrayList<String>();
private String line;
private Pattern p;
private  Matcher m1;
	
	public void ReadInput (String inputWebpage) throws IOException, MalformedURLException {
		if(inputWebpage.length() > 0) {
			webpage = inputWebpage;
		}
		//
	        try {
	            url = new URL(webpage);
	            br = new BufferedReader(new InputStreamReader(url.openStream()));
	            while ((line = br.readLine()) != null) {

	                sb.add(line);
	                sb.add(System.lineSeparator());
	              
	            }
	            // filter out lines containing "<code>" if site is https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html
	            if(webpage == "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html") {
	         for(int i = 0; i < sb.size(); i++) {
	        	 if(sb.get(i).contains("<code>")) {
	        		 for(int j = 0; j < sb.get(i).length(); j++) {
	        			 // filter out words between <code> and </code>
	        			 if(sb.get(i).charAt(j) == '<' && sb.get(i).charAt(j + 1) == 'c') {
	        				String requiredString = sb.get(i).substring(j, j+20).substring(6, (sb.get(i).substring(j, j+20).indexOf("/") - 1));
	        				 result.add(requiredString);
	        			 }
	        		 }
	        	 }
	         }
	         // for fetching words from Wikipedia
	            } else {
	            	for(int i = 0; i < sb.size(); i++) {
	   	        	 if(sb.get(i).contains("<p>")) {
	   	        		 for(int j = 0; j < sb.get(i).length(); j++) {
	   	        			 // filter out words between <p> and </p>
	   	        			 if(sb.get(i).charAt(j) == '<' && sb.get(i).charAt(j + 1) == 'p' && sb.get(i).charAt(j + 2) == '>') {
	   	        				resultTemp.add(sb.get(i).replaceAll("<[^>]*>", ""));
		        				
	   	        			 }
	   	        		 }
	   	        	 }
	   	         }
	            	for(int i = 0; i <resultTemp.size(); i++) {	            	
	            	// saves words longer than 10.
	            	p = Pattern.compile("[a-zA-Z]+"); 
	            	 m1 = p.matcher(resultTemp.get(i)); 
	                 while (m1.find()) { 
	                	 if(m1.group().length() > 10) {
	                		 result.add(m1.group());  
	                	 }
	                 } 
	            }
	            	}
	        } catch(MalformedURLException e) {
	        	 System.out.println();
				 System.out.println("the URL does not look right, try again and follow the format https://en.wikipedia.org/wiki/Stockholm");
				 System.out.println();
				 HangmanLogic hl = new HangmanLogic();
				 hl.menu();
	        } catch(IOException e) {
	        	e.printStackTrace();
	        } finally {
	            if (br != null) {
	                br.close();
	            }
	        }
	    }
	
	public ArrayList<String> getResult() {
		return result;
	}
	}