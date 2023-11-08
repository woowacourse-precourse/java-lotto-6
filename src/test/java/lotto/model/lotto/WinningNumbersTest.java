package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.lotto.Bonus;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningNumbers;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void 당첨_번호와_보너스_번호가_중복될_경우_예외를_발생시킨다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(1);
        assertThatThrownBy(() -> new WinningNumbers(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
    }
}