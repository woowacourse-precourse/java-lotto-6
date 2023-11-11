package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("맞은 번호 개수와 보너스 일치 여부로 랭킹 가져오기 테스트")
    @Test
    void getRanking() {
        Integer matchCount = 5;

        assertThat(Ranking.getRanking(matchCount, false)).isEqualTo(Ranking.THIRD);
        assertThat(Ranking.getRanking(matchCount, true)).isEqualTo(Ranking.SECOND);
    }

    @DisplayName("getPrize 쉼표 제거 테스트")
    @Test
    void getPrize() {
        assertThat(Ranking.SECOND.getPrize()).isEqualTo("30000000");
    }

    @DisplayName("Ranking toString 테스트")
    @Test
    void testToString() {
        assertThat(Ranking.SECOND.toString()).contains("5개 일치, 보너스 볼 일치 (30,000,000원)");
        assertThat(Ranking.FIRST.toString()).contains("6개 일치 (2,000,000,000원)");
    }
}