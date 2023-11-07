package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {
    private YieldCalculator yieldCalculator;
    private Map<String, Integer> winningResults;

    @BeforeEach
    public void setup() {
        yieldCalculator = new YieldCalculator();
        winningResults = new HashMap<>();
    }

    @DisplayName("산 금액보다 당첨금액이 적어도 수익률은 양수 여야 합니다.")
    @Test
    void 수익률_계산_테스트_1() {
        winningResults.put("3", 2);
        winningResults.put("4", 0);
        winningResults.put("5", 0);
        winningResults.put("5_bonus", 0);
        winningResults.put("6", 0);

        int purchasedPrice = 20000;
        double expectedValue = 50.0;
        double actualValue = yieldCalculator.calculateYieldCalculator(winningResults, purchasedPrice) + 100;

        assertEquals(expectedValue,actualValue);
    }

    @DisplayName("산 금액보다 당첨금액이 매우 클 때")
    @Test
    void 수익률_계산_테스트_2() {
        winningResults.put("3", 0);
        winningResults.put("4", 0);
        winningResults.put("5", 0);
        winningResults.put("5_bonus", 2);
        winningResults.put("6", 0);

        int purchasedPrice = 2000;
        double expectedValue = 3000000.0;
        double actualValue = yieldCalculator.calculateYieldCalculator(winningResults, purchasedPrice);

        assertEquals(expectedValue,actualValue);
    }
}