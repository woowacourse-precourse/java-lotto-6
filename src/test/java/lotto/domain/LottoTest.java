package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로또 번호의 개수가 6개 미만일 시 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1에서 45 사이의 정수값들을 전송해 로또 번호들을 초기화할 수 있다.")
    @Test
    void createLottoByProperNumbers() {
        // given
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = List.of(40, 41, 42, 43, 44, 45);
        List<Integer> numbers3 = List.of(1, 3, 16, 28, 37, 45);
        List<Integer> numbers4 = List.of(2, 8, 10, 15, 22, 36);

        // when
        Lotto lotto1 = new Lotto(numbers1);
        Lotto lotto2 = new Lotto(numbers2);
        Lotto lotto3 = new Lotto(numbers3);
        Lotto lotto4 = new Lotto(numbers4);

        // then
        assertThat(lotto1.getNumbers()).isEqualTo(numbers1);
        assertThat(lotto2.getNumbers()).isEqualTo(numbers2);
        assertThat(lotto3.getNumbers()).isEqualTo(numbers3);
        assertThat(lotto4.getNumbers()).isEqualTo(numbers4);
    }

    @DisplayName("로또 번호가 1에서 45 사이의 값이 아니면 예외가 발생한다.")
    @Test
    void createLottoByImproperNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE_EXCEPTION + 0);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE_EXCEPTION + 46);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어 있지 않으면 예외가 발생한다.")
    @Test
    void createLottoByImproperOrder() {
        assertThatThrownBy(() -> new Lotto(List.of(6, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_ORDER_EXCEPTION + 1 + NUMBER_INDICATION + 6 + ", "
                        + 2 + NUMBER_INDICATION + 1);

        assertThatThrownBy(() -> new Lotto(List.of(2, 3, 4, 5, 6, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_ORDER_EXCEPTION + 5 + NUMBER_INDICATION + 6 + ", "
                        + 6 + NUMBER_INDICATION + 1);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 5, 3, 6, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_ORDER_EXCEPTION + 3 + NUMBER_INDICATION + 5 + ", "
                        + 4 + NUMBER_INDICATION + 3);
    }
}
