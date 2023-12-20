package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ValueSource(ints = {1980, 1999, 2001, 15900})
    @ParameterizedTest
    void validatePriceTest(int price) {
        Assertions.assertThatThrownBy(() -> new Money(price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
