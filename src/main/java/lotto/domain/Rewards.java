package lotto.domain;

import lotto.exception.StateException;
import java.util.List;

import static lotto.exception.errorcode.StateErrorCode.FAIL_PARSE_LONG_TO_INT;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(final List<Reward> rewards) {
        this.rewards = rewards;
    }

    public long getTotalAmount() {
        return rewards.stream()
                .map(Reward::getAmount)
                .mapToLong(l -> l)
                .sum();
    }

    public int getCountFromRank(final int rank) {
        try {
            final long count = rewards.stream()
                    .filter(r -> r.getRank() == rank)
                    .count();
            return Math.toIntExact(count);
        } catch (ArithmeticException e) {
            throw new StateException(FAIL_PARSE_LONG_TO_INT);
        }
    }
}
