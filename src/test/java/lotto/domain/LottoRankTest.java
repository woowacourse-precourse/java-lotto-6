package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("로또 등수를 올바르게 반환하는지 확인")
    void testLottoRankValueOf() {
        assertThat(LottoRank.valueOf(0, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("일치하는 숫자가 5개지만 보너스 번호가 일치하지 않는 경우 3등을 반환하는지 확인")
    void testThirdRankCondition() {
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("매치된 숫자가 없는 경우 NONE을 반환하는지 확인")
    void testNoneRankCondition() {
        assertThat(LottoRank.valueOf(1, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.NONE);
    }

    @Test
    @DisplayName("각 등수의 매치되는 숫자 개수를 올바르게 반환하는지 확인")
    void testGetMatchCount() {
        assertThat(LottoRank.FIRST.getMatchCount()).isEqualTo(6);
        assertThat(LottoRank.SECOND.getMatchCount()).isEqualTo(5);
        assertThat(LottoRank.THIRD.getMatchCount()).isEqualTo(5);
        assertThat(LottoRank.FOURTH.getMatchCount()).isEqualTo(4);
        assertThat(LottoRank.FIFTH.getMatchCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호 일치 여부를 올바르게 반환하는지 확인")
    void testIsMatchBonus() {
        assertThat(LottoRank.SECOND.isMatchBonus()).isTrue();
        assertThat(LottoRank.FIRST.isMatchBonus()).isFalse();
        assertThat(LottoRank.THIRD.isMatchBonus()).isFalse();
    }

    @Test
    @DisplayName("각 등수의 상금을 올바르게 반환하는지 확인")
    void testGetPrize() {
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(LottoRank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(5_000);
    }
}

