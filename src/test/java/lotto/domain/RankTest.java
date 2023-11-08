package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("Rank 상금 반환 테스트")
    @Test
    void Rank_상금_반환_테스트() {
        Rank rank = Rank.FIFTH;
        assertThat(rank.getPrize()).isEqualTo(5000);
    }

    @DisplayName("Rank 상금 반환 실패 테스트")
    @Test
    void Rank_상금_반환_실패_테스트() {
        Rank rank = Rank.FIFTH;
        assertThat(rank.getPrize()).isNotEqualTo(5001);
    }
}