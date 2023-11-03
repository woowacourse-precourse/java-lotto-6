package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private static final String NO_A_NUMBER_MESSAGE = "로또 금액은 숫자여야 합니다";
    private static final String MIN_PRICE_1000_MESSAGE = "로또 금액은 1000원 이상이어야 합니다";
    private static final String UNIT_OF_1000_REQUIRED_MESSAGE = "로또 금액은 1000원 단위로 입력되어야 합니다";

    private static InputValidator inputValidator;

    @BeforeAll
    static void init() {
        //given
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000", "5000", "100000", "10000000"})
    @DisplayName("로또 구입금액이 정상적인 값일 때")
    void goodCase(String userInput) {
        assertDoesNotThrow(() -> {
            inputValidator.validatePrice(userInput);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"가나다", "ㅇ", "흥", "1000."})
    @DisplayName("로또 구입금액이 숫자가 아니면 예외")
    void 로또_구입금액이_숫자가_아니면_예외(String userInput) {
        assertThatThrownBy(() -> inputValidator.validatePrice(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NO_A_NUMBER_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"999", "1", "100", "30"})
    @DisplayName("로또 구입금액이 1000원 미만이면 예외")
    void 로또_구입금액이_1000원_미만이면_예외(String userInput) {
        assertThatThrownBy(() -> inputValidator.validatePrice(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MIN_PRICE_1000_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1999", "20001", "1001", "999900"})
    @DisplayName("로또 구입금액이 1000원 단위가 아니면 예외")
    void 로또_구입금액이_1000원_단위가_아니면_예외(String userInput) {
        assertThatThrownBy(() -> inputValidator.validatePrice(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UNIT_OF_1000_REQUIRED_MESSAGE);
    }
}