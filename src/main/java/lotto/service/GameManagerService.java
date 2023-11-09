package lotto.service;

import lotto.domain.GameManager;
import lotto.domain.Reward;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.dto.response.WinningResponse;
import lotto.dto.response.WinningStatistic;
import java.util.Map;
import java.util.stream.Collectors;

public class GameManagerService {
    public WinningResponse settleWinningResult(final User user, final Winning winning) {
        final GameManager gameManager = new GameManager(user, winning);
        final Map<Integer, WinningStatistic> statisticGroupingByRank = createStatisticGroupingByRank(gameManager);
        final double profitRate = gameManager.getProfitRate();

        return new WinningResponse(statisticGroupingByRank, profitRate);
    }

    private Map<Integer, WinningStatistic> createStatisticGroupingByRank(final GameManager gameManager) {
        return Reward.getWinningRewards()
                .stream()
                .collect(Collectors.toUnmodifiableMap(Reward::getRank, r -> WinningStatistic.from(r, gameManager.getCountFromRank(r.getRank()))));
    }
}
