package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoRank 열거형 테스트")
class LottoRankTest {

    @Test
    @DisplayName("LottoRank 열거형 값 확인")
    void testLottoRankValues() {
        assertEquals(LottoRank.FIRST.getMatchCount(), 6);
        assertEquals(LottoRank.FIRST.getPrize(), 2_000_000_000);

        assertEquals(LottoRank.SECOND.getMatchCount(), 5);
        assertEquals(LottoRank.SECOND.getPrize(), 30_000_000);

        assertEquals(LottoRank.THIRD.getMatchCount(), 5);
        assertEquals(LottoRank.THIRD.getPrize(), 1_500_000);

        assertEquals(LottoRank.FOURTH.getMatchCount(), 4);
        assertEquals(LottoRank.FOURTH.getPrize(), 50_000);

        assertEquals(LottoRank.FIFTH.getMatchCount(), 3);
        assertEquals(LottoRank.FIFTH.getPrize(), 5_000);

        assertEquals(LottoRank.NONE.getMatchCount(), 0);
        assertEquals(LottoRank.NONE.getPrize(), 0);
    }

    @Test
    @DisplayName("LottoRank 열거형 값 반환 확인")
    void testLottoRankValueOf() {
        // Act & Assert
        assertEquals(LottoRank.valueOf(6, false), LottoRank.FIRST);
        assertEquals(LottoRank.valueOf(5, false), LottoRank.THIRD);
        assertEquals(LottoRank.valueOf(5, true), LottoRank.SECOND);
        assertEquals(LottoRank.valueOf(4, false), LottoRank.FOURTH);
        assertEquals(LottoRank.valueOf(3, false), LottoRank.FIFTH);
        assertEquals(LottoRank.valueOf(2, false), LottoRank.NONE);
    }
}