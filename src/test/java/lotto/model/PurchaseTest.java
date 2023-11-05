package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {
    private final static String VALID_MONEY = "1000";
    private final static String INVALID_MONEY_NOT_NUMBER = "abc";
    private final static String INVALID_MONEY_MINIMUM_LIMIT = "999";
    private final static String INVALID_MONEY_UNIT_LIMIT = "1001";

    @Test
    @DisplayName("올바른 구입 금액이 입력된 경우")
    void validatePurchaseMoney() {
        assertDoesNotThrow(() -> new Purchase<Lotto> (VALID_MONEY));
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닌 경우")
    void validatePurchaseMoneyNotNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Purchase<Lotto> (INVALID_MONEY_NOT_NUMBER));
    }

    @Test
    @DisplayName("구입 금액이 1000원 미만인 경우")
    void validatePurchaseMoneyMinimumLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Purchase<Lotto> (INVALID_MONEY_MINIMUM_LIMIT));
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우")
    void validatePurchaseMoneyUnitLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Purchase<Lotto> (INVALID_MONEY_UNIT_LIMIT));
    }
}