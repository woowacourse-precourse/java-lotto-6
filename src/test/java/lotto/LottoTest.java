package lotto;

import lotto.domain.Lotto;
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

    @Test
    @DisplayName("로또 숫자가 1 미만 45 초과 시 예외처리")
    void isRightRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자가 오름차순이 아니면 예외처리")
    void isAscendingOrder() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 3, 4, 2, 5, 6))).isInstanceOf(
                IllegalStateException.class);
    }


}
