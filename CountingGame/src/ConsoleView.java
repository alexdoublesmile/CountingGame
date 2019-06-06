import java.util.ArrayList;
import java.util.HashSet;

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
        for (int i : arrayName) {
            System.out.print("Остается: " + i);
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
    public  void outputstartCounting(int n, int i) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Начинаем с игрока №" + n + ", ");
        System.out.println("    счет ведем с шагом \"" + i + "\"(т.е. считается каждый " + i + ")");
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------   Поехали!!!  -----------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
    }

    @ Override
    public void outputAllPlayers(ArrayList<String> arrayName, int w) {
        System.out.println("Все участники(считаем до " + w + "): ");
    	int n = 1;
        for (String s : arrayName) {
        	System.out.println("  " + n + ") \"" + s + "\"");
        	n++;
        }
        System.out.println("");
        System.out.println("");
    }

    @ Override
    public  void outputConditions(ArrayList<String> arrayName, int wordsNumber) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Принимают участие " + arrayName.size() + " игроков:  ");
        int n = 1;
        for (String s : arrayName) {
        	System.out.println("  " + n + ") \"" + s + "\"");
        	n++;
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
    public  void outputTempResult(ArrayList<String> arrayName, int num, String out) {
        if(!(arrayName.size() == 1)) {
            System.out.println("Шаг " + num + ". Вылетает: " + out);
            System.out.println("Остаются: ");
            int n = 1;
            for (String s : arrayName) {
            	System.out.println("  " + n + ") \"" + s + "\"");
            	n++;
            }
            System.out.println("");
            System.out.println("");
        } else {
            System.out.println("Шаг последний. Остаётся " + arrayName.get(0) + ".");
            System.out.println("");
        }
    }

    @ Override
    public  void outputResult(ArrayList<String> arrayName) {
        for (String s : arrayName) {
            System.out.print("* Поздравляем Вас, " + s + ". Вы - победитель! *");
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
    
    @ Override
    public void showFinalNumber(Calculate calculate) {
		System.out.println("-------------------------------------------------");
	    System.out.println("showFinalNumber: " + calculate.getFinalNumber());
	    System.out.println("-------------------------------------------------");
	}
    
    @ Override
    public void showNumStep(Calculate calculate) {
		System.out.println("-------------------------------------------------");
	    System.out.println("showNumStep: " + calculate.getNumStep());
	    System.out.println("-------------------------------------------------");
	}
    
    @ Override
    public void showOutPlayer(Calculate calculate) {
		System.out.println("-------------------------------------------------");
	    System.out.println("showOutPlayer: " + calculate.getOutPlayer());
	    System.out.println("-------------------------------------------------");
	}
    
    @ Override
    public void showCountOrder(Calculate calculate) {
		System.out.println("-------------------------------------------------");
	    System.out.println("showCountOrder: " + calculate.getCountOrder());
	    System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showPlayersList(Players players) {
        System.out.println("-------------------------------------------------");
        System.out.println("PlayersList: ");
		for (String i : players.getPlayersList()) {
			System.out.println(i + " ");
		}
		System.out.println("");
		System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showInitialPlayersList(Players players) {
        System.out.println("-------------------------------------------------");
        System.out.println("initialPlayersList: ");
		for (String i : players.getInitialPlayersList()) {
			System.out.println(i + " ");
		}
		System.out.println("");
		System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showFastCountPlayersList(Players players) {
        System.out.println("-------------------------------------------------");
        System.out.println("FastPlayersList: ");
		for (int i : players.getFastCountPlayersList()) {
			System.out.println(i + " ");
		}
		System.out.println("-------------------------------------------------");
	}
    
    @ Override
	public void showSomeString(Words words) {
		System.out.println("-----------------------------------");
		System.out.println("SomeString is " + words.getSomeString());
		System.out.println("-----------------------------------");
	}
	
    @ Override
	public void showSomeNumber(Words words) {
		System.out.println("-----------------------------------");
		System.out.println("SomeNumber is " + words.getSomeNumber());
		System.out.println("-----------------------------------");
	}
	
    @ Override
	public void showWordsNumber(Words words) {
		System.out.println("-----------------------------------");
		System.out.println("WordsNumber is " + words.getWordsNumber());
		System.out.println("-----------------------------------");
	}
	
    @ Override
	public void showAnswer(Answers answer) {
		System.out.println("-----------------------------------");
		System.out.println("Answer is " + answer.getAnswer());
		System.out.println("-----------------------------------");
	}
	
    @ Override
	public void showConfirmationAnswer(Answers answer) {
		System.out.println("-----------------------------------");
		System.out.println("ConfirmationAnswer is " + answer.getConfirmationAnswer());
		System.out.println("-----------------------------------");
	}
	
    @ Override
	public void showPositiveAnswerList(Answers answer) {
        System.out.println("-------------------------------------------------");
        System.out.println("positiveAnswerList: ");
        for (String s : answer.getPositiveAnswerList()) {
        	System.out.println(s);
        }
		System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showNegativeAnswerList(Answers answer) {
        System.out.println("-------------------------------------------------");
        System.out.println("negativeAnswerList: ");
        for (String s : answer.getNegativeAnswerList()) {
        	System.out.println(s);
        }
		System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showString(String name, String value) {
		System.out.println("-------------------------------------------------");
	    System.out.println(name + " is: " + value);
	    System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showNumber(String name, int value) {
		System.out.println("-------------------------------------------------");
	    System.out.println(name + " is: " + value);
	    System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showBoolean(String name, boolean value) {
		System.out.println("-------------------------------------------------");
	    System.out.println(name + " is: " + value);
	    System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showIntArrayList(String name, ArrayList<Integer> value) {
		int n = 1;
        System.out.println("-------------------------------------------------");
        System.out.println(name + " includes: ");
        for (int i : value) {
        	System.out.println("  " + n + ") \"" + i + "\".");
        	n++;
        }
		System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showStringArrayList(String name, ArrayList<String> value) {
		int n = 1;
        System.out.println("-------------------------------------------------");
        System.out.println(name + " includes: ");
        for (String s : value) {
        	System.out.println("  " + n + ") \"" + s + "\".");
        	n++;
        }
		System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showStringHashSet(String name, HashSet<String> value) {
		int n = 1;
        System.out.println("-------------------------------------------------");
        System.out.println(name + " includes: ");
        for (String s : value) {
        	System.out.println("  " + n + ") \"" + s + "\".");
        	n++;
        }
		System.out.println("-------------------------------------------------");
	}
	
    @ Override
	public void showIntHashSet(String name, HashSet<Integer> value) {
		int n = 1;
        System.out.println("-------------------------------------------------");
        System.out.println(name + " includes: ");
        for (int i : value) {
        	System.out.println("  " + n + ") \"" + i + "\".");
        	n++;
        }
		System.out.println("-------------------------------------------------");
	}
}
