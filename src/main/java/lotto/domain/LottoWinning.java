package lotto.domain;

public class LottoWinning {
    private int[] numbers;
    public enum rank {
        FIFTH_RANK("3개 일치", "5,000원"),
        FOURTH_RANK("4개 일치", "50,000원"),
        THIRD_RANK("5개 일치", "1,500,000원"),
        SECOND_RANK("5개 일치, 보너스 볼 일치", "30,000,000원"),
        FIRST_RANK("6개 일치", "2,000,000,000원");

        private final String matchesCount;
        private final String winningAmount;

        rank(String matchesCount, String winningAmount) {
            this.matchesCount = matchesCount;
            this.winningAmount = winningAmount;
        }
        public String getMatchesCount() {
            return matchesCount;
        }
        public String getWinningAmount() {
            return winningAmount;
        }
    }
}
