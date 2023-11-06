package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProfitTest {
    @DisplayName("수익은 0원으로 초기화 된다.")
    @Test
    void createProfit() {
        Profit profit = new Profit();
        assertThat(profit.getAmount()).isEqualTo(0);
    }

    @DisplayName("수익에 음수를 더하면 예외가 발생한다.")
    @Test
    void addProfitByNegativeInteger() {
        Profit profit = new Profit();

        assertThatThrownBy(() -> profit.add(-2000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}