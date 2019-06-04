import java.util.ArrayList;

public interface View {
	void outputStart();  
	void outputFastCountRules();  
	void outputGreetings();;
	void outputEnterName(int n);; 
	void outputMorePlayers();  
	void outputEnterPlayersFastCount();  
	void outputEnterCounting();  
	void outputCountCheck(int n);  
	void outputCountCheckAgain(int n);  
	void outputEnterCountingAgain();  
	void outputEnterCountingFastCount();  
	void outputstartCounting();  
	void outputAllPlayers(ArrayList<String> arrayName, int arrayNumber);  
	void outputConditions(ArrayList<String> arrayName, int arrayNumber, int wordsNumber);  
	void outputChooseGameMode();  
	void outputEnterUserSettings();  
	void outputEnterUserSettingsStep();  
	void outputEnterUserGameMode();  
	void outputTempResult(ArrayList<String> arrayName, int arrayNumber, int num, String out);  
	void outputResult(ArrayList<String> arrayName, int arrayNumber);  
	void outputResultFastCount(ArrayList<Integer> arrayName);  
	void outputPlayAgain();  
	void outputChooseContinue(); 
	void outputAgainFromBegin();
	void outputAgainWithMyTeam();
	void outputFinal();  
	void outputIncorrectAnswer();  
	void outputIncorrectChoose();  
	void outputWhat();  
	void outputCheckedNumber();  
}
	 
