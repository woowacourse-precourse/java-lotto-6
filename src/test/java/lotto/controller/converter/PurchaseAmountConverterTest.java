package lotto.controller.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseAmountConverterTest {

    private PurchaseAmountConverter purchaseAmountConverter;

    @BeforeEach
    void setUp() {
        purchaseAmountConverter = new PurchaseAmountConverter();
    }

    @Test
    void testConvert() {
        String validPurchaseAmount = "3000";
        int result = purchaseAmountConverter.convert(validPurchaseAmount);
        assertThat(result).isEqualTo(3);
    }
}