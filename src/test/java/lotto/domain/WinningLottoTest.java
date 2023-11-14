package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("6개의 당첨 로또 발행 및 보너스 번호")
    @Test
    void createLottoAndBonus() {

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.getBonus()).isEqualTo(7);
        assertThat(lotto).isEqualTo(winningLotto.getLotto());
    }

    @DisplayName("보너스 번호 중복되면 예외 처리")
    @Test
    void createBonusDuplicate() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 개수 6개 안되면 예외 처리")
    @Test
    void createLottoLimit() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 당첨 공백 포함된 로또 발행 및 보너스 번호")
    @Test
    void createBlankLotto() {

        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4,5 ,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(winningLotto.getLotto());
    }

    @DisplayName("6개의 당첨 ,,로 빈값 있어도 6개 로또 발행이면 통과")
    @Test
    void createBlankCommaLotto() {

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(winningLotto.getLotto());
    }

    @DisplayName("로또 번호에 1미만의 숫자가 있으면 예외")
    @Test
    void createLottoByMinLimitNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,0", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45초과의 숫자가 있으면 예외")
    @Test
    void createLottoByMaxLimitNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,46", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}