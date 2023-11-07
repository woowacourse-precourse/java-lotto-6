package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

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
}
