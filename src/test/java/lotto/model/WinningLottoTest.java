package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복된 숫자면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createWinningLottoByUnderRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 45보다 큰면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}