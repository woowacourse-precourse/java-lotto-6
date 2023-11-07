package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Lotto;
import domain.WinningLotto;

public class WinningLottoTest {

    private final WinningLotto winningLotto = new WinningLotto();

    @DisplayName("당첨번호와 보너스번호가 중복되면 예외가 발생한다.")
    @Test
    void createBounsNumberByDuplicateWinningNumber() {
        winningLotto.setNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> winningLotto.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 현재 로또의 일치하는 수의 개수를 반환한다.")
    @Test
    void createCountByLotto() {
        winningLotto.setNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(winningLotto.countWinNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

    @DisplayName("당첨번호와 로또번호가 5개 일치할때 보너스번호도 일치한다면 7을 반환한다.")
    @Test
    void createCountBySecondWin() {
        winningLotto.setNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        winningLotto.setBonusNumber(7);
        assertThat(winningLotto.countWinNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(7);
    }

}
