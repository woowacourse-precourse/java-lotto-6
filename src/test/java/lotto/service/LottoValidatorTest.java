package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {
    @DisplayName("로또 번호의 입력값이 없으면 예외가 발생한다.")
    @Test
    void isNothingInputTest() {
        String input = "";
        assertThatThrownBy(() -> LottoValidator.isNothingInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void isDigitInputTest() {
        String input = "100a";
        assertThatThrownBy(() -> LottoValidator.isDigitInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 입력값이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void isThousandIncrementTest() {
        String input = "12020";
        assertThatThrownBy(() -> LottoValidator.isThousandIncrement(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}