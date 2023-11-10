package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("보너스 번호가 로또 번호에 이미 존재하면 예외가 발생한다.")
    @Test
    void createWinningLottoByBonusNumberExistsInLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(2);
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus))
            .isInstanceOf(IllegalArgumentException.class);
    }
}