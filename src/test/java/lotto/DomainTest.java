package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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
        assertThatThrownBy(() -> domain.checkPriceUnit(wrongPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
