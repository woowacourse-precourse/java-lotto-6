package lotto;

import java.util.HashMap;
import java.util.Map;

public enum Result {
    THREE(1, "3개 일치 (5,000원) - "),
    FORTH(2, "4개 일치 (50,000원) - "),
    FIVE(3, "5개 일치 (1,500,000원) - "),
    FIVE_AND_BONUS(4, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(5, "6개 일치 (2,000,000,000원) - ");

    private final int key;
    private final String value;

    private static final Map<Integer, Result> resultEnumMap = new HashMap<>();

    Result(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    static {
        for (Result result : Result.values()) {
            resultEnumMap.put(result.getKey(), result);
        }
    }

    public static Result getByKey(int key) {
        return resultEnumMap.get(key);
    }
}