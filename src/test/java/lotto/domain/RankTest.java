package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("Rank 객체에서 일치 개수를 가져올 수 있다.")
    @Test
    void getMatchCount() {
        assertThat(Rank.FIFTH.getMatchCount()).isEqualTo(3);
        assertThat(Rank.FOURTH.getMatchCount()).isEqualTo(4);
        assertThat(Rank.THIRD.getMatchCount()).isEqualTo(5);
        assertThat(Rank.SECOND.getMatchCount()).isEqualTo(5);
        assertThat(Rank.FIRST.getMatchCount()).isEqualTo(6);
        assertThat(Rank.NONE.getMatchCount()).isEqualTo(0);
    }

    @DisplayName("Rank 객체에서 등수 설명을 가져올 수 있다.")
    @Test
    void getDescription() {
        assertThat(Rank.FIFTH.getDescription()).isEqualTo("3개 일치 (5,000원)");
        assertThat(Rank.FOURTH.getDescription()).isEqualTo("4개 일치 (50,000원)");
        assertThat(Rank.THIRD.getDescription()).isEqualTo("5개 일치 (1,500,000원)");
        assertThat(Rank.SECOND.getDescription()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
        assertThat(Rank.FIRST.getDescription()).isEqualTo("6개 일치 (2,000,000,000원)");
        assertThat(Rank.NONE.getDescription()).isEqualTo("꽝");
    }

    @DisplayName("Rank 객체에서 상금을 가져올 수 있다.")
    @Test
    void getPrize() {
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.NONE.getPrize()).isEqualTo(0);
    }
}