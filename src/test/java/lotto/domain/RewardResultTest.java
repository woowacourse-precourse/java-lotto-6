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
        // 당첨 번호를 설정합니다. 예를 들어, 1부터 6까지의 번호로 가정합니다.
        List<Integer> winningNumbersList = List.of(1, 2, 3, 4, 5, 6);
        winningNumber = new Lotto(winningNumbersList);

        // 보너스 번호를 설정합니다. 예를 들어, 번호 7을 가정합니다.
        bonusNumber = new BonusNumber(7, winningNumber);

        // 구매한 로또 번호를 설정합니다. 예를 들어, 3개의 로또를 구매하였다고 가정하고,
        // 각각 3개, 4개, 5개의 번호가 당첨되었다고 합시다.
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 10, 11, 12))); // 3개 일치 (5등)
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 11, 12)));  // 4개 일치 (4등)
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 13)));   // 5개 일치 (3등)

        lottos = new Lottos(lottoList);

        // RewardResult 인스턴스를 초기화합니다.
        rewardResult = new RewardResult();
    }

    @Test
    @DisplayName("RewardResult should correctly calculate the number of each reward")
    void calcRewardResultShouldCalculateResultsCorrectly() {
        // RewardResult 계산을 실행합니다.
        rewardResult.calcRewardResult(winningNumber, bonusNumber, lottos);

        // RewardResult를 검증합니다.
        assertEquals(1, rewardResult.getRewardCount(Reward.FIFTH));
        assertEquals(1, rewardResult.getRewardCount(Reward.FOURTH));
        assertEquals(1, rewardResult.getRewardCount(Reward.THIRD));
        assertEquals(0, rewardResult.getRewardCount(Reward.SECOND)); // 보너스 번호로 인한 2등은 없음
        assertEquals(0, rewardResult.getRewardCount(Reward.FIRST));  // 6개 번호 일치하는 경우는 없음
        assertEquals(0, rewardResult.getRewardCount(Reward.LOSE));   // 지정된 번호 중 LOSE는 없음
    }
}

