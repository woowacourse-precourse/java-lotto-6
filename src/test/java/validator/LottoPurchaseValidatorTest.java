package validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseValidatorTest {
    @Test
    public void testValidMinimumPurchaseAmount() {
        LottoPurchaseValidator lottoPurchaseValidator = new LottoPurchaseValidator();
        assertThrows(IllegalArgumentException.class, () -> lottoPurchaseValidator.validMinimumPurchaseAmount(999));
    }

    @Test
    public void testValidPurchaseDivideUp1000() {
        LottoPurchaseValidator lottoPurchaseValidator = new LottoPurchaseValidator();
        assertThrows(IllegalArgumentException.class, () -> lottoPurchaseValidator.validPurchaseDivideUp1000(1500));
    }

    @Test
    public void testValidIntegerPurchaseAmount() {
        LottoPurchaseValidator lottoPurchaseValidator = new LottoPurchaseValidator();
        assertDoesNotThrow(() -> lottoPurchaseValidator.vaildIntegerPurchaseAmount("3000"));
        assertThrows(IllegalArgumentException.class, () -> lottoPurchaseValidator.vaildIntegerPurchaseAmount("abc"));
    }
}