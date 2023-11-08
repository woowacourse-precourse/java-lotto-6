package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘고 중복된 숫자가 포함되면 개수에 대한 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumberAndOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageNotContaining("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호에 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(0, 1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(List.of(6, 1, 2, 3, 4, 5), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}