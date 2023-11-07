package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    InputValidator validator;

    @Test
    @BeforeEach
    void init() {
        validator = new InputValidator();
    }

    @ParameterizedTest
    @DisplayName("입력이 빈 값이면 예외가 발생한다")
    @ValueSource(strings = {"", " "})
    void inputIsBlank(String input) {
        assertThatThrownBy(() -> validator.validatePurchaseCostInputView(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 값을 입력할 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("입력이 정수가 아니면 예외가 발생한다")
    @ValueSource(strings = {"로또", "abc"})
    void inputIsNotInt(String input) {
        assertThatThrownBy(() -> validator.validatePurchaseCostInputView(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수가 아닌 다른 문자는 입력할 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 입력이 빈 값이면 예외가 발생한다")
    @ValueSource(strings = {"", " "})
    void inputWinningNumberIsBlank(String input) {
        assertThatThrownBy(() -> validator.validateWinningNumberInputView(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 값을 입력할 수 없습니다");
    }

    @Test
    @DisplayName("당첨 번호 입력이 ,로 구분했을때 6개로 나눠지지 않으면 예외가 발생한다")
    void splitWinningNumbersCheckSize() {
        assertThatThrownBy(() -> validator.validateWinningNumberInputView("3425324,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표를 기준으로 당첨 번호 6개를 입력해 주세요");
    }

    @Test
    @DisplayName("입력된 당첨 번호가 1~45 사이가 아니면 예외가 발생한다")
    void inputWinningNumbersOutOfSize() {
        assertThatThrownBy(() -> validator.validateWinningNumberInputView("1,32,5,88,21,45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45까지의 숫자만 가능합니다");
    }

    @Test
    @DisplayName("입력된 당첨 번호가 중복되면 예외가 발생한다")
    void inputWinningNumbersDuplication() {
        assertThatThrownBy(() -> validator.validateWinningNumberInputView("1,2,44,44,28,37"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 중복되어선 안됩니다");
    }
}
