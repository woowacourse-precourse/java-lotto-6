package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankingTest {

    @ParameterizedTest(name = "로또 매칭 개수와 보너스 숫자 매칭 여부에 따라 정상적으로 등수가 결정되는가.")
    @CsvSource({"6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH"})
    void returnRankingByMatchingCountAndBonus(int matchCount, boolean bonusMatch, Ranking expected) {
        assertThat(Ranking.of(matchCount, bonusMatch)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또 등수가 없는 경우 null 반환")
    @CsvSource(value = {"2", "1", "0"})
    void NoRankingOf(int matchCount) {
        boolean bonusMatch = false;

        assertThat(Ranking.of(matchCount, bonusMatch)).isEqualTo(null);
    }
}
