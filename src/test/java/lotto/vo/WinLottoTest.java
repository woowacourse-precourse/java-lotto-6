package lotto.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoTest {
    @DisplayName("당첨 번호 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinLottoByOverSize() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6, 7), 9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호 사이에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호는 (1-45) 범위 벗어난 숫자 있으면 예외가 발생한다.")
    @Test
    void createWinLottoByOutOfRange() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 45, 46), 51))
                .isInstanceOf(IllegalArgumentException.class);
    }
}