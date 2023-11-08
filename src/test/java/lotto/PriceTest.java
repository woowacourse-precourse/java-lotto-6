package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @DisplayName("구입 금액이 올바를 때")
    @Test
    void validPrice() {
        Price price = new Price();

        boolean isValid = price.isValidPrice("3000");

        assertTrue(isValid);
    }

    @DisplayName("구입 금액 입력이 1000 단위가 아닐 때")
    @Test
    void invalidPriceWithUnit() {
        Price price = new Price();

        boolean isValid = price.isValidPrice("1234");

        assertFalse(isValid);
    }

    @DisplayName("구입 금액 입력이 문자일 때")
    @Test
    void invalidPriceWithCharacter() {
        Price price = new Price();

        boolean isValid = price.isValidPrice("abc");

        assertFalse(isValid);
    }
}