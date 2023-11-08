package lotto.validators;

import static lotto.constant.ErrorMessage.INPUT_PRICE_IS_NOT_GREATER_THAN_ZERO;
import static lotto.constant.ErrorMessage.INPUT_PRICE_IS_NOT_MULTIPLE_OF_LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchaseValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "-1000, " + INPUT_PRICE_IS_NOT_GREATER_THAN_ZERO,
            "1500, " + INPUT_PRICE_IS_NOT_MULTIPLE_OF_LOTTO_PRICE
    })
    @DisplayName("로또 구매 금액 입력이 1,000원 단위가 아니거나, 음수인 경우 예외가 발생한다.")
    void validPurchasePrice(Integer purchasePrice, String expectedMessage) {
        assertThatThrownBy(() -> PurchaseValidator.validPurchasePrice(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}
