package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void createBonusNumberByDuplicated() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("보너스 번호가 1에서 45 사이의 숫자가 아니면 예외가 발생한다")
    @Test
    void createBonusNumberOutOfRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 50;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위를 벗어났습니다.");
    }

    @DisplayName("WinningLotto 객체가 잘 생성되어야 한다")
    @Test
    void createWinningLottoInstance() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        assertThat(winningLotto.getLotto()).isEqualTo(lotto);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }
}
