package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeTest {

    @Test
    @DisplayName("getMatchingNumbers() 메서드 테스트")
    void testMatchingNumbers() {
        assertEquals(6, LottoPrize.FIRST.getMatchingNumbers());
        assertEquals(5, LottoPrize.SECOND.getMatchingNumbers());
        assertEquals(5, LottoPrize.THIRD.getMatchingNumbers());
        assertEquals(4, LottoPrize.FOURTH.getMatchingNumbers());
        assertEquals(3, LottoPrize.FIFTH.getMatchingNumbers());
    }

    @Test
    @DisplayName("getPrize() 메서드 테스트")
    void testGetPrize() {
        assertEquals(2_000_000_000, LottoPrize.FIRST.getPrize());
        assertEquals(30_000_000, LottoPrize.SECOND.getPrize());
        assertEquals(1_500_000, LottoPrize.THIRD.getPrize());
        assertEquals(50_000, LottoPrize.FOURTH.getPrize());
        assertEquals(5_000, LottoPrize.FIFTH.getPrize());
    }

    @Test
    @DisplayName("enum class에서 제공하는 values 메서드 테스트")
    void testValues() {
        LottoPrize[] values = LottoPrize.values();
        assertEquals(5, values.length);
        assertEquals(LottoPrize.THIRD, values[2]);
    }

    @Test
    @DisplayName("enum class에서 제공하는 valueOf 메서드 테스트")
    void testValueOf() {
        assertEquals(LottoPrize.FIRST, LottoPrize.valueOf("FIRST"));
        assertEquals(LottoPrize.THIRD, LottoPrize.valueOf("THIRD"));
    }
}