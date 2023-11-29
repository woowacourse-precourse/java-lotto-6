package lotto.validation;

import static lotto.exception.ErrorInputException.ErrorMessage.PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.exception.ErrorInputException.ErrorMessage.PURCHASE_PRICE_IS_MORE_THAN_ONE;
import static lotto.exception.ErrorInputException.ErrorMessage.PURCHASE_PRICE_IS_NOT_INTEGER;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceValidatorTest {
    private final PurchasePriceValidator purchasePriceValidator;

    PurchasePriceValidatorTest() {
        purchasePriceValidator = new PurchasePriceValidator();
    }

    @DisplayName("구입 금액은 빈 값이거나 null이면 예외가 발생한다.")
    @Test
    void isNullOrEmptyTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> purchasePriceValidator.isBlank(null));

        //then
        assertTrue(exception.getMessage().contains(PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY.getMessage()));
    }

    @DisplayName("구입 금액으로 정수가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void isIntegerTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> purchasePriceValidator.isInteger("Not Integer"));

        //then
        assertTrue(exception.getMessage().contains(PURCHASE_PRICE_IS_NOT_INTEGER.getMessage()));
    }

    @DisplayName("구입 금액은 1보다 큰 자연수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -100})
    void purchasePrice_Greater_Than_One(int input) {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> purchasePriceValidator.moreThanOne(input));

        //then
        assertTrue(exception.getMessage().contains(PURCHASE_PRICE_IS_MORE_THAN_ONE.getMessage()));
    }

}