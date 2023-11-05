package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoInputValidatorTest {
    @DisplayName("입력한 로또 구입금액은 로또의 가격과 나누어떨어져야 한다")
    @Test
    void testValidPurchasePrice() {
        int validPurchasePrice = LottoConstants.LOTTO_PRICE.getConstant() * 5;

        LottoInputValidator.purchasePriceIsValid(validPurchasePrice);
    }

    @DisplayName("입력한 로또 구입금액이 로또의 가격과 나누어떨어지지 않는다면"
            + "IllegalArgumentException Error 가 발생한다")
    @Test
    void testInvalidPurchasePrice() {
        int invalidPurchasePrice = LottoConstants.LOTTO_PRICE.getConstant() + 1;

        try {
            LottoInputValidator.purchasePriceIsValid(invalidPurchasePrice);
            fail("IllegalArgumentException 이 발생하지 않았습니다");
        } catch (IllegalArgumentException e) {
            assertEquals(
                    LottoErrorMessageConstants.PURCHASE_PRICE_NOT_INDIVISIBLE_PRICE_ERROR_MESSAGE.getMessage(),
                    e.getMessage()
            );
        }
    }
}
