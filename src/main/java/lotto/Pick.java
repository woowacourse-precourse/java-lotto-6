package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Pick {
    private static String groupNumbers;
    public static int bonusNumber;
    public static List<Integer> luckyNumber = new ArrayList<Integer>();

    static void inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        groupNumbers = Console.readLine();
        System.out.println();
    }

    static void cutNumbers() {
        String[] separatedNumbers = groupNumbers.split(",");

        for (int i = 0; i < separatedNumbers.length; i++) {
            luckyNumber.add(Integer.parseInt(separatedNumbers[i]));
        }
    }

    static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String number = Console.readLine();
        bonusNumber = Integer.parseInt(number);
        System.out.println();
    }
    
    public static void playPick() {
        inputNumbers();
        cutNumbers();
        inputBonusNumber();
    }

}
