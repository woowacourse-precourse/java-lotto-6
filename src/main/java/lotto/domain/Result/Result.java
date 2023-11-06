package lotto.domain.Result;

import lotto.domain.Lotto.Lotto;
import lotto.domain.WinningNumber.WinningNumber;

import java.util.List;

public class Result {
    private static final int INITIAL_VALUE = 0;
    private static final int FIRST_PRIZE = 2000000000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int FORTH_PRIZE = 50000;
    private static final int FIFTH_PRIZE = 5000;

    private int firstRank = INITIAL_VALUE;
    private int secondRank = INITIAL_VALUE;
    private int thirdRank = INITIAL_VALUE;
    private int forthRank = INITIAL_VALUE;
    private int fifthRank = INITIAL_VALUE;

    private List<Lotto> lotties;
    private WinningNumber winningNumber;
    private double profit;

    public void printResult(List<Lotto> lotties, WinningNumber winningnumber) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        this.lotties = lotties;
        this.winningNumber = winningnumber;
        setAllRank();
        printRankResult();
        calculateProfit();
        printProfit();
    }

    private void setAllRank() {
        for (int i = 0; i < lotties.size(); i++) {
            setRank(lotties.get(i).getNumbers());
        }
    }

    private void setRank(List<Integer> numbers) {
        int matchNumberCount = INITIAL_VALUE;
        boolean matchBonus = false;
        for (int i = 0; i < numbers.size(); i++) {
            if (matchNumber(numbers.get(i))) {
                matchNumberCount++;
            }
            if (matchBonusNumber(numbers.get(i))) {
                matchBonus = true;
            }
        }
        setRankDetail(matchNumberCount, matchBonus);
    }

    private void setRankDetail(int matchNumberCount, boolean matchBonus) {
        if (matchNumberCount == 6) {
            firstRank++;
            return;
        }
        if (matchNumberCount == 5 && matchBonus) {
            secondRank++;
            return;
        }
        if (matchNumberCount == 5) {
            thirdRank++;
            return;
        }
        if (matchNumberCount == 4) {
            forthRank++;
            return;
        }
        if (matchNumberCount == 3) {
            fifthRank++;
            return;
        }
    }

    private boolean matchNumber(int num) {
        if (winningNumber.getWinningNumbers().contains(num)) {
            return true;
        }
        return false;
    }


    private boolean matchBonusNumber(int num) {
        if (winningNumber.getBonusNumber() == num) {
            return true;
        }
        return false;
    }

    private void printRankResult() {
        System.out.println("3개 일치 (5,000원) - " + fifthRank + "개");
        System.out.println("4개 일치 (50,000원) - " + forthRank + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdRank + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondRank + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstRank + "개");
    }

    private void calculateProfit() {
        int totalProfit =
                firstRank * FIRST_PRIZE + secondRank * SECOND_PRIZE + thirdRank * THIRD_PRIZE + forthRank * FORTH_PRIZE + fifthRank * FIFTH_PRIZE;
        int totalExpenditure = lotties.size() * 1000;
        this.profit = ((double)totalProfit / totalExpenditure) * 100;
    }

    private void printProfit() {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }


}
