package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationUtilsTest {

    @ParameterizedTest
    @NullSource
    public void 입력값이_null인_경우_예외테스트(String input) {
        //given
        final String nullString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validatePurchaseAmountNumber(nullString));

        //then
        assertThat(exception.getMessage()).isEqualTo(ValidationUtils.PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @EmptySource
    public void 입력값이_비어있는_경우_예외테스트(String input) {
        //given
        final String emptyString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validatePurchaseAmountNumber(emptyString));

        //then
        assertThat(exception.getMessage()).isEqualTo(ValidationUtils.PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "+", "-", "1a", "1+", "1-", "a1"})
    public void 입력값이_숫자가_아닌_경우_예외테스트(String input) {
        //given
        final String notNumberString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validatePurchaseAmountNumber(notNumberString));

        //then
        assertThat(exception.getMessage()).isEqualTo(ValidationUtils.PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    public void 입력값이_양수가_아닌_경우_예외테스트(int input) {
        //given
        final int notPositiveNumber = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.validatePurchaseAmountPositive(notPositiveNumber));

        //then
        assertThat(exception.getMessage()).isEqualTo(ValidationUtils.PURCHASE_AMOUNT_NOT_POSITIVE_EXCEPTION);
    }
}
