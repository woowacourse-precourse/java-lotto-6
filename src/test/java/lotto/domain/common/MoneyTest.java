package lotto.domain.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Money money = Money.from(1000);
        Money other = Money.from(1000);

        assertThat(money).isEqualTo(other);
    }

    @DisplayName("돈은 양수여야 한다.")
    @Test
    void checkPositiveMoney() {
        assertThatThrownBy(() -> Money.from(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈은 양수여야 합니다.");
    }

    @DisplayName("돈을 나눌 수 있다.")
    @Test
    void divide() {
        Money money = Money.from(10000);

        double result = money.divide(Money.from(1000));

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("알 수 없는 돈과 나누기 연산을 할 수 없다.")
    @Test
    void divideWithNull() {
        Money money = Money.from(10000);

        assertThatThrownBy(() -> money.divide(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 돈과 해당 연산을 수행할 수 없습니다.");
    }

    @DisplayName("알 수 없는 돈과 나머지 존재 확인 연산을 수행할 수 없다.")
    @Test
    void hasRemainderWithNull() {
        Money money = Money.from(10000);

        assertThatThrownBy(() -> money.hasRemainderWith(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 돈과 해당 연산을 수행할 수 없습니다.");
    }

    @DisplayName("다른 돈과의 나머지가 존재하는지 확인할 수 있다.")
    @Test
    void hasRemainderWith() {
        Money money = Money.from(10000);

        boolean result = money.hasRemainderWith(Money.from(1000));

        assertThat(result).isFalse();
    }
}
