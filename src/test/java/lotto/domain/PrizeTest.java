package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @DisplayName("Prize 의 결과를 잘 가져오는 지 확인")
    @Test
    public void testGetPrizeResult() {
        assertAll(
                () -> assertEquals(Prize.EMPTY, Prize.getPrizeResult(0, false)),
                () -> assertEquals(Prize.FIFTH, Prize.getPrizeResult(3, false)),
                () -> assertEquals(Prize.FOURTH, Prize.getPrizeResult(4, false)),
                () -> assertEquals(Prize.THIRD, Prize.getPrizeResult(5, false)),
                () -> assertEquals(Prize.SECOND, Prize.getPrizeResult(5, true)),
                () -> assertEquals(Prize.FIRST, Prize.getPrizeResult(6, false))
        );
    }

    @DisplayName("WinningPrize 를 정상적으로 가져오는 지 확인")
    @Test
    public void testGetWinningPrize() {
        assertAll(
                () -> assertEquals(0, Prize.EMPTY.getWinningPrize()),
                () -> assertEquals(5_000, Prize.FIFTH.getWinningPrize()),
                () -> assertEquals(50_000, Prize.FOURTH.getWinningPrize()),
                () -> assertEquals(1_500_000, Prize.THIRD.getWinningPrize()),
                () -> assertEquals(30_000_000, Prize.SECOND.getWinningPrize()),
                () -> assertEquals(2_000_000_000, Prize.FIRST.getWinningPrize())
        );
    }

    @DisplayName("등수별 기능 정상 작동 확인")
    @Test
    public void testGetMatchLottoNumber() {
        assertAll(
                () -> assertEquals(0, Prize.EMPTY.getMatchLottoNumber()),
                () -> assertEquals(3, Prize.FIFTH.getMatchLottoNumber()),
                () -> assertEquals(4, Prize.FOURTH.getMatchLottoNumber()),
                () -> assertEquals(5, Prize.THIRD.getMatchLottoNumber()),
                () -> assertEquals(5, Prize.SECOND.getMatchLottoNumber()),
                () -> assertEquals(6, Prize.FIRST.getMatchLottoNumber())
        );
    }
}
