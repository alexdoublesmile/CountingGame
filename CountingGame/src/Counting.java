
public class Counting {

    private static String Mode = "";

    public static String mode() {
        return Mode;
    }

    public static void start() {
        Mode = "";
        Output.outputStart();
        Mode = Input.inputString();
        if(!(Mode.equals("1") || Mode.equals("2"))) {
            Output.outputAnswerAgain();
            start();
        }
        else if (Mode.equals("2")) {
            countingDetail();
        } else  {
            Output.outputFastStart();
            Input.startFast();
        }
    }

    public static void countingFast(int ArrayName[], int n, int firstNum) {
        /// ������������� ����������
        Input.FastCountPlayers(ArrayName, n);
        /// ����
        Input.countFast(ArrayName, n, firstNum);
        /// �����
        Output.outputAgain();
        Input.inputStartAgain();
    }

    public static void countingDetail() {
        /// �����������
        Output.outputGreetings();

        /// ����������� ����������
        Input.inputRegister();

        /// ���� ����������
        Output.outputCounting();
        Input.inputCounting();

        /// ����� ���� ����������
        Input.inputConditions();

        /// ����
        Output.outputGameMode();
        Input.inputGameMode();

        /// ���������
        Input.inputResult();

        /// �����
        Output.outputAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailSecond() {
        /// ���� ����������
        Output.outputCounting();
        Input.inputCounting();

        /// ����� ���� ����������
        Input.inputConditions();

        /// ����
        Output.outputGameMode();
        Input.inputGameMode();

        /// ���������
        Input.inputResult();

        /// �����
        Output.outputAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailThird() {
        /// ����� ���� ����������
        Input.inputConditions();

        /// ����
        Output.outputGameMode();
        Input.inputGameMode();

        /// ���������
        Input.inputResult();

        /// �����
        Output.outputAgain();
        Input.inputStartAgain();
    }
}
