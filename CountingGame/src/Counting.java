public class Counting {

    private static String Mode = "";

    public static String mode() {
        return Mode;
    }

    public static void start() {
        Mode = "";
        Output.outputStart();
        Mode = Input.inputAnyString();
        if(!(Mode.equals("1") || Mode.equals("2"))) {
            Output.outputAnswerAgain();
            start();
        }
        else if (Mode.equals("2")) {
            countingDetail();
        } else  {
            Output.outputFastCountRules();
            Input.startFastCount();
        }
    }

    public static void countingFast() {
        Output.outputPlayAgain();
        Input.inputStartAgain();
    }

    public static void countingDetail() {
        Output.outputGreetings();
        Input.inputPlayerNames();
        Output.outputEnterCounting();
        Input.inputCounting();
        Input.inputConditions();
        Output.outputChooseGameMode();
        Input.inputGameMode();
        Input.inputResult();
        Output.outputPlayAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailSecond() {
        Output.outputEnterCounting();
        Input.inputCounting();
        Input.inputConditions();
        Output.outputChooseGameMode();
        Input.inputGameMode();
        Input.inputResult();
        Output.outputPlayAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailThird() {
        Input.inputConditions();
        Output.outputChooseGameMode();
        Input.inputGameMode();
        Input.inputResult();
        Output.outputPlayAgain();
        Input.inputStartAgain();
    }
}
