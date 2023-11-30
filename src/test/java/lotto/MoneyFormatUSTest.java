package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyFormatUSTest {

    MoneyFormatUS moneyFormatUS = new MoneyFormatUS();

    @Test
    void moneyFormatTest() {
        assertEquals("5,000,000" , moneyFormatUS.moneyFormat(5000000));
    }
}