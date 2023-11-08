package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RateTest {

    @Test
    void getRateShouldCalculateRateCorrectly() {
        Money money = mock(Money.class);
        RewardResult rewardResult = mock(RewardResult.class);

        when(money.getLottoCount()).thenReturn(10);
        when(rewardResult.getRewardCount(Reward.FIFTH)).thenReturn(2);
        when(rewardResult.getRewardCount(Reward.FOURTH)).thenReturn(0);
        when(rewardResult.getRewardCount(Reward.THIRD)).thenReturn(0);
        when(rewardResult.getRewardCount(Reward.SECOND)).thenReturn(0);
        when(rewardResult.getRewardCount(Reward.FIRST)).thenReturn(0);
        when(rewardResult.getRewardCount(Reward.LOSE)).thenReturn(8);

        Rate rate = new Rate(money, rewardResult);
        double expectedRate = 100.0;
        assertEquals(expectedRate, rate.getRate());
    }
}
