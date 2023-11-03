package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Prize {
    private String groupNumbers;
    private int bonusCounts;
    private int luckyCounts;
    private int[] finalResult = new int[5];
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

    void separateNumbers() {
        for (int i = 0; i < Issue.lottoGroup.size(); i++) {
            separatedLotto = Issue.lottoGroup.get(i);

            checkNumbers();
            winPrize();
        }
    }

    void checkNumbers() {
        for (int j = 0; j < separatedLotto.size(); j++) {
            if (separatedLotto.contains(luckyNumber.get(j))) {
                luckyCounts += 1;
            }

            if (separatedLotto.contains((bonusNumber))) {
                bonusCounts += 1;
            }
        }
    }

    void winPrize() {
        if (luckyCounts == 6) {
            finalResult[0] += 1;
        }

        else if (luckyCounts == 5 && bonusCounts == 1) {
            finalResult[1] += 1;
        }

        else if (luckyCounts == 5 && bonusCounts == 0) {
            finalResult[2] += 1;
        }

        else if (luckyCounts == 4) {
            finalResult[3] += 1;
        }

        else if (luckyCounts == 3) {
            finalResult[4] += 1;
        }
    }
}
