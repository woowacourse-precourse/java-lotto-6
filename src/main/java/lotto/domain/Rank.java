package lotto.domain;

import java.util.function.BiPredicate;

public enum Rank {

    FIRST(2_000_000_000, (matchCount, hasBonusNumber) -> matchCount == 6),
    SECOND(30_000_000, (matchCount, hasBonusNumber) -> matchCount == 5 && hasBonusNumber),
    THIRD(1_500_000, (matchCount, hasBonusNumber) -> matchCount == 5 && !hasBonusNumber),
    FOURTH(50_000, (matchCount, hasBonusNumber) -> matchCount == 4),
    FIFTH(5_000, (matchCount, hasBonusNumber) -> matchCount == 3),
    MISS(0, (matchCount, hasBonusNumber) -> matchCount < 3);

    private final long reward;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(long reward, BiPredicate<Integer, Boolean> condition) {
        this.reward = reward;
        this.condition = condition;
    }

    public boolean matchesCondition(int matchCount, boolean hasBonusNumber) {
        return condition.test(matchCount, hasBonusNumber);
    }

    public String toString() {
        return String.format("%d개 일치%s (%,d원)",
                condition.test(6, false) ? 6 :
                        condition.test(5, true) ? 5 :
                                condition.test(5, false) ? 5 :
                                        condition.test(4, false) ? 4 :
                                                condition.test(3, false) ? 3 : 0,
                condition == SECOND.condition ? ", 보너스 볼 일치" : "",
                reward);
    }

    public long getReward() {
        return reward;
    }
}