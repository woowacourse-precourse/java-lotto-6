package lotto.model;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,삼,4,5,6", "!!!", "1,2,3, 4", "1,2,3, ,5,6", "1,2,3,4,5"})
    void 당첨_번호_입력_양식(String input) {
        WinningNumber winningNumber = new WinningNumber();

        assertThatCode(() -> winningNumber.inputWinningNumber("1,2,3,4,5,6")).doesNotThrowAnyException();
        assertThatThrownBy(() -> winningNumber.inputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바르지 않은 당첨 번호 입력 양식입니다.");
    }
}