package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.wrapper.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeManagerTest {

    @DisplayName("구입 금액과 당첨 금액의 비율로 수익률을 계산한다.")
    @Test
    void getProfitRate() {
        // given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1,2,3,4,7,8)),
                new Lotto(List.of(1,2,3,7,8,9))
        ));
        PrizeManager prizeManager = new PrizeManager(winningNumbers, bonusNumber, lottos);
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        double expectedProfitRate = (55000 / (double) 2000) * 100;
        // when
        double profitRate = prizeManager.getProfitRate(purchaseAmount);
        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}