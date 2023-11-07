package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("당첨 번호와 중복되는 보너스 번호 입력시 예외가 발생한다.")
    @Test
    void createBonusNumberDuplicatedWithWinningLotto() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;
        // when, then
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER.getWithPrefix());
    }
}