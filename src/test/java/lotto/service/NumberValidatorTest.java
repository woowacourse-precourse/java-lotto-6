package lotto.service;

import java.util.List;
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

    @DisplayName("보너스 번호가 당첨 번호에 속해있으면 예외를 발생시킨다")
    @Test
    void validateDuplicateNumber() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> numberValidator.validateDuplicateNumber(4, List.of(1, 2, 3, 4, 5, 6))),
                () -> Assertions.assertDoesNotThrow(
                        () -> numberValidator.validateDuplicateNumber(1, List.of(2, 3, 4, 5, 6, 7)))
        );
    }

    @DisplayName("구매 금액이 1000원 단위인지 확인한다. 1000원단위가 아니면 예외를 발생시킨다.")
    @Test
    void validatePurchasePrice() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> numberValidator.validatePurchasePrice(1042)),
                () -> Assertions.assertDoesNotThrow(() -> numberValidator.validatePurchasePrice(2000))
        );
    }

    @DisplayName("로또 번호가 6개인지 확인한다. 6개가 아니면 예외를 발생시킨다")
    @Test
    void isSixNumber() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> numberValidator.validateInputDataLengthIsSix(
                                new String[]{"1", "2"})),
                () -> Assertions.assertDoesNotThrow(
                        () -> numberValidator.validateInputDataLengthIsSix(new String[]{"1", "2", "3", "4", "5", "6"}))
        );
    }
}
