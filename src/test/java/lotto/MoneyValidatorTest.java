package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.MoneyValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyValidatorTest {
    @DisplayName("1000원 이하의 값을 입력하면 예외가 발생한다.")
    @Test
    void testUnderThousand() {
        assertThatThrownBy(() -> MoneyValidator.validateNumber(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void testThousandUnits() {
        assertThatThrownBy(() -> MoneyValidator.validateThousand(3500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
