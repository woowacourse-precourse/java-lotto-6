package lotto.domain;

import static lotto.constants.Error.DUPLICATION_BONUS_ERROR;
import static lotto.constants.Error.RANGE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("범위를 초과하는 값을 가진 당첨번호를 넣으면 예외가 발생한다.")
    @Test
    void rangeOutWinningNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(32, 41, 6, 7, 8, 99))))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(RANGE_ERROR.getMessage());
    }

    @DisplayName("범위에 맞는 당첨번호를 넣으면 저장이된다.")
    @Test
    void rangeInWinningNumber() {
        WinningLotto result = new WinningLotto(new Lotto(List.of(32, 41, 6, 7, 8, 45)));
        assertThat(result.getWinningNumber()).isEqualTo(List.of(32, 41, 6, 7, 8, 45));
    }

    @DisplayName("당첨번호와 중복된 보너스 번호를 넣으면 예외가 발생한다.")
    @Test
    void duplicationBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(32, 41, 6, 7, 8, 45))).setBounusNumber(45))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATION_BONUS_ERROR.getMessage());
    }
}