package lotto.cashier;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.lottocompany.Reward;
import lotto.lottocompany.RewardHistory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashierTest {

    private Cashier cashier = new Cashier();

    @AfterEach
    void tearDown() {
        cashier = new Cashier();
    }

    @DisplayName("로또 구매 개수를 계산한다.")
    @Test
    void calculateLottoCount() {
        //given
        int purchaseAmount = 10000;

        //when
        int lottoCount = cashier.calculateLottoCount(purchaseAmount);

        //then
        assertThat(lottoCount).isEqualTo(purchaseAmount / 1000);
    }
    
    @DisplayName("총 로또 당첨금을 계산한다.")
    @Test
    void calculateTotalRewardAmount() {
        //given
        Reward first = Reward.FIRST;
        Reward second = Reward.SECOND;
        Reward third = Reward.THIRD;
        RewardHistory rewardHistory = RewardHistory.create(List.of(first, second, third));

        //when
        int totalRewardAmount = cashier.calculateTotalRewardAmount(rewardHistory);

        //then
        assertThat(totalRewardAmount)
                .isEqualTo(first.getPrizeMoney() + second.getPrizeMoney() + third.getPrizeMoney());
    }

    @DisplayName("수익률을 계산한다(소숫점 둘째 자리에서 반올림).")
    @Test
    void calculateProfitRate() {
        //given
        int purchaseAmount = 8000;
        cashier.calculateLottoCount(purchaseAmount);

        Reward first = Reward.FIFTH;
        RewardHistory rewardHistory = RewardHistory.create(List.of(first));
        cashier.calculateTotalRewardAmount(rewardHistory);

        //when
        double profitRate = cashier.calculateProfitRate();
        //then
        assertThat(profitRate)
                .isEqualTo((((double) first.getPrizeMoney() / purchaseAmount * 100) * 100) / 100);
    }

}
