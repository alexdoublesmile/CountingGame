import java.util.ArrayList;

public class Output {

    public static void outputStart() {
        System.out.println("В какую считалочку предпочитаете сыграть?");
        System.out.println("- 1 - Быстрый вариант");
        System.out.println("- 2 - Детальный вариант");
    }

    public static void outputFastCountRules() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------------- Правила -----------------------------");
        System.out.println("Участники пронумерованы и стоят кружком");
        System.out.println("При выбывании одного, счет идет со следующего и так до конца");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputGreetings() {
        System.out.println("*** Приветствуем в нашей Автоматизированной Считалочке (АС-1)! ***");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputEnterName(int n) {
        System.out.println("Введите имя " + n + " игрока: ");
    }

    public static void outputMorePlayers() {
        System.out.println("Будут ли еще игроки?");
    }

    public static void outputEnterPlayersFastCount() {
        System.out.println("Введите количество участников: ");
    }

    public static void outputEnterCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Введите считалочку или количество слов в ней: ");
    }

    public static void outputCountCheck(int n) {
        System.out.println("Кол-во слов в считалочке: " + n + ". Верно?");
    }

    public static void outputCountCheckAgain(int n) {
        System.out.println("..может тогда " + (n - 1) + "?");
    }

    public static void outputEnterCountingAgain() {
        System.out.println("Введите еще разок Вашу считалочку (не забывайте о пробелах)");
        System.out.println(".. ну или просто введите количество слов в ней: ");
    }

    public static void outputEnterCountingFastCount() {
        System.out.println("Введите количество слов в считалочке: ");
    }

    public static void outputstartCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------   Поехали!!!  -----------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
    }

    public static void outputAllPlayers(ArrayList<String> arrayName, int arrayNumber) {
        for (String i : arrayName) {
        	System.out.print(i + "  ");
        } 
        System.out.println("");
        System.out.println("");
    }

    public static void outputConditions(ArrayList<String> arrayName, int arrayNumber, int wordsNumber) {
        System.out.println("----------------------------------------------------------------");
        System.out.print("Принимают участие " + arrayNumber + " игроков:  ");
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print(arrayName.get(i) + "  ");
        }
        System.out.println("");
        System.out.println("А кол-во слов в считалочке = " + wordsNumber + ".");
        System.out.println("");
        System.out.println("");
    }

    public static void outputChooseGameMode() {
        System.out.println("Как будем считать?");
        System.out.println("- 1 - Все стоят кружком. Считаем от начала до конца навылет");
        System.out.println("- 2 - Все стоят в ряд. Считаем каждый раз с начала ряда");
        System.out.println("- 3 - Свои правила");

    }

    public static void outputEnterUserSettings() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Чтобы создать свои правила, следует ввести дополнительные данные ");
        System.out.println("");
        System.out.println("Введите номер участника, с которого начинать счет: ");
    }

    public static void outputEnterUserSettingsStep() {
        System.out.println("Введите шаг, с которым следует вести счет: ");
    }

    public static void outputEnterUserGameMode() {
        System.out.println("Выберите порядок счета после вылета одного из участников:");
        System.out.println("- 1 - считать с участника, следующего за вылетающим");
        System.out.println("- 2 - считать каждый раз с начала очереди");
    }

    public static void outputTempResult(ArrayList<String> arrayName, int arrayNumber, int num, String out) {
        if(!(arrayNumber == 1)) {
            System.out.println("Шаг " + num + ". Вылетает: " + out);
            System.out.println("Остаются: ");
            for (int i = 0; i < arrayNumber; i++) {
                if(i == arrayNumber - 1) {
                    System.out.print(arrayName.get(i) + ".");
                } else {
                    System.out.print(arrayName.get(i) + ", ");
                }
            }
            System.out.println("");
            System.out.println("");
        } else {
            System.out.println("Шаг последний. Остаётся " + arrayName.get(0) + ".");
            System.out.println("");
        }
    }

    public static void outputResult(ArrayList<String> arrayName, int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("* Поздравляем Вас, " + arrayName.get(i) + ". Вы - победитель! *");
        }
        System.out.println("");
    }

    public static void outputResultFastCount(ArrayList<Integer> arrayName, int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("Остается: " + arrayName.get(i));
            System.out.println("");
        }
    }

    public static void outputPlayAgain() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Сыграем еще?");
    }

    public static void outputChooseContinue() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("С какого места Вы хотели бы повторить?");
        System.out.println("- 1 - Хочу сыграть с самого начала");
        System.out.println("- 2 - Играть с теми же участниками");
        System.out.println("- 3 - Играть с теми же участниками и той же считалочкой");
    }

    public static void outputFinal() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("*** Спасибо за игру. Приходите еще! :) ***");
    }

    public static void outputAnswer() {
        System.out.println("Не совсем понятен Ваш ответ.. Это означает \"Да\" ?");
        System.out.println("- 1 - Да");
        System.out.println("- 2 - Нет");
    }

    public static void outputAnswerAgain() {
        System.out.println("Выберите, пожалуйста, одно из предложенных значений");
    }

    public static void outputWhat() {
        System.out.println("Введите, пожалуйста, что-то более внятное :)");
    }

    public static void outputCheckedNumber() {
        System.out.println("Введите, пожлуйста, значение в виде числа");
    }
}
