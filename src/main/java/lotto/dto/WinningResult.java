package lotto.dto;

import java.util.Map;
import lotto.domain.lotto.Rank;
import lotto.domain.user.User;

public class WinningResult {
    private final Map<Rank, Integer> rankCount;
    private final double profitRate;

    public WinningResult(Map<Rank, Integer> rankCount, double profitRate) {
        this.rankCount = rankCount;
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double getProfitRate() {
        return profitRate;
    }

    static public WinningResult from(User user) {
        return new WinningResult(user.getRankCount(), user.getProfitRate());
    }
}
