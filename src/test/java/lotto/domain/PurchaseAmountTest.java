package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseAmountTest {
    @DisplayName("입력값이 null이면 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    void createPurchaseAmountByNullString(String input) {
        //given
        final String nullString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(nullString));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("입력값이 비어있으면 예외가 발생한다.")
    @ParameterizedTest
    @EmptySource
    void createPurchaseAmountByEmptyString(String input) {
        //given
        final String emptyString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(emptyString));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "+", "-", "1a", "1+", "1-", "a1"})
    void createPurchaseAmountByNotNumber(String input) {
        //given
        final String notNumberString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(notNumberString));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("입력값이 양수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1000"})
    void createPurchaseAmountByNotPositiveNumber(String input) {
        //given
        final String notPositiveNumber = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(notPositiveNumber));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_POSITIVE_EXCEPTION);
    }

    @DisplayName("입력값이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "100", "500", "999", "1001"})
    void createPurchaseAmountByNotDivisible(String input) {
        //given
        final String notDivisibleNumber = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(notDivisibleNumber));

        //then
        assertThat(exception.getMessage()).isEqualTo(PurchaseAmount.PURCHASE_AMOUNT_NOT_DIVISIBLE_EXCEPTION);
    }

    @DisplayName("입력값이 로또 가격으로 나누어 떨어지면 정상적으로 작동한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "5000", "10000"})
    void createPurchaseAmountByValidNumber(String input) {
        //given
        final String validNumber = input;

        // when, then
        assertThatCode(() -> new PurchaseAmount(validNumber))
                .doesNotThrowAnyException();
    }
}
