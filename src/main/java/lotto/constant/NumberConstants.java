package lotto.constant;

import static lotto.constant.MessageConstants.CANNOT_INSTANTIATE;

public final class NumberConstants {

    private NumberConstants() {
        throw new AssertionError(CANNOT_INSTANTIATE);
    }

    public static final int ONE_HUNDRED = 100;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final long LOTTO_PRICE = 1000L;
    public static final long MIN_MONEY = 1000L;
    public static final int BONUS_COUNT = 5;

    public static final String SPLIT_SEPARATOR = ",";
    public static final String NOT_DIGIT = "^\\d+$";

}
