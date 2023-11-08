package lotto.domain;

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

    public int getLottoCount() {
        return lottoCost / 1000;
    }
}
