package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("일치하는 번호 개수와 보너스 번호의 포함여부를 알면 순위를 매길 수 있다.")
    @Test
    void getRanking() {
        Assertions.assertAll(
                () -> assertThat(Ranking.getRanking(4,false)).isEqualTo(Ranking.FOURTH),
                () -> assertThat(Ranking.getRanking(5,false)).isEqualTo(Ranking.THIRD),
                () -> assertThat(Ranking.getRanking(3,false)).isEqualTo(Ranking.FIFTH),
                () -> assertThat(Ranking.getRanking(5,true)).isEqualTo(Ranking.SECOND),
                () -> assertThat(Ranking.getRanking(6,false)).isEqualTo(Ranking.FIRST),
                () -> assertThat(Ranking.getRanking(2,true)).isEqualTo(Ranking.FAIL)
        );
    }
}