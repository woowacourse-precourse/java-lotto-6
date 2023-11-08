package lotto.model;

import static lotto.util.Constants.PURCHASE_PRICE_UNIT;
import static lotto.util.ExceptionMessage.PURCHASE_INVALID_TYPE;
import static lotto.util.ExceptionMessage.PURCHASE_INVALID_UNIT;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseTest {

    @Test
    void 구입금액이_숫자_이외의_문자이면_안된다() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new Purchase("asdf"));
        assertEquals(e.getMessage(), PURCHASE_INVALID_TYPE.getMessage());
    }

    @Test
    void 구입금액이_1000단위의_숫자여야_한다() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new Purchase("123"));
        assertEquals(e.getMessage(), String.format(PURCHASE_INVALID_UNIT.getMessage(),PURCHASE_PRICE_UNIT));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,'[ERROR] 구매 금액은 양수이고, 1000단위로 입력해주세요.'",
        "-5000,'[ERROR] 구매 금액은 양수이고, 1000단위로 입력해주세요.'",
    })
    void 구임금액이_0보다_커야_한다(String price, String exceptionMessage) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new Purchase(price));
        assertEquals(e.getMessage(), exceptionMessage);
    }

}