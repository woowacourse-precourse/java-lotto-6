package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import lotto.record.ProfitRate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateTest {
    @Test
    @DisplayName("수익률이 반올림 되지 않으면 예외가 발생한다.")
    void PROFIT_RATE_NOT_ROUNDED() {
        assertThatThrownBy(() -> new ProfitRate(0.127, 12.0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수익률이 소수점 첫째자리가 아니면 예외가 발생한다.")
    void PROFIT_RATE_DECIMAL_NOT_ONE() {
        assertThatThrownBy(() -> new ProfitRate(0.1214, 12.14))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수익률은 소숫점 첫째자리부터 반올림 된 다.")
    void printProfitRate() {
        assertSimpleTest(() -> assertThat(new ProfitRate(0.121, 12.1)
                .printProfitRate()).contains("12.1%"));
    }
}