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

    void printPrize() {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + finalResult[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + finalResult[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + finalResult[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + finalResult[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + finalResult[0] + "개");
    }
}
