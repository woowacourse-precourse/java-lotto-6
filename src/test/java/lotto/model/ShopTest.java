package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {
    @Test
    public void testShopCreation() {
        int purchaseAmount = 5000;
        Shop shop = Shop.of(purchaseAmount);

        assertNotNull(shop);
        assertEquals(purchaseAmount, shop.getPurchaseNumber() * 1000);
        assertNotNull(shop.givePaperBag());
    }

    @Test
    public void testInvalidShopCreation() {
        int invalidPurchaseAmount = 1501;
        try {
            Shop shop = Shop.of(invalidPurchaseAmount);
            fail("예외가 발생해야 합니다.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
