package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    public void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        // given
        final Lotto winningNumbersData = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final BonusNumber bonusNumber = new BonusNumber(6);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbersData, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}