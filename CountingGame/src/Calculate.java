import java.util.ArrayList;

public class Calculate {

	private int startNumber = 1;
	private int stepNumber = 1;
	private int numStep = 1;
	private int finalNumber = 0;
	private int fastCountFinalNumber = 0;
	private String gameOrder = "1";
	private String outPlayer = "";
	
	public int getFinalNumber() {
		return finalNumber;
	}
	public void setFinalNumber(int finalNumber) {
		this.finalNumber = finalNumber;
	}
	public void showFinalNumber() {
		System.out.println("-------------------------------------------------");
	    System.out.println("showFinalNumber: " + getFinalNumber());
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
	public void showNumStep() {
		System.out.println("-------------------------------------------------");
	    System.out.println("showNumStep: " + getNumStep());
	}
	public String getOutPlayer() {
		return outPlayer;
	}
	public void setOutPlayer(String outPlayer) {
		this.outPlayer = outPlayer;
	}
	public void showOutPlayer() {
		System.out.println("-------------------------------------------------");
	    System.out.println("showOutPlayer: " + getOutPlayer());
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
	public String getGameOrder() {
		return gameOrder;
	}
	public void setGameOrder(String gameOrder) {
		this.gameOrder = gameOrder;
	}
	public void increaseGameOrder() {
		gameOrder = "2";
	}
	
	void mainCalc(ArrayList<String> playersList, int arrayNumber, int wordsNumber, String order) {
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
	}
	
	void fastCalc(ArrayList<Integer> fastCountPlayersList, int arrayNumber, int wordsNumber) {
		fastCountFinalNumber = wordsNumber;
        while (arrayNumber > 1) {
            if(fastCountFinalNumber % arrayNumber > 0) {
            	fastCountPlayersList.remove(fastCountFinalNumber % arrayNumber - 1);
            	fastCountFinalNumber = fastCountFinalNumber % arrayNumber + wordsNumber - 1;
            } else {
            	fastCountPlayersList.remove(fastCountPlayersList.size() - 1);
            	fastCountFinalNumber = wordsNumber;
            }
            arrayNumber--;
        }
    }
	
	void newCalc(ArrayList<String> fastCountPlayersList, int arrayNumber, int wordsNumber) {	
        /// new counting method
		
    }
}