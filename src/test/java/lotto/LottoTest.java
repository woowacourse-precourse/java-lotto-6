package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
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

    @DisplayName("로또 번호에 최솟값보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByIncludeNumberLessThanMinimumValue() {
        assertThatThrownBy(() -> new Lotto(List.of(LottoEnum.NUMBER_MIN.getValue() - 1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 최댓값보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByIncludeNumberGreaterThanMaximumValue() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, LottoEnum.NUMBER_MAX.getValue() + 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}