package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @Test
    @DisplayName("로또 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void 로또_금액이_1000원_단위인지_검증() {
        assertThatThrownBy(() -> new Payment("2222"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 금액 입력이 숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    void 로또_금액이_숫자인지_검증() {
        assertThatThrownBy(() -> new Payment("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}