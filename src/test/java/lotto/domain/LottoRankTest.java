package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("같은 번호가 3개 미만인 경우 NONE 출력")
    @Test
    void checkMatchCountIsLessThanThree() {
        assertEquals(LottoRank.NONE, LottoRank.getLottoRank(2, false));
        assertEquals(LottoRank.NONE, LottoRank.getLottoRank(1, true));
        assertEquals(LottoRank.NONE, LottoRank.getLottoRank(0, false));
    }

    @DisplayName("5개 번호 일치 및 보너스볼 일치 시 FIVE_MATCH_WITH_BONUS 출력")
    @Test
    void checkMatchCountIsFiveWithBonus() {
        assertEquals(LottoRank.FIVE_MATCH_WITH_BONUS, LottoRank.getLottoRank(5, true));
    }

    @DisplayName("5개 번호가 같지만 보너스 볼이 일치하지 않는 경우 FIVE_MATCH 출력")
    @Test
    void checkMatchCountIsFiveWithoutBonus() {
        assertEquals(LottoRank.FIVE_MATCH_NO_BONUS, LottoRank.getLottoRank(5, false));
    }

    @DisplayName("6개 번호가 같을 경우 SIX_MATCH 출력")
    @Test
    void checkMatchCountIsSix() {
        assertEquals(LottoRank.SIX_MATCH, LottoRank.getLottoRank(6, false));
    }
}
