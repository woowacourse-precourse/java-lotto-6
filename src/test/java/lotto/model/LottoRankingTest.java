package lotto.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankingTest {

    @Test
    @DisplayName("조건에 맞는 로또 랭킹을 반환하는지 확인한다.")
    void determineRanking_isNoneMatch() {
        /**
         * given : 일치하는 번호(0)가 없고, 보너스 번호도 없는(false) 경우가 주어진다.
         * when : 당첨 등수를 판단한다.
         * then : 매칭된 번호와 보너스가 없으므로, 결과는 NONE_MATCH이다.
         */
        int matchCount = 0;
        boolean hasBonusNumber = false;

        LottoRanking lottoRanking = LottoRanking.determineRanking(matchCount, hasBonusNumber);
        assertThat(lottoRanking).isEqualTo(LottoRanking.NONE_MATCH);
    }

    @Test
    @DisplayName("조건에 맞는 로또 랭킹을 반환하는지 확인한다.")
    void determineRanking_isMatchFiveBonus() {
        /**
         * given : 일치하는 번호(5)가 있고, 보너스 번호도 있는(true) 경우가 주어진다.
         * when : 당첨 등수를 판단한다.
         * then : 매칭된 번호는 5개이고, 보너스 번호가 있으므로, 결과는 MATCH_FIVE_BONUS이다.
         */
        int matchCount = 5;
        boolean hasBonusNumber = true;

        LottoRanking lottoRanking = LottoRanking.determineRanking(matchCount, hasBonusNumber);
        assertThat(lottoRanking).isEqualTo(LottoRanking.SECOND);
    }
}