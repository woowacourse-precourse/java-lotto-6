package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("보너스 번호가 로또 넘버와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumbers() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoWithRightRange() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}