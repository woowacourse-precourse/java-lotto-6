package lotto.domain;

import static lotto.constant.MessageConstants.CANNOT_DUPLICATE_LOTTO_AND_BONUS;
import static lotto.constant.MessageConstants.LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createDuplicateBonusNumberWithWinning() {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        // when, then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CANNOT_DUPLICATE_LOTTO_AND_BONUS);
    }

    @DisplayName("보너스 번호가 1 ~ 45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWrongRangeBonusNumber() {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 49;

        // when, then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_RANGE);
    }

}
