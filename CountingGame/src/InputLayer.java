import java.util.ArrayList;
import java.util.HashSet;

public class InputLayer implements ModelLayer {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Main methods  ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    @ Override
	public String getPlayMode(Mode mode) {
		return mode.getPlayMode();
	}
	
    @ Override
	public void setPlayMode(Mode mode, String s) {
		mode.setPlayMode(s);
	}
	
    @ Override
	public String getContinueMode(Mode mode) {
		return mode.getContinueMode();
	}
	
    @ Override
	public void setContinueMode(Mode mode, String s) {
		mode.setContinueMode(s);
	}

    @ Override
	public int getArrayNumber(Players players) {
		return players.getArrayNumber();
	}
	
    @ Override
	public void setArrayNumber(Players players, int i) {
		players.setArrayNumber(i);
	}
	
    @ Override
	public void increaseArrayNumber(Players players) {
		players.increaseArrayNumber();
	}
	
    @ Override
	public void reduceArrayNumber(Players players) {
		players.reduceArrayNumber();
	}
	
    @ Override
	public int getWordsNumber(Words words) {
		return words.getWordsNumber();
	}
	
    @ Override
	public void setWordsNumber(Words words, int i) {
		words.setWordsNumber(i);
	}
	
    @ Override
	public void resetWordsNumber(Words words) {
		words.resetWordsNumber();
	}
	
    @ Override
	public int countWordsFromString(Words words, String s) {
        return words.countWordsFromString(s);
    }
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Lists methods ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    @ Override
	public ArrayList<String> getPlayersList(Players players) {
		return players.getPlayersList();
	}
	
    @ Override
	public void addToPlayersList(Players players, String s) {
		players.addToPlayersList(s);
	}
	    
    @ Override
	public ArrayList<Integer> getFastCountPlayersList(Players players) {
		return players.getFastCountPlayersList();
	}	

    @ Override
	public HashSet<String> getPositiveAnswerList(Answers answers) {
		return answers.getPositiveAnswerList();
	}
	
    @ Override
	public HashSet<String> getNegativeAnswerList(Answers answers) {
		return answers.getNegativeAnswerList();
	}
	
    @ Override
	public void addToPositiveAnswerList(Answers answers) {
		answers.addToPositiveAnswerList(answers.getAnswer().toLowerCase());
	}

    @ Override
	public void addToNegativeAnswerList(Answers answers) {
		answers.addToNegativeAnswerList(answers.getAnswer().toLowerCase());
	}	
	
    @ Override
	public void copySettings(Players players) {
		players.copySettings();
	}

    @ Override
	public void returnSettings(Players players) {
		players.returnSettings();
	}
	
    @ Override
	public void numberingOfPlayers(Players players, int n) {
		players.numberingOfPlayers(n);
    }
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Count methods ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
////////////   main count  ////////////		
	
    @ Override
	public int getStartNumber(Calculate calculate) {
		return calculate.getStartNumber();
	}
	
    @ Override
	public void setStartNumber(Calculate calculate, int i) {
		calculate.setStartNumber(i);
	}
	
    @ Override
	public int getStepNumber(Calculate calculate) {
		return calculate.getStepNumber();
	}
	
    @ Override
	public void setStepNumber(Calculate calculate, int i) {
		calculate.setStepNumber(i);
	}
	
    @ Override
	public String getCountOrder(Calculate calculate) {
		return calculate.getCountOrder();
	}
	
    @ Override
	public void setCountOrder(Calculate calculate, String s) {
		calculate.setCountOrder(s);
	}
    
    @ Override
	public void increaseCountOrder(Calculate calculate) {
		calculate.increaseCountOrder();
	}

    @ Override
	public void increaseMoreCountOrder(Calculate calculate) {
		calculate.increaseMoreCountOrder();
	}

    @ Override
	public void resetCountOrder(Calculate calculate) {
		calculate.resetCountOrder();
	}
    
    @ Override
	public int getFinalNumber(Calculate calculate) {
		return calculate.getFinalNumber();
	}
	
    @ Override
	public void setFinalNumber(Calculate calculate, int i) {
		calculate.setFinalNumber(i);
	}
	
    @ Override
	public int getNumStep(Calculate calculate) {
		return calculate.getNumStep();
	}
	
    @ Override
	public void setNumStep(Calculate calculate, int i) {
		calculate.setNumStep(i);
	}
	
    @ Override
	public void resetNumStep(Calculate calculate) {
		calculate.resetNumStep();
	}
	
    @ Override
	public void increaseNumStep(Calculate calculate) {
		calculate.increaseNumStep();
	}
	
    @ Override
	public String getOutPlayer(Calculate calculate) {
		return calculate.getOutPlayer();
	}
	
    @ Override
	public void setOutPlayer(Calculate calculate, String s) {
		calculate.setOutPlayer(s);
	}
    
    @ Override
	public void mainCalc(Players players, Calculate calculate, ArrayList<String> playersList, int arrayNumber, int wordsNumber) {
		calculate.mainCalc(players, playersList, arrayNumber, wordsNumber);
	}
	
////////////  --- fast count ---  ////////////	
	
    @ Override
	public int getNumberOfPlayer(Players players) {
		return players.getNumberOfPlayer();
	}
	
    @ Override
	public void setNumberOfPlayer(Players players, int s) {
		players.setNumberOfPlayer(s);
	}
	
    @ Override
	public void increaseNumberOfPlayer(Players players) {
		players.increaseNumberOfPlayer();
	}
	
    @ Override
	public void resetNumberOfPlayer(Players players) {
		players.resetNumberOfPlayer();
	}
	
    @ Override
	public void fastCalc(Calculate calculate, ArrayList<Integer> fastCountPlayersList, int arrayNumber, int wordsNumber) {
		calculate.fastCalc(fastCountPlayersList, arrayNumber, wordsNumber);
    }

///////	----- new count --- ///////
	
    @ Override
	public void newCalc(Players players, Calculate calculate, ArrayList<String> playersList, int arrayNumber, int wordsNumber) {
		calculate.newCalc(players, playersList, arrayNumber, wordsNumber);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////--- Service and Answers methods ---////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////--- Service ---//////////
	
    @ Override
	public String inputAnyString(Words words) {
		return words.inputAnyString();
		}

    @ Override
	public String getSomeString(Words words) {
		return words.getSomeString();
	}

    @ Override
	public void setSomeString(Words words, String s) {
		words.setSomeString(s);
	}
	
    @ Override
	public boolean checkStringIsReal(Words words, String s) {
		if(!(words.checkStringIsReal(s))) {
			return false;
		}
		return true;
	}
	
    @ Override
	public boolean checkStringIsOnlyNumber(Words words, String s) {
	  	if (!(words.checkStringIsOnlyNumber(s))) {
	  		return false;
	  	}
	  	return true; 
	}
	
    @ Override
	public int getNumberFromSomeString(Words words, String s) {
		return words.getNumberFromSomeString(s);
	}
	
    @ Override
	public int getSomeNumber(Words words) {
		return words.getSomeNumber();
	}
	
    @ Override
	public void setSomeNumber(Words words, int i) {
		words.setSomeNumber(i);
	}

//////// --- Answers --- ///////////	
	
    @ Override
	public String getAnswer(Answers answers) {
		return answers.getAnswer();
	}
	
    @ Override
	public void setAnswer(Answers answers, String s) {
		answers.setAnswer(s);
	}
	
    @ Override
	public String getConfirmationAnswer(Answers answers) {
		return answers.getConfirmationAnswer();
	}

    @ Override
	public void setConfirmationAnswer(Answers answers, String s) {
		answers.setConfirmationAnswer(s);	
	}
	
    @ Override
	public boolean checkPositiveOrNegativeAnswer(Answers answers) {
		if(!(answers.getNegativeAnswerList().contains(answers.getAnswer().toLowerCase())) && !(answers.getPositiveAnswerList().contains(answers.getAnswer().toLowerCase()))) {
			return false;
		}
		return true;
	}
	
    @ Override
	public boolean checkNegativeAnswer(Answers answers) {
		if(!(answers.getNegativeAnswerList().contains(answers.getAnswer().toLowerCase()))) {
			return false;
		}
		return true;
	}
}
