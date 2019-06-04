import java.util.ArrayList;
import java.util.HashSet;

public interface ModelLayer {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Main methods  ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	String getPlayMode(Mode mode);
	void setPlayMode(Mode mode, String s);
	void showPlayMode(Mode mode, String s);
	String getContinueMode(Mode mode);
	void setContinueMode(Mode mode, String s);
	int getArrayNumber(Players players);
	void setArrayNumber(Players players, int i);
	void increaseArrayNumber(Players players);
	void reduceArrayNumber(Players players);
	void showArrayNumber(Players players);
	int getWordsNumber(Words wordsNumber);
	void setWordsNumber(Words wordsNumber, int i);
	void resetWordsNumber(Words wordsNumber);
	void showWordsNumber(Words wordsNumber);
	int countWordsFromString(Words wordsNumber, String s);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////---  Lists methods ---/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	ArrayList<String> getPlayersList(Players players);
	void addToPlayersList(Players players, String s);
	void showPlayersList(Players players);
	void showInitialPlayersList(Players players);
	ArrayList<Integer> getFastCountPlayersList(Players players);
	void showFastCountPlayersList(Players players);
	HashSet<String> getPositiveAnswerList(Answers answers);
	HashSet<String> getNegativeAnswerList(Answers answers);
	void addToPositiveAnswerList(Answers answers);
	void addToNegativeAnswerList(Answers answers);
	void showPositiveAnswerList(Answers answers);
	void showNegativeAnswerList(Answers answers);
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
	String getGameOrder(Calculate calculate);
	void setGameOrder(Calculate calculate, String s);
	void increaseGameOrder(Calculate calculate);
	int getFinalNumber(Calculate calculate);
	void setFinalNumber(Calculate calculate, int i);
	int getNumStep(Calculate calculate);
	void setNumStep(Calculate calculate, int i);
	void resetNumStep(Calculate calculate);
	void increaseNumStep(Calculate calculate);
	String getOutPlayer(Calculate calculate);
	void setOutPlayer(Calculate calculate, String s);
	void mainCalc(Calculate calculate, ArrayList<String> playersList, int arrayNumber, int wordsNumber, String order);

////////////--- fast count ---  ////////////	

	int getNumberOfPlayer(Players players);
	void setNumberOfPlayer(Players players, int s);
	void increaseNumberOfPlayer(Players players);
	void resetNumberOfPlayer(Players players);
	void getCountIndex(Words wordsNumber);
	void resetCountIndex(Words wordsNumber);
	void increaseCountIndex(Words wordsNumber);
	boolean finishCount(Words wordsNumber);
	void fastCalc(Calculate calculate, ArrayList<Integer> fastCountPlayersList, int arrayNumber, int wordsNumber);

///////	----- new count --- ///////

	void newCalc(Calculate calculate, ArrayList<String> playersList, int arrayNumber, int wordsNumber);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////--- Service and Answers methods ---////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////--- Service ---//////////

	String inputAnyString(Words wordsNumber);
	String getSomeString(Words wordsNumber);
	void setSomeString(Words wordsNumber, String s);
	void showSomeString(Words wordsNumber);
	boolean checkStringIsReal(Words wordsNumber, String s);
	boolean checkStringIsOnlyNumber(Words wordsNumber, String s);
	int getNumberFromSomeString(Words wordsNumber, String s);
	int getSomeNumber(Words wordsNumber);
	void setSomeNumber(Words wordsNumber, int i);
	void showSomeNumber(Words wordsNumber);

////////--- Answers --- ///////////	

	String getAnswer(Answers answers);
	void setAnswer(Answers answers, String s);
	void showAnswer(Answers answers);
	String getConfirmationAnswer(Answers answers);
	void setConfirmationAnswer(Answers answers, String s);
	void showConfirmationAnswer(Answers answers);
	boolean checkPositiveOrNegativeAnswer(Answers answers);
	boolean checkNegativeAnswer(Answers answers);		
}
