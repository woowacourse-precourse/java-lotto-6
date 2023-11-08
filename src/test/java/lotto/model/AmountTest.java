package lotto.model;

import lotto.config.LottoPrice;
import lotto.view.Messages;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AmountTest {

    @Test
    public void testValidAmountInitialization() {
        Amount validAmount = new Amount(Integer.toString(LottoPrice.LOTTO_PRICE.getValue() * 2));
        assertNotNull(validAmount);
        assertEquals(2, validAmount.getAmount());
    }

    @Test
    public void testInvalidAmountInitialization() {
        // Invalid amount (less than the minimum price)
        IllegalArgumentException invalidAmountException = assertThrows(IllegalArgumentException.class, () -> new Amount("500"));
        assertEquals(Messages.LOTTO_PRICE_ERROR_MESSAGE, invalidAmountException.getMessage());

        // Invalid amount (not a number)
        IllegalArgumentException invalidNumberException = assertThrows(IllegalArgumentException.class, () -> new Amount("abc"));
        assertEquals(Messages.LOTTO_STATE_ERROR_MESSAGE, invalidNumberException.getMessage());
    }
}
