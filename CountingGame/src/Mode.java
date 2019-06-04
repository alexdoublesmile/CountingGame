
public class Mode {
	private String playMode = "";
	private String continueMode = "";
	
	public String getPlayMode() {
		return playMode;
	}
	
	public void setPlayMode(String playMode) {
		this.playMode = playMode;
	}
	
	public void showPlayMode() {
		System.out.println("");
		System.out.println("-----------------------------------");
		System.out.println("PlayMode is " + playMode);
		System.out.println("-----------------------------------");
		System.out.println("");		
	}
	
	public String getContinueMode() {
		return continueMode;
	}
	
	public void setContinueMode(String continueMode) {
		this.continueMode = continueMode;
	}

}
