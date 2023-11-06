package lotto;

import model.Lotto;
import model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자가 아닌 문자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNonNumericCharacter() {
        assertThatThrownBy(() -> new WinningLotto("1,8,3,21,a,37","42"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 1이상 45이하의 범위를 벗어나는 숫자가 있으면 예외가 발생한다. - 45 초과")
    @Test
    void createLottoIncludesNumberOverRange() {
        assertThatThrownBy(() -> new WinningLotto("1,8,3,46,11,37","42"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 1이상 45이하의 범위를 벗어나는 숫자가 있으면 예외가 발생한다. - 1 미만")
    @Test
    void createLottoIncludesNumberUnderRange() {
        assertThatThrownBy(() -> new WinningLotto("1,8,3,0,11,37","42"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 숫자의 길이가 2를 초과하면 예외가 발생한다.")
    @Test
    void createLottoByOverBonusNumberLength() {
        assertThatThrownBy(() -> new WinningLotto("1,8,3,24,11,37","123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 숫자가 1 이상 45 이하의 범위를 벗어나면 예외가 발생한다 - 1 미만")
    @Test
    void createLottoIncludesBonusNumberUnderRange() {
        assertThatThrownBy(() -> new WinningLotto("1,8,3,24,11,37","0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 숫자가 1 이상 45 이하의 범위를 벗어나면 예외가 발생한다 - 45 초과")
    @Test
    void createLottoIncludesBonusNumberOverRange() {
        assertThatThrownBy(() -> new WinningLotto("1,8,3,24,11,37","46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 숫자가 1 이상 45 이하의 범위를 벗어나면 예외가 발생한다 - 45 초과")
    @Test
    void createLottoThatLottoNumberContainsBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,8,3,24,11,37","11"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}