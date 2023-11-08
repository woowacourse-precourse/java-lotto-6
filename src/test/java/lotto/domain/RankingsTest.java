package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankingsTest {
    @DisplayName("각 등수를 옳게 반환하는지 확인 한다.")
    @ParameterizedTest
    @MethodSource("provideExampleLotto")
    void getRankingsPerMathCount(
            Lotto exampleLotto,
            WinningNumbers winningNumbers,
            Rankings expected) {

        Rankings actual = winningNumbers.assignRankings(exampleLotto);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideExampleLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(List.of(1,2,3,4,5,6)),
                        new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7),
                        Rankings.FIRST_PLACE),
                Arguments.of(
                        new Lotto(List.of(1,2,3,4,5,7)),
                        new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7),
                        Rankings.SECOND_PLACE),
                Arguments.of(
                        new Lotto(List.of(1,2,3,4,5,8)),
                        new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7),
                        Rankings.THIRD_PLACE),
                Arguments.of(
                        new Lotto(List.of(1,2,3,4,8,9)),
                        new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7),
                        Rankings.FOURTH_PLACE),
                Arguments.of(
                        new Lotto(List.of(1,2,3,8,9,10)),
                        new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7),
                        Rankings.FIFTH_PLACE)
        );
    }
}