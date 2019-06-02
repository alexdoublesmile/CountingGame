import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.*;

class Input {

    private static int arrayNumber = 1;
    private static int initialArrayNumber = 1;
    private static ArrayList<String> playersList = new ArrayList<String>(arrayNumber);
    private static ArrayList<String> initialPlayersList = new ArrayList<String>(initialArrayNumber);
    private static ArrayList<Integer> fastCountPlayersList = new ArrayList<Integer>(arrayNumber);
    private static int wordsNumber;
    private static int numberOfPlayer = 1;
    private static int countIndex = 0;

    private static String[] positiveAnswerArray = new String[]{"да", "давай", "ок", "ага", "угу", "конечно", "можно", "сыграем", "верно", "точно", "правильно", "хорошо", "будут", "y", "yes", "ok", "lf", "1"};
    private static HashSet<String> positiveAnswerList = new HashSet<String>(Arrays.asList(positiveAnswerArray));
    private static String[] negativeAnswerArray = new String[]{"нет", "не", "неа", "хватит", "хорош", "yt", "ytn", "неверно", "0"};
    private static HashSet<String> negativeAnswerList = new HashSet<String>(Arrays.asList(negativeAnswerArray));

///////// working methods for Fast count /////////
    
    // starting for fast count
    public static void startFastCount() {
        Output.outputEnterPlayersFastCount();
        arrayNumber = Input.checkNumber();
        Output.outputEnterCountingFastCount();
        wordsNumber = Input.checkNumber();
        numberingOfPlayers(fastCountPlayersList, arrayNumber);
        fastCount(fastCountPlayersList, arrayNumber, wordsNumber);
        Counting.countingFast();
    }

    // initialization of players for fast count
    public static void numberingOfPlayers(ArrayList<Integer> fastCountPlayersList, int n) {
        for(int i = 1; i <= n; i++) {
        	fastCountPlayersList.add(i);
        }
    }

    // fast count
    public static void fastCount(ArrayList<Integer> fastCountPlayersList, int numberOfPlayers, int startIndex) {
        int mainIndex = startIndex;
        while (numberOfPlayers > 1) {
            if(mainIndex % numberOfPlayers > 0) {
            	fastCountPlayersList.remove(mainIndex % numberOfPlayers - 1);
            	mainIndex = mainIndex % numberOfPlayers + startIndex - 1;
            } else {
            	fastCountPlayersList.remove(fastCountPlayersList.size() - 1);
            	mainIndex = startIndex;
            }
            numberOfPlayers--;
        }
        Output.outputResultFastCount(fastCountPlayersList, numberOfPlayers);
    }

///////// working methods for Detail count /////////
    
    // input players
    public static void inputPlayerNames() {
        Output.outputEnterName(numberOfPlayer);
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
    
    public static String testPlayerName() {
    	String playerName = inputAnyString();
    	while (playerName.equals("") || playerName.equals(" ")) {
            Output.outputWhat();
            playerName = inputAnyString();
        }
    	return playerName;
    }

    public static void askMorePlayers() {
    	Output.outputMorePlayers();
        String answer = inputAnyString();
        if (!(checkPositiveAnswer(answer))) {
        	numberOfPlayer = 1;
        } else {
            arrayNumber++;
            inputPlayerNames();
        }
    }
    
    // input of counting
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
            Output.outputWhat();
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
        Pattern pattern = Pattern.compile("[A-Za-z0-9А-Яа-я]+");
        Matcher matcher = pattern.matcher(counting);
        while (matcher.find())
            count++;
        return count;
    }
    
    public static int checkNumberOfWords(int severalWords) {
    	int finalNumberOfWords = severalWords;
    	Output.outputCountCheck(severalWords);
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
    	Output.outputCountCheckAgain(severalWords);
        String secondAnswer = inputAnyString();
        if (!(checkPositiveAnswer(secondAnswer))) {
            Output.outputEnterCountingAgain();
        } else {
        	countIndex = 1;
        }
    }

    // view all settings
    public static void inputConditions() {
        Output.outputConditions(playersList, arrayNumber, wordsNumber);
    }

    // choose Game mode
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
                Output.outputAnswerAgain();
                inputGameMode();
        }
    }

    // user Game mode settings
    public static void inputUserGameMode() {
        Output.outputEnterUserSettings();
        int startNumber = checkNumber();
        
        Output.outputEnterUserSettingsStep();
        int stepNumber = checkNumber();
        
        Output.outputEnterUserGameMode();
        String order = testGameOrderInput();
        mainCount(startNumber, stepNumber, order);
    }
    
    public static String testGameOrderInput() {
    	String orderInput = inputAnyString();
        while (!(orderInput.equals("1")) && !(orderInput.equals("2"))) {
            Output.outputAnswerAgain();
            orderInput = inputAnyString();
        }
    	return orderInput;
    }

    // main count
    public static void mainCount(int startNumber, int stepNumber, String order) {
    	ArrayList<String> tempPlayersList = new ArrayList<String>(initialPlayersList);
        Output.outputstartCounting();
        Output.outputAllPlayers(playersList, arrayNumber);
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
            Output.outputTempResult(playersList, arrayNumber, numStep, outPlayer);
            numStep++;
        }
        initialPlayersList = tempPlayersList;
    }

    // view all results
    public static void inputResult() {
        Output.outputResult(playersList, arrayNumber);
    }

    // play again
    public static void inputStartAgain() {
        String playedMode = Counting.mode();
        String playAgain = inputAnyString();
        if (!(checkPositiveAnswer(playAgain))) {
            Output.outputFinal();
        } else {
            if(playedMode.equals("2")) {
                Output.outputChooseContinue();
                inputContinue();
            } else  {
            	clearSettings();
                Counting.start();
            }

        }
    }
      
    // play again settings
    public static void inputContinue() {
        String countinue = inputAnyString();
        switch (countinue) {
            case ("1"):
            	clearSettings();
                Counting.start();
                break;
            case ("2"):
            	returnSettings();
                Counting.countingDetailSecond();
                break;
            case ("3"):
            	returnSettings();
                Counting.countingDetailThird();
                break;
            default:
                Output.outputAnswerAgain();
                inputContinue();
        }
    }

///////// method-helpers /////////

//input String and return it
public static String inputAnyString() {
    Scanner scanString = new Scanner(System.in);
    String s = scanString.nextLine();
    return s;
}

//test input for not "space" or "enter" and return it
public static String checkString(String someString) {
	while (someString.equals("") || someString.equals(" ")) {
        Output.outputWhat();
        someString = inputAnyString();
    }
	return someString;
}

//test input for number and return it
public static int checkNumber() {
    String number = inputAnyString();
    while (!(number.matches("[0-9]+"))) {
        Output.outputCheckedNumber();
        number = inputAnyString();
    }
    int n = Integer.parseInt(number);
    return n;
}

//test input for positive or negative answer
public static boolean checkPositiveAnswer(String tryPositiveAnswer) {
    tryPositiveAnswer = checkString(tryPositiveAnswer);
    if (!(negativeAnswerList.contains(tryPositiveAnswer.toLowerCase())) && !(positiveAnswerList.contains(tryPositiveAnswer.toLowerCase()))) {
    	if (additionalTestOfAnswer(tryPositiveAnswer)) {
            return true;
    	} else {
    		return false;
    	}
    } else if (negativeAnswerList.contains(tryPositiveAnswer.toLowerCase())) {
        return false;
    }
    return true;
}

public static boolean additionalTestOfAnswer(String someAnswer) {
	String confirmationAnswer = checkAnswer(someAnswer);
    if (confirmationAnswer.equals("1")) {
    	positiveAnswerList.add(someAnswer.toLowerCase());
        return true;
    } else {
    	negativeAnswerList.add(someAnswer.toLowerCase());
        return false;
    }
}

public static String checkAnswer(String someAnswer) {
	String confirmationAnswer = "";
    while (!(confirmationAnswer.equals("1") || (confirmationAnswer.equals("2")))) {
        Output.outputAnswer();
        confirmationAnswer = inputAnyString();
        if (!(confirmationAnswer.equals("1") || (confirmationAnswer.equals("2")))) {
            Output.outputAnswerAgain();
        }
    }
    return confirmationAnswer;
}

public static void copyDataFromPlayersList() {
	initialPlayersList = playersList;
    initialArrayNumber = arrayNumber;
}

public static void copyDataToPlayersList() {
	playersList = initialPlayersList;
    arrayNumber = initialArrayNumber;
}

public static void clearSettings() {
	fastCountPlayersList.clear();
	playersList.clear();
	initialPlayersList.clear();
    arrayNumber = 1;
    initialArrayNumber = 1;
    countIndex = 0;
}

public static void returnSettings() {
	playersList = initialPlayersList;
    arrayNumber = initialArrayNumber;
}

}
