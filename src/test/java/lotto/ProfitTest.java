package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfitTest {
    @DisplayName("하나도 걸리지 않았을때 수익률은 0.0이다.")
    @Test
    void zeroProfit() {
        Profit profit = new Profit();
        double testProfit = profit.calculateProfit(List.of(0, 0, 0, 0, 0, 0, 0, 0), 5);
        assertEquals("0.0", String.format("%.1f", testProfit));

    }

    @DisplayName("1등이 걸리면 수익률은 40000000.0이다.")
    @Test
    void firstPrizeProfit() {
        Profit profit = new Profit();
        double testProfit = profit.calculateProfit(List.of(0, 0, 0, 0, 0, 0, 1, 0), 5);
        assertEquals("40000000.0", String.format("%.1f", testProfit));

    }

    @DisplayName("1등 부터 5등까지 한번씩 걸리면 수익률은 40631100.0이다.")
    @Test
    void allPrizeProfit() {
        Profit profit = new Profit();
        double testProfit = profit.calculateProfit(List.of(0, 0, 0, 1, 1, 1, 1, 1), 5);
        assertEquals("40631100.0", String.format("%.1f", testProfit));

    }
}
