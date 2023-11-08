package winningNumber;

import domain.Lotto;
import domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    @DisplayName("1등 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 6, 6)), 9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등 당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumberWithBonusNumber() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 6, 9)), 9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등 당첨 번호에 번호가 범위를 초과하면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverNumberRange() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 6, 99)), 32))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 초과하면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverNumberRangeWithBonusNumber() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 6, 9)), 99))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또 번호에 맞는 개수를 반환해준다.")
    @Test
    void returnCountMatch() {
        Lotto playerLotto = new Lotto((List.of(1, 2, 3, 32, 33, 34)));
        int result = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 6, 9)), 10)
                .countMatch(playerLotto);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("로또 번호가 보너스 번호와 일치하면 참값을 반환해준다.")
    @Test
    void returnIsMatchBonusNumber() {
        Lotto playerLotto = new Lotto((List.of(1, 2, 3, 10, 33, 34)));
        boolean result = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 6, 9)), 10)
                .isMatchBonusNumber(playerLotto);
        assertThat(result).isEqualTo(true);
    }
}
