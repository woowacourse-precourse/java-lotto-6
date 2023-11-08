package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @DisplayName("입력값이 정수가 아니면 예외가 발생한다.")
    @Test
    void inputNonInteger() {
        String input = "ABC";
        assertThatThrownBy(() -> InputValidator.checkIsInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 양수가 아니면 예외가 발생한다.")
    @Test
    void inputNonPositiveForPurchaseAmount() {
        int amount = -1000;
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void inputIndivisiblePurchaseAmount() {
        int amount = 3500;
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1부터 45 사이의 수가 아닌 경우 예외가 발생한다.")
    @Test
    void inputBonusOverRange() {
        int bonus = 46;
        assertThatThrownBy(() -> InputValidator.validateBonus(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 정수가 아닌 수가 있으면 예외가 발생한다.")
    @Test
    void inputLottoNumberForNonInteger() {
        String numbers = "1,2,3,4,5,6.5";
        assertThatThrownBy(() -> InputValidator.validateLottoFormat(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
