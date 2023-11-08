package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PurchaseTest {

    @Test
    public void testPurchaseValid() {
        Purchase purchase = new Purchase(5000, 5);
        assertEquals(5000, purchase.getPrice());
        assertEquals(5, purchase.getTicketCount());
    }

    @Test
    public void testPurchaseInvalidPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Purchase(3001, 3);
        });
    }
}
