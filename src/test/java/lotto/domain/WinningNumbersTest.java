package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    @DisplayName("")
    @ParameterizedTest
    @MethodSource("parametersForDetermineRankTest")
    void determineRank_Success(Lotto lotto, Rank rank) {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when, then
        Assertions.assertThat(winningNumbers.determineRank(lotto)).isEqualTo(rank);
    }

    static Stream<Arguments> parametersForDetermineRankTest() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 10)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 7, 9, 12)), Rank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 9, 10, 11, 12)), Rank.MISS)
        );
    }
}