package lotto.domain;

public class LottoBuyAmount {
    private static final int MIN_PRICE = 1000;
    private static final int LOTTO_PRICE = 1000;
    private static final String INVALID_PRICE_RANGE_MESSAGE = "[ERROR] 최소금액은 1,000원입니다.";
    private static final String INVALID_PRICE_MESSAGE = "[ERROR] 로또 구입금액은 1,000원 단위여야합니다.";

    private static void validatePrice(int buyAmount) {
        if (buyAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_MESSAGE);
        }
    }

    private static void validateRange(int buyAmount) {
        if (buyAmount < MIN_PRICE) {
            throw new IllegalArgumentException(INVALID_PRICE_RANGE_MESSAGE);
        }
    }

    public static int getAmount(int buyAmount) {
        validateRange(buyAmount);
        validatePrice(buyAmount);
        return buyAmount / LOTTO_PRICE;
    }
}
