package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호를 생성하면 오름차순으로 정렬한다.")
    void createLottoBySortAsc() throws Exception {
        // given
        final List<Integer> numbers = List.of(6, 5, 3, 4, 2, 1);
        final Lotto lotto = new Lotto(numbers);

        // when
        final List<Integer> result = lotto.getNumbers();

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
