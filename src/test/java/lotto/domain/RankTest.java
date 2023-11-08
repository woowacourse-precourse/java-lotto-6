package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @MethodSource("provideMatchingNumberCountsAndResultRank")
    void testFindByMatchingNumber(int matchingNumberCount,
                           int matchingBonusNumberCount,
                           Rank expectedRank) {
        //given
        //when
        Rank actualRank = Rank.findByMatchingNumber(matchingNumberCount, matchingBonusNumberCount);

        //then
        assertThat(actualRank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideMatchingNumberCountsAndResultRank() {
        return Stream.of(
                Arguments.of(6, 0, Rank.FIRST),
                Arguments.of(5, 1, Rank.SECOND),
                Arguments.of(5, 0, Rank.THIRD),
                Arguments.of(4, 1, Rank.FORTH),
                Arguments.of(4, 0, Rank.FORTH),
                Arguments.of(3, 0, Rank.FIFTH),
                Arguments.of(3, 1, Rank.FIFTH)
        );
    }
}