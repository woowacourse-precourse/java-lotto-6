package lotto.constant;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rewards {
    FIRST(2_000_000_000, (matchCount, hasBonus) -> matchCount == 6),
    SECOND(30_000_000, (matchCount, hasBonus) -> matchCount == 5 && hasBonus),
    THIRD(1_500_000, (matchCount, hasBonus) -> matchCount == 5 && !hasBonus),
    FOURTH(50_000, (matchCount, hasBonus) -> matchCount == 4),
    FIFTH(5_000, (matchCount, hasBonus) -> matchCount == 3),
    LOSE(0, (matchCount, hasBonus) -> matchCount < 3);

    private final int value;
    private final BiPredicate<Integer, Boolean> condition;

    private Rewards(int value, BiPredicate<Integer, Boolean> condition) {
        this.value = value;
        this.condition = condition;
    }

    public static Rewards of(Integer matchCount, Boolean hasBonus) {
        return Arrays.stream(Rewards.values())
                .filter(reward -> reward.condition.test(matchCount, hasBonus))
                .findAny()
                .orElse(LOSE);
    }

    public int getValue() {
        return value;
    }
}
