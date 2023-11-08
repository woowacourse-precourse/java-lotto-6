package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @DisplayName("6개 번호가 일치하면 1등이다.")
    @Test
    void valueOf_AllNumbersMatch_ReturnsFirst() {
        LottoRank rank = LottoRank.valueOf(6, false);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등이다.")
    @Test
    void valueOf_FiveNumbersAndBonusMatch_ReturnsSecond() {
        LottoRank rank = LottoRank.valueOf(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("5개 번호가 일치하면 3등이다.")
    @Test
    void valueOf_FiveNumbersMatch_ReturnsThird() {
        LottoRank rank = LottoRank.valueOf(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("2개 이하 번호가 일치하면 등수에 해당하지 않는다.")
    @Test
    void valueOf_TwoOrLessNumbersMatch_ReturnsNone() {
        LottoRank rankTwoMatches = LottoRank.valueOf(2, false);
        LottoRank rankOneMatch = LottoRank.valueOf(1, false);
        LottoRank rankNoMatches = LottoRank.valueOf(0, false);

        assertThat(rankTwoMatches).isEqualTo(LottoRank.NONE);
        assertThat(rankOneMatch).isEqualTo(LottoRank.NONE);
        assertThat(rankNoMatches).isEqualTo(LottoRank.NONE);
    }
}
