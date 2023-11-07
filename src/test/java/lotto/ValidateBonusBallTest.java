package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidateBonusBallTest {

    @Test
    void 범위_내의_숫자_큼() {
        assertThatThrownBy(() -> new ValidateBonusBall().isInRange(46))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 45보다 큰 숫자는 입력 할 수 없습니다.");
    }

    @Test
    void 범위_내의_숫자_작음() {
        assertThatThrownBy(() -> new ValidateBonusBall().isInRange(0))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 1보다 작은 숫자는 입력 할 수 없습니다.");
    }

}
