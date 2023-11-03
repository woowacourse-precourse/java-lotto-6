package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Prize {
    private String groupNumbers;
    private int luckyCounts;
    private List<Integer> separatedLotto;
    public static List<Integer> luckyNumber;
    public static int bonusNumber;

    void inputNumbers() {
        groupNumbers = Console.readLine();
    }

    void cutNumbers() {
        String[] separatedNumbers = groupNumbers.split(",");

        for (int i = 0; i < separatedNumbers.length; i++) {
            luckyNumber.add(Integer.parseInt(separatedNumbers[i]));
        }
    }

    void inputBonusNumber() {
        String number = Console.readLine();
        bonusNumber = Integer.parseInt(number);
    }

    void checkNumbers() {
        for (int j = 0; j < separatedLotto.size(); j++) {
            if (separatedLotto.contains(luckyNumber.get(j))) {
                luckyCounts += 1;
            }
        }
    }
}
