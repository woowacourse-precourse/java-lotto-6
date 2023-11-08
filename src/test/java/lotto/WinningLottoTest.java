package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("보너스 번호가 범위를 초과하면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)), 55))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위미만이면 예외가 발생한다.")
    @Test
    void createWinningLottoByUnderRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)), -3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 일치하면 예외가 발생한다.")
    @Test
    void createWinningLottoByBonusNumberDuplicateWithLotto() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또에 해당하는 로또를 반환한다.")
    @Test
    void getLotto() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(input, 8);
        Lotto result = winningLotto.getLotto();

        assertThat(result).isEqualTo(input);
    }

    @DisplayName("당첨 로또에 해당하는 보너스 번호를 반환한다.")
    @Test
    void getBonusNumber() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(input, 8);
        int result = winningLotto.getBonusNumber();

        assertThat(result).isEqualTo(8);
    }
}