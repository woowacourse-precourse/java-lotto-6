package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @Test
    public void testGetLottoResult() {
        assertAll(
                () -> assertEquals(Prize.EMPTY, Prize.getLottoResult(0, false)),
                () -> assertEquals(Prize.FIFTH, Prize.getLottoResult(3, false)),
                () -> assertEquals(Prize.FOURTH, Prize.getLottoResult(4, false)),
                () -> assertEquals(Prize.THIRD, Prize.getLottoResult(5, false)),
                () -> assertEquals(Prize.SECOND, Prize.getLottoResult(5, true)),
                () -> assertEquals(Prize.FIRST, Prize.getLottoResult(6, false))
                );
    }

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
