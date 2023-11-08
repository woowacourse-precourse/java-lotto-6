package lotto.utils;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeType {
    FIFTH_PLACE(3, 5_000, "3개 일치 (5,000원)"),
    FOURTH_PLACE(4, 50_000, "4개 일치 (50,000원)"),
    THIRD_PLACE(5, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND_PLACE(6, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST_PLACE(7, 2_000_000_000, "6개 일치 (2,000,000,000원)");

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
