package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("금액이 같을 경우 동등하다")
    @Test
    void equalsTest() {
        Money first = new Money(1_000);
        Money second = new Money(1_000);
        assertEquals(first, second);
    }

    @DisplayName("1000원 단위가 아닐 경우 예외를 반환한다")
    @Test
    void createMoneyNotInUnits() {
        assertThatThrownBy(() -> new Money(1_234)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원일 경우 예외를 반환한다")
    @Test
    void createMoneyWithZero() {
        assertThatThrownBy(() -> new Money(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
