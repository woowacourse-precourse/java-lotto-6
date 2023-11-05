package lotto.ranking;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("맞은 번호와 보너스 개수에 따른 랭킹이 생성")
    @MethodSource("getMatchCountAndRank")
    @ParameterizedTest(name = "맞은 개수 : {0}, 보너스 : {1} => 결과 : {2}")
    void createRanking(Integer matchCount, boolean bonusMatch, Ranking ranking) {
        Ranking result = Ranking.calculateRanking(matchCount, bonusMatch);
        Assertions.assertThat(result).isEqualTo(ranking);
    }

    private static Stream<Arguments> getMatchCountAndRank() {
        return Stream.of(
                Arguments.of(6, false, Ranking.FIRST),
                Arguments.of(5, true, Ranking.SECOND),
                Arguments.of(5, false, Ranking.THIRD),
                Arguments.of(4, true, Ranking.FOURTH),
                Arguments.of(3, true, Ranking.FIFTH),
                Arguments.of(2, false, Ranking.NOTHING)
        );
    }
}
