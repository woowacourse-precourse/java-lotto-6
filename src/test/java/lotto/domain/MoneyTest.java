package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @DisplayName("금액의 범위가 맞고 1000원 단위일 경우 Money를 성공적으로 생성한다.")
    @Test
    void createMoney() {
        Long value = 1_000L;

        assertDoesNotThrow(() -> new Money(value));
    }

    @DisplayName("금액의 범위가 벗어날 경우 Money를 생성할 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {999L, 100_000_000_001L})
    void createMoneyWithInvalidRange(Long input) {
        assertThatThrownBy(() -> new Money(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 단위가 아닌 경우 Money를 생성할 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {1_100L, 10_000_000_001L})
    void createMoneyWithInvalidUnit(Long input) {
        assertThatThrownBy(() -> new Money(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
