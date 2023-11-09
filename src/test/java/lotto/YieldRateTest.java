package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YieldRateTest {

    @Test
    void 수익률_생성_기능() {
        // given
        YieldRate yieldRate = YieldRate.newInstance(AmountToBuyLotto.newInstance("10000"), 50000);
        // when

        // then
        assertThat(yieldRate).isInstanceOf(YieldRate.class);
    }

    @Test
    void 수익률_메세지_기능() {
        // given
        YieldRate yieldRate = YieldRate.newInstance(AmountToBuyLotto.newInstance("10000"), 15000);
        // when
        String rateMessage = yieldRate.getRateMessage();
        // then
        assertThat(rateMessage).contains("총 수익률은 150.0%입니다.");
    }
}