package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.controller.InputValidator;
import lotto.util.ErrorConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("구입 금액이 숫자가 아닐 때 예외를 던진다")
    void validatePurchaseAmount_NotANumber_ThrowsException() {
        String input = "9천9백원";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.OVER_INTEGER);
    }

    @Test
    @DisplayName("구입 금액이 정수 범위가 아닐 때 예외를 던진다")
    void validatePurchaseAmount_NotAIntRange_ThrowsException() {
        String input = "12345678910";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.OVER_INTEGER);
    }

    @Test
    @DisplayName("구입 금액이 1000원 미만일 때 예외를 던진다")
    void validatePurchaseAmount_LessThanMinimum_ThrowsException() {
        String input = "500";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.THOUSAND_UNIT);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 때 예외를 던진다")
    void validatePurchaseAmount_NotAThousandUnit_ThrowsException() {
        String input = "2500";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.THOUSAND_UNIT);
    }

    @Test
    @DisplayName("올바른 구입금액 입력일 때, 예외를 던지지 않는다.")
    void validateWinningNumbers_InputIsValid_DoesNotThrowException() {
        String input = "2000";

        assertThatCode(() -> InputValidator.validatePurchaseAmount(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호가 쉼표로 구분되지 않았을 때 예외를 던진다")
    void validateWinningNumbers_SeparateComma_ThrowsException() {
        String input = "1;2;3;4;5;6";

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INADEQUATE_INPUT);
    }

    @Test
    @DisplayName("당첨 번호가 숫자로 구성되어 있지 않았을 때 예외를 던진다")
    void validateWinningNumbers_NotANumber_ThrowsException() {
        String input = "1,2,a,4,5,6";

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INADEQUATE_INPUT);
    }

    @Test
    @DisplayName("당첨 번호가 6개의 숫자로 이루어지지 않았을 때 예외를 던진다")
    void validateWinningNumbers_NoLength6_ThrowsException() {
        String input = "1,2,3,4,5,7,8";

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INADEQUATE_INPUT);
    }

    @Test
    @DisplayName("당첨 번호 입력에 쉼표가 연속되었을 때 예외를 던진다")
    void validateWinningNumbers_InputContainsConsecutiveComma_ThrowsException() {
        String input = "1,,2,3,4,5,6";

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INADEQUATE_INPUT);
    }

    @Test
    @DisplayName("당첨 번호가 쉼표로 시작할 때 예외를 던진다.")
    void validateWinningNumbers_InputStartsWithComma_ThrowsException() {
        String input = ",1,2,3,4,5,6";

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INADEQUATE_INPUT);
    }

    @Test
    @DisplayName("당첨 번호가 쉼표로 끝날 때 예외를 던진다.")
    void validateWinningNumbers_InputEndsWithComma_ThrowsException() {
        String input = "1,2,3,4,5,6,";

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INADEQUATE_INPUT);
    }

    @Test
    @DisplayName("당첨 번호가 정수 허용값을 넘어섰을 때 예외를 던진다")
    void validateWinningNumbers_NotAIntRange_ThrowsException() {
        String input = "1,2,3,4,5,12345678910";

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.OVER_INTEGER);
    }

    @Test
    @DisplayName("올바른 당첨 번호 입력일 때, 예외를 던지지 않는다.")
    void validateCarNamesInput_InputIsValid_DoesNotThrowException() {
        String input = "1,2,3,4,5,6";

        assertThatCode(() -> InputValidator.validateWinningNumbers(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외를 던진다")
    void validateBonusNumber_DuplicateWithWinningNumber_ThrowsException() {
        String bonusNumber = "6";

        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.DUPLICATE_NUMBER);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 때 예외를 던진다")
    void validateBonusNumber_NotANumber_ThrowsException() {
        String bonusNumber = "abc";

        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.OVER_INTEGER);
    }

    @Test
    @DisplayName("보너스 번호가 1-45 범위가 아닐 때 예외를 던진다")
    void validateBonusNumber_OverRange_ThrowsException() {
        String bonusNumber = "47";

        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.OVER_RANGE);
    }

    @Test
    @DisplayName("올바른 보너스 번호 입력일 때, 예외를 던지지 않는다.")
    void validateBonusNumber_InputIsValid_DoesNotThrowException() {
        String bonusNumber = "7";

        assertThatCode(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .doesNotThrowAnyException();
    }
}