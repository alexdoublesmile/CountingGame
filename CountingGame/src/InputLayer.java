import java.util.ArrayList;
import java.util.HashSet;

public class InputLayer implements ModelLayer {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Main methods  ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getPlayMode(Mode mode) {
		return mode.getPlayMode();
	}
	
	public void setPlayMode(Mode mode, String s) {
		mode.setPlayMode(s);
	}
	
	public void showPlayMode(Mode mode, String s) {
		mode.showPlayMode();
	}
	
	public String getContinueMode(Mode mode) {
		return mode.getContinueMode();
	}
	
	public void setContinueMode(Mode mode, String s) {
		mode.setContinueMode(s);
	}

	public int getArrayNumber(Players players) {
		return players.getArrayNumber();
	}
	
	public void setArrayNumber(Players players, int i) {
		players.setArrayNumber(i);
	}
	
	public void increaseArrayNumber(Players players) {
		players.increaseArrayNumber();
	}
	
	public void reduceArrayNumber(Players players) {
		players.reduceArrayNumber();
	}
	
	public void showArrayNumber(Players players) {
		players.showArrayNumber();
	}
	
	public int getWordsNumber(Words words) {
		return words.getWordsNumber();
	}
	
	public void setWordsNumber(Words words, int i) {
		words.setWordsNumber(i);
	}
	
	public void resetWordsNumber(Words words) {
		words.resetWordsNumber();
	}
	
	public void showWordsNumber(Words words) {
		words.showWordsNumber();
	}
	
	public int countWordsFromString(Words words, String s) {
        return words.countWordsFromString(s);
    }
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Lists methods ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<String> getPlayersList(Players players) {
		return players.getPlayersList();
	}
	
	public void addToPlayersList(Players players, String s) {
		players.addToPlayersList(s);
	}
	
	public void showPlayersList(Players players) {
		players.showPlayersList();
	}
	
	public void showInitialPlayersList(Players players) {
		players.showInitialPlayersList();
	}
	    
	public ArrayList<Integer> getFastCountPlayersList(Players players) {
		return players.getFastCountPlayersList();
	}
	
	public void showFastCountPlayersList(Players players) {
		players.showFastCountPlayersList();
	}	

	public HashSet<String> getPositiveAnswerList(Answers answers) {
		return answers.getPositiveAnswerList();
	}
	
	public HashSet<String> getNegativeAnswerList(Answers answers) {
		return answers.getNegativeAnswerList();
	}
	
	public void addToPositiveAnswerList(Answers answers) {
		answers.addToPositiveAnswerList(answers.getAnswer().toLowerCase());
	}

	public void addToNegativeAnswerList(Answers answers) {
		answers.addToPositiveAnswerList(answers.getAnswer().toLowerCase());
	}
	
	public void showPositiveAnswerList(Answers answers) {
		answers.showPositiveAnswerList();
	}
	
	public void showNegativeAnswerList(Answers answers) {
		answers.showNegativeAnswerList();
	}	
	
	public void copySettings(Players players) {
		players.copySettings();
	}

	public void returnSettings(Players players) {
		players.returnSettings();
	}
	
	public void numberingOfPlayers(Players players, int n) {
		players.numberingOfPlayers(n);
    }
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Count methods ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
////////////   main count  ////////////		
	
	public int getStartNumber(Calculate calculate) {
		return calculate.getStartNumber();
	}
	
	public void setStartNumber(Calculate calculate, int i) {
		calculate.setStartNumber(i);
	}
	
	public int getStepNumber(Calculate calculate) {
		return calculate.getStepNumber();
	}
	
	public void setStepNumber(Calculate calculate, int i) {
		calculate.setStepNumber(i);
	}
	
	public String getGameOrder(Calculate calculate) {
		return calculate.getGameOrder();
	}
	
	public void setGameOrder(Calculate calculate, String s) {
		calculate.setGameOrder(s);
	}
	
	public void increaseGameOrder(Calculate calculate) {
		calculate.increaseGameOrder();
	}
	
	public int getFinalNumber(Calculate calculate) {
		return calculate.getFinalNumber();
	}
	
	public void setFinalNumber(Calculate calculate, int i) {
		calculate.setFinalNumber(i);
	}
	
	public int getNumStep(Calculate calculate) {
		return calculate.getNumStep();
	}
	
	public void setNumStep(Calculate calculate, int i) {
		calculate.setNumStep(i);
	}
	
	public void resetNumStep(Calculate calculate) {
		calculate.resetNumStep();
	}
	
	public void increaseNumStep(Calculate calculate) {
		calculate.increaseNumStep();
	}
	
	public String getOutPlayer(Calculate calculate) {
		return calculate.getOutPlayer();
	}
	
	public void setOutPlayer(Calculate calculate, String s) {
		calculate.setOutPlayer(s);
	}
	
	public void mainCalc(Calculate calculate, ArrayList<String> playersList, int arrayNumber, int wordsNumber, String order) {
		calculate.mainCalc(playersList, arrayNumber, wordsNumber, order);
	}
	
////////////  --- fast count ---  ////////////	
	
	public int getNumberOfPlayer(Players players) {
		return players.getNumberOfPlayer();
	}
	
	public void setNumberOfPlayer(Players players, int s) {
		players.setNumberOfPlayer(s);
	}
	
	public void increaseNumberOfPlayer(Players players) {
		players.increaseNumberOfPlayer();
	}
	
	public void resetNumberOfPlayer(Players players) {
		players.resetNumberOfPlayer();
	}
		
	public void getCountIndex(Words words) {
		words.getCountIndex();
	}

	public void resetCountIndex(Words words) {
		words.resetCountIndex();
	}
	
	public void increaseCountIndex(Words words) {
		words.increaseCountIndex();
	}
	
	public boolean finishCount(Words words) {
    	if (words.finishCount(words.getCountIndex())) {
            return true;
    	}
        return false;
    }
	
	public void fastCalc(Calculate calculate, ArrayList<Integer> fastCountPlayersList, int arrayNumber, int wordsNumber) {
		calculate.fastCalc(fastCountPlayersList, arrayNumber, wordsNumber);
    }

///////	----- new count --- ///////
	
	public void newCalc(Calculate calculate, ArrayList<String> playersList, int arrayNumber, int wordsNumber) {
		calculate.newCalc(playersList, arrayNumber, wordsNumber);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////--- Service and Answers methods ---////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////--- Service ---//////////
	
	public String inputAnyString(Words words) {
		return words.inputAnyString();
		}

	public String getSomeString(Words words) {
		return words.getSomeString();
	}

	public void setSomeString(Words words, String s) {
		words.setSomeString(s);
	}
	
	public void showSomeString(Words words) {
		words.showSomeString();	
	}
	
	public boolean checkStringIsReal(Words words, String s) {
		if(!(words.checkStringIsReal(s))) {
			return false;
		}
		return true;
	}
	
	public boolean checkStringIsOnlyNumber(Words words, String s) {
	  	if (!(words.checkStringIsOnlyNumber(s))) {
	  		return false;
	  	}
	  	return true; 
	}
	
	public int getNumberFromSomeString(Words words, String s) {
		return words.getNumberFromSomeString(s);
	}
	
	public int getSomeNumber(Words words) {
		return words.getSomeNumber();
	}
	
	public void setSomeNumber(Words words, int i) {
		words.setSomeNumber(i);
	}
	
	public void showSomeNumber(Words words) {
		words.showSomeNumber();	
	}

//////// --- Answers --- ///////////	
	
	public String getAnswer(Answers answers) {
		return answers.getAnswer();
	}
	
	public void setAnswer(Answers answers, String s) {
		answers.setAnswer(s);
	}

	public void showAnswer(Answers answers) {
		answers.showAnswer();
	}
	
	public String getConfirmationAnswer(Answers answers) {
		return answers.getConfirmationAnswer();
	}

	public void setConfirmationAnswer(Answers answers, String s) {
		answers.setConfirmationAnswer(s);	
	}
	
	public void showConfirmationAnswer(Answers answers) {
		answers.showConfirmationAnswer();	
	}
	
	public boolean checkPositiveOrNegativeAnswer(Answers answers) {
		if(!(answers.getNegativeAnswerList().contains(answers.getAnswer().toLowerCase())) && !(answers.getPositiveAnswerList().contains(answers.getAnswer().toLowerCase()))) {
			return false;
		}
		return true;
	}
	
	public boolean checkNegativeAnswer(Answers answers) {
		if(!(answers.getNegativeAnswerList().contains(answers.getAnswer().toLowerCase()))) {
			return false;
		}
		return true;
	}
}
