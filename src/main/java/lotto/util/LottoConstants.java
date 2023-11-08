package lotto.util;

public final class LottoConstants {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBERS_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    private LottoConstants() {
        throw new AssertionError("This class should not be instantiated");
    }
}
