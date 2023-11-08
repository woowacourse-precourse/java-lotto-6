package lotto.util;

public class LottoVO {

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public static int getLottoMinValue() {
        return LOTTO_MIN_VALUE;
    }

    public static int getLottoMaxValue() {
        return LOTTO_MAX_VALUE;
    }

    public static int getLottoNumberCount() {
        return LOTTO_NUMBER_COUNT;
    }
}
