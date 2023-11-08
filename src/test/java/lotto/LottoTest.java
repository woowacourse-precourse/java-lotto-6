package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 번호 목록 확인시 저장했던 값을 반환한다.")
    @Test
    void toValue() {
        // given
        final List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        final Lotto lotto = new Lotto(expected);

        // when
        final List<Integer> result = lotto.toValue();

        // then
        assertThat(result).hasSameElementsAs(expected);
    }

    @Test
    @DisplayName("일치하는 숫자 개수 확인 요청시 일치 개수를 반환한다.")
    void matchNum() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final Lotto lotto = new Lotto(numbers);
        final Lotto compareLotto = new Lotto(numbers);

        // when
        final int result = lotto.matchNum(compareLotto);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자를 갖고 있는지 확인 요청시 포함 여부를 반환한다.")
    void contains() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final Lotto lotto = new Lotto(numbers);
        final Lotto compareLotto = new Lotto(numbers);

        // when
        final int result = lotto.matchNum(compareLotto);

        // then
        assertThat(result).isEqualTo(numbers.size());
    }
}
