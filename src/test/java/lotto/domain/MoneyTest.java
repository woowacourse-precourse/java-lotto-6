package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {8000, 1000000})
    void 정상적으로_Money_생성(int money) {
        assertDoesNotThrow(() -> new Money(money));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000, 1234})
    void ONE_THOUSAND_WON_로_나누어_떨어지지않는_경우_양수가_아닌경우_IAE(int money) {
        assertThrows(IllegalArgumentException.class, () -> new Money(money));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000, 1234})
    void ONE_THOUSAND_WON_로_정상적으로_나눠지는_경우(int money) {
        assertThrows(IllegalArgumentException.class, () -> new Money(money));
    }


}