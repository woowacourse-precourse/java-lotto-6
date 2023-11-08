package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("6개 일치하는 경우 1등")
    public void testFirstRank() {
        assertThat(Rank.findRank(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호도 일치하는 경우 2등")
    public void testSecondRankWithBonus() {
        assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호는 일치하지 않는 경우 3등")
    public void testThirdRankWithoutBonus() {
        assertThat(Rank.findRank(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 일치하는 경우 4등")
    public void testFourthRank() {
        assertThat(Rank.findRank(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치하는 경우 5등")
    public void testFifthRank() {
        assertThat(Rank.findRank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하 일치하는 경우 등수 없음")
    public void testNoRank() {
        assertThat(Rank.findRank(2, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.findRank(1, false)).isEqualTo(Rank.NONE);
    }

    @Test
    @DisplayName("상금 확인")
    public void testPrizeAmounts() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
        assertThat(Rank.NONE.getPrize()).isEqualTo(0);
    }
}
