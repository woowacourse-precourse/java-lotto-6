package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PrizeReception;
import lotto.domain.wrapper.BonusNumber;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.utils.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeReceptionTest {

    @DisplayName("구입 금액과 당첨 금액의 비율로 수익률을 계산한다.")
    @Test
    void getProfitRate() {
        // given
        Map<Prize, Integer> lottosResult = new HashMap<>();
        lottosResult.put(Prize.FOURTH, 1);
        lottosResult.put(Prize.FIFTH, 1);
        PrizeReception prizeReception = new PrizeReception(lottosResult);
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        double expectedProfitRate = (55000 / (double) 2000) * 100;
        // when
        double profitRate = prizeReception.getProfitRate(purchaseAmount);
        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}