package lotto;

import lotto.controller.LottoController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateReturnRateTest() {
        LottoController lottoController = new LottoController();
        long totalPrize = 2000000000;
        int amount = 1000;

        double returnRate = lottoController.calculateReturnRate(totalPrize, amount);

        assertThat(returnRate).isEqualTo(200000000.0);
    }
}
