package lotto;

import controller.LottoController;
import exception.DuplicateLottoNumberException;
import exception.WrongLottoSizeException;
import exception.WrongRangeLottoNumberException;
import java.util.List;
import model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void createWinningLottoByWrongSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(WrongLottoSizeException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(DuplicateLottoNumberException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoByWrongRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(WrongRangeLottoNumberException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.2")
    @Test
    void createWinningLottoByWrongRangeBonusNumber2() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(WrongRangeLottoNumberException.class);
    }

    @DisplayName("당첨 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoByWrongRangeWinningNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(WrongRangeLottoNumberException.class);
    }

    @DisplayName("당첨 번호가 범위를 벗어나면 예외가 발생한다.2")
    @Test
    void createWinningLottoByWrongRangeWinningNumber2() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 0), 7))
                .isInstanceOf(WrongRangeLottoNumberException.class);
    }
}
