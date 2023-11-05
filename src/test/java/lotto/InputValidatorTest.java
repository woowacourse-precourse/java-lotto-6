package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("입력값에 숫자가 아닌 문자가 포함되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-4000", "s5000", "5000ㄷㄷ"})
    void 입력값_숫자인지_검증(String input) {
        assertThatThrownBy(() -> InputValidator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값들에 숫자가 아닌 문자가 포함되면 예외가 발생한다.")
    @Test
    void 모든_입력값이_숫자인지_검증() {
        String[] inputs = {"1", "2", "notnumber1", "4", "5"};

        assertThatThrownBy(() -> InputValidator.validateIsAllNumber(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
