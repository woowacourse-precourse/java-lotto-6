package lotto.constant;

import java.util.Arrays;
import java.util.Objects;

public enum LottoResultRule {
    THREE_MATCH(3, false, 5_000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000),
    NONE(0, false, 0);

    private final Integer matchCount;
    private final Boolean hasBonus;
    private final Integer prize;

    LottoResultRule(final Integer matchCount, final Boolean hasBonus, final Integer prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static LottoResultRule matchCount(final Integer matchCount, final Boolean hasBonus) {
        return Arrays.stream(LottoResultRule.values())
//                .filter(v -> matchCount == v.matchCount && hasBonus == v.hasBonus)
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
