package lotto.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    private NumberValidator numberValidator;

    public NumberValidatorTest() {
        numberValidator = new NumberValidator();
    }

    @DisplayName("입력값이 숫자인지 검증한다. 숫자가 아니면 예외를 발생시킨다")
    @Test
    void validatePurchasePriceIsNumber() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> numberValidator.validateInputDataIsNumber("ㅁㄴㅁ")),
                () -> Assertions.assertDoesNotThrow(() -> numberValidator.validateInputDataIsNumber("123"))
        );
    }

    @DisplayName("구매금액이 숫자인지 검증한다. 숫자가 아니면 예외를 발생시킨다")
    @Test
    void validateDuplicateNumber() {

    }

    @DisplayName("구매금액이 숫자인지 검증한다. 숫자가 아니면 예외를 발생시킨다")
    @Test
    void validatePurchasePrice() {

    }
}
