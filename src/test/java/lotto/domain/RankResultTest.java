package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankResultTest {

    @DisplayName("총 상금액을 구할 수 있다")
    @ParameterizedTest
    @MethodSource
    void getTotalPrize(long expected, Rank... ranks) {
        RankResult rankResult = new RankResult();
        for (Rank rank : ranks) {
            rankResult.add(rank);
        }

        long totalPrize = rankResult.getTotalPrize();

        assertThat(totalPrize).isEqualTo(expected);
    }

    public static Stream<Arguments> getTotalPrize() {
        return Stream.of(
                Arguments.of(0L, new Rank[]{Rank.NONE, Rank.NONE}),
                Arguments.of(5000L, new Rank[]{Rank.NONE, Rank.FIFTH}),
                Arguments.of(5000L + 5000L, new Rank[]{Rank.FIFTH, Rank.FIFTH}),
                Arguments.of(2_000_000_000L + 5000L + 5000L, new Rank[]{Rank.FIFTH, Rank.FIFTH, Rank.FIRST})
        );
    }

    @DisplayName("맵에 NONE을 제외한 순위를 더할 수 있다.")
    @Test
    void add() {
        RankResult rankResult = new RankResult();

        rankResult.add(Rank.NONE);
        rankResult.add(Rank.FIFTH);
        rankResult.add(Rank.FOURTH);
        rankResult.add(Rank.THIRD);
        rankResult.add(Rank.SECOND);
        rankResult.add(Rank.FIRST);

        rankResult.add(Rank.FIRST);

        Collection<Integer> actual = rankResult.values();
        assertThat(actual).containsExactly(1, 1, 1, 1, 2);
    }
}
