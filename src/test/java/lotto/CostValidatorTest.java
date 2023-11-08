package lotto;

import lotto.validator.CostValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CostValidatorTest {
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void setCostByNotUnit1() {
        assertThatThrownBy(() -> new CostValidator().validateCost("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void setCostByNotUnit2() {
        assertThatThrownBy(() -> new CostValidator().validateCost("10001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void setCostByNotUnit3() {
        assertThatThrownBy(() -> new CostValidator().validateCost("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void setCostByString1() {
        assertThatThrownBy(() -> new CostValidator().validateCost("thousand"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자 외 문자가 있으면 예외가 발생한다.")
    @Test
    void setCostWithString1() {
        assertThatThrownBy(() -> new CostValidator().validateCost("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자 외 문자가 있으면 예외가 발생한다.")
    @Test
    void setCostWithString2() {
        assertThatThrownBy(() -> new CostValidator().validateCost("3000 "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자 외 문자가 있으면 예외가 발생한다.")
    @Test
    void setCostWithString3() {
        assertThatThrownBy(() -> new CostValidator().validateCost(" 5000"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
