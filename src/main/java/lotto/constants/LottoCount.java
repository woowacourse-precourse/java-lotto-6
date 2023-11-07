package lotto.constants;

public enum LottoCount {
    LOTTO_COUNT_START(3, "5,000원"),

    LOTTO_COUNT_START_FOUR(4, "50,000원"),

    LOTTO_COUNT_FIVE(5, "1,500,000원"),

    LOTTO_COUNT_BONUS(6, "30,000,000원"),

    LOTTO_COUNT_SIX(7, "2,000,000,000원");

    private int count;
    private String price;

    LottoCount(int count, String price) {
        this.count = count;
        this.price = price;
    }

    public static String matchingPrice(int count) {
        String result = LOTTO_COUNT_START.price;
        if (count == LOTTO_COUNT_START_FOUR.count) {
            result = LOTTO_COUNT_START_FOUR.price;
        }
        if (count == LOTTO_COUNT_FIVE.count) {
            result = LOTTO_COUNT_FIVE.price;
        }
        if (count == LOTTO_COUNT_BONUS.count) {
            result = LOTTO_COUNT_BONUS.price;
        }
        if (count == LOTTO_COUNT_SIX.count) {
            result = LOTTO_COUNT_SIX.price;
        }
        return result;
    }
}
