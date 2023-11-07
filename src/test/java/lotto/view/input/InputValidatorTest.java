package lotto.view.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("입력값 숫자형태 테스트 : 입력값이 숫자형태가 아니라면 IllegalArgumentException를 발생시킨다.")
    @ParameterizedTest(name = "입력값이 \"{0}\" 이면 예외발생")
    @ValueSource(strings = {"100k", "abc", "123$"})
    void validateNumericFormat(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumericFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력값이 로또가격으로 나누어지는지 테스트 : 입력값이 로또 가격으로 나누어 지지 않는다면 IllegalArgumentException를 발생시킨다.")
    @ParameterizedTest(name = "입력값이 {0} 이면 예외발생")
    @ValueSource(ints = {100, 1001, 9999})
    void validateLottoPrice(int input) {
        int lottoPrice = 1000;

        assertThatThrownBy(() -> InputValidator.validateLottoPrice(input, lottoPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력값 0보다 큰지 테스트 : 입력값이 0보다 작다면 IllegalArgumentException를 발생시킨다.")
    @ParameterizedTest(name = "입력값이 {0} 이면 예외발생")
    @ValueSource(ints = {-1, -999})
    void validateNumericFormat(int input) {
        assertThatThrownBy(() -> InputValidator.validateNonNegativeNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력값이 \"1,2,3,4,5,6\" 형식인지 테스트 : 입력값이 \"1,2,3,4,5,6\" 형식이 아니라면 IllegalArgumentException를 발생시킨다.")
    @ParameterizedTest(name = "입력값이 \"{0}\" 이면 예외발생")
    @ValueSource(strings = {"1,2,3,4, 5, 6", "123456"})
    void validateWinningNumberFormat(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumberFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}