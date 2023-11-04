package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {

    @DisplayName("1000원 이상의 금액으로 돈 객체가 생성된다.")
    @Test
    void createMoneyTest() {
        // given
        int input = 1000;

        // when
        Money money = new Money(input);

        // then
        assertThat(money).isNotNull();
        Assertions.assertThat(money.money()).isEqualTo(input);
    }

    @DisplayName("1000원 미만의 금액으로 돈 객체를 생성하면 예외가 발생한다.")
    @Test
    void createMoneyByLessThan1000Test() {
        // given
        int input = 999;

        // when & then
        Assertions.assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수의 금액으로 돈 객체를 생성하면 예외가 발생한다.")
    @Test
    void createMoneyByNegativeNumberTest() {
        // given
        int input = -1000;

        // when & then
        Assertions.assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
