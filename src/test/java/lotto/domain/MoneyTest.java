package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void validation_성공() {
        int amount = 30_000;
        assertThatCode(() -> new Money(amount)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 320, 4730, 56240})
    void validation_1000의배수가아닐때(int invalidAmount) {
        assertThatThrownBy(() -> new Money(invalidAmount)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1_000, -42_000, -752_000})
    void validation_음수일때(int invalidAmount) {
        assertThatThrownBy(() -> new Money(invalidAmount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getAmount() {
        int amount = 524_000;
        Money money = new Money(amount);

        assertThat(money.getAmount()).isEqualTo(amount);
    }
}