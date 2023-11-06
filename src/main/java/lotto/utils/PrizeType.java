package lotto.utils;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeType {
    FIRST_PLACE(1, 2_000_000_000, "2,000,000,000원"),
    SECOND_PLACE(2, 30_000_000, "30,000,000원"),
    THIRD_PLACE(3, 1_500_000, "1,500,000원"),
    FOURTH_PLACE(4, 50_000, "50,000원"),
    FIFTH_PLACE(5, 5_000, "5,000원"),
    LOSS(0, 0, "꽝");

    private static final Map<Integer, PrizeType> codeToPrizeTypeMap =
            Stream.of(values()).collect(
                    Collectors.toMap(PrizeType::getCode, type -> type)
            );

    private final Integer code;
    private final Integer prizeMoney;
    private final String description;

    PrizeType(Integer code, Integer prizeMoney, String description) {
        this.code = code;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static PrizeType getTypeByCode(Integer code) {
        return codeToPrizeTypeMap.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
