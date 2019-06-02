import java.util.ArrayList;

public class Output {

    public static void outputStart() {
        System.out.println("� ����� ���������� ������������� �������?");
        System.out.println("- 1 - ������� �������");
        System.out.println("- 2 - ��������� �������");
    }

    public static void outputFastCountRules() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------------- ������� -----------------------------");
        System.out.println("��������� ������������� � ����� �������");
        System.out.println("��� ��������� ������, ���� ���� �� ���������� � ��� �� �����");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputGreetings() {
        System.out.println("*** ������������ � ����� ������������������ ���������� (��-1)! ***");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputEnterName(int n) {
        System.out.println("������� ��� " + n + " ������: ");
    }

    public static void outputMorePlayers() {
        System.out.println("����� �� ��� ������?");
    }

    public static void outputEnterPlayersFastCount() {
        System.out.println("������� ���������� ����������: ");
    }

    public static void outputEnterCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("������� ���������� ��� ���������� ���� � ���: ");
    }

    public static void outputCountCheck(int n) {
        System.out.println("���-�� ���� � ����������: " + n + ". �����?");
    }

    public static void outputCountCheckAgain(int n) {
        System.out.println("..����� ����� " + (n - 1) + "?");
    }

    public static void outputEnterCountingAgain() {
        System.out.println("������� ��� ����� ���� ���������� (�� ��������� � ��������)");
        System.out.println(".. �� ��� ������ ������� ���������� ���� � ���: ");
    }

    public static void outputEnterCountingFastCount() {
        System.out.println("������� ���������� ���� � ����������: ");
    }

    public static void outputstartCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------   �������!!!  -----------------------------");
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
        System.out.print("��������� ������� " + arrayNumber + " �������:  ");
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print(arrayName.get(i) + "  ");
        }
        System.out.println("");
        System.out.println("� ���-�� ���� � ���������� = " + wordsNumber + ".");
        System.out.println("");
        System.out.println("");
    }

    public static void outputChooseGameMode() {
        System.out.println("��� ����� �������?");
        System.out.println("- 1 - ��� ����� �������. ������� �� ������ �� ����� �������");
        System.out.println("- 2 - ��� ����� � ���. ������� ������ ��� � ������ ����");
        System.out.println("- 3 - ���� �������");

    }

    public static void outputEnterUserSettings() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("����� ������� ���� �������, ������� ������ �������������� ������ ");
        System.out.println("");
        System.out.println("������� ����� ���������, � �������� �������� ����: ");
    }

    public static void outputEnterUserSettingsStep() {
        System.out.println("������� ���, � ������� ������� ����� ����: ");
    }

    public static void outputEnterUserGameMode() {
        System.out.println("�������� ������� ����� ����� ������ ������ �� ����������:");
        System.out.println("- 1 - ������� � ���������, ���������� �� ����������");
        System.out.println("- 2 - ������� ������ ��� � ������ �������");
    }

    public static void outputTempResult(ArrayList<String> arrayName, int arrayNumber, int num, String out) {
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

    public static void outputResult(ArrayList<String> arrayName, int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("* ����������� ���, " + arrayName.get(i) + ". �� - ����������! *");
        }
        System.out.println("");
    }

    public static void outputResultFastCount(ArrayList<Integer> arrayName, int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("��������: " + arrayName.get(i));
            System.out.println("");
        }
    }

    public static void outputPlayAgain() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("������� ���?");
    }

    public static void outputChooseContinue() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("� ������ ����� �� ������ �� ���������?");
        System.out.println("- 1 - ���� ������� � ������ ������");
        System.out.println("- 2 - ������ � ���� �� �����������");
        System.out.println("- 3 - ������ � ���� �� ����������� � ��� �� �����������");
    }

    public static void outputFinal() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("*** ������� �� ����. ��������� ���! :) ***");
    }

    public static void outputAnswer() {
        System.out.println("�� ������ ������� ��� �����.. ��� �������� \"��\" ?");
        System.out.println("- 1 - ��");
        System.out.println("- 2 - ���");
    }

    public static void outputAnswerAgain() {
        System.out.println("��������, ����������, ���� �� ������������ ��������");
    }

    public static void outputWhat() {
        System.out.println("�������, ����������, ���-�� ����� ������� :)");
    }

    public static void outputCheckedNumber() {
        System.out.println("�������, ���������, �������� � ���� �����");
    }
}
