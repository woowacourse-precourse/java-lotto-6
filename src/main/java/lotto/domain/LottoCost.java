package lotto.domain;

import java.util.Objects;

public class LottoCost {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private final int lottoCost;

    public LottoCost(int lottoCost) {
        validateRemainder(lottoCost);
        this.lottoCost = lottoCost;
    }

    private void validateRemainder(int lottoCost) {
        if (lottoCost % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    private static void validateZero(int lottoCost) {
        if (lottoCost == ZERO) {
            throw new IllegalArgumentException("0을 제외한 정확한 입력값을 입력해주세요.");
        }
    }

    public int getLottoCount() {
        return lottoCost / 1000;
    }
}
