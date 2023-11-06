package lotto.model;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    WinningNumber winningNumber;

    @BeforeEach
    void beforeEach() {
        this.winningNumber = new WinningNumber();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,삼,4,5,6", "!!!", "1,2,3, 4", "1,2,3, ,5,6", "1,2,3,4,5"})
    void 당첨_번호_입력_양식(String input) {
        assertThatCode(() -> winningNumber.inputWinningNumber("1,2,3,4,5,6")).doesNotThrowAnyException();
        assertThatThrownBy(() -> winningNumber.inputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    void 당첨_번호_범위(String input) {
        assertThatCode(() -> winningNumber.inputWinningNumber("1,2,3,4,5,6")).doesNotThrowAnyException();
        assertThatThrownBy(() -> winningNumber.inputWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1부터 45까지의 숫자만 사용됩니다.");
    }

    @Test
    void 당첨_번호_중복() {
        assertThatCode(() -> winningNumber.inputWinningNumber("1,2,3,4,5,6")).doesNotThrowAnyException();
        assertThatThrownBy(() -> winningNumber.inputWinningNumber("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 번호가 존재합니다. 다른 번호를 입력해주세요.");
    }
}