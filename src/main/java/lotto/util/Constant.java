package lotto.util;

public class Constant {
    public static final int LOTTO_MINIMUM_RANGE = 1;
    public static final int LOTTO_MAXIMUM_RANGE = 45;
    public static final int NUMBER_PICK_COUNT = 6;
    public static final int AMOUNT_UNIT = 1000;
    public static final int MINIMUM_AMOUNT = 1000;
    public static final int LOTTO_PRICE = 1000;
    public static final int CONVERT_PERCENT = 100;
    public static final int NOTHING = 0;
    public static final int REMAINDER = 0;

    public static final String PURCHASE_AMOUNT_PATTERN = "^[0-9]*$";
    public static final String WINNING_NUMBERS_PATTERN = "\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}";
    public static final String BONUS_NUMBER_PATTERN = "\\d{1,2}";
    public static final String WINNING_AMOUNT_PATTERN = "\\B(?=(\\d{3})+(?!\\d))";
    public static final String DELIMITER = ",";
    public static final String DECIMAL_PLACES = "%.1f";
}
