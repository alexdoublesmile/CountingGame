import java.util.ArrayList;
import java.util.HashSet;

public class ConsoleView implements View {

	@ Override
    public void outputStart() {
        System.out.println("� ����� ���������� ������������� �������?");
        System.out.println("- 1 - ������� �������");
        System.out.println("- 2 - ��������� �������");
    }

	@ Override
    public void outputFastCountRules() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------------- ������� -----------------------------");
        System.out.println("��������� ������������� � ����� �������");
        System.out.println("��� ��������� ������, ���� ���� �� ���������� � ��� �� �����");
        System.out.println("----------------------------------------------------------------");
    }

    @ Override
    public void outputGreetings() {
        System.out.println("*** ������������ � ����� ������������������ ���������� (��-1)! ***");
        System.out.println("----------------------------------------------------------------");
    }

    @ Override
    public void outputEnterPlayersFastCount() {
        System.out.println("������� ���������� ����������: ");
    }

    @ Override
    public void outputEnterCountingFastCount() {
        System.out.println("������� ���������� ���� � ����������: ");
    }

    @ Override
    public void outputResultFastCount(ArrayList<Integer> arrayName) {
        for (int i : arrayName) {
            System.out.print("��������: " + i);
            System.out.println("");
        }
    }
    
    @ Override
    public void outputEnterName(int n) {
        System.out.println("������� ��� " + n + " ������: ");
    }


    @ Override
    public  void outputMorePlayers() {
        System.out.println("����� �� ��� ������?");
    }


    @ Override    
    public  void outputEnterCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("������� ���������� ��� ���������� ���� � ���: ");
    }

    @ Override
    public  void outputCountCheck(int n) {
        System.out.println("���-�� ���� � ����������: " + n + ". �����?");
    }

    @ Override
    public  void outputCountCheckAgain(int n) {
        System.out.println("..����� ����� " + (n - 1) + "?");
    }

    @ Override
    public  void outputEnterCountingAgain() {
        System.out.println("������� ��� ����� ���� ���������� (�� ��������� � ��������)");
        System.out.println(".. �� ��� ������ ������� ���������� ���� � ���: ");
    }

    @ Override
    public  void outputstartCounting(int n, int i) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("�������� � ������ �" + n + ", ");
        System.out.println("    ���� ����� � ����� \"" + i + "\"(�.�. ��������� ������ " + i + ")");
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------   �������!!!  -----------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
    }

    @ Override
    public void outputAllPlayers(ArrayList<String> arrayName, int w) {
        System.out.println("��� ���������(������� �� " + w + "): ");
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
        System.out.println("��������� ������� " + arrayName.size() + " �������:  ");
        int n = 1;
        for (String s : arrayName) {
        	System.out.println("  " + n + ") \"" + s + "\"");
        	n++;
        }
        System.out.println("");
        System.out.println("� ���-�� ���� � ���������� = " + wordsNumber + ".");
        System.out.println("");
        System.out.println("");
    }

    @ Override
    public  void outputChooseGameMode() {
        System.out.println("��� ����� �������?");
        System.out.println("- 1 - ��� ����� �������. ������� �� ������ �� ����� �������");
        System.out.println("- 2 - ��� ����� � ���. ������� ������ ��� � ������ ����");
        System.out.println("- 3 - ���� �������");
        /*
        System.out.println("- 4 - New rules");
        */
    }

    @ Override
    public  void outputSetCountStartNumber() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("����� ������� ���� �������, ������� ������ �������������� ������ ");
        System.out.println("");
        System.out.println("������� ����� ���������, � �������� �������� ����: ");
    }

    @ Override
    public  void outputSetCountStepNumber() {
        System.out.println("������� ���, � ������� ������� ����� ����: ");
    }

    @ Override
    public  void outputSetCountOrder() {
        System.out.println("�������� ������� ����� ����� ������ ������ �� ����������:");
        System.out.println("- 1 - ������� � ���������, ���������� �� ����������");
        System.out.println("- 2 - ������� ������ ��� � ������ �������");
    }

    @ Override
    public  void outputTempResult(ArrayList<String> arrayName, int num, String out) {
        if(!(arrayName.size() == 1)) {
            System.out.println("��� " + num + ". ��������: " + out);
            System.out.println("��������: ");
            int n = 1;
            for (String s : arrayName) {
            	System.out.println("  " + n + ") \"" + s + "\"");
            	n++;
            }
            System.out.println("");
            System.out.println("");
        } else {
            System.out.println("��� ���������. ������� " + arrayName.get(0) + ".");
            System.out.println("");
        }
    }

    @ Override
    public  void outputResult(ArrayList<String> arrayName) {
        for (String s : arrayName) {
            System.out.print("* ����������� ���, " + s + ". �� - ����������! *");
        }
        System.out.println("");
    }

    @ Override
    public void outputPlayAgain() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("������� ���?");
    }

    @ Override
    public void outputChooseContinue() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("� ������ ����� �� ������ �� ���������?");
        System.out.println("- 1 - ���� ������� � ������ ������");
        System.out.println("- 2 - ������ � ���� �� �����������");
        System.out.println("- 3 - ������ � ���� �� ����������� � ��� �� �����������");
    }

    @ Override
    public void outputAgainFromBegin() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("* �������! ������� �������! :) *");
        System.out.println("");
    }
    
    @ Override
    public void outputAgainWithMyTeam() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("* ��� ����� � ���� �� �����������! *");
        System.out.println("");
    }
    
    @ Override
    public void outputFinal() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("*** ������� �� ����. ��������� ���! :) ***");
    }

    @ Override
    public void outputIncorrectAnswer() {
        System.out.println("�� ������ ������� ��� �����.. ��� �������� \"��\" ?");
        System.out.println("- 1 - ��");
        System.out.println("- 2 - ���");
    }

    @ Override
    public void outputIncorrectChoose() {
        System.out.println("��������, ����������, ���� �� ������������ ��������");
    }

    @ Override
    public void outputWhat() {
        System.out.println("�������, ����������, ���-�� ����� ������� :)");
    }

    @ Override
    public void outputCheckedNumber() {
        System.out.println("�������, ���������, �������� � ���� �����");
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
