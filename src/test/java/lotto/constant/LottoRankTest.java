package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @DisplayName("RANK_ONE VALUES 테스트")
    @Test
    public void testRankOneValues() {
        LottoRank rank = LottoRank.RANK_ONE;
        assertThat(rank.getMatchedNormalNum()).isEqualTo(6);
        assertThat(rank.getMatchedBonusNum()).isEqualTo(0);
        assertThat(rank.getReward()).isEqualTo(2_000_000_000);
    }

    @DisplayName("RANK_TWO VALUES 테스트")
    @Test
    public void testRankTwoValues() {
        LottoRank rank = LottoRank.RANK_TWO;
        assertThat(rank.getMatchedNormalNum()).isEqualTo(5);
        assertThat(rank.getMatchedBonusNum()).isEqualTo(1);
        assertThat(rank.getReward()).isEqualTo(30_000_000);
    }

    @DisplayName("RANK_THREE VALUES 테스트")
    @Test
    public void testRankThreeValues() {
        LottoRank rank = LottoRank.RANK_THREE;
        assertThat(rank.getMatchedNormalNum()).isEqualTo(5);
        assertThat(rank.getMatchedBonusNum()).isEqualTo(0);
        assertThat(rank.getReward()).isEqualTo(1_500_000);
    }

    @DisplayName("RANK_FOUR VALUES 테스트")
    @Test
    public void testRankFourValues() {
        LottoRank rank = LottoRank.RANK_FOUR;
        assertThat(rank.getMatchedNormalNum()).isEqualTo(4);
        assertThat(rank.getMatchedBonusNum()).isEqualTo(0);
        assertThat(rank.getReward()).isEqualTo(50_000);
    }

    @DisplayName("RANK_FIVE VALUES 테스트")
    @Test
    public void testRankFiveValues() {
        LottoRank rank = LottoRank.RANK_FIVE;
        assertThat(rank.getMatchedNormalNum()).isEqualTo(3);
        assertThat(rank.getMatchedBonusNum()).isEqualTo(0);
        assertThat(rank.getReward()).isEqualTo(5_000);
    }

    @DisplayName("RANK_OUTSIDE VALUES 테스트")
    @Test
    public void testRankOutsideValues() {
        LottoRank rank = LottoRank.RANK_OUTSIDE;
        assertThat(rank.getMatchedNormalNum()).isEqualTo(-1);
        assertThat(rank.getMatchedBonusNum()).isEqualTo(-1);
        assertThat(rank.getReward()).isEqualTo(0);
    }
}