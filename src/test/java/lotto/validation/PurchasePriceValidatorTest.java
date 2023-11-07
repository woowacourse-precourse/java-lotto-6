package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchasePriceValidatorTest {
    @Test
    void 로또_구입_금액_입력이_null이면_예외발생() {
        // given
        String purchasePrice = null;

        // when, then
        assertThrowOnInvalidPurchasePrice(purchasePrice);
    }

    @Test
    void 로또_구입_금액_입력이_빈문자열이면_예외발생() {
        // given
        String purchasePrice = "";

        // when, then
        assertThrowOnInvalidPurchasePrice(purchasePrice);
    }

    @Test
    void 로또_구입_금액_입력이_숫자가_아니면_예외발생() {
        // given
        String purchasePrice = "1000a";

        // when, then
        assertThrowOnInvalidPurchasePrice(purchasePrice);
    }

    @Test
    void 로또_구입_금액_입력이_int형_범위를_벗어나면_예외발생() {
        // given
        String purchasePrice = "10000000000000";

        // when, then
        assertThrowOnInvalidPurchasePrice(purchasePrice);
    }

    @Test
    void 로또_구입_금액_입력이_음수면_예외발생() {
        // given
        String purchasePrice = "-100000";

        // when, then
        assertThrowOnInvalidPurchasePrice(purchasePrice);
    }

    @Test
    void 로또_구입_금액_입력이_1000으로_나누어_떨어지지_않으면_예외발생() {
        // given
        String purchasePrice = "100001";

        // when, then
        assertThrowOnInvalidPurchasePrice(purchasePrice);
    }

    @Test
    void 로또_구입_금액_정상값_테스트() {
        // given
        String purchasePrice = "100000";

        // when, then
        assertNotThrowsOnValidPurchasePrice(purchasePrice);
    }

    private static void assertNotThrowsOnValidPurchasePrice(String purchasePrice) {
        assertDoesNotThrow(() -> {
            Validator.validatePurchasePrice(purchasePrice);
        });
    }

    private static void assertThrowOnInvalidPurchasePrice(String purchasePrice) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validatePurchasePrice(purchasePrice);
        });
    }
}