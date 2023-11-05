package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @DisplayName("구입 금액의 범위가 맞고 1,000 단위일 경우 성공적으로 생성한다.")
    @Test
    void createMoney() {
        Long value = 1_000L;

        assertDoesNotThrow(() -> new Money(value));
    }

    @DisplayName("구입 금액이 1,000 미만이거나 100,000,000,000 초과일 경우 Money를 생성할 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {999L, 100_000_000_001L})
    void createMoneyByInvalidRange(Long input) {
        assertThatThrownBy(() -> new Money(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000 단위가 아닐 경우 Money를 생성할 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {1_100L, 10_000_000_001L})
    void createMoneyByInvalidUnit(Long input) {
        assertThatThrownBy(() -> new Money(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
