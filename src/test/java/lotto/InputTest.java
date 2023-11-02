package lotto;


import lotto.contents.ContentErrors;
import lotto.utils.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @DisplayName("음수 금액을 입력하면 예외가 발생한다.")
    @Test
    void validateNonNegativeWithNegativeAmount() {
        int negativeAmount = -1000;
        assertThatThrownBy(() -> ValidationUtil.validateNonNegative(negativeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 음수일 수 없습니다.");
    }

    @DisplayName("1000원 단위가 아닌 금액을 입력하면 예외가 발생한다.")
    @Test
    void validateThousandUnitWithInvalidAmount() {
        int invalidAmount = 1500;
        assertThatThrownBy(() -> ValidationUtil.validateThousandUnit(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 금액이 유효하지 않습니다. 1,000원 단위로 입력해주세요.");
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
    void validateCorrectNumbersCount() {
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
}