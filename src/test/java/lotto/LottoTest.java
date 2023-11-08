package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @DisplayName("로또 정렬를 할 수 있다.")
    @MethodSource("lottoSortingTestValue")
    void lottoSortingTest(List<Integer> numbers, String expect) {
        Lotto lotto = new Lotto(numbers);
        Assertions.assertThat(lotto.getNumbersPrintFormat()).isEqualTo(expect);
    }

    private static Stream<Arguments> lottoSortingTestValue() {
        return Stream.of(
                Arguments.of(List.of(1, 7, 3, 24, 5, 18), "[1, 3, 5, 7, 18, 24]"),
                Arguments.of(List.of(45, 41, 7, 2, 32, 11), "[2, 7, 11, 32, 41, 45]")
        );
    }

    @ParameterizedTest
    @DisplayName("로또에 숫자가 포함되어있는지 확인 할 수 있다.")
    @MethodSource("lottoContainNumberTestValue")
    void lottoContainNumberTest(List<Integer> numbers, int target, boolean expect) {
        Lotto lotto = new Lotto(numbers);
        Assertions.assertThat(lotto.isContainNumber(target)).isEqualTo(expect);
    }

    private static Stream<Arguments> lottoContainNumberTestValue() {
        return Stream.of(
                Arguments.of(List.of(1, 7, 3, 24, 5, 18), 18, true),
                Arguments.of(List.of(45, 41, 7, 2, 32, 11), 18, false)
        );
    }

    @ParameterizedTest
    @DisplayName("비교하여 카운트할 수 있다.")
    @MethodSource("countMatchNumbersTestValue")
    void countMatchNumbersTest(List<Integer> numbers, List<Integer> target, int expect) {
        Lotto lotto = new Lotto(numbers);
        Assertions.assertThat(lotto.countMatchNumbers(target)).isEqualTo(expect);
    }

    private static Stream<Arguments> countMatchNumbersTestValue() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 36), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 35, 36), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 34, 35, 36), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 33, 34, 35, 36), 2),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 32, 33, 34, 35, 36), 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(31, 32, 33, 34, 35, 36), 0)

        );
    }
}