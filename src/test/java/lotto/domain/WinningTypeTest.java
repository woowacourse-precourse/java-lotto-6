package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTypeTest {
    @Test
    @DisplayName("조건에 맞는 WinningType 객체를 성공적으로 반환한다.")
    public void WinningType_조회_테스트() {
        assertEquals(WinningType.FIRST, WinningType.findWinningType(6, false));
        assertEquals(WinningType.SECOND, WinningType.findWinningType(5, true));
        assertEquals(WinningType.THIRD, WinningType.findWinningType(5, false));
        assertEquals(WinningType.FOURTH, WinningType.findWinningType(4, false));
        assertEquals(WinningType.FIFTH, WinningType.findWinningType(3, false));
        assertEquals(WinningType.NONE, WinningType.findWinningType(2, false));
    }

    @Test
    @DisplayName("각 WinningType 당첨 번호 갯수의 기준을 반환한다.")
    public void 당첨_번호_갯수_반환_테스트() {
        assertEquals(6, WinningType.FIRST.getWinningCount());
        assertEquals(5, WinningType.SECOND.getWinningCount());
        assertEquals(5, WinningType.THIRD.getWinningCount());
        assertEquals(4, WinningType.FOURTH.getWinningCount());
        assertEquals(3, WinningType.FIFTH.getWinningCount());
        assertEquals(0, WinningType.NONE.getWinningCount());
    }

    @Test
    @DisplayName("각 WinningType 보너스 번호 포함 여부의 기준을 반환한다.")
    public void 보너스_번호_포함_여부_반환_테스트() {
        assertTrue(WinningType.SECOND.hasBonusNumber());
        assertFalse(WinningType.FIRST.hasBonusNumber());
        assertFalse(WinningType.THIRD.hasBonusNumber());
        assertFalse(WinningType.FOURTH.hasBonusNumber());
        assertFalse(WinningType.FIFTH.hasBonusNumber());
        assertFalse(WinningType.NONE.hasBonusNumber());
    }

    @Test
    @DisplayName("각 WinningType의 금액을 반환한다.")
    public void 금액_반환_테스트() {
        assertEquals(2000000000, WinningType.FIRST.getPrice());
        assertEquals(30000000, WinningType.SECOND.getPrice());
        assertEquals(1500000, WinningType.THIRD.getPrice());
        assertEquals(50000, WinningType.FOURTH.getPrice());
        assertEquals(5000, WinningType.FIFTH.getPrice());
        assertEquals(0, WinningType.NONE.getPrice());
    }
}
