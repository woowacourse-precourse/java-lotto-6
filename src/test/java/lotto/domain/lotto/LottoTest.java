package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또가 생성되면 오름차순으로 정렬되어 있다.")
    @Test
    void should_Create_Sorted_Lotto_Numbers() {
        // given
        List<Integer> numbers = List.of(10, 45, 3, 36, 25, 12);

        // when
        Lotto lotto = Lotto.from(numbers);

        // then
        List<Integer> expected = List.of(3, 10, 12, 25, 36, 45);
        assertThat(lotto.getLottoNumbers()).isEqualTo(expected);
    }
}