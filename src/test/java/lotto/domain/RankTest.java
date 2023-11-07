package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.stream.Stream;
import lotto.dto.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("당첨 번호와 로또로 등수를 계산할 수 있다")
    @ParameterizedTest
    @MethodSource
    void getRankByLottoAndWinningNumber(int matchCount, boolean hasBonus, Rank expected) {

        Rank actual = Rank.of(new MatchResult(matchCount, hasBonus));

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> getRankByLottoAndWinningNumber() {
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

    @DisplayName("총 상금액을 구할 수 있다")
    @ParameterizedTest
    @MethodSource
    void getTotalPrize(EnumMap<Rank, Integer> rankToCount, long expected) {

        long totalPrize = Rank.getTotalPrize(rankToCount);

        assertThat(totalPrize).isEqualTo(expected);
    }

    public static Stream<Arguments> getTotalPrize() {
        return Stream.of(
                Arguments.of(createRankToCount(Rank.NONE, Rank.NONE), 0L),
                Arguments.of(createRankToCount(Rank.NONE, Rank.FIFTH), 5000L),
                Arguments.of(createRankToCount(Rank.FIFTH, Rank.FIFTH), 5000L + 5000L),
                Arguments.of(createRankToCount(Rank.FIFTH, Rank.FIFTH, Rank.FIRST), 2_000_000_000L + 5000L + 5000L)
        );
    }

    private static EnumMap<Rank, Integer> createRankToCount(Rank... ranks) {
        EnumMap<Rank, Integer> rankToInteger = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            add(rankToInteger, rank);
        }
        return rankToInteger;
    }

    private static void add(EnumMap<Rank, Integer> map, Rank rank) {
        map.put(rank, map.getOrDefault(rank, 0) + 1);
    }
}
