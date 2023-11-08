package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Ranking;
import org.junit.jupiter.api.Test;

public class RankingTest {
    @Test
    void 일등_판단() {
        assertThat(Ranking.getRanking(6,0).getContents())
                .isEqualTo(Ranking.FIRST.getContents());
    }

    @Test
    void 이등_판단() {
        assertThat(Ranking.getRanking(5,1).getContents())
                .isEqualTo(Ranking.SECOND.getContents());
    }

    @Test
    void 삼등_판단() {
        assertThat(Ranking.getRanking(5,0).getContents())
                .isEqualTo(Ranking.THIRD.getContents());
    }

    @Test
    void 사등_판단() {
        assertThat(Ranking.getRanking(4,0).getContents())
                .isEqualTo(Ranking.FOURTH.getContents());
    }

    @Test
    void 오등_판단() {
        assertThat(Ranking.getRanking(3,0).getContents())
                .isEqualTo(Ranking.FIFTH.getContents());
    }

    @Test
    void 보너스_있는_경우_사등_판단() {
        assertThat(Ranking.getRanking(4,1).getContents())
                .isEqualTo(Ranking.FOURTH.getContents());
    }

    @Test
    void 등수_없음_판단() {
        assertThat(Ranking.getRanking(2,1).getContents())
                .isEqualTo(Ranking.NO_WINNING.getContents());
    }
}
