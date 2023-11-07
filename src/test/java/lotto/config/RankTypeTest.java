package lotto.config;

import static lotto.config.RankType.FIFTH;
import static lotto.config.RankType.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTypeTest {
    @Test
    void 일치하는_숫자_개수로_등수타입_찾기() {
        assertThat(RankType.findByCorrectCount(5, false)).isEqualTo(THIRD);
    }

    @Test
    void 등수_얻기() {
        assertThat(FIFTH.getRank()).isEqualTo(5);
    }

    @Test
    void 일치하는_숫자_개수_얻기() {
        assertThat(FIFTH.getCorrectCount()).isEqualTo(3);
    }

    @Test
    void 등수로_등수타입_찾기() {
        assertThat(RankType.findByRank(5)).isEqualTo(FIFTH);
    }

    @Test
    void 상금_얻기() {
        assertThat(FIFTH.getPrice()).isEqualTo(5000);
    }
}