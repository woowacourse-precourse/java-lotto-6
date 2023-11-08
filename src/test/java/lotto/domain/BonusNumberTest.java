package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @Test
    void 보너스_번호의_범위가_잘못된_경우 () {
        assertThatThrownBy(() -> new BonusNumber(0, List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void 당첨_번호중_보너스_번호와_중복되는_번호가_있는_경우 () {
        assertThatThrownBy(() -> new BonusNumber(1, List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_NUMBER.getMessage());
    }
}
