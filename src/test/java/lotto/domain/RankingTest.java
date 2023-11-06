package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RankingTest {

    @DisplayName("로또 번호와 일치하는 값 개수와 보너스 번호 일치 여부에 따라 등수를 반환한다.")
    @ParameterizedTest(name = "일치 값 개수: {0}, 보너스 번호 일치 여부: {1}, 결과: {2}")
    @MethodSource("matchCountAndContainBonusNumber")
    void getRankingTest(int matchCount, boolean containBonusNumber, Ranking ranking) {
        Assertions.assertThat(Ranking.getRanking(matchCount, containBonusNumber)).isEqualTo(ranking);
    }

    static Stream<Arguments> matchCountAndContainBonusNumber() {
        return Stream.of(
                Arguments.arguments(6, false, Ranking.FIRST),
                Arguments.arguments(5, true, Ranking.SECOND),
                Arguments.arguments(5, false, Ranking.THIRD),
                Arguments.arguments(4, false, Ranking.FOURTH),
                Arguments.arguments(3, false, Ranking.FIFTH),
                Arguments.arguments(2, false, Ranking.FAIL)
        );
    }
}
