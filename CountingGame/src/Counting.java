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
        /// приветствие
        Output.outputGreetings();

        /// регистрация участников
        Input.inputPlayerNames();

        /// ввод считалочки
        Output.outputEnterCounting();
        Input.inputCounting();

        /// вывод всех параметров
        Input.inputConditions();

        /// счет
        Output.outputChooseGameMode();
        Input.inputGameMode();

        /// результат
        Input.inputResult();

        /// финал
        Output.outputPlayAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailSecond() {
        /// ввод считалочки
        Output.outputEnterCounting();
        Input.inputCounting();

        /// вывод всех параметров
        Input.inputConditions();

        /// счет
        Output.outputChooseGameMode();
        Input.inputGameMode();

        /// результат
        Input.inputResult();

        /// финал
        Output.outputPlayAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailThird() {
        /// вывод всех параметров
        Input.inputConditions();

        /// счет
        Output.outputChooseGameMode();
        Input.inputGameMode();

        /// результат
        Input.inputResult();

        /// финал
        Output.outputPlayAgain();
        Input.inputStartAgain();
    }
}
