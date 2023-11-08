package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningBonusLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnigBonusLottoTest {
    @DisplayName("당첨 번호와 보너스 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void createWinningBonusLottoByOverlapNumber() {
        Lotto winning = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 6;
        assertThatThrownBy(() -> new WinningBonusLotto(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1에서 45사이가 아니면 예외가 발생한다.")
    @Test
    void createWinningBonusLottoByBoundaryNumber() {
        Lotto winning = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 46;
        assertThatThrownBy(() -> new WinningBonusLotto(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
