package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseTest {
    @DisplayName("구입 금액에 양의 값인 숫자를 입력한다.")
    @Test
    void testValidatePositiveNumber() {
        assertDoesNotThrow(() -> new Purchase(1000));
        assertDoesNotThrow(() -> new Purchase(2000));

        assertThrows(IllegalArgumentException.class, () -> new Purchase(0));
        assertThrows(IllegalArgumentException.class, () -> new Purchase(-1000));
    }

    @DisplayName("구입 금액에 1000원 단위의 숫자를 입력한다.")
    @Test
    void testValidateThousandUnit() {
        assertDoesNotThrow(() -> new Purchase(1000));
        assertDoesNotThrow(() -> new Purchase(2000));

        assertThrows(IllegalArgumentException.class, () -> new Purchase(1500));
        assertThrows(IllegalArgumentException.class, () -> new Purchase(250));
    }
}
