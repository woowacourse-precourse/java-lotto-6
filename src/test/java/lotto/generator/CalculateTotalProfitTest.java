package lotto.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTotalProfitTest {
    @DisplayName("총 수익을 올바르게 계산한다.")
    @Test
    void testCalculateTotalProfit() {
        List<Integer> winCounts = List.of(0, 2, 3, 1, 0, 4); // 당첨 번호 개수
        int t = 10; // 투자 금액

        int totalProfit = CalculateTotalProfit.calculateTotalProfit(winCounts, t);

        assertThat(totalProfit).isEqualTo(55000);
    }

    @DisplayName("모든 당첨 번호 개수가 0이면 총 수익은 0이다.")
    @Test
    void testCalculateTotalProfit_AllZeroWinCounts() {
        List<Integer> winCounts = List.of(0, 0, 0, 0, 0, 0); // 모든 당첨 번호 개수가 0
        int t = 10; // 투자 금액

        int totalProfit = CalculateTotalProfit.calculateTotalProfit(winCounts, t);

        assertThat(totalProfit).isEqualTo(0);
    }
}
