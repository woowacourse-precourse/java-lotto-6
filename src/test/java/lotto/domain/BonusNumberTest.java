package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusNumberTest {

    @Test
    void 보너스_번호가_허용범위를_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.create(47))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_최소허용_범위보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.create(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getNumber를_통해_로또번호를_반환한다() {
        assertEquals(BonusNumber.create(1).getNumber(), 1);
    }
}