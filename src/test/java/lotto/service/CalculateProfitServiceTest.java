package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.view.LottoOutputView;
import lotto.view.View;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateProfitServiceTest extends OutputChecker {
    private final LottoOutputView OUTPUT_VIEW = (LottoOutputView) View.generateLottoOutputView();

    @DisplayName("calculateProfit 메서드 작동 확인 테스트")
    @Test
    void calculateProfitTest() {
        CalculateProfitService testInstance = (CalculateProfitService) Service.generateCalculateProfitService();

        Integer money = 10_000;
        Long reward = 1_000_000_000L;
        testInstance.calculateProfit(money, reward, OUTPUT_VIEW);

        assertThat(output()).contains("10000000.0%");
    }
}