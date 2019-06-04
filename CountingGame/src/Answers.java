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
	
	public void showAnswer() {
		System.out.println("-------------------------------------------------");
        System.out.println("Answer: ");
		System.out.println(answer);
		System.out.println("");
		System.out.println("");
	}
	
	public void showConfirmationAnswer() {
        System.out.println("-------------------------------------------------");
        System.out.println("ConfirmationAnswer: ");
		System.out.println(confirmationAnswer);
		System.out.println("");
		System.out.println("");
	}
	
	public void showPositiveAnswerList() {
        System.out.println("-------------------------------------------------");
        System.out.println("positiveAnswerList: ");
        for (String s : positiveAnswerList) {
        	System.out.println(s);
        }
		System.out.println("");
		System.out.println("");
	}
	
	public void showNegativeAnswerList() {
        System.out.println("-------------------------------------------------");
        System.out.println("negativeAnswerList: ");
        for (String s : negativeAnswerList) {
        	System.out.println(s);
        }
		System.out.println("");
		System.out.println("");
	}
	
	 public HashSet<String> getPositiveAnswerList() {
		return positiveAnswerList;
	}

	public void setPositiveAnswerList(HashSet<String> positiveAnswerList) {
		Answers.positiveAnswerList = positiveAnswerList;
	}

	public HashSet<String> getNegativeAnswerList() {
		return negativeAnswerList;
	}

	public void setNegativeAnswerList(HashSet<String> negativeAnswerList) {
		Answers.negativeAnswerList = negativeAnswerList;
	}   

	public void addToPositiveAnswerList(String s) {
		positiveAnswerList.add(s);
	}

	public void addToNegativeAnswerList(String s) {
		negativeAnswerList.add(s);
	}
	
}
