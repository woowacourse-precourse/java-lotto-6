package lotto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchasedLottosTest {

    @Test
    public void testLottosToString() {
        Purchase purchase = new Purchase(5000);
        PurchasedLottos purchasedLottos = new PurchasedLottos(purchase);
        StringBuilder expectedStringBuilder = new StringBuilder();
        for (int i = 0; i < purchase.getTicketCount(); i++) {
            expectedStringBuilder.append(purchasedLottos.getLottos().get(i).toString());
            expectedStringBuilder.append("\n");
        }
        String expected = expectedStringBuilder.toString();
        String actual = purchasedLottos.LottosToString();
        assertEquals(expected, actual);
    }
}
