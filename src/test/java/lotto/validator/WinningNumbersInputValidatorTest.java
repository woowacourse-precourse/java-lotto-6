package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningNumbersInputValidatorTest {

    BasicValidator<String> winningNumbersInputValidator = new WinningNumbersInputValidator();

    @Test
    void 당첨_번호에_대한_사용자_입력값_검증() {
        assertThatThrownBy(() -> winningNumbersInputValidator.validate("a,b,c,d,e,f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 숫자가 아닙니다.");

        assertThatThrownBy(() -> winningNumbersInputValidator.validate("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 6자리가 아닙니다.");

        assertThatThrownBy(() -> winningNumbersInputValidator.validate("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 1과 45 사이여야 합니다.");

        assertThatThrownBy(() -> winningNumbersInputValidator.validate("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값들이 중복되지 않아야 합니다.");
    }
}