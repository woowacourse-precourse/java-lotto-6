package lotto.constant;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class GeneralConstant {
    private GeneralConstant() {}
    public static final int INT_NULL = -1;
    public static final int ZERO = 0;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBERS_SIZE = 6;
    public static final int PRIZE_RANK_MAX = 5;
    public static final int LOTTO_PRICE = 1000;
    public static final String LEFT_BRACKET = "[";
    public static final String RIGHT_BRACKET = "]";
    public static final String DELIMITER = ",";
    public static final String DELIMITER_WITH_SPACE = ", ";
    public static final HashMap<Integer, String> PRIZE_RANK_INDEXES = new HashMap<Integer, String>() {{
        put(0, "FIFTH");
        put(1, "FOURTH");
        put(2, "THIRD");
        put(3, "SECOND");
        put(4, "FIRST");
    }};

    public static final HashMap<String, Integer> PRIZE_RANK_MONEY = new HashMap<String, Integer>() {{
        put("FIRST", 2000000000);
        put("SECOND", 30000000);
        put("THIRD", 1500000);
        put("FOURTH", 50000);
        put("FIFTH", 5000);
    }};

    public static final HashMap<String, Integer> PRIZE_RANK_WEIGHT = new LinkedHashMap<String, Integer>() {{
        put("FIRST", 7);
        put("SECOND", 6);
        put("THIRD", 5);
        put("FOURTH", 4);
        put("FIFTH", 3);
    }};
}
