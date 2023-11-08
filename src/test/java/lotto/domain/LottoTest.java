package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.NUMBERS_SIZE_INVALID_EXCEPTION);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.NUMBERS_DUPLICATE_EXCEPTION);
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.NUMBERS_RANGE_INVALID_EXCEPTION);
    }

    @DisplayName("로또 번호가 1부터 45 사이의 6개의 숫자로 이루어져 있으면 정상적으로 작동한다.")
    @Test
    void createLottoByValidNumbers() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertThatCode(() -> new Lotto(numbers))
                .doesNotThrowAnyException();
    }
}