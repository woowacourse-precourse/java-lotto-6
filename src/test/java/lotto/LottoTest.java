package lotto;

import lotto.model.Lotto;
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

    @ParameterizedTest
    @MethodSource("provide_getScore_TestData")
    @DisplayName("점수를 제대로 리턴하는지 확인")
    void provideWinningNumber(List<Integer> winningNumbers, int bonusNumber, int[] expectedResult) {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .getScore(winningNumbers, bonusNumber))
                .contains(expectedResult);
    }

    private static Stream<Arguments> provide_getScore_TestData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, new int[]{6, 0}),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), 6, new int[]{5, 1}),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), 45, new int[]{5, 0})

        );
    }

}