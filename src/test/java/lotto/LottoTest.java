package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 오름차순이 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoByNotAscendingNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(6, 5, 4, 3, 2, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45까지의 숫자가 아닐경우 예외가 발생한다.")
    @Test
    void createLottoByNotNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 47, 48, 49, 50, 51)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개이며 각 숫자가 중복 없이 1부터 45까지의 숫자로 오름차순일 경우 로또가 정상적으로 발행된다.")
    @Test
    void createLottoByFollowingTheRule() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.size()).isEqualTo(6);
    }
}