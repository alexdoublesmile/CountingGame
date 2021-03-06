import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {

    private int wordsNumber;
    private int someNumber = 0;
	private String someString = "";
	
	public String getSomeString() {
		return someString;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}
		
    public int getSomeNumber() {
		return someNumber;
	}

	public void setSomeNumber(int someNumber) {
		this.someNumber = someNumber;
	}

	public int getWordsNumber() {
		return wordsNumber;
	}

	public void setWordsNumber(int wordsNumber) {
		this.wordsNumber = wordsNumber;
	}
	
	public void resetWordsNumber() {
		this.wordsNumber = 0;
	}
		
	public Scanner getScanner() {
		  Scanner scanString = new Scanner(System.in);
		  return scanString;
		}
	
	public String inputAnyString() {
	  String s = getScanner().nextLine();
	  return s;
	}
		
	public void closeScanner() {
		getScanner().close();
		}
	
	
	public boolean checkStringIsReal(String someString) {
		if(someString.equals("") || someString.equals(" ")) {
	      return false;
	  }
		return true;
	}
	
	public boolean checkStringIsOnlyNumber(String s) {
	  	if (!(s.matches("[0-9]+"))) {
	  		return false;
	  	}
	  	return true; 
	}

	public int getNumberFromSomeString(String someString) {
		int number = Integer.parseInt(someString);
		return number;
	}
	
	public int countWordsFromString(String s) {
        int count = 0;
        Pattern pattern = Pattern.compile("[A-Za-z0-9�-��-�]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find())
            count++;
        return count;
    }
}
