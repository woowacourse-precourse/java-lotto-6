package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("구입 금액을 두 개 이상 입력하면 예외가 발생한다.")
    @Test
    void manyValuesTest() {
        assertThatThrownBy(() -> Player.from("1000,2000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    void hasNotNumberTest() {
        assertThatThrownBy(() -> Player.from("1e"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수인 경우에 예외가 발생한다.")
    @Test
    void hasNegativeNumberTest() {
        assertThatThrownBy(() -> Player.from("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 최소 금액보다 작을 경우에 예외가 발생한다.")
    @Test
    void lessThanMinimumAmountTest() {
        assertThatThrownBy(() -> Player.from("300"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 기준 금액으로 나눠지지 않을 경우에 예외가 발생한다.")
    @Test
    void notDividedByUnitAmountTest() {
        assertThatThrownBy(() -> Player.from("1400"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}