package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("WinningLotto가 잘 생성된다.")
    @Test
    void createWinningLotto() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningLotto winningLotto = WinningLotto.of(winningNumber, bonusNumber);

        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("로또와 당첨 번호 비교")
    @Test
    void compareLottoWithWinningNumbers() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 9;
        WinningLotto winningLotto = WinningLotto.of(winningNumber, bonusNumber);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));

        WinningInfo winningInfo = winningLotto.compare(userLotto);

        assertThat(winningInfo).isEqualTo(WinningInfo.FIVE_AND_BONUS_MATCH);
    }


}