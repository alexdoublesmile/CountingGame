
import java.util.Scanner;

class Input {


/*
///////// working methods for Fast count ///////////////////////////////////////////////////////////////////////////////////////////////
    
    // starting for fast count
    

    // initialization of players for fast count
    

    // fast count
    

///////// working methods for Detail count /////////////////////////////////////////////////////////////////////////////////////////////////
    
    // input players////////////////////////////////////////////
    public static void inputPlayerNames() {
        ConsoleView.outputEnterName(numberOfPlayer);
        String playerName = testPlayerName();
            numberOfPlayer++;
        if (numberOfPlayer == 2) {
            arrayNumber++;
            playersList.add(playerName);
            	inputPlayerNames();
        } else if (numberOfPlayer > 2) {
            playersList.add(playerName);
            askMorePlayers();
        }
        copyDataFromPlayersList();
    }
    

    public static void askMorePlayers() {
    	ConsoleView.outputMorePlayers();
        String answer = inputAnyString();
        if (!(checkPositiveAnswer(answer))) {
        	numberOfPlayer = 1;
        } else {
            arrayNumber++;
            inputPlayerNames();
        }
    }
    
    // input of counting////////////////////////////////////////////
    public static void inputCounting() {
    	while(!(finishCount(countIndex))) {
    		String someString = inputAnyString();
            if (someString.matches("[0-9]+")) {
            	countIndex = 1;
                wordsNumber = Integer.parseInt(someString);
            } else {
            	wordsNumber = countNumberOfWords(someString);
            }
    	}
    	countIndex = 0;
    }

    public static boolean finishCount(int index) {
    	if (index == 1) {
            return true;
    	}
        return false;
    }
    
    public static int countNumberOfWords(String notNumberString) {
    	int numberOfWords = 0;
    	int severalWords = testForSeveralWords(notNumberString);
    	numberOfWords = checkNumberOfWords(severalWords);
        return numberOfWords;
    }
    
    public static int testForSeveralWords(String notNumberString) {
    	int severalWords = countWords(notNumberString);
        while (severalWords < 2) {
            ConsoleView.outputWhat();
            String someString = inputAnyString();
            if (someString.matches("[0-9]+")) {
            	severalWords = Integer.parseInt(someString);
            } else {
            	severalWords = countWords(someString);
            }
        }
        return severalWords;
    }
    
    public static int countWords(String counting) {
        int count = 0;
        Pattern pattern = Pattern.compile("[A-Za-z0-9Р-пр-џ]+");
        Matcher matcher = pattern.matcher(counting);
        while (matcher.find())
            count++;
        return count;
    }
    
    public static int checkNumberOfWords(int severalWords) {
    	int finalNumberOfWords = severalWords;
    	ConsoleView.outputCountCheck(severalWords);
        String answer = inputAnyString();
        if (!(checkPositiveAnswer(answer))) {
        	checkNumberOfWordsAgain(severalWords);
        	return finalNumberOfWords - 1;
        } else {
        	countIndex = 1;
            return finalNumberOfWords;
        }
    }
    
    public static void checkNumberOfWordsAgain(int severalWords) {
    	ConsoleView.outputCountCheckAgain(severalWords);
        String secondAnswer = inputAnyString();
        if (!(checkPositiveAnswer(secondAnswer))) {
            ConsoleView.outputEnterCountingAgain();
        } else {
        	countIndex = 1;
        }
    }

    // view all settings
    public static void inputConditions() {
        ConsoleView.outputConditions(playersList, arrayNumber, wordsNumber);
    }

    // choose Game mode//////////////////////////////////////////////////
    public static void inputGameMode() {
        String gameMode = inputAnyString();
        switch (gameMode) {
            case ("1"):
                mainCount(1, 1, "1");
                break;
            case ("2"):
                mainCount(1, 1, "2");
                break;
            case ("3"):
                inputUserGameMode();
                break;
            default:
                ConsoleView.outputAnswerAgain();
                inputGameMode();
        }
    }

    // user Game mode settings
    public static void inputUserGameMode() {
        ConsoleView.outputEnterUserSettings();
        int startNumber = checkNumber();
        
        ConsoleView.outputEnterUserSettingsStep();
        int stepNumber = checkNumber();
        
        ConsoleView.outputEnterUserGameMode();
        String order = testGameOrderInput();
        mainCount(startNumber, stepNumber, order);
    }
    
    public static String testGameOrderInput() {
    	String orderInput = inputAnyString();
        while (!(orderInput.equals("1")) && !(orderInput.equals("2"))) {
            ConsoleView.outputAnswerAgain();
            orderInput = inputAnyString();
        }
    	return orderInput;
    }

    // main count
    public static void mainCount(int startNumber, int stepNumber, String order) {
    	ArrayList<String> tempPlayersList = new ArrayList<String>(initialPlayersList);
        ConsoleView.outputstartCounting();
        ConsoleView.outputAllPlayers(playersList, arrayNumber);
        int finalNumber = wordsNumber*stepNumber - (stepNumber - 1) + (startNumber - 1);
        int numStep = 1;
        String outPlayer;
        while (arrayNumber > 1) {
            if (order.equals("1")) {
                if(finalNumber % arrayNumber > 0) {
                    outPlayer = playersList.get(finalNumber % arrayNumber - 1);
                    playersList.remove(finalNumber % arrayNumber - 1);
                    finalNumber = (finalNumber % arrayNumber) + wordsNumber*stepNumber - (stepNumber - 1) - 1;
                } else {
                    outPlayer = playersList.get(arrayNumber - 1);
                    playersList.remove(playersList.size() - 1);
                    finalNumber = wordsNumber*stepNumber - (stepNumber - 1);
                }
            } else {
                if (finalNumber % arrayNumber > 0) {
                    outPlayer = playersList.get(finalNumber % arrayNumber - 1);
                    playersList.remove(finalNumber % arrayNumber - 1);
                } else {
                    outPlayer = playersList.get(arrayNumber - 1);
                    playersList.remove(playersList.size() - 1);
                }
            }
            arrayNumber--;
            ConsoleView.outputTempResult(playersList, arrayNumber, numStep, outPlayer);
            numStep++;
        }
        initialPlayersList = tempPlayersList;
    }

    // view all results
    public static void inputResult() {
        ConsoleView.outputResult(playersList, arrayNumber);
    }

*/

///////// method-helpers ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




//input String and return it
	public String inputAnyString() {
	  Scanner scanString = new Scanner(System.in);
	  String s = scanString.nextLine();
	  return s;
	}
	
//test input for not "space" or "enter" and return it
	public boolean checkString(String someString) {
		if(someString.equals("") || someString.equals(" ")) {
	      return false;
	  }
		return true;
	}
}
