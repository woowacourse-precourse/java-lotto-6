package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @DisplayName("사용자가 돈을 1000보다 작게 쓰면 예외가 발생한다.")
    @Test
    void createPlayByOverRangeMoney() {
        assertThatThrownBy(() -> new Player("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 돈을 잘못 입력 했을 때 예외가 발생한다.")
    @Test
    void createPlayByWrongMoney() {
        assertThatThrownBy(() -> new Player("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}