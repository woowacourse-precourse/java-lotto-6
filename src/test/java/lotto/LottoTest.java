package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[1, 45]범위의 중복없는 6개의 정수가 생성되어야 한다.")
    @Test
    void should_generateValidNumbers_when_generateLottoNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers())
                .isSortedAccordingTo(Comparator.naturalOrder());
        assertThat(lotto.getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("중복있는 숫자가 들어가면 실패한다.")
    @Test
    void should_fail_when_isDuplicateNumbers() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);

        assertThatThrownBy(
                () -> new Lotto(numbers));
    }

    @DisplayName("1미만의 숫자가 들어가면 실패한다.")
    @Test
    void should_fail_when_hasLessThan1() {
        List<Integer> numbers = List.of(-1, 1, 2, 3, 4, 5);

        assertThatThrownBy(
                () -> new Lotto(numbers));
    }

    @DisplayName("45초과의 숫자가 들어가면 실패한다.")
    @Test
    void should_fail_when_hasGreaterThan45() {
        List<Integer> numbers = List.of(46, 1, 2, 3, 4, 5);

        assertThatThrownBy(
                () -> new Lotto(numbers));
    }

    @DisplayName("6자리가 아니면 실패한다.")
    @Test
    void should_fail_when_lengthIsNot6() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(
                () -> new Lotto(numbers));
    }
}