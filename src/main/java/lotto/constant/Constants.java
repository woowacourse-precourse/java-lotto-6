package lotto.constant;

public final class Constants {
    public static final int LOTTO_PRICE = 1000;
    public static final int MIN_PURCHASE_QUANTITY = 1;
    public static final int MAX_PURCHASE_QUANTITY = 10000000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int BONUS_NUMBER_DEPENDENT_RANK_MATCHED_COUNT = 5;

    public static final long MIN_AMOUNT = (long) LOTTO_PRICE * MIN_PURCHASE_QUANTITY;
    public static final long MAX_AMOUNT = (long) LOTTO_PRICE * MAX_PURCHASE_QUANTITY;
}