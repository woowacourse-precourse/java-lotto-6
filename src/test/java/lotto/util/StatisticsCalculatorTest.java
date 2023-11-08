package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsCalculatorTest {
    @DisplayName("당첨 된 로또 금액에 대한 수익률을 전달한다.")
    @Test
    void creatRevenueRate() {
        HashMap<Integer, Integer> winResult = new HashMap<>();
        winResult.put(3, 0);
        winResult.put(4, 2);
        winResult.put(5, 0);
        winResult.put(6, 1);
        winResult.put(7, 0);

        assertThat(new StatisticsCalculator().getRate(winResult, 20000000)).isEqualTo("10.0");
    }


}
