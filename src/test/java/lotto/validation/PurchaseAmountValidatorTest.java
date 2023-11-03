package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {

    @DisplayName("입력 값이 공백으로만 이루어진 문자열이면 예외를 발생시킨다")
    @Test
    void blankStringThrowIllegalArgumentException() {
        //given
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

        //when, then
        assertThatThrownBy(() -> purchaseAmountValidator.validatePurchaseAmount("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백으로만 이루어진 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("입력 값이 빈 문자열이면 예외를 발생시킨다.")
    @Test
    void emptyStringThrowIllegalArgumentException() {
        //given
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

        //when, then
        assertThatThrownBy(() -> purchaseAmountValidator.validatePurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("입력 값이 1000원 단위가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"500", "1300", "2100"})
    void notDivisibleByThousandThrowIllegalArgumentException(String purchaseAmount) {
        //given
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

        //when, then
        assertThatThrownBy(() -> purchaseAmountValidator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 단위만 입력할 수 있습니다.");

    }

    @DisplayName("입력 값이 숫자가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"money", "2000원", "hello"})
    void notNumberThrowIllegalArgumentException(String purchaseAmount) {
        //given
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

        //when, then
        assertThatThrownBy(() -> purchaseAmountValidator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력할 수 있습니다.");
    }

    @DisplayName("입력 값이 1000원 단위의 숫자면 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "15000", "0"})
    void NumberThrowIllegalArgumentException(String purchaseAmount) {
        //given
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

        //when, then
        assertDoesNotThrow(() -> purchaseAmountValidator.validatePurchaseAmount(purchaseAmount));
    }
}