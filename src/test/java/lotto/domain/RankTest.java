package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    @DisplayName("맞힌 개수와 보너스 볼 일치 여부에 따라 올바른 Rank 반환")
    void givenMatchCountAndBonusMatch_whenValueOf_thenReturnsCorrectRank() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false), "6개 일치는 FIRST여야 함");
        assertEquals(Rank.SECOND, Rank.valueOf(5, true), "5개 일치와 보너스 볼 일치는 SECOND여야 함");
        assertEquals(Rank.THIRD, Rank.valueOf(5, false), "5개 일치는 THIRD여야 함");
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false), "4개 일치는 FOURTH여야 함");
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false), "3개 일치는 FIFTH여야 함");
        assertEquals(Rank.NONE, Rank.valueOf(2, false), "2개 일치는 NONE이어야 함");
    }

    @Test
    @DisplayName("각 Rank의 맞힌 개수가 올바르게 반환됨")
    void whenGetCountOfMatch_thenReturnsCorrectMatchCount() {
        assertEquals(6, Rank.FIRST.getCountOfMatch(), "FIRST는 6개 일치여야 함");
        assertEquals(5, Rank.SECOND.getCountOfMatch(), "SECOND는 5개 일치여야 함");
        assertEquals(5, Rank.THIRD.getCountOfMatch(), "THIRD는 5개 일치여야 함");
    }
}