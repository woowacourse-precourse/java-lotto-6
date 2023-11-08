package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {
    @DisplayName("로또 등수 테스트")
    @Test
    public void lottoRankGetRank() {
        assertEquals("1등", LottoRank.FIRST_PLACE.getRank());
        assertEquals("2등", LottoRank.SECOND_PLACE.getRank());
    }

    @DisplayName("일치하는 개수에 맞는 등수를 반환한다.")
    @Test
    public void lottoRankGetMatchingCountByRank() {
        assertEquals(6, LottoRank.getMatchingCountByRank("1등"));
        assertEquals(5, LottoRank.getMatchingCountByRank("2등"));
    }

    @DisplayName("등수에 맞는 당첨금을 반환한다.")
    @Test
    public void lottoRankGetPrizeByRank() {
        assertEquals(2000000000, LottoRank.getPrizeByRank("1등"));
        assertEquals(30000000, LottoRank.getPrizeByRank("2등"));
    }

    @DisplayName("일치하는 개수에 맞는 LottoRank를 반환한다.")
    @Test
    public void lottoRankFindByMatchCount() {
        assertEquals(LottoRank.FIRST_PLACE, LottoRank.findByMatchCount(6, 0));
        assertEquals(LottoRank.SECOND_PLACE, LottoRank.findByMatchCount(5, 1));
    }
}
