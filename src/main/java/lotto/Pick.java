package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Pick {
    private static String groupNumbers;
    public static int bonusNumber;
    static String[] separatedNumbers;
    public static List<Integer> luckyNumber = new ArrayList<Integer>();

    static void inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                groupNumbers = Console.readLine();
                cutNumbers();
                break;
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해야 합니다.");
            }
        }

        System.out.println();
    }

    static void cutNumbers() {
        separatedNumbers = groupNumbers.split(",");

        for (int i = 0; i < separatedNumbers.length; i++) {
            luckyNumber.add(Integer.parseInt(separatedNumbers[i]));
        }
    }

    static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                bonusNumber = Integer.parseInt(Console.readLine());
                break;
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해야 합니다.");
            }
        }

        System.out.println();
    }
    
    public static void playPick() {
        inputNumbers();
        inputBonusNumber();
    }

}
