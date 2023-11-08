package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.wrapper.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeReceptionTest {

    @DisplayName("특정 등수를 몇 번 당첨했는지 조회한다.")
    @Test
    void getPrizeCount() {
        // given
        Map<Prize, Integer> lottosResult = new HashMap<>();
        lottosResult.put(Prize.FIRST, 1);
        lottosResult.put(Prize.FIFTH, 3);
        PrizeReception prizeReception = new PrizeReception(lottosResult);
        int expectedFirstPrizeCount = 1;
        int expectedFifthPrizeCount = 3;
        // when, then
        assertThat(prizeReception.getPrizeCount(Prize.FIRST)).isEqualTo(expectedFirstPrizeCount);
        assertThat(prizeReception.getPrizeCount(Prize.FIFTH)).isEqualTo(expectedFifthPrizeCount);
    }

    @DisplayName("당첨으로 얻은 금액과 로또를 구입한 금액을 기준으로 퍼센트 단위 수익률을 소수점 둘째 자리에서 반올림하여 계산한다.")
    @Test
    void getProfitRate() {
        // given
        Map<Prize, Integer> lottosResult = new HashMap<>();
        lottosResult.put(Prize.FIFTH, 1);
        PrizeReception prizeReception = new PrizeReception(lottosResult);
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        double expectedProfit = 62.5;
        // when, then
        assertThat(prizeReception.getProfitRate(purchaseAmount))
                .isEqualTo(expectedProfit);
    }
}