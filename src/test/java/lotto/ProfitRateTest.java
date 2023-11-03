package lotto;

import lotto.record.ProfitRate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProfitRateTest {
    @Test
    @DisplayName("수익률이 반올림 되지 않으면 예외가 발생한다.")
    void PROFIT_RATE_NOT_ROUNDED() {
        assertThatThrownBy(() -> new ProfitRate(123.7, 123.0))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("수익률이 소수점 첫째자리가 아니면 예외가 발생한다.")
    void PROFIT_RATE_DECIMAL_NOT_ONE() {
        assertThatThrownBy(() -> new ProfitRate(123.7, 124.00))
                .isInstanceOf(IllegalArgumentException.class);
    }
}