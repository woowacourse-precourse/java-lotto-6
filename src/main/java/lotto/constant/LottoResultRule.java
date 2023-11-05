package lotto.constant;

import java.util.Arrays;
import java.util.Objects;

public enum LottoResultRule {
    NONE(0, false, 0),
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_MATCH_WITH_BONUS(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000);

    private final Integer matchCount;
    private final Boolean hasBonus;
    private final Integer prize;

    LottoResultRule(final Integer matchCount, final Boolean hasBonus, final Integer prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static LottoResultRule matchCount(final Integer matchCount, final Boolean hasBonus, final Integer price) {
        return Arrays.stream(LottoResultRule.values())
                .filter(v -> Objects.equals(matchCount, v.matchCount) && Objects.equals(hasBonus, v.hasBonus))
                .findFirst()
                .orElse(NONE);
    }

    public int toMatchCount() {
        return matchCount;
    }

    public int toPrize() {
        return prize;
    }
}
