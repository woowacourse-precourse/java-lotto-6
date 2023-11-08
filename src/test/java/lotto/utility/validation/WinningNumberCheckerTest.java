package lotto.utility.validation;

import static lotto.constants.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class WinningNumberCheckerTest {
    @Test
    void 당첨로또와_보너스번호가_중복되면_예외가_발생한다() {
        // given
        Lotto 당첨로또 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber 보너스번호 = new BonusNumber(1);

        // when & then
        assertThatThrownBy(() -> {
            WinningNumberChecker.validate(당첨로또, 보너스번호);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(DUPLICATED_LOTTO_NUMBER);
    }

}