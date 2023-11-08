package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    public void 보너스_번호가_1미만이면_예외가_발생합니다() {
        Assertions.assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스_번호가_46이상이면_예외가_발생합니다() {
        Assertions.assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}