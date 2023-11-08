package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Reward {
    FIRST_PLACE(2000000000L, false, 6, 1),
    SECOND_PLACE(30000000L, true, 5, 2),
    THIRD_PLACE(1500000L, false, 5, 3),
    FOURTH_PLACE(50000L, false, 4, 4),
    LAST_PLACE(5000L, false, 3, 5),
    NONE(0L, false, 0, 6);

    private static final Map<Integer, Map<Boolean, List<Reward>>> REWARD_GROUPING_BY_RANK = Arrays.stream(values())
            .collect(Collectors.groupingBy(Reward::getMatchedCount, Collectors.groupingBy(Reward::isMatchedBonusNumber)));

    private final long amount;
    private final boolean matchedBonusNumber;
    private final int matchedCount;
    private final int rank;

    Reward(final long amount, final boolean matchedBonusNumber, final int matchedCount, final int rank) {
        this.amount = amount;
        this.matchedBonusNumber = matchedBonusNumber;
        this.matchedCount = matchedCount;
        this.rank = rank;
    }

    public static Reward getInstance(final boolean bonusNumberMatched, final int matchedCount) {
        if (matchedCount < LAST_PLACE.matchedCount) {
            return NONE;
        }

        return REWARD_GROUPING_BY_RANK
                .get(matchedCount)
                .get(bonusNumberMatched)
                .get(0);
    }

    public long getAmount() {
        return amount;
    }

    private boolean isMatchedBonusNumber() {
        return matchedBonusNumber;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getRank() {
        return rank;
    }
}
