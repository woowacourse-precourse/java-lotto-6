package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import Model.Domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DomainTest {
    @DisplayName("구입 금액이 1,000 단위가 아닐 때 예외 발생")
    @Test
    void priceUnit() {
        Domain domain = Domain.getInstance();
        int wrongPrice = 1050;

        assertThrows(IllegalArgumentException.class, () -> domain.checkPriceUnit(wrongPrice),
                "구입 금액이 1,000 단위가 아닐 때 예외가 발생해야 합니다.");
    }
}
