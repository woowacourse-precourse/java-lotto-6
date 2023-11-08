package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EarningsTest {

    @DisplayName("구입금액 14,000원 당첨금액 50,000원일 때의 당첨 수익률은 2.57이다.")
    @Test
    void calculateEarnings() {
        Earnings earnings = Earnings.calculate(14000, 50000);
        assertThat(earnings.getEarningsRate()).isEqualTo(2.57);
    }
}