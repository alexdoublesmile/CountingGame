import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.*;

class Input {

    private static int arrayNumber = 1;
    private static int arraySameNumber = 1;
    private static ArrayList<String> playersList = new ArrayList<String>(arrayNumber);
    private static ArrayList<String> samePlayersList = new ArrayList<String>(arraySameNumber);
    private static ArrayList<Integer> fastPlayersList = new ArrayList<Integer>(arrayNumber);
    private static int countPlayers = 1;
    private static int wordsNumber;
    private static int numStep = 1;
    private static String outPlayer;

    // lists of positive and negative answers
    private static String[] positiveAnswerArray = new String[]{"да", "давай", "ок", "ага", "угу", "конечно", "можно", "сыграем", "верно", "точно", "правильно", "хорошо", "будут", "y", "yes", "ok", "lf", "1"};
    private static HashSet<String> positiveAnswerList = new HashSet<String>(Arrays.asList(positiveAnswerArray));
    private static String[] negativeAnswerArray = new String[]{"нет", "не", "неа", "хватит", "хорош", "yt", "ytn", "неверно", "0"};
    private static HashSet<String> negativeAnswerList = new HashSet<String>(Arrays.asList(negativeAnswerArray));

    // ввод данных для быстрого счета
    public static void startFast() {
        Output.outputPlayersFast();
        arrayNumber = Input.checkNumber();
        Output.outputCountingFast();
        wordsNumber = Input.checkNumber();
        fastCountPlayers(fastPlayersList, arrayNumber);
        countFast(fastPlayersList, arrayNumber, wordsNumber);
        Counting.countingFast();
    }

    // инициализация участников для быстрого режима
    public static void fastCountPlayers(ArrayList<Integer> fastPlayersList, int n) {
        for(int i = 1; i <= n; i++) {
        	fastPlayersList.add(i);
        }
    }

    // счет в быстром режиме
    public static void countFast(ArrayList<Integer> fastPlayersList, int n, int firstNum) {
        int lastNum = firstNum;
        while (n > 1) {
            if(lastNum % n > 0) {
            	fastPlayersList.remove(lastNum % n - 1);
                lastNum = lastNum % n + firstNum - 1;
            } else {
            	fastPlayersList.remove(fastPlayersList.size() - 1);
                lastNum = firstNum;
            }
            n--;
        }
        Output.outputFastResult(fastPlayersList, n);
    }

    // ввод имен участников
    public static void inputRegister() {
        Output.outputName(countPlayers);
        String player = inputString();
        while (player.equals("") || player.equals(" ")) {
            Output.outputWhat();
            player = inputString();
        }
            countPlayers++;
        if (countPlayers == 2) {
            arrayNumber++;
            playersList.add(player);
            inputRegister();
        } else if (countPlayers > 2) {
            Output.outputNameAgain();
            String answer = inputString();
            if (!(positive(answer))) {
            	countPlayers = 1;
                playersList.add(player);
            } else {
                arrayNumber++;
                playersList.add(player);
                inputRegister();
            }
        }
        samePlayersList = playersList;
        arraySameNumber = arrayNumber;
    }

    // ввод считалочки
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

    // подсчет слов считалочки
    public static int countWords(String counting) {
        int count = 0;
        Pattern pattern = Pattern.compile("[A-Za-z0-9А-Яа-я]+");
        Matcher matcher = pattern.matcher(counting);
        while (matcher.find())
            count++;
        return count;
    }

    // ввод и вывод параметров и результатов
    public static void inputConditions() {
        Output.outputConditions(playersList, arrayNumber, wordsNumber);
    }

    // ввод выбора режима
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

    // ввод данных для пользовательского режима
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

    // счет в детальном режиме
    public static void mainCount(int startNumber, int stepNumber, String order) {
    	ArrayList<String> forSamePlayersList = new ArrayList<String>(samePlayersList);
        Output.outputstartCounting();
        Output.outputAllPlayers(playersList, arrayNumber);
        int finalNumber = wordsNumber*stepNumber + (startNumber - 1);
        numStep = 1;
        while (arrayNumber > 1) {
            if (order.equals("1")) {
                if(finalNumber % arrayNumber > 0) {
                    outPlayer = playersList.get(finalNumber % arrayNumber - 1);
                    playersList.remove(finalNumber % arrayNumber - 1);
                    finalNumber = (finalNumber % arrayNumber) + wordsNumber*stepNumber - 1;
                } else {
                    outPlayer = playersList.get(arrayNumber - 1);
                    playersList.remove(playersList.size() - 1);
                    finalNumber = wordsNumber*stepNumber;
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
            /// текущее уменьшение массива во время счета
            arrayNumber--;
            /// текущий результат во время счета
            Output.outputTempResult(playersList, arrayNumber, numStep, outPlayer);
            numStep++;
        }
        samePlayersList = forSamePlayersList;
    }

    // ввод и вывод результатов
    public static void inputResult() {
        Output.outputResult(playersList, arrayNumber);
    }

    // перезапуск
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
            	fastPlayersList.clear();
                arrayNumber = 1;
                Counting.start();
            }

        }
    }

    // ввод условий перезапуска
    public static void inputContinue() {
        String countinue = inputString();
        switch (countinue) {
            case ("1"):
            	playersList.clear();
            	arrayNumber = 1;
                Counting.start();
                break;
            case ("2"):
            	playersList = samePlayersList;
                arrayNumber = arraySameNumber;
                Counting.countingDetailSecond();
                break;
            case ("3"):
            	playersList = samePlayersList;
                arrayNumber = arraySameNumber;
                Counting.countingDetailThird();
                break;
            default:
                Output.outputAnswerAgain();
                inputContinue();
        }
    }

  
    
    // тест ввода положительных и отрицательных ответов
    public static boolean positive(String tryPositive) {
        while (tryPositive.equals("") || tryPositive.equals(" ")) {
            Output.outputWhat();
            tryPositive = inputString();
        }
        String maybeYes = "";
        if (!(negativeAnswerList.contains(tryPositive.toLowerCase())) && !(positiveAnswerList.contains(tryPositive.toLowerCase()))) {
            while (!(maybeYes.equals("1") || (maybeYes.equals("2")))) {
                Output.outputAnswer();
                maybeYes = inputString();
                if (!(maybeYes.equals("1") || (maybeYes.equals("2")))) {
                    Output.outputAnswerAgain();
                }
            }
            if (maybeYes.equals("1")) {
            	positiveAnswerList.add(tryPositive.toLowerCase());
                return true;
            } else {
            	negativeAnswerList.add(tryPositive.toLowerCase());
                return false;
            }

        } else if (negativeAnswerList.contains(tryPositive.toLowerCase())) {
            return false;
        }
        return true;
    }

    // тест ввода численных значений
    public static int checkNumber() {
        String number = inputString();
        while (!(number.matches("[0-9]+"))) {
            Output.outputCheckedNumber();
            number = inputString();
        }
        int n = Integer.parseInt(number);
        return n;
    }
    
    // общий шаблон уменьшения массива
    public static void arrayCut(String ArrayName[]) {
        String ArrayCopy[] = new String[ArrayName.length - 1];
        System.arraycopy(ArrayName, 0, ArrayCopy, 0, ArrayCopy.length);
        ArrayName = ArrayCopy;
    }

    // общий шаблон ввода строковых данных
    public static String inputString() {
        Scanner scanString = new Scanner(System.in);
        String s = scanString.nextLine();
        return s;
    }
    
    // method-helpers
    public static void getPositiveAnswersList() {
    	System.out.println("-----------------------------------");
    	for(String answer : positiveAnswerList) {
        	System.out.println(answer);
        }
    	System.out.println("--- " + positiveAnswerList.size() + " ---");
    	System.out.println("-----------------------------------");
    }
    
    public static void getNegativeAnswersList() {
    	System.out.println("-----------------------------------");
    	for(String answer : negativeAnswerList) {
        	System.out.println(answer);
        }
    	System.out.println("--- " + negativeAnswerList.size() + " ---");
    	System.out.println("-----------------------------------");
    }

    public static void getPlayersList() {
    	System.out.println("----------------playersList-------------------");
    	for(String player : playersList) {
        	System.out.println(player);
        }
    	System.out.println("--- " + playersList.size() + " ---");
    	System.out.println("---arrayNumber-------- " + arrayNumber + " ------------------------");
    	System.out.println("-----------------------------------");
    }
    
    public static void getSamePlayersList() {
    	System.out.println("-----------------samePlayersList------------------");
    	for(String player : samePlayersList) {
        	System.out.println(player);
        }
    	System.out.println("--- " + samePlayersList.size() + " ---");
    	
    	System.out.println("---arraySameNumber-------- " + arraySameNumber + " ------------------------");
    	System.out.println("-----------------------------------");
    }
}
