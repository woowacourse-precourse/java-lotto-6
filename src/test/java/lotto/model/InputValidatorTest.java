package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.view.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("유효한 입력 금액이 정수로 올바르게 파싱되는지 검증")
    @Test
    void createValidInputMoney() {
        String validInputMoney = "2000";
        int result = inputValidator.validateInputMoney(validInputMoney);
        assertThat(result).isEqualTo(2000);
    }

    @DisplayName("숫자가 아닌 입력 금액이 주어졌을 때 IllegalArgumentException이 발생하는지 검증")
    @Test
    void createNonNumericInputMoney() {
        String nonNumericInputMoney = "!@#";
        assertThatThrownBy(() -> inputValidator.validateInputMoney(nonNumericInputMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 구매 금액이 주어졌을 때 IllegalArgumentException이 발생하는지 검증")
    @Test
    void createInvalidPurchaseAmount() {
        String invalidPurchaseAmount = "1050";
        assertThatThrownBy(() -> inputValidator.validateInputMoney(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 보너스 번호가 정수로 올바르게 파싱되는지 검증")
    @Test
    void createValidBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String validBonusNumber = "7";
        int result = inputValidator.validateBonusNumber(winningNumbers, validBonusNumber);
        assertThat(result).isEqualTo(7);
    }

    @DisplayName("유효하지 않은 보너스 번호가 주어졌을 때 IllegalArgumentException이 발생하는지 검증")
    @Test
    void createInvalidBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String invalidBonusNumber = "66";
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(winningNumbers, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 포함된 보너스 번호가 주어졌을 때 IllegalArgumentException이 발생하는지 검증")
    @Test
    void createBonusNumberInWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNumberInWinningNumbers = "1";
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(winningNumbers, bonusNumberInWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 당첨 번호가 주어졌을 때 IllegalArgumentException이 발생하는지 검증")
    @Test
    void createWinningNumbersWithDuplicates() {
        String winningNumbersWithDuplicates = "1, 2, 3, 4, 5, 5";
        assertThatThrownBy(() -> inputValidator.validateAndParseWinningNumbers(winningNumbersWithDuplicates))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 당첨 번호가 주어졌을 때 IllegalArgumentException이 발생하는지 검증")
    @Test
    void createWinningNumbersOutOfRange() {
        String winningNumbersOutOfRange = "0, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> inputValidator.validateAndParseWinningNumbers(winningNumbersOutOfRange))
                .isInstanceOf(IllegalArgumentException.class);
    }
}