package lotto.domain.result;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProfitTest {

    Profit profit = new Profit();

    List<Integer> prizeCounts1 = List.of(0, 0, 0, 1, 0);
    List<Integer> prizeCounts2 = List.of(1, 0, 0, 0, 0);

    int totalPrize1 = 30000000;
    int totalPrize2 = 5000;

    int totalSpent = 8000;

    double profitRate1 = 375000;
    double profitRate2 = 62.5;

    @DisplayName("계산된 수익률을 소수점 둘째 자리에서 반올림하는지 테스트한다.")
     @Test
    void formatProfitRateTest() {
        String testFormat1 = profit.formatProfitRate(12.345);

        Assertions.assertEquals("12.3", testFormat1);
    }

    @DisplayName("수익률 계산을 테스트한다.")
    @Test
    void calculateProfitRateTest() {
        double testProfitRate1 = profit.calculateProfitRate(totalPrize1, totalSpent);
        double testProfitRate2 = profit.calculateProfitRate(totalPrize2, totalSpent);

        Assertions.assertEquals(profitRate1, testProfitRate1);
        Assertions.assertEquals(profitRate2, testProfitRate2);
    }

    @DisplayName("총 상금 계산을 테스트한다.")
    @Test
    void calculateTotalPrizeTest() {
        int testTotalPrize1 = profit.calculateTotalPrize(prizeCounts1);
        int testTotalPrize2 = profit.calculateTotalPrize(prizeCounts2);

        Assertions.assertEquals(totalPrize1, testTotalPrize1);
        Assertions.assertEquals(totalPrize2, testTotalPrize2);
    }
}