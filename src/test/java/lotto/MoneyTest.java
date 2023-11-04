package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    void validationTest() {
        assertThatThrownBy(() -> {
            Money money = new Money(1200);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
