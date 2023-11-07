package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoResultTest {

    private HashMap result = new HashMap<>();
    private HashMap testResult = new HashMap<>();

    @DisplayName("당첨 숫자 개수 확인")
    @Test
    void statistics() {
        LottoResult.initialize();
        for (int i = 3; i < 8; i++) {
            testResult.put(i, 1);
        }
        for (int i = 3; i < 8; i++) {
            LottoResult.statistics(i, false);
        }
        result = LottoResult.statistics(5, true);
        assertThat(result).isEqualTo(testResult);
    }

    @DisplayName("수익률 확인")
    @Test
    void calculateProfit() {
        LottoResult.initialize();
        LottoResult.statistics(5, true);
        double profit = LottoResult.calculateProfit(2);
        assertThat(profit).isEqualTo(1500000);
    }
}