package lotto.constant;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rewards {
    LOSE(0, 0, (matchCount, hasBonus) -> matchCount < 3),
    FIFTH(5_000, 3, (matchCount, hasBonus) -> matchCount == 3),
    FOURTH(50_000, 4, (matchCount, hasBonus) -> matchCount == 4),
    THIRD(1_500_000, 5, (matchCount, hasBonus) -> matchCount == 5 && !hasBonus),
    SECOND(30_000_000, 5, (matchCount, hasBonus) -> matchCount == 5 && hasBonus),
    FIRST(2_000_000_000, 6, (matchCount, hasBonus) -> matchCount == 6);

    private final int value;
    private final int count;
    private final BiPredicate<Integer, Boolean> condition;

    private Rewards(int value, int count, BiPredicate<Integer, Boolean> condition) {
        this.value = value;
        this.count = count;
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

    public int getCount() {
        return count;
    }
}
