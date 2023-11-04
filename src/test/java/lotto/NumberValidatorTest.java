package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.MoneyValidator;
import lotto.util.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {
    @DisplayName("숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void testUnderThousand() {
        assertThatThrownBy(() -> NumberValidator.validateChangeNumber("Test"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
