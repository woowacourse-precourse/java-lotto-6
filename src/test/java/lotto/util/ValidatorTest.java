package lotto.util;

import org.junit.jupiter.api.Test;

import static lotto.util.Validator.validateIntegerMoney;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    void shouldThrowIllegalException_whenMoneyInputHasRemains() {
        Integer testMoney = 1500;

        assertThatThrownBy(() -> validateIntegerMoney(testMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 금액은 1000원으로 나누어 떨어져야 합니다");
    }


    @Test
    void shouldThrowIllegalException_whenMoneyInputIsLowerThan0() {
        Integer testMoney = -50;

        assertThatThrownBy(() -> validateIntegerMoney(testMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 0 이상의 정수가 되어야 합니다");
    }
}
