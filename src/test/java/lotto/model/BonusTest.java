package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BonusTest {

    @Test
    void 보너스_번호가_1_45_범위_밖이다() {
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}