package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1보다 작거나, 45보다 큰 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 46), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호에 로또 번호와 중복되는 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoAndBonusByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 46), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호에 1보다 작거나, 45보다 큰 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoAndBonusByOverRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 45), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}