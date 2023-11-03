package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoTest {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(2, 3, 4, 5, 6, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(3, 4, 5, 6, 7, 8), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(4, 5, 6, 7, 8, 9), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(5, 6, 7, 8, 9, 10), 2),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(6, 7, 8, 9, 10, 11), 1)
        );
    }

    @DisplayName("정답 번호와 구입한 로또 번호의 동일한 숫자 개수를 반환한다.")
    @ParameterizedTest
    @MethodSource("parameters")
    void countCorrectLottoNumbers(List<Integer> userNumbers, List<Integer> winningNumbers, int expectedCount) {
        // given
        Lotto userLotto = new Lotto(userNumbers);

        // when
        int correctCount = userLotto.countCorrectLottoNumbers(winningNumbers);

        // then
        assertThat(correctCount).isEqualTo(expectedCount);
    }

}