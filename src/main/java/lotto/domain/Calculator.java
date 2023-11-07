package lotto.domain;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.MatchingCounts;
import lotto.model.Purchase;

public class Calculator {
    public Calculator() {
    }

    public void calculateWinningLottoResults(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers,
                                             MatchingCounts matchingCounts) {
        for (List<Integer> numbers : lottoNumbers) {
            countMatchingNumbers(numbers, winningNumbers, matchingCounts);
        }
    }

    private boolean isMatch(int number, List<Integer> winningNumbers) {
        return winningNumbers.contains(number);
    }

    private boolean hasReachedCount5(int count) {
        return count == 5;
    }

    private void handleMatchingCounts(int count, boolean isCount5, MatchingCounts matchingCounts) {
        if (count >= 3 && !isCount5) {
            matchingCounts.displayWinningInfo(count, 0);
        }
    }

    private void countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers,
                                      MatchingCounts matchingCounts) {
        int count = countMatches(lottoNumbers, winningNumbers);
        boolean isCount5 = hasReachedCount5(count);
        handleMatchingCounts(count, isCount5, matchingCounts);

        if (isCount5) {
            countBonusNumbers(lottoNumbers, matchingCounts, count);
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

    private void countBonusNumbers(List<Integer> lottoNumbers, MatchingCounts matchingCounts, int count) {
        int bonus = 0;

        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber == BonusNumber.getBonusNumber()) {
                bonus++;
            }
        }

        matchingCounts.displayWinningInfo(count, bonus);
    }

    public String calculateProfitPercentage(MatchingCounts matchingCounts) {
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

    private int calculateLineLottoTotal(Prize[] prizes, MatchingCounts matchingCounts) {
        int lineLottoTotal = 0;

        for (int i = 0; i < 5; i++) {
            lineLottoTotal += prizes[i].getPrizeAmount() * matchingCounts.getMatchingCount().get(i);
        }

        return lineLottoTotal;
    }

    private double calculateProfit(int lineLottoTotal) {
        double purchaseAmount = Purchase.getPurchaseAmount();
        return (double) lineLottoTotal / purchaseAmount * 100;
    }

    private String formatProfit(double profit) {
        return String.format("%.1f", profit);
    }
}