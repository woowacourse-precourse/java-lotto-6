package lotto.controller;

import java.util.List;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    @DisplayName("입력받은 값이 숫자가 아닌 경우 예외를 발생시킨다.")
    void isNumber_NotNumber_ThrowsException() {
        String input = "abc";
        assertThatThrownBy(() -> Validator.isNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER);
    }

    @Test
    @DisplayName("입력받은 값이 숫자인 경우 해당 숫자를 반환한다.")
    void isNumber_Number_ReturnsNumber() {
        String input = "1000";
        int expected = 1000;
        assertThat(Validator.isNumber(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("구매 금액이 1000의 배수가 아닌 경우 예외를 발생시킨다.")
    void isThousandUnit_NotMultipleOfThousand_ThrowsException() {
        int purchasePrice = 1500;
        assertThatThrownBy(() -> Validator.isThousandUnit(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_THOUSAND_UNIT);
    }

    @Test
    @DisplayName("1에서 45 사이의 범위가 아닌 번호는 예외를 발생시킨다.")
    void isValidRange_OutOfRange_ThrowsException() {
        int input = 46;
        assertThatThrownBy(() -> Validator.isValidRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_RANGE);
    }

    @Test
    @DisplayName("1에서 45 사이의 범위에 있는 번호는 해당 번호를 반환한다.")
    void isValidRange_ValidRange_ReturnsNumber() {
        int input = 45;
        assertThat(Validator.isValidRange(input)).isEqualTo(input);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우 예외를 발생시킨다.")
    void isSixNumber_NotSixNumbers_ThrowsException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> Validator.isSixNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INPUT);
    }

    @Test
    @DisplayName("로또 번호가 6개인 경우 해당 번호 리스트를 반환한다.")
    void isSixNumber_SixNumbers_ReturnsNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(Validator.isSixNumber(numbers)).isEqualTo(numbers);
    }

    @Test
    @DisplayName("구매 금액 입력이 올바르지 않을 경우 예외를 발생시킨다.")
    void validatePurchaseAmount_InvalidInput_ThrowsException() {
        String input = "1000원";
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액 입력이 올바를 경우 금액을 반환한다.")
    void validatePurchaseAmount_ValidInput_ReturnsAmount() {
        String input = "2000";
        int expected = 2000;
        assertThat(Validator.validatePurchaseAmount(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("당첨 번호 입력이 올바르지 않을 경우 예외를 발생시킨다.")
    void validateWinningNumber_InvalidInput_ThrowsException() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> Validator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INPUT);
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어날 경우 예외를 발생시킨다.")
    void validateBonusNumber_OutOfRange_ThrowsException() {
        String inputOutOfRange = "49";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Validator.validateBonusNumber(inputOutOfRange, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_RANGE);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외를 발생시킨다.")
    void validateBonusNumber_DuplicateWithWinningNumber_ThrowsException() {
        String inputDuplicate = "6";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Validator.validateBonusNumber(inputDuplicate, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_DUPLICATE);
    }


}
