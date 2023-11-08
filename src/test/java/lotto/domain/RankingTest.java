package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RankingTest {

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("전달받은 번호의 일치 정도에 맞는 등수를 반환한다.")
    void compareRanking(Integer matchNumbers, Integer matchBonus, Ranking ranking) {
        // when
        Ranking comparedRanking = Ranking.compareRanking(matchNumbers, matchBonus);

        // then
        assertThat(comparedRanking).isEqualTo(ranking);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(6, 1, Ranking.FIRST),
                Arguments.of(6, 0, Ranking.FIRST),
                Arguments.of(5, 1, Ranking.SECOND),
                Arguments.of(5, 0, Ranking.THIRD),
                Arguments.of(4, 1, Ranking.FOURTH),
                Arguments.of(4, 0, Ranking.FOURTH),
                Arguments.of(3, 1, Ranking.FIFTH),
                Arguments.of(3, 0, Ranking.FIFTH)
        );
    }

}