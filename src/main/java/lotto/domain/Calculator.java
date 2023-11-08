package lotto.domain;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.MatchingCounts;
import lotto.model.Purchase;

public class Calculator {
    private static final int MINIMUM_COUNT_FOR_PRIZE = 3;
    private static final int REQUIRED_COUNT_FOR_BONUS = 5;
    private static final int NUMBER_OF_PRIZES = 5;

    public Calculator() {
    }

    public void calculateWinningLottoResults(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers) {
        for (List<Integer> numbers : lottoNumbers) {
            countMatchingNumbers(numbers, winningNumbers);
        }
    }

    private boolean isMatch(int number, List<Integer> winningNumbers) {
        return winningNumbers.contains(number);
    }

    private boolean hasReachedCount5(int count) {
        return count == REQUIRED_COUNT_FOR_BONUS;
    }

    private void handleMatchingCounts(int count, boolean isCount5) {
        if (count >= MINIMUM_COUNT_FOR_PRIZE && !isCount5) {
            MatchingCounts.displayWinningInfo(count, 0);
        }
    }

    private void countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = countMatches(lottoNumbers, winningNumbers);
        boolean isCount5 = hasReachedCount5(count);
        handleMatchingCounts(count, isCount5);

        if (isCount5) {
            countBonusNumbers(lottoNumbers, count);
        }
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;

        for (int number : lottoNumbers) {
            if (isMatch(number, winningNumbers)) {
                count++;
            }
        }

        return count;
    }

    private void countBonusNumbers(List<Integer> lottoNumbers, int count) {
        int bonus = 0;

        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber == BonusNumber.getBonusNumber()) {
                bonus++;
            }
        }

        MatchingCounts.displayWinningInfo(count, bonus);
    }

    public static String calculateProfitPercentage(MatchingCounts matchingCounts) {
        Prize[] prizes = {
                Prize.MATCH_3,
                Prize.MATCH_4,
                Prize.MATCH_5,
                Prize.MATCH_5_PLUS_BONUS,
                Prize.MATCH_6
        };

        int lineLottoTotal = calculateLineLottoTotal(prizes, matchingCounts);
        double profit = calculateProfit(lineLottoTotal);
        return formatProfit(profit);
    }

    private static int calculateLineLottoTotal(Prize[] prizes, MatchingCounts matchingCounts) {
        int lineLottoTotal = 0;

        for (int i = 0; i < NUMBER_OF_PRIZES; i++) {
            lineLottoTotal += prizes[i].getPrizeAmount() * matchingCounts.getMatchingCount().get(i);
        }

        return lineLottoTotal;
    }

    private static double calculateProfit(int lineLottoTotal) {
        double purchaseAmount = Purchase.getPurchaseAmount();
        return (double) lineLottoTotal / purchaseAmount * 100;
    }

    private static String formatProfit(double profit) {
        return String.format("%.1f", profit);
    }
}