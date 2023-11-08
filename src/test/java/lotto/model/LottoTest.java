package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
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
                .isInstanceOf(DuplicatedNumberException.class);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("outOfRangeParameter")
    @DisplayName("범위 밖의 숫자 예외 발생")
    void createLottoByOutOfRangeNumbers(String testName, List<Integer> input) {
        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(OutOfRangeNumberException.class);
    }

    private static Stream<Arguments> outOfRangeParameter() {
        return Stream.of(
                // 최댓값 초과 시 오류 발생
                Arguments.of("45 초과", List.of(1, 2, 3, 4, 5, 46)),

                // 최솟값 미만 시 오류 발생
                Arguments.of("1 미만", List.of(0, 1, 2, 3, 4, 5))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("compareLottoParameter")
    @DisplayName("로또끼리 번호 비교")
    void calculateSameNumber(String testName, List<Integer> input, int count) {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int result = myLotto.calculateSameNumberCount(new Lotto(input));
        assertThat(result).isEqualTo(count);
    }

    private static Stream<Arguments> compareLottoParameter() {
        return Stream.of(
                Arguments.of("0개", List.of(7, 8, 9, 10, 11, 12), 0),
                Arguments.of("1개", List.of(1, 7, 8, 9, 10, 11), 1),
                Arguments.of("2개", List.of(1, 2, 7, 8, 9, 10), 2),
                Arguments.of("3개", List.of(1, 2, 3, 7, 8, 9), 3),
                Arguments.of("4개", List.of(1, 2, 3, 4, 7, 8), 4),
                Arguments.of("5개", List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of("6개", List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }
}