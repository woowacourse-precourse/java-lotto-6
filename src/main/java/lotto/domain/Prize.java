package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    NONE(0, 0, (matchCount, isMatchBonus) -> matchCount < 3),
    FIRST(6, 2000000000, (matchCount, isMatchBonus) -> matchCount == 6),
    SECOND(5, 30000000, (matchCount, isMatchBonus) -> matchCount == 5 && isMatchBonus),
    THIRD(5, 1500000, (matchCount, isMatchBonus) -> matchCount == 5 && !isMatchBonus),
    FOURTH(4, 50000, (matchCount, isMatchBonus) -> matchCount == 4),
    FIFTH(3, 5000, (matchCount, isMatchBonus) -> matchCount == 3);

    private final int matchNumber;
    private final int reward;
    private final BiPredicate<Integer, Boolean> biPredicate;

    Prize(int matchNumber, int reward, BiPredicate<Integer, Boolean> biPredicate) {
        this.matchNumber = matchNumber;
        this.reward = reward;
        this.biPredicate = biPredicate;
    }

    public static Prize getPrize(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.biPredicate.test(matchCount, isMatchBonus))
                .findAny()
                .orElse(NONE);
    }
}
