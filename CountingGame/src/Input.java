
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

class Input {

    private static int arrayNumber = 1;
    private static int arraySameNumber = 1;
    private static int countPlayers = 1;
    private static int wordsNumber;
    private static int numStep = 1;
    private static String arrayCompany[] = new String[arrayNumber];
    private static String arraySameCompany[] = new String[arraySameNumber];
    private static String outPlayer;

    // "������������" ������� ������������� � ������������� �������
    private static String[] positive = new String[]{"��", "�����", "��", "���", "���", "�������", "�����", "�������", "�����", "�����", "���������", "������", "�����", "y", "yes", "ok", "lf", "1"};
    private static String[] negative = new String[]{"���", "��", "���", "������", "�����", "yt", "ytn", "�������", "0"};

    // ���� ����� ������������� � ������������� �������
    public static boolean positive(String tryPositive) {
        while (tryPositive.equals("") || tryPositive.equals(" ")) {
            Output.outputWhat();
            tryPositive = inputString();
        }
        String MaybeYes = "";
        if (!(Arrays.asList(negative).contains(tryPositive.toLowerCase())) && !(Arrays.asList(positive).contains(tryPositive.toLowerCase()))) {
            while (!(MaybeYes.equals("1") || (MaybeYes.equals("2")))) {
                Output.outputAnswer();
                MaybeYes = inputString();
                if (!(MaybeYes.equals("1") || (MaybeYes.equals("2")))) {
                    Output.outputAnswerAgain();
                }
            }
            if (MaybeYes.equals("1")) {
                String ArrayCopy[] = Arrays.copyOf(positive, positive.length + 1);
                positive = ArrayCopy;
                positive[positive.length - 1] = tryPositive.toLowerCase();
                return true;
            } else {
                String ArrayCopy[] = Arrays.copyOf(negative, negative.length + 1);
                negative = ArrayCopy;
                negative[negative.length - 1] = tryPositive.toLowerCase();
                return false;
            }

        } else if (Arrays.asList(negative).contains(tryPositive.toLowerCase())) {
            return false;
        }
        return true;
    }

    // ���� ����� ��������� ��������
    public static int checkNumber() {
        String number = inputString();
        while (!(number.matches("[0-9]+"))) {
            Output.outputCheckedNumber();
            number = inputString();
        }
        int n = Integer.parseInt(number);
        return n;
    }

    // ���� ������ ��� �������� �����
    public static void startFast() {
        Output.outputPlayersFast();
        int n = Input.checkNumber();
        Output.outputCountingFast();
        int x = Input.checkNumber();
        int company[] = new int[n];
        Counting.countingFast(company, n, x);
    }

    // ������������� ���������� ��� �������� ������
    public static void FastCountPlayers(int ArrayName[], int n) {
        for(int i = 0; i < n; i++) {
            ArrayName[i] = i + 1;
        }
    }

    // ���� � ������� ������
    public static void countFast(int ArrayName[], int n, int firstNum) {
        int lastNum = firstNum;
        while (n > 1) {
            if(lastNum % n > 0) {
                for (int i = lastNum % n; i < n; i++) {
                    ArrayName[i - 1] = ArrayName[i];
                }
                lastNum = (lastNum % n) + firstNum - 1;
            } else {
                lastNum = firstNum;
            }
            int companyCopy2[] = new int[ArrayName.length - 1];
            System.arraycopy(ArrayName, 0, companyCopy2, 0, companyCopy2.length);
            ArrayName = companyCopy2;
            n--;
        }
        Output.outputFastResult(ArrayName, n);
    }

    // ���� ���� ����������
    public static void inputRegister() {
        Output.outputName(countPlayers);
        arrayCompany[(arrayNumber - 1)] = inputString();
        while (arrayCompany[(arrayNumber - 1)].equals("") || arrayCompany[arrayNumber - 1].equals(" ")) {
            Output.outputWhat();
            arrayCompany[(arrayNumber - 1)] = inputString();
        }
            countPlayers++;
        if (countPlayers == 2) {
            String ArrayCopy[] = Arrays.copyOf(arrayCompany, arrayCompany.length + 1);
            arrayCompany = ArrayCopy;
            arrayNumber++;
            inputRegister();
        } else if (countPlayers > 2) {
            Output.outputNameAgain();
            String answer = inputString();
            if (!(positive(answer))) {

            } else {

                String ArrayCopy[] = Arrays.copyOf(arrayCompany, arrayCompany.length + 1);
                arrayCompany = ArrayCopy;
                arrayNumber++;
                inputRegister();
            }
            countPlayers = 1;
        }
        String arrayForSameCompany[] = Arrays.copyOf(arrayCompany, arrayCompany.length);
        arraySameCompany = arrayForSameCompany;
        arraySameNumber = arrayNumber;
    }

    // ���� ����������
    public static void inputCounting() {
        String counting = inputString();
        if (counting.matches("[0-9]+")) {
            wordsNumber = Integer.parseInt(counting);
        } else {
            int severalWords = countWords(counting);
            while (severalWords < 2) {
                Output.outputWhat();
                counting = inputString();
                if (counting.matches("[0-9]+")) {
                    wordsNumber = Integer.parseInt(counting);
                    severalWords = wordsNumber;
                    break;
                } else
                severalWords = countWords(counting);
            }
            Output.outputCountCheck(severalWords);
            String scan = inputString();
            if (!(positive(scan))) {
                Output.outputCountCheckAgain(severalWords);
                String scanMore = inputString();
                if (!(positive(scanMore))) {
                    Output.outputCountingAgain();
                } else {
                    wordsNumber = severalWords - 1;
                }
            } else {
                wordsNumber = severalWords;
            }
        }
    }

    // ������� ���� ����������
    public static int countWords(String counting) {
        int count = 0;
        Pattern pattern = Pattern.compile("[A-Za-z0-9�-��-�]+");
        Matcher matcher = pattern.matcher(counting);
        while (matcher.find())
            count++;
        return count;
    }

    // ���� � ����� ���������� � �����������
    public static void inputConditions() {
        Output.outputConditions(arrayCompany, arrayNumber, wordsNumber);
    }

    // ���� ������ ������
    public static void inputGameMode() {
        String gameMode = inputString();
        switch (gameMode) {
            case ("1"):
                mainCount(1, 1, "1");
                break;
            case ("2"):
                mainCount(1, 1, "2");
                break;
            case ("3"):
                inputUserGameMode();
                break;
            default:
                Output.outputAnswerAgain();
                inputGameMode();
        }
    }

    // ���� ������ ��� ����������������� ������
    public static void inputUserGameMode() {
        Output.outputUserSettings();
        int startNumber = checkNumber();
        Output.outputUserSettingsStep();
        int stepNumber = checkNumber();
        Output.outputUserGameMode();
        String order = inputString();
        while (!(order.equals("1")) && !(order.equals("2"))) {
            Output.outputAnswerAgain();
            order = inputString();
        }
        mainCount(startNumber, stepNumber, order);
    }

    // ���� � ��������� ������
    public static void mainCount(int startNumber, int stepNumber, String order) {
        String arrayForSameCompany[] = Arrays.copyOf(arrayCompany, arrayCompany.length);
        arraySameCompany = arrayForSameCompany;
        arraySameNumber = arrayNumber;
        Output.outputstartCounting();
        Output.outputAllPlayers(arrayCompany, arrayNumber);
        int finalNumber = wordsNumber*stepNumber + (startNumber - 1);
        numStep = 1;
        while (arrayNumber > 1) {
            if (order.equals("1")) {
                if(finalNumber % arrayNumber > 0) {
                    outPlayer = arrayCompany[finalNumber % arrayNumber - 1];
                    for (int i = finalNumber % arrayNumber; i < arrayNumber; i++) {
                        arrayCompany[i - 1] = arrayCompany[i];
                    }
                    finalNumber = (finalNumber % arrayNumber) + wordsNumber*stepNumber - 1;
                } else {
                    outPlayer = arrayCompany[arrayNumber - 1];
                    finalNumber = wordsNumber*stepNumber;
                }
            } else {
                if (finalNumber % arrayNumber > 0) {
                    outPlayer = arrayCompany[finalNumber % arrayNumber - 1];
                    for (int i = finalNumber % arrayNumber; i < arrayNumber; i++) {
                        arrayCompany[i - 1] = arrayCompany[i];
                    }
                } else {
                    outPlayer = arrayCompany[arrayNumber - 1];
                }
            }
            /// ������� ���������� ������� �� ����� �����
            arrayCut(arrayCompany);
            arrayNumber--;
            /// ������� ��������� �� ����� �����
            Output.outputTempResult(arrayCompany, arrayNumber, numStep, outPlayer);
            numStep++;
        }
    }

    // ���� � ����� �����������
    public static void inputResult() {
        Output.outputResult(arrayCompany, arrayNumber);
    }

    // ����������
    public static void inputStartAgain() {
        String was = Counting.mode();
        String again = inputString();
        if (!(positive(again))) {
            Output.outputFinal();
        } else {
            if(was.equals("2")) {
                Output.outputContinue();
                inputContinue();
            } else  {
                Counting.start();
            }

        }
    }

    // ���� ������� �����������
    public static void inputContinue() {
        String countinue = inputString();
        switch (countinue) {
            case ("1"):
                Counting.start();
                break;
            case ("2"):
                arrayCompany = arraySameCompany;
                arrayNumber = arraySameNumber;
                Counting.countingDetailSecond();
                break;
            case ("3"):
                arrayCompany = arraySameCompany;
                arrayNumber = arraySameNumber;
                Counting.countingDetailThird();
                break;
            default:
                Output.outputAnswerAgain();
                inputContinue();
        }
    }

    // ����� ������ ���������� �������
    public static void arrayCut(String ArrayName[]) {
        String ArrayCopy[] = new String[ArrayName.length - 1];
        System.arraycopy(ArrayName, 0, ArrayCopy, 0, ArrayCopy.length);
        ArrayName = ArrayCopy;
    }

    // ����� ������ ����� ��������� ������
    public static String inputString() {
        Scanner scanString = new Scanner(System.in);
        String s = scanString.nextLine();
        return s;
    }
}
