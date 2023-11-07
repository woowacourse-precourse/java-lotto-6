package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.exception.MoneyException;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isExactlyInstanceOf(LottoException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isExactlyInstanceOf(LottoException.class);
    }

    @Test
    void 로또번호가_유효범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
            .isExactlyInstanceOf(LottoException.class);
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6)))
            .isExactlyInstanceOf(LottoException.class);
    }
}
