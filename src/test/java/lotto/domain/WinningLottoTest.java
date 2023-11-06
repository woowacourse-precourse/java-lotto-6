package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("당첨번호와 보너스 번호 중 같은게 있으면 예외 발생")
    @Test
    void createWinningLottoByDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 보너스 번호 중 같은게 있으면 예외 발생")
    @Test
    void createLottoByWrongRangeNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
