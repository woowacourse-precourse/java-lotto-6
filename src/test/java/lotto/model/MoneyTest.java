package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("양수가 아닌 구입 금액")
    @Test
    void MoneyNotPositive() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 양수여야 합니다.");
    }

    @DisplayName("1000의 배수가 아닌 금액")
    @Test
    void MoneyNotDivisible() {
        assertThatThrownBy(() -> new Money(5500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 단위는 1000원이어야 합니다.");
    }

    @DisplayName("정상 금액")
    @Test
    void MoneyNormal() {
        Money object = new Money(1000);
        Money anotherObject = new Money(1000);
        Money differentObject = new Money(2000);

        assertThat(object).isEqualTo(anotherObject);
        assertThat(object).hasSameHashCodeAs(anotherObject);
        assertThat(object).isNotEqualTo(differentObject);
    }
}