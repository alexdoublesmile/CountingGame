import java.util.ArrayList;

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
        for (int i = 0; i < 1; i++) {
            System.out.print("��������: " + arrayName.get(i));
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
    public  void outputstartCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------   �������!!!  -----------------------------");
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
        System.out.print("��������� ������� " + arrayNumber + " �������:  ");
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print(arrayName.get(i) + "  ");
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
    public  void outputTempResult(ArrayList<String> arrayName, int arrayNumber, int num, String out) {
        if(!(arrayNumber == 1)) {
            System.out.println("��� " + num + ". ��������: " + out);
            System.out.println("��������: ");
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
            System.out.println("��� ���������. ������� " + arrayName.get(0) + ".");
            System.out.println("");
        }
    }

    @ Override
    public  void outputResult(ArrayList<String> arrayName, int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("* ����������� ���, " + arrayName.get(i) + ". �� - ����������! *");
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
}
