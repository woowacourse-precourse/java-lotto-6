package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final User user;
    private final Winning winning;
    private final Rewards rewards;

    public GameManager(final User user, final Winning winning) {
        this.user = user;
        this.winning = winning;
        this.rewards = createRewards(user, winning);
    }

    public double getProfitRate() {
        final long totalAmount = rewards.getTotalAmount();
        return user.getProfitRate(totalAmount);
    }

    public int getCountFromRank(final int rank) {
        return rewards.getCountFromRank(rank);
    }

    private Rewards createRewards(final User user, final Winning winning) {
        final List<Reward> rewards = new ArrayList<>();
        for (int i = 0; i < user.getPurchaseCount(); i++) {
            final int matchedCount = winning.getMatchedCount(user.getLottoFromIndex(i));
            final boolean containBonusNumber = winning.containBonusNumber(user.getLottoFromIndex(i));
            rewards.add(Reward.getFromMatchingResult(containBonusNumber, matchedCount));   // 메서드명 변경
        }

        return new Rewards(rewards);
    }
}
