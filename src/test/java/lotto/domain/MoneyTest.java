package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, -15000, -10})
    @DisplayName("로또 구입 금액이 양수가 아니라면 예외 발생")
    void moneyNotPositiveExceptionTest(final int amount) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> Money.from(amount));
    }
}