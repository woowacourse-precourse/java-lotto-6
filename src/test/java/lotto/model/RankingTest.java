package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankingTest {
    @DisplayName("잘못된 랭킹 값 입력")
    @Test
    void createRankingWithWrongParameters() {
        assertThatThrownBy(() -> Ranking.getRanking(1, true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
