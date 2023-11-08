package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {//입력값 예외발생 로직은 InputView에서 담당.
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
