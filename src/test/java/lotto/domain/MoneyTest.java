package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("돈을 생성하면 돈이 생성된다.")
    @Test
    void createMoney() {
        Money money = new Money("1000");

        assertThat(money.getMoney()).isEqualTo(1000);
    }

    @DisplayName("돈을 생성할 때 빈문자열을 넘기면 에러가 발생한다.")
    @Test
    void exceptionEmptyMoney() {
        assertThatThrownBy(() -> new Money(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈을 생성할 때 null을 넘기면 에러가 발생한다.")
    @Test
    void exceptionNullMoney() {
        assertThatThrownBy(() -> new Money(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나누어지지 않는 숫자를 넘기면 에러가 발생한다.")
    @Test
    void exceptionDivideBy1000Money() {
        assertThatThrownBy(() -> new Money("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나눈 값이 반환된다.")
    @Test
    void getDividedThousandWonCount() {
        Money money = new Money("8000");

        assertThat(money.getDividedThousandWonCount()).isEqualTo(8);
    }
}
