package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private static final String NOT_A_NUMBER_MESSAGE = "입력은 숫자여야 합니다";
    private static final String UNDER_20_BILLION_REQUIRED = "입력은 20억 이하여야 합니다";

    private static InputValidator inputValidator;

    @BeforeAll
    static void init() {
        //given
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "10", "100000", "9999999"})
    @DisplayName("정상동작")
    void good_case(String userInput) {
        Assertions.assertDoesNotThrow(() -> inputValidator.validateIsNumber(userInput));
    }

    @ParameterizedTest
    @CsvSource(value = {"가나다", "ㅇ", "흥", "1000."})
    @DisplayName("입력이 숫자가 아니면 예외")
    void 입력이_숫자가_아니면_예외(String userInput) {
        assertThatThrownBy(() -> inputValidator.validateIsNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_A_NUMBER_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"2000000001", "10000000000", "100000000000000"})
    @DisplayName("입력이 20억 이상일 때 예외")
    void 입력이_20억_이상일_때_예외(String userInput) {
        assertThatThrownBy(() -> inputValidator.validateIsNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UNDER_20_BILLION_REQUIRED);
    }
}