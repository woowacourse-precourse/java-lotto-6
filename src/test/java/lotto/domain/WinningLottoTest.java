package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("유효한 입력으로 객체를 생성한다.")
    @Test
    void createByValidNumbers() {
        assertThat(new WinningLotto(List.of(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    @DisplayName("로또 번호의 개수가 6개를 넘어가면 예외가 발생한다.")
    @Test
    void createByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createByUnderSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createByDuplicatedNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1에서 45사이의 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createByInvalidRangeNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(0, 1, 2, 3, 4, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
