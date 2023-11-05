package lotto.constant;

import java.util.List;

public final class GeneralConstant {
    private GeneralConstant() {}
    public static final int ZERO = 0;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBERS_SIZE = 6;
    public static final int PRIZE_RANK_MAX = 5;
    public static final int SECOND_RANK_WEIGHT = 10;
    public static final int THIRD_RANK = 5;
    public static final int LOTTO_PRICE = 1000;
    public static final String LEFT_BRACKET = "[";
    public static final String RIGHT_BRACKET = "]";
    public static final String DELIMITER = ",";
    public static final String DELIMITER_WITH_SPACE = ", ";
    public static final List<Integer> PRIZE_RANK_WEIGHTS = List.of(3, 4, 5, 15, 6);
    public static final List<Integer> PRIZE_MONEY = List.of(5000, 50000, 1500000, 30000000, 2000000000);
    public static final List<String> PRIZE_PRINT_ORDER = List.of(
            "FIFTH_PRIZE", "FOURTH_PRIZE", "THIRD_PRIZE", "SECOND_PRIZE", "FIRST_PRIZE"
    );
}
