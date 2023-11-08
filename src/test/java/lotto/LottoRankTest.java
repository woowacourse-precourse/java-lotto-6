package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {

    @DisplayName("정확한 등수의 LottoRank가 반환되는지 테스트")
    @Test
    public void testValueOfCorrectRank() {
        assertEquals(LottoRank.FIRST, LottoRank.valueOf(6, false));
        assertEquals(LottoRank.SECOND, LottoRank.valueOf(5, true));
        assertEquals(LottoRank.THIRD, LottoRank.valueOf(5, false));
        assertEquals(LottoRank.FOURTH, LottoRank.valueOf(4, false));
        assertEquals(LottoRank.FIFTH, LottoRank.valueOf(3, false));
        assertEquals(LottoRank.MISS, LottoRank.valueOf(2, false));
    }

    @DisplayName("각 등수별 당첨 금액이 정확한지 테스트")
    @Test
    public void testLottoRankWinnings() {
        assertEquals(2_000_000_000, LottoRank.FIRST.getWinnings());
        assertEquals(30_000_000, LottoRank.SECOND.getWinnings());
    }
}

