package lotto;

import lotto.model.Lotto;
import lotto.model.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호를 정확히 출력하는지 확인한다.")
    void printLottoNumber() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("로또 번호가 오름차순으로 정렬되는지 확인한다.")
    void provide_UnSorted_Numbers() {
        assertThat(new Lotto(List.of(6,5,4,3,2,1)))
                .isEqualTo("[1, 2, 3, 4, 5 ,6]");
    }

    @ParameterizedTest
    @MethodSource("provide_getScore_TestData")
    @DisplayName("점수를 제대로 리턴하는지 확인")
    void provideWinningNumber(List<Integer> winningNumbers, int bonusNumber, Ranking expectedResult) {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .getRank(winningNumbers, bonusNumber))
                .isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provide_getScore_TestData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, Ranking.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), 6, Ranking.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), 45, Ranking.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 10, 11), 45, Ranking.FORTH),
                Arguments.of(List.of(1, 2, 3, 10, 11, 12), 45, Ranking.FIFTH),
                Arguments.of(List.of(1, 2, 10, 11, 12, 13), 45, Ranking.EMPTY)
        );
    }

}