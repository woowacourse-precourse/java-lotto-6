package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.exception.NotDuplicatedLottoNumberException;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    void 보너스_번호를_포함한_당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            new LottoNumbers(List.of(1, 2, 3, 4, 5, 6), 1);
        }).isInstanceOf(NotDuplicatedLottoNumberException.class);
    }
}