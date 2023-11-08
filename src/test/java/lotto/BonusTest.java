package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    @DisplayName("잘못된 범위의 수가 입력된 경우 예외 발생")
    @Test
    void 잘못된_범위의_수_입력_테스트() {
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
