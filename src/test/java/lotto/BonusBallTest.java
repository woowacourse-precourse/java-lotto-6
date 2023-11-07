package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BonusBallTest {

    @Test
    void 보너스볼_검증_큼() {
        assertThatThrownBy(() -> new BonusBall(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 45보다 큰 숫자는 입력 할 수 없습니다.");
    }

    @Test
    void 보너스볼_검증_작음() {
        assertThatThrownBy(() -> new BonusBall(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1보다 작은 숫자는 입력 할 수 없습니다.");
    }
}
