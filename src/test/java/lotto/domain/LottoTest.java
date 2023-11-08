package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Error.Domain.WRONG_LOTTO_NUMBER_RANGE;
import static lotto.Error.Domain.WRONG_LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호_개수_초과_6개() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_LOTTO_SIZE.getText());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호_중복() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45가 넘는 수가 들어가면 예외가 발생한다.")
    @Test
    void 로또_번호_45_초과() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_LOTTO_NUMBER_RANGE.getText());
    }

    @DisplayName("로또 번호에 1 미만인 수가 들어가면 예외가 발생한다.")
    @Test
    void 로또_번호_1_미만() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 0, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_LOTTO_NUMBER_RANGE.getText());
    }
}