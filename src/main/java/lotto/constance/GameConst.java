package lotto.constance;

public class GameConst {
    public static final int LOTTO_RANGE_START = 1;
    public static final int LOTTO_RANGE_END = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int BONUS_CHECK_NECESSARY_NUMBER = 5;

    public static final int LOTTO_PRICE = 1_000;
    public static final int MONEY_UNIT = 1_000;
    public static final int LOTTO_PURCHASE_LIMIT = 100_000;

    public static final String DELIMITER = ",";
    public static final String FORMAT_INPUT_ANSWERS = String.format("^([\\d]*+%s){5}+[\\d]*$", GameConst.DELIMITER);
}
