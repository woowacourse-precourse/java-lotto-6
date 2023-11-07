package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    NONE(0, 0L, (matchedCount, isBonus) -> matchedCount < 3),
    FIFTH(3, 5_000L, (matchedCount, isBonus) -> matchedCount == 3),
    FOURTH(4, 50_000L, (matchedCount, isBonus) -> matchedCount == 4),
    THIRD(5, 1_500_000L, (matchedCount, isBonus) -> matchedCount == 5 && !isBonus),
    SECOND(5, 30_000_000L, (matchedCount, isBonus) -> matchedCount == 5 && isBonus),
    FIRST(6, 2_000_000_000L, (matchedCount, isBonus) -> matchedCount == 6);

    private final int count;
    private final Long money;
    private final BiPredicate<Integer, Boolean> predicate;

    Prize(int count, Long money, BiPredicate<Integer, Boolean> predicate) {
        this.count = count;
        this.money = money;
        this.predicate = predicate;
    }

    public static Prize valueOf(int matchedCount, boolean isBonus) {
        return Arrays.stream(values())
            .filter(prize -> prize.predicate.test(matchedCount, isBonus))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
