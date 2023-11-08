package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @DisplayName("각 등수에 맞는 상금이 올바르게 반환되는지 테스트")
    @Test
    public void shouldReturnCorrectPrizeForLottoRank() {
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2000000000);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30000000);
        assertThat(LottoRank.THIRD.getPrize()).isEqualTo(1500000);
        assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(50000);
        assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(5000);
        assertThat(LottoRank.NONE.getPrize()).isEqualTo(0);
    }

    @DisplayName("3개 미만일 때 NONE을 반환하는지 테스트")
    @Test
    public void shouldReturnNoneForLessThanThreeMatches() {
        assertThat(LottoRank.of(0, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.of(1, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.of(2, false)).isEqualTo(LottoRank.NONE);
    }

    @DisplayName("맞춘 개수에 따라 올바른 LottoRank를 반환하는지 테스트")
    @Test
    public void shouldReturnCorrectLottoRankForMatchCount() {
        assertThat(LottoRank.of(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.of(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.of(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.of(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.of(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("보너스 번호에 따른 올바른 LottoRank를 반환하는지 테스트")
    @Test
    public void shouldConsiderBonusMatchForSecondRank() {
        assertThat(LottoRank.of(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.of(5, false)).isEqualTo(LottoRank.THIRD);
    }
}
