package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Pick {
    public static List<Integer> luckyNumber = new ArrayList<Integer>();
    public static int bonusNumber;
    static String[] separatedNumbers;
    private static String groupNumbers;

    static void inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                luckyNumber = new ArrayList<Integer>();
                groupNumbers = Console.readLine();

                cutNumbers();
                raiseInvalidNumbersException();
                raiseDuplicateNumbersException();
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
                raiseNumberRangeException();
                break;
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] 1~45 범위의 숫자를 입력해야 합니다.");
            }
        }

        System.out.println();
    }
    
    public static void playPick() {
        inputNumbers();
        inputBonusNumber();
    }

    private static void raiseInvalidNumbersException() {
        if (luckyNumber.size() != Issue.NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException();
        }
    }

    private static void raiseDuplicateNumbersException() {
        if(luckyNumber.size() != luckyNumber.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }

    private static void raiseNumberRangeException() {
        if (bonusNumber > Issue.MAXIMUM_OF_NUMBER || bonusNumber < Issue.MINIMUM_OF_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
