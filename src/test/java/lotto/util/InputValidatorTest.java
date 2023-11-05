package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private static final String NOT_A_NUMBER_MESSAGE = "입력은 숫자여야 합니다";

    private static InputValidator inputValidator;

    @BeforeAll
    static void init() {
        //given
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"가나다", "ㅇ", "흥", "1000."})
    @DisplayName("입력이 숫자가 아니면 예외")
    void 입력이_숫자가_아니면_예외(String userInput) {
        assertThatThrownBy(() -> inputValidator.validateIsNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_A_NUMBER_MESSAGE);
    }
}