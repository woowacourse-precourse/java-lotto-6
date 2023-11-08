package lotto;

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

    public void printResultSummary(int[] matchCounts, boolean isBonusMatchIncluded) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts[5]);

        if (isBonusMatchIncluded) {
            System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts[5 + 1]); // Assuming 5+1 represents 5 numbers + bonus match.
        }

        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts[6]);
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

}
