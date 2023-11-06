package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    private static final int ZERO_MATCHES = 0;
    private static final int ONE_MATCH = 1;
    private static final int TWO_MATCHES = 2;
    private static final int THREE_MATCHES = 3;
    private static final int FOUR_MATCHES = 4;
    private static final int FIVE_MATCHES = 5;
    private static final int SIX_MATCHES = 6;

    private static final boolean MATCH_BONUS = true;
    private static final boolean NO_MATCH_BONUS = false;

    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 30_000_000;
    private static final int THIRD_PRIZE = 1_500_000;
    private static final int FOURTH_PRIZE = 50_000;
    private static final int FIFTH_PRIZE = 5_000;

    @Test
    @DisplayName("로또 등수를 올바르게 반환하는지 확인")
    void testLottoRankValueOf() {
        assertThat(LottoRank.valueOf(ZERO_MATCHES, NO_MATCH_BONUS)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(THREE_MATCHES, NO_MATCH_BONUS)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(FOUR_MATCHES, NO_MATCH_BONUS)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(FIVE_MATCHES, NO_MATCH_BONUS)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(FIVE_MATCHES, MATCH_BONUS)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(SIX_MATCHES, NO_MATCH_BONUS)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("일치하는 숫자가 5개지만 보너스 번호가 일치하지 않는 경우 3등을 반환하는지 확인")
    void testThirdRankCondition() {
        assertThat(LottoRank.valueOf(FIVE_MATCHES, NO_MATCH_BONUS)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("매치된 숫자가 없는 경우 NONE을 반환하는지 확인")
    void testNoneRankCondition() {
        assertThat(LottoRank.valueOf(ONE_MATCH, NO_MATCH_BONUS)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(TWO_MATCHES, NO_MATCH_BONUS)).isEqualTo(LottoRank.NONE);
    }

    @Test
    @DisplayName("각 등수의 매치되는 숫자 개수를 올바르게 반환하는지 확인")
    void testGetMatchCount() {
        assertThat(LottoRank.FIRST.getMatchCount()).isEqualTo(SIX_MATCHES);
        assertThat(LottoRank.SECOND.getMatchCount()).isEqualTo(FIVE_MATCHES);
        assertThat(LottoRank.THIRD.getMatchCount()).isEqualTo(FIVE_MATCHES);
        assertThat(LottoRank.FOURTH.getMatchCount()).isEqualTo(FOUR_MATCHES);
        assertThat(LottoRank.FIFTH.getMatchCount()).isEqualTo(THREE_MATCHES);
    }

    @Test
    @DisplayName("보너스 번호 일치 여부를 올바르게 반환하는지 확인")
    void testIsMatchBonus() {
        assertThat(LottoRank.SECOND.isMatchBonus()).isEqualTo(MATCH_BONUS);
        assertThat(LottoRank.FIRST.isMatchBonus()).isEqualTo(NO_MATCH_BONUS);
        assertThat(LottoRank.THIRD.isMatchBonus()).isEqualTo(NO_MATCH_BONUS);
    }

    @Test
    @DisplayName("각 등수의 상금을 올바르게 반환하는지 확인")
    void testGetPrize() {
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(FIRST_PRIZE);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(SECOND_PRIZE);
        assertThat(LottoRank.THIRD.getPrize()).isEqualTo(THIRD_PRIZE);
        assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(FOURTH_PRIZE);
        assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(FIFTH_PRIZE);
    }
}


