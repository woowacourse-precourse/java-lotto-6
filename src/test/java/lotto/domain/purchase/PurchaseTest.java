package lotto.domain.purchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PurchaseTest {
    @Test
    void validatePrice() {
        // Given
        Purchase purchase = new Purchase();

        // When
        int validPrice = 2000;
        int invalidPrice = 1234;

        // Then
        Assertions.assertDoesNotThrow(() -> purchase.validatePrice(validPrice));
        Assertions.assertThrows(IllegalArgumentException.class, () -> purchase.validatePrice(invalidPrice));
    }
}