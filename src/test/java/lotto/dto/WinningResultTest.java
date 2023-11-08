package lotto.dto;

import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class WinningResultTest {

    @DisplayName("두 Result가 같은지 테스트")
    @Test
    public void sameResultTest() {
        // given
        Map<Rank, Integer> ranks = new HashMap<>();
        ranks.put(Rank.THIRD, 2);
        ranks.put(Rank.SECOND, 1);

        Map<Rank, Integer> expectedRanks = new HashMap<>();
        expectedRanks.put(Rank.THIRD, 2);
        expectedRanks.put(Rank.SECOND, 1);

        // when
        WinningResult winningResult = new WinningResult(ranks);

        // then
        Assertions.assertThat(winningResult).isEqualTo(new WinningResult(expectedRanks));
    }

    @DisplayName("두 Result가 다른지 테스트")
    @ParameterizedTest
    @MethodSource("notSameResultProvider")
    public void notSameResultTest(Map<Rank, Integer> expectedRanks) {
        // given
        Map<Rank, Integer> ranks = new HashMap<>();
        ranks.put(Rank.THIRD, 2);
        ranks.put(Rank.SECOND, 1);

        // when
        WinningResult winningResult = new WinningResult(ranks);

        // then
        Assertions.assertThat(winningResult).isNotEqualTo(new WinningResult(expectedRanks));
    }

    private static Stream<Arguments> notSameResultProvider() { // argument source method
        Map<Rank, Integer> expectedRanks1 = new HashMap<>();
        expectedRanks1.put(Rank.THIRD, 1);
        expectedRanks1.put(Rank.SECOND, 1);

        Map<Rank, Integer> expectedRanks2 = new HashMap<>();
        expectedRanks2.put(Rank.FIRST, 2);
        expectedRanks2.put(Rank.SECOND, 1);

        return Stream.of(Arguments.of(expectedRanks1), Arguments.of(expectedRanks2));
    }
}
