import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {

    private int wordsNumber;
    private int someNumber = 0;
	private String someString = "";
    private int countIndex = 0;
	
	public String getSomeString() {
		return someString;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}
	
	public void showSomeString() {
		System.out.println("-----------------------------------");
		System.out.println("SomeString is " + someString);
		System.out.println("-----------------------------------");
	}
	
    public int getSomeNumber() {
		return someNumber;
	}

	public void setSomeNumber(int someNumber) {
		this.someNumber = someNumber;
	}

	public void showSomeNumber() {
		System.out.println("-----------------------------------");
		System.out.println("SomeNumber is " + someNumber);
		System.out.println("-----------------------------------");
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
		
	public void showWordsNumber() {
		System.out.println("-----------------------------------");
		System.out.println("WordsNumber is " + wordsNumber);
		System.out.println("-----------------------------------");
	}
	
	public String inputAnyString() {
	  Scanner scanString = new Scanner(System.in);
	  String s = scanString.nextLine();
	  return s;
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
        Pattern pattern = Pattern.compile("[A-Za-z0-9Р-пр-џ]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find())
            count++;
        return count;
    }

	public boolean finishCount(int index) {
    	if (index == 1) {
            return true;
    	}
        return false;
    }
	

    public int getCountIndex() {
		return countIndex;
	}
    
	public void setCountIndex(int countIndex) {
		this.countIndex = countIndex;
	}

	public void resetCountIndex() {
		this.countIndex = 0;
	}
	
	public void increaseCountIndex() {
		this.countIndex = 1;
	}
}
