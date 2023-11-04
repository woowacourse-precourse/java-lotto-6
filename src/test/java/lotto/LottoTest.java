package lotto;

import static lotto.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.ErrorMessage.NOT_IN_RANGE;
import static lotto.ErrorMessage.NOT_SORT;
import static lotto.ErrorMessage.OUT_OF_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("로또 번호에 1-45가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotNumberInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_IN_RANGE.getMessage());
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어 있지 않으면 예외가 발생한다.")
    @Test
    void createLottoByNotSort() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 6, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SORT.getMessage());
    }
}
