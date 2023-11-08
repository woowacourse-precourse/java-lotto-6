package lotto;

import java.util.Map;
import java.util.Set;

public class LottoResultCalculator {

    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResultCalculator(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult calculateResult(Set<Integer> userNumbers) {
        int matchCount = (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonusMatch = userNumbers.contains(bonusNumber);

        return new LottoResult(matchCount, bonusMatch);
    }

    public void printResultSummary(Map<LottoRank, Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%s - %d개\n", rank.getResultText(), rankCount.getOrDefault(rank, 0));
            }
        }
    }


    public static class LottoResult {
        private final int matchCount;
        private final boolean bonusMatch;

        private LottoResult(int matchCount, boolean bonusMatch) {
            this.matchCount = matchCount;
            this.bonusMatch = bonusMatch;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public boolean isBonusMatch() {
            return bonusMatch;
        }
    }

    public static double calculateYield(int purchaseAmount, Map<LottoRank, Integer> rankCount) {
        int totalWinningMoney = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalWinningMoney += rank.getWinningMoney() * rankCount.getOrDefault(rank, 0);
        }

        return (double) totalWinningMoney / purchaseAmount;
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f입니다.\n", yield);
    }

}
