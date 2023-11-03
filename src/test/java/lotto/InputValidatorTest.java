package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("구입 금액에 숫자가 아닌 문자가 포함되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-4000", "s5000", "5000ㄷㄷ"})
    void 구입_금액_입력값_검증(String input) {
        assertThatThrownBy(() -> InputValidator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
