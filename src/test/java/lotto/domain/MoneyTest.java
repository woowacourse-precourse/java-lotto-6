package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("입력한 금액 숫자로 변환")
    @Test
    void getMoneyTest() {
        Money money = new Money("5000");
        assertThat(money.getMoney()).isEqualTo(5000);
    }

    @DisplayName("로또 매수 계산")
    @Test
    void countTheNumberOfTickets() {
        Money money = new Money("5000");
        assertThat(money.getTickets()).isEqualTo(5);
    }

    @DisplayName("숫자 외의 입력 값이 있으면 예외가 발생한다.")
    @Test
    void containValuesOtherThanNumbers() {
        assertThatThrownBy(() -> new Money("123dd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void isLessThanPrice() {
        assertThatThrownBy(() -> new Money("950"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void isNotDivisibleByPrice() {
        assertThatThrownBy(() -> new Money("1800"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}