package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.InputDataValidator;

public class BonusNumberTest {

    InputDataValidator inputDataValidator = new InputDataValidator();

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkIsNumericBonusNumber() {
        String bonusNumber = "7ff";
        assertThatThrownBy(() -> inputDataValidator.validIntegerInput(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1미만의 숫자면 예외가 발생한다.")
    @Test
    void checkBonusNumberRange() {
        String bonusNumber = "0";
        assertThatThrownBy(() -> inputDataValidator.validMaxMinBonusNumber(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45를 초과 하는 숫자면 예외가 발생한다.")
    @Test
    void checkBonusNumberRange2() {
        String bonusNumber = "46";
        assertThatThrownBy(() -> inputDataValidator.validMaxMinBonusNumber(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호가 있으면 예외가 발생한다.")
    @Test
    void checkDuplicateBonusNumberWithWinningNumber() {
        String[] winningNumber = {"1", "2", "3", "4", "5", "6"};
        String bonusNumber = "3";
        assertThatThrownBy(
            () -> inputDataValidator.validDuplicateBonusNumberWithWinningNumber(bonusNumber,
                winningNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
