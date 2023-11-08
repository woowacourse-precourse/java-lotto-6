package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import lotto.config.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReturnRateCalculatorTest {
    @DisplayName("수익률 계산 일치 여부 확인")
    @Test
    public void caculateRuturnRate() {
        ReturnRateCalculator returnRateCalculator = new ReturnRateCalculator();
        HashMap<String, Integer> countByPrize = new HashMap<>() {{
            put(LottoConfig.FIRST_PRIZE_REWARD, 0);
            put(LottoConfig.SECOND_PRIZE_REWARD, 0);
            put(LottoConfig.THIRD_PRIZE_REWARD, 0);
            put(LottoConfig.FOURTH_PRIZE_REWARD, 1);
            put(LottoConfig.FIFTH_PRIZE_REWARD, 1);
        }};
        int cost = 10000;

        assertThat(returnRateCalculator.getReturnRate(countByPrize, cost)).isEqualTo((float) 550.0);

    }

}