package lotto.domain;

import java.util.function.BiFunction;

public enum Rank {

    FIRST(6, false, 2_000_000_000L, (match, hasBonusNumber) -> match == 6),
    SECOND(5, true, 30_000_000L, (match, hasBonusNumber) -> match == 5 && hasBonusNumber),
    THIRD(5, false, 1_500_000L, (match, hasBonusNumber) -> match == 5 && !hasBonusNumber),
    FOURTH(4, false, 50_000L,(match, hasBonusNumber) -> match == 4),
    FIFTH(3, false, 5_000L, (match, hasBonusNumber) -> match == 3),
    MISS(0, false, 0L, (match, hasBonusNumber) -> match <= 2);

    private final int match;
    private final boolean hasBonusNumber;
    private final long reward;
    private final BiFunction<Long, Boolean, Boolean> condition;

    Rank(int match, boolean hasBonusNumber, long reward, BiFunction<Long, Boolean, Boolean> condition) {
        this.match = match;
        this.hasBonusNumber = hasBonusNumber;
        this.reward = reward;
        this.condition = condition;
    }

    public boolean matchesCondition(long match, boolean hasBonusNumber) {
        return condition.apply(match, hasBonusNumber);
    }

    @Override
    public String toString() {
        StringBuilder rankDetails = new StringBuilder();
        rankDetails.append(String.format("%d개 일치", match));
        if (hasBonusNumber) {
            rankDetails.append(", 보너스 볼 일치");
        }
        rankDetails.append(String.format(" (%,d원)", reward));
        return rankDetails.toString();
    }

    public long getReward() {
        return reward;
    }
}
