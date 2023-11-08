package lotto.domain;

import lotto.exception.StateException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.exception.errorcode.StateErrorCode.FAIL_GET_VALUE_FROM_COLLECTION;

public enum Reward {
    FIRST_PLACE(2000000000L, false, 6, 1),
    SECOND_PLACE(30000000L, true, 5, 2),
    THIRD_PLACE(1500000L, false, 5, 3),
    FOURTH_PLACE(50000L, false, 4, 4),
    LAST_PLACE(5000L, false, 3, 5),
    NONE(0L, false, 0, 6);

    private static final Map<Integer, Map<Boolean, List<Reward>>> REWARD_GROUPING_BY_RANK = Arrays.stream(values())
            .collect(Collectors.groupingBy(Reward::getMatchedCount, Collectors.groupingBy(Reward::isRequiredBonusNumber)));

    private final long amount;
    private final boolean requiredBonusNumber;
    private final int matchedCount;
    private final int rank;

    Reward(final long amount, final boolean requiredBonusNumber, final int matchedCount, final int rank) {
        this.amount = amount;
        this.requiredBonusNumber = requiredBonusNumber;
        this.matchedCount = matchedCount;
        this.rank = rank;
    }

    public static List<Reward> getWinningRewards() {
        return Arrays.stream(Reward.values())
                .filter(r -> r != NONE)
                .toList();
    }

    public static Reward getFromMatchingResult(final boolean bonusNumberMatched, final int matchedCount) {
        if (matchedCount < LAST_PLACE.matchedCount) {
            return NONE;
        }

        boolean requiredBonusNumber = false;
        if (matchedCount == SECOND_PLACE.matchedCount) {
            requiredBonusNumber = bonusNumberMatched;
        }

        try {
            return REWARD_GROUPING_BY_RANK
                    .get(matchedCount)
                    .get(requiredBonusNumber)
                    .get(0);
        } catch (Exception e) {
            throw new StateException(FAIL_GET_VALUE_FROM_COLLECTION);
        }
    }

    public long getAmount() {
        return amount;
    }

    private boolean isRequiredBonusNumber() {
        return requiredBonusNumber;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getRank() {
        return rank;
    }
}
