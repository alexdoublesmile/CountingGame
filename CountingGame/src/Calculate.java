import java.util.ArrayList;

public class Calculate {

	private int startNumber = 1;
	private int stepNumber = 1;
	private int numStep = 1;
	private int finalNumber = 0;
	private int fastCountFinalNumber = 0;
	private String countOrder = "1";
	private String outPlayer = "";
	
	public int getFinalNumber() {
		return finalNumber;
	}
	public void setFinalNumber(int finalNumber) {
		this.finalNumber = finalNumber;
	}
	
	public int getNumStep() {
		return numStep;
	}
	public void setNumStep(int numStep) {
		this.numStep = numStep;
	}
	public void resetNumStep() {
		numStep = 1;
	}
	public void increaseNumStep() {
		numStep++;
	}
	
	public String getOutPlayer() {
		return outPlayer;
	}
	public void setOutPlayer(String outPlayer) {
		this.outPlayer = outPlayer;
	}
	
	public int getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
	public int getStepNumber() {
		return stepNumber;
	}
	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}
	public String getCountOrder() {
		return countOrder;
	}
	public void setCountOrder(String countOrder) {
		this.countOrder = countOrder;
	}
	
	public void increaseCountOrder() {
		countOrder = "2";
	}
	public void increaseMoreCountOrder() {
		countOrder = "3";
	}
	public void resetCountOrder() {
		this.countOrder = "1";
	}
	
	void mainCalc(Players players, ArrayList<String> playersList, int wordsNumber) {
		if (countOrder.equals("1")) {
            if(finalNumber % playersList.size() > 0) {
                outPlayer = playersList.get(finalNumber % playersList.size() - 1);
                playersList.remove(finalNumber % playersList.size() - 1);
                finalNumber = (finalNumber % (playersList.size() + 1)) + wordsNumber*stepNumber - (stepNumber - 1) - 1;
            } else {
                outPlayer = playersList.get(playersList.size() - 1);
                playersList.remove(playersList.get(playersList.size() - 1));
                finalNumber = wordsNumber*stepNumber - (stepNumber - 1);
            }
        } else {
            if (finalNumber % playersList.size() > 0) {
                outPlayer = playersList.get(finalNumber % playersList.size() - 1);
                playersList.remove(finalNumber % playersList.size() - 1);
            } else {
                outPlayer = playersList.get(playersList.size() - 1);
                playersList.remove(playersList.get(playersList.size() - 1));
            }
        }
	}
	
	void fastCalc(ArrayList<Integer> fastCountPlayersList, int wordsNumber) {
		fastCountFinalNumber = wordsNumber;
        while (fastCountPlayersList.size() > 1) {
            if(fastCountFinalNumber % (fastCountPlayersList.size()) > 0) {
            	fastCountPlayersList.remove(fastCountFinalNumber % fastCountPlayersList.size() - 1);
            	fastCountFinalNumber = fastCountFinalNumber % (fastCountPlayersList.size() + 1) + wordsNumber - 1;
            } else {
            	fastCountPlayersList.remove(fastCountPlayersList.size() - 1);
            	fastCountFinalNumber = wordsNumber;
            }
        }
    }
	
	void newCalc(Players players, ArrayList<String> playersList, int wordsNumber) {	
		
        /// new counting method
           
        
    }
}
