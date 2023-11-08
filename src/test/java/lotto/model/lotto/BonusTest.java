package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class BonusTest {
    @Test
    void 보너스_번호가_1부터_45_사이_숫자이다() {
        assertDoesNotThrow(() -> new Bonus(1));
    }

    @Test
    void 보너스_번호가_1부터_45_사이_숫자가_아닐_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}