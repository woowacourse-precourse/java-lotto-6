package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.contents.ContentErrors;
import lotto.utils.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class InputTest {
    @DisplayName("음수 금액을 입력하면 예외가 발생한다.")
    @Test
    void validateNonNegativeAmount() {
        int negativeAmount = -1000;
        assertThatThrownBy(() -> ValidationUtil.validateNonNegative(negativeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.NEGATIVE_AMOUNT.getErrorMessage());
    }

    @DisplayName("1000원 단위가 아닌 금액을 입력하면 예외가 발생한다.")
    @Test
    void validateThousandUnitAmount() {
        int invalidAmount = 1500;
        assertThatThrownBy(() -> ValidationUtil.validateThousandUnit(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.INVALID_AMOUNT.getErrorMessage());
    }

    @Test
    @DisplayName("입력값이 null이거나 공백만 있는 경우 예외를 발생시킨다.")
    void validateEmptyOrWhitespace() {
        assertThatThrownBy(() -> ValidationUtil.validateBlank(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.BLANK_SPACE_IN_INPUT.getErrorMessage());

        assertThatThrownBy(() -> ValidationUtil.validateBlank(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.BLANK_SPACE_IN_INPUT.getErrorMessage());
    }

    @Test
    @DisplayName("각 숫자가 1~45 범위에 없는 경우 예외를 발생시킨다.")
    void validateNumberRange() {
        List<Integer> numbersOutOfRange = Arrays.asList(0, 46, 2, 3, 4, 5);
        assertThatThrownBy(() -> ValidationUtil.validateNumberRange(numbersOutOfRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.INVALID_RANGE.getErrorMessage());
    }

    @Test
    @DisplayName("숫자들 사이에 중복이 있는 경우 예외를 발생시킨다.")
    void validateNoDuplicates() {
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 3, 4, 5);
        assertThatThrownBy(() -> ValidationUtil.validateNoDuplicates(numbersWithDuplicates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.DUPLICATE_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("정확히 6개의 숫자가 입력되지 않은 경우 예외를 발생시킨다.")
    void validateNumbersCount() {
        List<Integer> incorrectNumbersCount = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> ValidationUtil.validateCorrectNumbersCount(incorrectNumbersCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.VALID_LOTTO_NUMBERS_COUNT.getErrorMessage());
    }

    @Test
    @DisplayName("입력된 문자열이 숫자와 쉼표로만 이루어져 있지 않은 경우 예외를 발생시킨다.")
    void validateSpecialCharacters() {
        String invalidCharactersInput = "1, 2, 3, 4, 5, a";
        assertThatThrownBy(() -> ValidationUtil.validateSpecialCharacters(invalidCharactersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.INVALID_NUMBER_FORMAT.getErrorMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외를 발생시킨다.")
    void validateBonusNumberOutOfRange() {
        int bonusNumber = 46; // 범위를 벗어나는 경우
        assertThatThrownBy(() -> ValidationUtil.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.INVALID_BONUS_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 발생시킨다.")
    void validateBonusNumberDuplicateWithWinningNumbers() {
        int bonusNumber = 10;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 10); // 중복되는 경우
        assertThatThrownBy(() -> ValidationUtil.validateBonusNumberNotInWinningNumbers(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.BONUS_NUMBER_DUPLICATE.getErrorMessage());
    }
    @Test
    @DisplayName("로또 당첨 번호의 입력길이가 초과된 경우 예외를 발생시킨다.")
    void inputValidateWinningNumbersOutOfRange() {
        String WinningNumbersOutCase = "11,22,33,44,23,1245";
        assertThatThrownBy(() -> ValidationUtil.validateWinningNumbersOutOfRange(WinningNumbersOutCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.INPUT_OUT_OF_RANGE.getErrorMessage());
    }
    @Test
    @DisplayName("1인당 100000원 이상 로또를 구매할 시 예외를 발생 시킨다.")
    void inputValidatePurchaseAmount() {
        int PurchaseAmount = 100001;
        assertThatThrownBy(() -> ValidationUtil.validatePurchaseAmountRange(PurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ContentErrors.INVALID_OUT_OF_RANGE.getErrorMessage());
    }
}
