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

    /**
     * 당첨 결과를 계산하고, 메시지로 출력하는 메서드
     *
     * @param lotto 발행된 로또(PublishedLotto)
     * @param pair 당첨 번호와 당첨 보너스 번호 묶음(LottoBonusPair)
     * @param outputView 출력 담당 객체(LottoOutputView)
     */
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

    /**
     * 총 당첨 금액을 반환하는 메서드
     *
     * @return 총 당첨 금액(Long)
     */
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