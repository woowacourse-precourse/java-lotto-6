package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<String> numbersInput = List.of("1", "2", "3", "4", "5", "6", "7");
        String bonusNumInput = "8";

        assertThatThrownBy(() -> WinningLotto.createWinningLotto(numbersInput, bonusNumInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<String> numbersInput = List.of("1", "2", "3", "4", "5", "6", "7");
        String bonusNumInput = "1";

        assertThatThrownBy(() -> WinningLotto.createWinningLotto(numbersInput, bonusNumInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위가 넘어선 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByRangeOverNumber() {
        List<String> numbersInput = List.of("1", "2", "3", "4", "5", "6", "500");
        String bonusNumInput = "1";

        assertThatThrownBy(() -> WinningLotto.createWinningLotto(numbersInput, bonusNumInput))
                .isInstanceOf(IllegalArgumentException.class);

        String bonusNumInput1 = "500";

        assertThatThrownBy(() -> WinningLotto.createWinningLotto(numbersInput, bonusNumInput1))
                .isInstanceOf(IllegalArgumentException.class);

        String maxBonusNum = "3000000000";

        assertThatThrownBy(() -> WinningLotto.createWinningLotto(numbersInput, bonusNumInput1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 숫자에 문자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByIncludeChar() {
        List<String> numbersInput = List.of("x", "2", "3", "4", "5", "6", "7");
        String bonusNumInput = "y";

        assertThatThrownBy(() -> WinningLotto.createWinningLotto(numbersInput, bonusNumInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 숫자에 문자가 있으면 예외가 발생한다.")
    @Test
    void returnMatchCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<String> numbersInput = List.of("1", "2", "3", "4", "5", "10");
        String bonusNumInput = "8";

        WinningLotto winningLotto = WinningLotto.createWinningLotto(numbersInput, bonusNumInput);
        long count = winningLotto.countMatchLotto(lotto);
        boolean hasBonus = winningLotto.matchBonusNum(lotto);

        assertThat(count).isEqualTo(5L);
        assertThat(hasBonus).isTrue();
    }

}