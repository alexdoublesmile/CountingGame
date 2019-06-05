import java.util.ArrayList;

public class Players {
	
    private int arrayNumber = 1;
    private int initialArrayNumber = 1;
	private int numberOfPlayer = 1;
    private ArrayList<String> playersList = new ArrayList<String>(16);
    private ArrayList<String> initialPlayersList = new ArrayList<String>(16);
    private ArrayList<Integer> fastCountPlayersList = new ArrayList<Integer>(16);

	public int getArrayNumber() {
		return arrayNumber;
	}
    
	public void setArrayNumber(int arrayNumber) {
		this.arrayNumber = arrayNumber;
	}
	
	public void increaseArrayNumber() {
		this.arrayNumber++;
	}
	
	public void reduceArrayNumber() {
		this.arrayNumber--;
	}
	
	public int getInitialArrayNumber() {
		return initialArrayNumber;
	}
	
	public void setInitialArrayNumber(int initialArrayNumber) {
		this.initialArrayNumber = initialArrayNumber;
	}

	public int getNumberOfPlayer() {
		return numberOfPlayer;
	}

	public void setNumberOfPlayer(int numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
	}
	
	public void increaseNumberOfPlayer() {
		this.numberOfPlayer++;
	}
	
	public void resetNumberOfPlayer() {
		this.numberOfPlayer = 1;
	}
	
	public ArrayList<Integer> getFastCountPlayersList() {
		return fastCountPlayersList;
	}

	public ArrayList<String> getPlayersList() {
		return playersList;
	}
	
	public int getPlayersListSize() {
		return playersList.size();
	}

	public ArrayList<String> getInitialPlayersList() {
		return initialPlayersList;
	}
	
	public void addToPlayersList(String s) {
		playersList.add(s);
	}

	public void addToInitialPlayersList(String s) {
		initialPlayersList.add(s);
	}
	
	public void copySettings() {
		ArrayList<String> copyOfPlayersList = new ArrayList<String>(playersList);
		initialPlayersList = copyOfPlayersList;
		initialArrayNumber = arrayNumber;
	}

	public void returnSettings() {
		playersList = initialPlayersList;
	    arrayNumber = initialArrayNumber;
	}
	
	public void numberingOfPlayers(int n) {
        for(int i = 1; i <= n; i++) {
        	fastCountPlayersList.add(i);
        }
    }
}
