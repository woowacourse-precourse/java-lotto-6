package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseServiceTest {

    PurchaseService purchaseService;

    @BeforeEach
    void setUp() {
        purchaseService = new PurchaseService();
    }

    @Test
    void 옳은_값이_들어오면_Purchase를_생성한다() {
        Purchase purchase = purchaseService.getPurchaseIfValid("5000");
        assertEquals(purchase.getPrice(), 5000);
        assertNotEquals(purchase, null);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "5234",
        "-5000",
        "0",
        "sdf"
    })
    void 옳은_값이_들어오지_않으면_Purchase를_생성하지_않는다(String price) {
        Purchase purchase = purchaseService.getPurchaseIfValid(price);
        assertNull(purchase);
    }

}