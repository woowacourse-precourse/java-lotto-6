package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.dto.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("맞춘 개수와 보너스 여부로 등수를 계산할 수 있다")
    @ParameterizedTest
    @MethodSource
    void getRankByMatchCountAndHasBonus(int matchCount, boolean hasBonus, Rank expected) {

        Rank actual = Rank.of(new MatchResult(matchCount, hasBonus));

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> getRankByMatchCountAndHasBonus() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, true, Rank.NONE),
                Arguments.of(2, false, Rank.NONE),
                Arguments.of(1, true, Rank.NONE),
                Arguments.of(1, false, Rank.NONE),
                Arguments.of(0, true, Rank.NONE),
                Arguments.of(0, false, Rank.NONE)
        );
    }
}
