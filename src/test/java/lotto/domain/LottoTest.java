package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import lotto.exception.LottoException;

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

    @Test
    void 생성된_로또번호가_오름차순인지_확인한다() {
        List<Integer> descendingLotto = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1));
        Lotto lotto = new Lotto(descendingLotto);

        assertThat(lotto.getLotto()).containsExactlyInAnyOrder(1,2,3,4,5,6);
    }
}
