package lotto.domain;


public class Prize {
    public enum WinningPrize {
        FIRST_RANK(1_000_000_000),
        SECOND_RANK(50_000_000),
        THIRD_RANK(1_000_000),
        FOURTH_RANK(50_000),
        FIFTH_RANK(5_000);

        private final int prizeAmount;

        WinningPrize(int prizeAmount) {
            this.prizeAmount = prizeAmount;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }
}
