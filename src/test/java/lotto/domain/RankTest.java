package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @MethodSource("rankInputProvider")
    public void 로또_등수_계산(int matchCount, boolean containBonusBall, Rank expected) {
        Rank rank = Rank.getRating(matchCount, containBonusBall);
        assertThat(rank).isEqualTo(expected);
    }

    private static Stream<Arguments> rankInputProvider() { // argument source method
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST), // 1등
                Arguments.of(5, true, Rank.SECOND), // 2등
                Arguments.of(5, false, Rank.THIRD), // 3등
                Arguments.of(4, false, Rank.FOURTH), // 4등
                Arguments.of(3, false, Rank.FIFTH) // 5등
        );
    }
}
