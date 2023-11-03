package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Error.Domain.BONUS_NUMBER_ALREADY_EXIST;
import static lotto.Error.Domain.WRONG_LOTTO_NUMBER_RANGE;

class WinningLottoTest {
    private Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("보너스 번호가 로또 번호 중 하나와 중복되면 예외가 발생한다.")
    void 보너스_번호_중복_예외() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(lotto, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_ALREADY_EXIST.getText());
    }

    @Test
    @DisplayName("보너스 번호가 45 초과면 예외가 발생한다.")
    void 보너스_번호_45_초과_예외() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(lotto, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_LOTTO_NUMBER_RANGE.getText());
    }

    @Test
    @DisplayName("보너스 번호가 1 미만이면 예외가 발생한다.")
    void 보너스_번호_0_미만_예외() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(lotto, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_LOTTO_NUMBER_RANGE.getText());
    }
}