import java.util.ArrayList;
import java.util.HashSet;

public interface ModelLayer {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Main methods  ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	String getPlayMode(Mode mode);
	void setPlayMode(Mode mode, String s);
	String getContinueMode(Mode mode);
	void setContinueMode(Mode mode, String s);
	int getWordsNumber(Words wordsNumber);
	void setWordsNumber(Words wordsNumber, int i);
	void resetWordsNumber(Words wordsNumber);
	int countWordsFromString(Words wordsNumber, String s);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Lists methods ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	ArrayList<String> getPlayersList(Players players);
	void addToPlayersList(Players players, String s);
	ArrayList<Integer> getFastCountPlayersList(Players players);
	int getPlayersListSize(Players players);
	int getFastCountPlayersListSize(Players players);
	HashSet<String> getPositiveAnswerList(Answers answers);
	HashSet<String> getNegativeAnswerList(Answers answers);
	void addToPositiveAnswerList(Answers answers);
	void addToNegativeAnswerList(Answers answers);
	void copySettings(Players players);
	void returnSettings(Players players);
	void numberingOfPlayers(Players players, int n);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Count methods ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////main count  ////////////		

	int getStartNumber(Calculate calculate);
	void setStartNumber(Calculate calculate, int i);
	int getStepNumber(Calculate calculate);
	void setStepNumber(Calculate calculate, int i);
	String getCountOrder(Calculate calculate);
	void setCountOrder(Calculate calculate, String s);
	void increaseCountOrder(Calculate calculate);
	void increaseMoreCountOrder(Calculate calculate);
	void resetCountOrder(Calculate calculate);
	int getFinalNumber(Calculate calculate);
	void setFinalNumber(Calculate calculate, int i);
	int getNumStep(Calculate calculate);
	void setNumStep(Calculate calculate, int i);
	void resetNumStep(Calculate calculate);
	void increaseNumStep(Calculate calculate);
	String getOutPlayer(Calculate calculate);
	void setOutPlayer(Calculate calculate, String s);
	void mainCalc(Players players, Calculate calculate, ArrayList<String> playersList, int wordsNumber);

////////////--- fast count ---  ////////////	

	int getNumberOfPlayer(Players players);
	void setNumberOfPlayer(Players players, int s);
	void increaseNumberOfPlayer(Players players);
	void resetNumberOfPlayer(Players players);
	void fastCalc(Calculate calculate, ArrayList<Integer> fastCountPlayersList, int wordsNumber);

///////	----- new count --- ///////

	void newCalc(Players players, Calculate calculate, ArrayList<String> playersList, int wordsNumber);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////--- Service and Answers methods ---////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////--- Service ---//////////

	String inputAnyString(Words wordsNumber);
	String getSomeString(Words wordsNumber);
	void setSomeString(Words wordsNumber, String s);
	boolean checkStringIsReal(Words wordsNumber, String s);
	boolean checkStringIsOnlyNumber(Words wordsNumber, String s);
	int getNumberFromSomeString(Words wordsNumber, String s);
	int getSomeNumber(Words wordsNumber);
	void setSomeNumber(Words wordsNumber, int i);
	void closeScanner(Words words);
	
////////--- Answers --- ///////////	

	String getAnswer(Answers answers);
	void setAnswer(Answers answers, String s);
	String getConfirmationAnswer(Answers answers);
	void setConfirmationAnswer(Answers answers, String s);
	boolean checkPositiveOrNegativeAnswer(Answers answers);
	boolean checkNegativeAnswer(Answers answers);		
}
