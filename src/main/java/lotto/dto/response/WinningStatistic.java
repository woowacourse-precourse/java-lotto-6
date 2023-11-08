package lotto.dto.response;

import lotto.domain.Reward;

public class WinningStatistic {
    private final long amount;
    private final int matchedCount;
    private final int count;

    public WinningStatistic(final long amount, final int matchedCount, final int count) {
        this.amount = amount;
        this.matchedCount = matchedCount;
        this.count = count;
    }

    public long getAmount() {
        return amount;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getCount() {
        return count;
    }

    public static WinningStatistic from(final Reward reward, final int count) {
        return new WinningStatistic(reward.getAmount(), reward.getMatchedCount(), count);
    }
}
