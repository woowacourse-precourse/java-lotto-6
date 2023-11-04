package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReturnCalculatorTest {
    @Test
    @DisplayName("수익률 계산")
    void 수익률_계산() {
        //3000원 내고 5000원 당첨
        Map<WinningStatus, Integer> statusAndCount = new HashMap<>();
        statusAndCount.put(WinningStatus.MATCH3, 1);

        assertThat(ReturnCalculator.calculate(statusAndCount, 3)).isEqualTo((double) 5000 / 3000 * 100);
    }
}