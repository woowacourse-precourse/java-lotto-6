package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseAmountTest {
    @ParameterizedTest
    @NullSource
    public void 입력값이_null인_경우_예외테스트(String input) {
        //given
        final String nullString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(nullString));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @EmptySource
    public void 입력값이_비어있는_경우_예외테스트(String input) {
        //given
        final String emptyString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(emptyString));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "+", "-", "1a", "1+", "1-", "a1"})
    public void 입력값이_숫자가_아닌_경우_예외테스트(String input) {
        //given
        final String notNumberString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(notNumberString));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1000"})
    public void 금액이_양수가_아닌_경우_예외테스트(String input) {
        //given
        final String notPositiveNumber = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(notPositiveNumber));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_POSITIVE_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "100", "500", "999", "1001"})
    public void 금액이_로또_가격으로_나누어_떨어지지_않는_경우_예외테스트(String input) {
        //given
        final String notDivisibleNumber = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(notDivisibleNumber));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_DIVISIBLE_EXCEPTION);
    }
}
