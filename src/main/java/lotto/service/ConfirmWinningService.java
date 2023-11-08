package lotto.service;

import static lotto.util.constants.Numbers.REWARD_CRITERIA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.LottoBonusPair;
import lotto.model.PublishedLotto;
import lotto.util.constants.Reward;
import lotto.view.LottoOutputView;

public class ConfirmWinningService implements Service {
    private Long reward;

    ConfirmWinningService() {
        reward = 0L;
    }

    public void confirmWinning(final PublishedLotto lotto, final LottoBonusPair pair,
                               final LottoOutputView outputView) {
        List<Integer> rankList = pair.getResults(lotto);
        Map<Integer, Integer> rankCount = new HashMap<>();
        for (Integer rank : rankList) {
            if (hasWon(rank)) {
                rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
                addReward(rank);
            }
        }
        outputView.printWinningResult(rankCount);
    }

    public Long getTotalReward() {
        return this.reward;
    }

    private boolean hasWon(final Integer rank) {
        return rank <= REWARD_CRITERIA.getNumber();
    }

    private void addReward(final Integer rank) {
        reward += Reward.fromRank(rank);
    }
}
