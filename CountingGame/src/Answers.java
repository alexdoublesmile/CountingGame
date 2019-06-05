import java.util.Arrays;
import java.util.HashSet;

public class Answers {

	private String answer = "";
	private String confirmationAnswer = "";
	private static String[] positiveAnswerArray = new String[]{"да", "давай", "ок", "ага", "угу", "конечно", "можно", "сыграем", "верно", "точно", "правильно", "хорошо", "будут", "y", "yes", "ok", "lf", "1"};
    private static String[] negativeAnswerArray = new String[]{"нет", "не", "неа", "хватит", "хорош", "yt", "ytn", "неверно", "0"};
    private static HashSet<String> positiveAnswerList = new HashSet<String>(Arrays.asList(positiveAnswerArray));
    private static HashSet<String> negativeAnswerList = new HashSet<String>(Arrays.asList(negativeAnswerArray));
	
    public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getConfirmationAnswer() {
		return confirmationAnswer;
	}

	public void setConfirmationAnswer(String confirmationAnswer) {
		this.confirmationAnswer = confirmationAnswer;
	}
		
	 public HashSet<String> getPositiveAnswerList() {
		return positiveAnswerList;
	}

	public HashSet<String> getNegativeAnswerList() {
		return negativeAnswerList;
	}  

	public void addToPositiveAnswerList(String s) {
		positiveAnswerList.add(s);
	}

	public void addToNegativeAnswerList(String s) {
		negativeAnswerList.add(s);
	}
	
}
