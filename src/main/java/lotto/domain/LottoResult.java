package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    NONE(0, 0, "0개 일치"),
    FIFTH(3, 5000, "3개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    THIRD(5,  1500000, "5개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2000000000, "6개 일치");

    private final int match;
    private final long moneyAmount;
    private final String description;

    LottoResult(int match, long moneyAmount, String description) {
        this.match = match;
        this.moneyAmount = moneyAmount;
        this.description = description;
    }

    public static LottoResult of(int match) {
        return Arrays.stream(values())
                .filter(v -> match == v.match)
                .findFirst()
                .orElse(NONE);
    }

}
