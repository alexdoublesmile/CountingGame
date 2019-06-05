import java.util.ArrayList;

public class ConsoleView implements View {

	@ Override
    public void outputStart() {
        System.out.println("В какую считалочку предпочитаете сыграть?");
        System.out.println("- 1 - Быстрый вариант");
        System.out.println("- 2 - Детальный вариант");
    }

	@ Override
    public void outputFastCountRules() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------------- Правила -----------------------------");
        System.out.println("Участники пронумерованы и стоят кружком");
        System.out.println("При выбывании одного, счет идет со следующего и так до конца");
        System.out.println("----------------------------------------------------------------");
    }

    @ Override
    public void outputGreetings() {
        System.out.println("*** Приветствуем в нашей Автоматизированной Считалочке (АС-1)! ***");
        System.out.println("----------------------------------------------------------------");
    }

    @ Override
    public void outputEnterPlayersFastCount() {
        System.out.println("Введите количество участников: ");
    }

    @ Override
    public void outputEnterCountingFastCount() {
        System.out.println("Введите количество слов в считалочке: ");
    }

    @ Override
    public void outputResultFastCount(ArrayList<Integer> arrayName) {
        for (int i = 0; i < 1; i++) {
            System.out.print("Остается: " + arrayName.get(i));
            System.out.println("");
        }
    }
    
    @ Override
    public void outputEnterName(int n) {
        System.out.println("Введите имя " + n + " игрока: ");
    }


    @ Override
    public  void outputMorePlayers() {
        System.out.println("Будут ли еще игроки?");
    }


    @ Override    
    public  void outputEnterCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Введите считалочку или количество слов в ней: ");
    }

    @ Override
    public  void outputCountCheck(int n) {
        System.out.println("Кол-во слов в считалочке: " + n + ". Верно?");
    }

    @ Override
    public  void outputCountCheckAgain(int n) {
        System.out.println("..может тогда " + (n - 1) + "?");
    }

    @ Override
    public  void outputEnterCountingAgain() {
        System.out.println("Введите еще разок Вашу считалочку (не забывайте о пробелах)");
        System.out.println(".. ну или просто введите количество слов в ней: ");
    }

    @ Override
    public  void outputstartCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------   Поехали!!!  -----------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
    }

    @ Override
    public void outputAllPlayers(ArrayList<String> arrayName, int arrayNumber) {
        for (String i : arrayName) {
        	System.out.print(i + "  ");
        } 
        System.out.println("");
        System.out.println("");
    }

    @ Override
    public  void outputConditions(ArrayList<String> arrayName, int arrayNumber, int wordsNumber) {
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

    @ Override
    public  void outputChooseGameMode() {
        System.out.println("Как будем считать?");
        System.out.println("- 1 - Все стоят кружком. Считаем от начала до конца навылет");
        System.out.println("- 2 - Все стоят в ряд. Считаем каждый раз с начала ряда");
        System.out.println("- 3 - Свои правила");
        /*
        System.out.println("- 4 - New rules");
        */
    }

    @ Override
    public  void outputSetCountStartNumber() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Чтобы создать свои правила, следует ввести дополнительные данные ");
        System.out.println("");
        System.out.println("Введите номер участника, с которого начинать счет: ");
    }

    @ Override
    public  void outputSetCountStepNumber() {
        System.out.println("Введите шаг, с которым следует вести счет: ");
    }

    @ Override
    public  void outputSetCountOrder() {
        System.out.println("Выберите порядок счета после вылета одного из участников:");
        System.out.println("- 1 - считать с участника, следующего за вылетающим");
        System.out.println("- 2 - считать каждый раз с начала очереди");
    }

    @ Override
    public  void outputTempResult(ArrayList<String> arrayName, int arrayNumber, int num, String out) {
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

    @ Override
    public  void outputResult(ArrayList<String> arrayName, int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("* Поздравляем Вас, " + arrayName.get(i) + ". Вы - победитель! *");
        }
        System.out.println("");
    }

    @ Override
    public void outputPlayAgain() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Сыграем еще?");
    }

    @ Override
    public void outputChooseContinue() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("С какого места Вы хотели бы повторить?");
        System.out.println("- 1 - Хочу сыграть с самого начала");
        System.out.println("- 2 - Играть с теми же участниками");
        System.out.println("- 3 - Играть с теми же участниками и той же считалочкой");
    }

    @ Override
    public void outputAgainFromBegin() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("* Отлично! Поехали сначала! :) *");
        System.out.println("");
    }
    
    @ Override
    public void outputAgainWithMyTeam() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("* Еще разок с теми же участниками! *");
        System.out.println("");
    }
    
    @ Override
    public void outputFinal() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("*** Спасибо за игру. Приходите еще! :) ***");
    }

    @ Override
    public void outputIncorrectAnswer() {
        System.out.println("Не совсем понятен Ваш ответ.. Это означает \"Да\" ?");
        System.out.println("- 1 - Да");
        System.out.println("- 2 - Нет");
    }

    @ Override
    public void outputIncorrectChoose() {
        System.out.println("Выберите, пожалуйста, одно из предложенных значений");
    }

    @ Override
    public void outputWhat() {
        System.out.println("Введите, пожалуйста, что-то более внятное :)");
    }

    @ Override
    public void outputCheckedNumber() {
        System.out.println("Введите, пожлуйста, значение в виде числа");
    }
}
