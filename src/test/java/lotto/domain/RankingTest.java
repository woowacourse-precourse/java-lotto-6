package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankingTest {

    @Test
    void 로또_1등이_정상적으로_반환되는가() {
        int matchCount = 6;
        boolean bonusMatch = false;

        assertThat(Ranking.of(matchCount, bonusMatch)).isEqualTo(Ranking.FIRST);
    }

    @Test
    void 로또_2등이_정상적으로_반환되는가() {
        int matchCount = 5;
        boolean bonusMatch = true;

        assertThat(Ranking.of(matchCount, bonusMatch)).isEqualTo(Ranking.SECOND);
    }

    @Test
    void 로또_3등이_정상적으로_반환되는가() {
        int matchCount = 5;
        boolean bonusMatch = false;

        assertThat(Ranking.of(matchCount, bonusMatch)).isEqualTo(Ranking.THIRD);
    }

    @Test
    void 로또_4등이_정상적으로_반환되는가() {
        int matchCount = 4;
        boolean bonusMatch = false;

        assertThat(Ranking.of(matchCount, bonusMatch)).isEqualTo(Ranking.FOURTH);
    }

    @Test
    void 로또_5등이_정상적으로_반환되는가() {
        int matchCount = 3;
        boolean bonusMatch = false;

        assertThat(Ranking.of(matchCount, bonusMatch)).isEqualTo(Ranking.FIFTH);
    }

    @ParameterizedTest(name = "로또 등수가 없는 경우 null 반환")
    @CsvSource(value = {"2", "1", "0"})
    void 로또_등수가_없는_경우_null(int matchCount) {
        boolean bonusMatch = false;

        assertThat(Ranking.of(matchCount, bonusMatch)).isEqualTo(null);
    }
}
