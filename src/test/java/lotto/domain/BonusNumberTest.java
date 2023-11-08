package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    List<Integer> numbers = Arrays.asList(1, 3, 22, 28, 32, 45);

    @Test
    void 보너스번호가_당첨_번호와_중복인_경우_예외_발생() {
        assertThatThrownBy(() -> new BonusNumber(3, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_1미만인_경우_예외_발생() {
        assertThatThrownBy(() -> new BonusNumber(0, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_45초과인_경우_예외_발생() {
        assertThatThrownBy(() -> new BonusNumber(100, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}