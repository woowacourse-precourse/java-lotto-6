package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 구매_금액_천원_단위_아니면_예외() {
        int number = 8400;
        Assertions.assertThatThrownBy(() -> InputValidator.validateDivision1000(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
    }
}