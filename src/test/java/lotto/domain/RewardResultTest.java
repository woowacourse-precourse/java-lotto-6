package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

class RewardResultTest {

    private Lotto winningNumber;
    private BonusNumber bonusNumber;
    private Lottos lottos;
    private RewardResult rewardResult;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbersList = List.of(1, 2, 3, 4, 5, 6);
        winningNumber = new Lotto(winningNumbersList);
        bonusNumber = new BonusNumber(7, winningNumber);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 10, 11, 12)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 11, 12)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 13)));
        lottos = new Lottos(lottoList);
        rewardResult = new RewardResult();
    }

    @Test
    @DisplayName("RewardResult가 각 Reward를 올바르게 계산하는지 확인한다.")
    void calcRewardResultShouldCalculateResultsCorrectly() {
        rewardResult.calcRewardResult(winningNumber, bonusNumber, lottos);
        assertEquals(1, rewardResult.getRewardCount(Reward.FIFTH));
        assertEquals(1, rewardResult.getRewardCount(Reward.FOURTH));
        assertEquals(1, rewardResult.getRewardCount(Reward.THIRD));
        assertEquals(0, rewardResult.getRewardCount(Reward.SECOND));
        assertEquals(0, rewardResult.getRewardCount(Reward.FIRST));
        assertEquals(0, rewardResult.getRewardCount(Reward.LOSE));
    }
}

