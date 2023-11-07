package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InputViewTest {
    private InputView inputView = new InputView();

    @DisplayName("구매 금액에 공백이 포함되어 있으면 예외 발생")
    @Test
    void validatePurchaseAmount_ContainsSpace() {
        String input = "10 000";
        assertThatThrownBy(() -> inputView.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백이 없는 값이어야 합니다.");
    }

    @DisplayName("구매 금액이 숫자가 아니면 예외 발생")
    @Test
    void validatePurchaseAmount_NotANumber() {
        String input = "abc";
        assertThatThrownBy(() -> inputView.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값은 유효한 범위의 숫자여야 합니다.");
    }

    @DisplayName("구매 금액이 1,000의 배수가 아니면 예외 발생")
    @Test
    void validatePurchaseAmount_NotMultipleOf1000() {
        String input = "1050";
        assertThatThrownBy(() -> inputView.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값은 1,000의 배수여야 합니다.");
    }

    @DisplayName("구매 금액이 최대 범위를 벗어나면 예외 발생")
    @Test
    void validatePurchaseAmount_OutOfMaxRange() {
        String input = "1001000";
        assertThatThrownBy(() -> inputView.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값은 1,000이상, 1,000,000이하의 숫자여야 합니다.");
    }

    @DisplayName("구매 금액이 최소 범위를 벗어나면 예외 발생")
    @Test
    void validatePurchaseAmount_OutOfMinRange() {
        String input = "-1000";
        assertThatThrownBy(() -> inputView.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값은 1,000이상, 1,000,000이하의 숫자여야 합니다.");
    }

    @DisplayName("입력된 답변이 올바른 형식인지 확인")
    @Test
    void testValidateInputAnswer() {
        String validInput = "1,2,3,4,5,6";
        assertDoesNotThrow(() -> inputView.validateInputAnswer(validInput));
    }

    @DisplayName("입력된 답변이 공백을 포함하는지 확인")
    @Test
    void testValidateInputAnswerWhiteSpace() {
        String invalidInput = "1,22,33,44,45";
        assertThatThrownBy(() -> inputView.validateInputAnswer(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 6개의 숫자를 입력해주세요.");
    }

    @DisplayName("입력된 답변이 쉼표로 시작하는지 확인")
    @Test
    void testValidateInputAnswerStart() {
        String invalidInput = ",1,2,3,4,5,6";
        assertThatThrownBy(() -> inputView.validateInputAnswer(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표로 시작하거나 끝나면 안됩니다.");
    }

    @DisplayName("입력된 답변이 쉼표로 끝나는지 확인")
    @Test
    void testValidateInputAnswerEnd() {
        String invalidInput = "1,2,3,4,5,6,";
        assertThatThrownBy(() -> inputView.validateInputAnswer(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표로 시작하거나 끝나면 안됩니다.");
    }

    @DisplayName("입력된 답변이 최대값을 넘는지 확인")
    @Test
    void testValidateInputAnswerMaxRange() {
        String invalidInput = "1,2,3,4,5,666666666666666666666666";
        assertThatThrownBy(() -> inputView.validateInputAnswer(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 잘못된 범위의 입력입니다.");
    }

    @DisplayName("입력된 답변이 최소값을 넘는지 확인")
    @Test
    void testValidateInputAnswerMinRange() {
        String invalidInput = "0,1";
        assertThatThrownBy(() -> inputView.validateInputAnswer(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 잘못된 범위의 입력입니다.");
    }

    @DisplayName("입력된 답변이 올바른 여섯 자리 형식인지 확인")
    @Test
    void testValidateInputSixAnswer() {
        String invalidInput = "1,22,33,44,45";
        assertThatThrownBy(() -> inputView.validateInputAnswer(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 6개의 숫자를 입력해주세요.");
    }

    @DisplayName("유효한 입력으로부터 정수 리스트를 올바르게 반환")
    @Test
    void testValidateAnswerNumber_ValidInput() {
        String validInput = "1,2,3,4,5,6";
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> actualNumbers = inputView.validateAnswerNumber(validInput);
        assertThat(actualNumbers).isEqualTo(expectedNumbers);
    }

    @DisplayName("유효하지 않은 입력에 대해 예외 발생")
    @Test
    void testValidateAnswerNumber_InvalidInput() {
        String invalidInput = "1,2,three,4,5,6";
        assertThatThrownBy(() -> inputView.validateAnswerNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputView.VALIDATE_STRING_TO_INT_MESSAGE);
    }

    @DisplayName("번호 리스트가 로또 번호 범위 내에 있고 중복되지 않으면 예외 발생하지 않음")
    @Test
    void testValidateAnswerNumberRange_ValidInput() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> inputView.validateAnswerNumberRange(validNumbers));
    }

    @DisplayName("번호 리스트가 로또 번호 범위를 벗어나면 예외 발생")
    @Test
    void testValidateAnswerNumberRange_OutOfMaxRange() {
        List<Integer> outOfRangeNumbers = List.of(1, 2, 3, 4, 5, 46); // 0은 유효 범위 밖
        assertThatThrownBy(() -> inputView.validateAnswerNumberRange(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("번호 리스트가 로또 번호 범위를 벗어나면 예외 발생")
    @Test
    void testValidateAnswerNumberRange_OutOfMinRange() {
        List<Integer> outOfRangeNumbers = List.of(0, 2, 3, 4, 5, 6); // 0은 유효 범위 밖
        assertThatThrownBy(() -> inputView.validateAnswerNumberRange(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("번호 리스트에 중복된 숫자가 있으면 예외 발생")
    @Test
    void testValidateAnswerNumberRange_DuplicateNumbers() {
        List<Integer> duplicateNumbers = List.of(1, 2, 2, 4, 5, 6); // '2'가 중복됨
        assertThatThrownBy(() -> inputView.validateAnswerNumberRange(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자입니다.");
    }

    @DisplayName("보너스 번호가 올바른 경우 예외 발생하지 않음")
    @Test
    void testValidateBonusNumber_Valid() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "7";
        assertDoesNotThrow(() -> inputView.validateBonusNumber(winningNumbers, bonusNumber));
    }

    @DisplayName("보너스 번호가 0 이하면 예외 발생")
    @Test
    void testValidateBonusNumber_LessThanMinimum() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "0";
        assertThatThrownBy(() -> inputView.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 46 이상이면 예외 발생")
    @Test
    void testValidateBonusNumber_GreaterThanMaximum() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "46";
        assertThatThrownBy(() -> inputView.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
    @Test
    void testValidateBonusNumber_DuplicateWithWinningNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "6";
        assertThatThrownBy(() -> inputView.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 중복된 숫자입니다.");
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외 발생")
    @Test
    void testValidateBonusNumber_NotANumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "abc";
        assertThatThrownBy(() -> inputView.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputView.VALIDATE_STRING_TO_INT_MESSAGE);
    }

    @DisplayName("보너스 번호에 공백이 있으면 예외 발생")
    @Test
    void testValidateBonusNumber_ContainsSpace() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = " 7";
        assertThatThrownBy(() -> inputView.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputView.VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE);
    }
}
