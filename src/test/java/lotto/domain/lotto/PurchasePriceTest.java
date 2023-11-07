package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.domain.purchaseprice.PurchasePriceDivisibleException;
import lotto.exception.domain.purchaseprice.PurchasePriceFormatException;
import lotto.exception.domain.purchaseprice.PurchasePriceLowAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구매 금액 검증 테스트")
class PurchasePriceTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,000", "2000", "200000", "01000"})
    @DisplayName("1,000원 단위 금액을 입력했을 때 정상적으로 객체 생성")
    void testValidPurchasePrice(String validPurchasePrice) {
        PurchasePrice validPrice = PurchasePrice.create(validPurchasePrice);

        if (validPurchasePrice.contains(",")) {
            validPurchasePrice = validPurchasePrice.replaceAll(",", "");
        }

        assertEquals(Integer.parseInt(validPurchasePrice), validPrice.getPrice());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "1000$", "1000won"})
    @DisplayName("입력값에 ,나 숫자가 아닌 것이 포함되면 예외 발생")
    void testInValidFormat(String invalidInput) {
        assertThrows(PurchasePriceFormatException.class, () -> {
            PurchasePrice.create(invalidInput);
        });
    }

    @Test
    @DisplayName("1000원 미만의 금액을 입력했을 때 예외 발생")
    void testLowAmount() {
        assertThrows(PurchasePriceLowAmountException.class, () -> {
            PurchasePrice.create("999");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1999", "28,900", "3001"})
    @DisplayName("1000원 단위 금액을 입력하지 않았을 경우 예외 발생")
    void testIndivisibleValue(String indivisibleInput) {
        assertThrows(PurchasePriceDivisibleException.class, () -> {
            PurchasePrice.create(indivisibleInput);
        });
    }
}