package lotto.service;

import static lotto.util.constants.Numbers.REWARD_CRITERIA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.LottoBonusPair;
import lotto.model.PublishedLotto;
import lotto.util.constants.Reward;
import lotto.view.LottoOutputView;
import lotto.view.View;

public class ConfirmWinningService implements Service {
    private Long reward;

    ConfirmWinningService() {
        reward = 0L;
    }

    public void confirmWinning(PublishedLotto lotto, LottoBonusPair pair, LottoOutputView lottoOutputView) {
        List<Integer> rankList = pair.getResults(lotto);
        Map<Integer, Integer> rankCount = new HashMap<>();
        for (Integer rank : rankList) {
            if (hasWon(rank)) {
                rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
                addReward(rank);
            }
        }
        lottoOutputView.printWinningResult(rankCount);
    }

    public Long getTotalReward() {
        return this.reward;
    }

    private boolean hasWon(Integer rank) {
        return rank <= REWARD_CRITERIA.getNumber();
    }

    private void addReward(Integer rank) {
        reward += Reward.fromRank(rank);
    }
}
