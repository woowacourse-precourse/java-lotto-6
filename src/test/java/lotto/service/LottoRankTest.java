package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @DisplayName("로또 번호가 5개 일치하고 보너스 번호가 맞으면 2등 반환")
    @Test
    void success_Second() {
        // give
        int matchCount = 5;
        boolean hasBonusMatched = true;
        // when
        LottoRank rank = LottoRank.valueOf(matchCount, hasBonusMatched);
        // then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("로또 번호가 5개 일치하고 보너스 번호가 틀리면 3등 반환")
    @Test
    void success_Third() {
        // give
        int matchCount = 5;
        boolean hasBonusMatched = false;
        // when
        LottoRank rank = LottoRank.valueOf(matchCount, hasBonusMatched);
        // then
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("로또 번호가 3개 미만 일치하면 등수 없음")
    @Test
    void success_None() {
        // give
        int matchCount = 2;
        boolean hasBonusMatched = false;
        // when
        LottoRank rank = LottoRank.valueOf(matchCount, hasBonusMatched);
        // then
        assertThat(rank).isEqualTo(LottoRank.NONE);
    }

}