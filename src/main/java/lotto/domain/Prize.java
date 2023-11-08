package lotto.domain;


public class Prize {
    public enum WinningPrize {
        FIRST_PRIZE(1_000_000_000),
        SECOND_PRIZE(50_000_000),
        THIRD_PRIZE(1_000_000),
        FOURTH_PRIZE(50_000),
        FIFTH_PRIZE(5_000);

        private final int prizeAmount;

        WinningPrize(int prizeAmount) {
            this.prizeAmount = prizeAmount;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }
}
