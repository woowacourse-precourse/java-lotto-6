package lotto.validators;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력한 로또 구입 금액에 숫자 이외의 문자가 있으면 예외가 발생한다.")
    @Test
    void validatePriceInputByCharacter() {
        String purchasePrice = "8,000";

        assertThatThrownBy(() -> InputValidator.validatePriceInput(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 로또 구입 금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void validatePriceInputByIndivisible() {
        String purchasePrice = "8500";

        assertThatThrownBy(() -> InputValidator.validatePriceInput(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 번호의 길이가 기준보다 길면 예외가 발생한다.")
    @Test
    void validateWinnigNumberInputByOverSize() {
        String winningNumber = "1,2,3,4,5,6,7";

        assertThatThrownBy(() -> InputValidator.validateWinnigNumberInput(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 번호의 범위가 기준에 벗어나면 예외가 발생한다.")
    @Test
    void validateWinnigNumberInputByWrongRange() {
        String winningNumber = "1,2,3,4,5,46";

        assertThatThrownBy(() -> InputValidator.validateWinnigNumberInput(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void validateWinnigNumberInputByDuplicatedNumber() {
        String winningNumber = "1,2,3,4,5,5";

        assertThatThrownBy(() -> InputValidator.validateWinnigNumberInput(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 보너스 번호의 범위가 기준에 벗어나면 예외가 발생한다.")
    @Test
    void validateBonusNumberInputByWrongRange() {
        String bonusNumberInput = "46";
        List<String> winningNumbers = List.of("1", "2", "3", "4", "5", "6");

        assertThatThrownBy(() -> InputValidator.validateBonusNumberInput(bonusNumberInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 보너스 번호가 당첨 번호와 중복이 있으면 예외가 발생한다.")
    @Test
    void validateBonusNumberInputByDuplicatedNumber() {
        String bonusNumberInput = "6";
        List<String> winningNumbers = List.of("1", "2", "3", "4", "5", "6");

        assertThatThrownBy(() -> InputValidator.validateBonusNumberInput(bonusNumberInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}