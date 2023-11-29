package lotto.model;

import static lotto.exception.ErrorInputException.ErrorMessage.PURCHASE_PRICE_CAN_DIVIDE_BY_THOUSAND;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceTest {

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {999, 10001, 19999, 20001})
    void not_Divided_By_Thousand(int purchasePrice) {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PurchasePrice.createPurchasePrice(purchasePrice));

        //then
        assertTrue(exception.getMessage().contains(PURCHASE_PRICE_CAN_DIVIDE_BY_THOUSAND.getMessage()));
    }

    @DisplayName("구입 금액이 1,000원 단위라면 정상 작동한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 20000})
    void Divided_By_Thousand(int purchasePrice) {
        //then
        assertDoesNotThrow(() -> PurchasePrice.createPurchasePrice(purchasePrice));
    }
}