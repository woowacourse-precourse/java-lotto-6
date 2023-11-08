package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CashTest {
    @DisplayName("입력한 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createCashByIllegalAmount() {
        assertThatThrownBy(() -> new Cash(1250))
                .isInstanceOf(IllegalArgumentException.class);
    }
}