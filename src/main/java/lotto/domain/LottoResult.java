package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LottoResult {
    NONE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_WITH_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int price;

    LottoResult(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public boolean check(int matchCount, boolean bonusMatch) {
        return this.matchCount == matchCount;
    }

    public static LottoResult valueOf(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(lottoResult -> lottoResult.check(matchCount, bonusMatch))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}
