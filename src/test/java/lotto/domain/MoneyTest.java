package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {
    @DisplayName("구입 금액 객체 생성")
    @Test
    void validation_성공() {
        int amount = 30_000;
        assertThatCode(() -> new Money(amount)).doesNotThrowAnyException();
    }

    @DisplayName("구입 금액이 1000의 배수가 아니면 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 320, 4730, 56240})
    void validation_1000의배수가아닐때(int invalidAmount) {
        assertThatThrownBy(() -> new Money(invalidAmount)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수면 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1_000, -42_000, -752_000})
    void validation_음수일때(int invalidAmount) {
        assertThatThrownBy(() -> new Money(invalidAmount)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액 액수 반환")
    @Test
    void getAmount() {
        int amount = 524_000;
        Money money = new Money(amount);

        assertThat(money.getAmount()).isEqualTo(amount);
    }
}