package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또는 중복되지 않는 6개의 숫자와 보너스 번호 1개를 가진다.")
    void createWiningLotto() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningLotto).isEqualTo(new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    @DisplayName("6개의 숫자 중 보너스 번호와 일치하는 숫자가 있으면 예외가 발생한다.")
    void invalidWinningLotto() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호 중 보너스 번호와 일치하는 숫자가 존재합니다.");
    }
}