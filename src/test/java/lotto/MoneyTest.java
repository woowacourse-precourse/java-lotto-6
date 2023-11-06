package lotto;

import model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createUserWithNonDividedByThousand() {
        assertThatThrownBy(() -> new Money("12500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 int의 최댓값을 초과하면 예외가 발생한다.")
    @Test
    void createUserWithOverIntegerRange() {
        assertThatThrownBy(() -> new Money("2147483648"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 int의 최댓값을 초과하면 예외가 발생한다.")
    @Test
    void createUserWithTooBigNumber() {
        assertThatThrownBy(() -> new Money("9999999999999999999999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 int의 최솟값 미만이면 예외가 발생한다.")
    @Test
    void createUserWithUnderIntegerRange() {
        assertThatThrownBy(() -> new Money("-2147483649"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 int의 최솟값 미만이면 예외가 발생한다.")
    @Test
    void createUserWithTooSmallNumber() {
        assertThatThrownBy(() -> new Money("-9999999999999999999999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createUserWithUnderMinMoneyRange() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createUserWithOverMaxMoneyRange() {
        assertThatThrownBy(() -> new Money("1000001000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
