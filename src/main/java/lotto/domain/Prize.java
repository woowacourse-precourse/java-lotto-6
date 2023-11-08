package lotto.domain;

import lotto.Lotto;

public class Prize {
    public enum WinningPrize {
        FIRST_PRIZE(1_000_000_000), // 1등 상금 (10억 원)
        SECOND_PRIZE(50_000_000), // 2등 상금 (5천만 원)
        THIRD_PRIZE(1_000_000), // 3등 상금 (1백만 원)
        FOURTH_PRIZE(50_000), // 4등 상금 (5만 원)
        FIFTH_PRIZE(5_000); // 5등 상금 (5천 원)

        private final int prizeAmount;

        WinningPrize(int prizeAmount) {
            this.prizeAmount = prizeAmount;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }
}
