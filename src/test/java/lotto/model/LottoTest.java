package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @DisplayName("로또 번호가 1이상 45이하가 아니면 예외가 발생한다.")
    @Test
    void createLottoByRangeOut() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 0, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("인자로 받은 번호가 로또 번호 리스트 안에 있으면 true를 반환한다.")
    @Test
    void checkIfNumberIsInLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertTrue(lotto.containsNumber(1));
    }

    @DisplayName("인자로 받은 번호가 로또 번호 리스트 안에 없으면 false를 반환한다.")
    @Test
    void checkIfNumberIsNotInLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertFalse(lotto.containsNumber(8));
    }
}