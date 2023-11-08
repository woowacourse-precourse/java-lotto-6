package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.winninglotto.WinningLottoDistinctException;
import lotto.exception.winninglotto.WinningLottoRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("보너스 번호에 1 미만인 숫자가 존재하면 예외가 발생한다.")
    @Test
    void createWinningLottoByBonusNumberUnderMinBound() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(WinningLottoRangeException.class);
    }

    @DisplayName("보너스 번호에 45 초과인 숫자가 존재하면 예외가 발생한다.")
    @Test
    void createWinningLottoByBonusNumberOverMaxBound() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(WinningLottoRangeException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void createWinningLottoByBonusNumberInWinningNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(WinningLottoDistinctException.class);
    }
}
