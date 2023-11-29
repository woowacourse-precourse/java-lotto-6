package lotto.validation;

import static lotto.constant.ValidateMessage.PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.constant.ValidateMessage.PURCHASE_PRICE_IS_NOT_INTEGER;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceValidatorTest {
    private final PurchasePriceValidator purchasePriceValidator;

    PurchasePriceValidatorTest() {
        purchasePriceValidator = new PurchasePriceValidator();
    }


    @DisplayName("구입 금액은 null or empty 이면 예외가 발생한다.")
    @Test
    void isNullOrEmptyTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> purchasePriceValidator.isNullOrEmpty(null));

        //then
        assertTrue(exception.getMessage().contains(PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY.message));
    }

    @DisplayName("구입 금액은 정수가 아닌 문자가 입력되면 예외가 발생한다.")
    @Test
    void isNotInteger() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> purchasePriceValidator.isInteger("1,2,3,4,5,6"));

        //then
        assertTrue(exception.getMessage().contains(PURCHASE_PRICE_IS_NOT_INTEGER.message));
    }

}