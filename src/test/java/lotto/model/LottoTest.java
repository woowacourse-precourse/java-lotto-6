package lotto.model;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호에_보너스번호가_포함되어있으면_안된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertTrue(lotto.containBonusNumber(1));
        assertFalse(lotto.containBonusNumber(7));
    }

    @Test
    void 로또번호와_당첨번호_중_동일하지_않은_번호는_제거된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 3, 5, 7, 9, 21));

        int size = lotto.removeNonCommonNumber(winningNumbers);

        assertEquals(size, 3);
    }
}