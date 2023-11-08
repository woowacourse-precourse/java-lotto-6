package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @DisplayName("구매 금액 입력이 빈칸일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "")
    void createInputBuyAmountByEmptyInput(String buyAmount) {
        assertThatThrownBy(() -> InputValidator.validateBuyAmount(buyAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력에 공백이 포함될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" 5000", "50 00", "5000 "})
    void createInputBuyAmountByContainsBlankInput(String buyAmount) {
        assertThatThrownBy(() -> InputValidator.validateBuyAmount(buyAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력이 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"e000", "lotto", "5000!"})
    void createInputBuyAmountByNotNumberInput(String buyAmount) {
        assertThatThrownBy(() -> InputValidator.validateBuyAmount(buyAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"5500", "500", "10100"})
    void createInputBuyAmountByRestIsNonZero(String buyAmount) {
        assertThatThrownBy(() -> InputValidator.validateBuyAmount(buyAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력이 빈칸일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "")
    void createInputWinningNumbersByEmptyInput(String winningNumbers) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 공백이 포함될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2,3,4,5,6", "1, ,2,3,4,5,6", " "})
    void createInputWinningNumbersByContainsBlankInput(String winningNumbers) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력이 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,e,3,4,5,6", "lotto", "a,b,c,d,e,f"})
    void createInputWinningNumbersByNotNumberInput(String winningNumbers) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 빈칸일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "")
    void createInputBonusNumberByEmptyInput(String bonusNumber) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 공백이 포함될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", " 7", "7 "})
    void createInputBonusNumberByContainsBlankInput(String bonusNumber) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"seven", "eeee", "7s"})
    void createInputBonusNumberByNotNumberInput(String bonusNumber) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}