package lotto.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrizeTest {

    @Test
    public void 매치_카운트가_3일_때_상금_검증() {
        assertEquals(Prize.MATCH_3, Prize.valueOf(3L, false));
        assertEquals(5000, Prize.MATCH_3.getPrizeMoney());
        assertEquals("3개 일치 (5,000원)", Prize.MATCH_3.getDescription());
    }

    @Test
    public void 매치_카운트가_4일_때_상금_검증() {
        assertEquals(Prize.MATCH_4, Prize.valueOf(4L, false));
        assertEquals(50_000, Prize.MATCH_4.getPrizeMoney());
        assertEquals("4개 일치 (50,000원)", Prize.MATCH_4.getDescription());
    }

    @Test
    public void 매치_카운트가_5이고_보너스_볼_일치하지_않을_때_상금_검증() {
        assertEquals(Prize.MATCH_5, Prize.valueOf(5L, false));
        assertEquals(1_500_000, Prize.MATCH_5.getPrizeMoney());
        assertEquals("5개 일치 (1,500,000원)", Prize.MATCH_5.getDescription());
    }

    @Test
    public void 매치_카운트가_5이고_보너스_볼이_일치할_때_상금_검증() {
        assertEquals(Prize.MATCH_5_BONUS, Prize.valueOf(5L, true));
        assertEquals(30_000_000, Prize.MATCH_5_BONUS.getPrizeMoney());
        assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원)", Prize.MATCH_5_BONUS.getDescription());
    }

    @Test
    public void 매치_카운트가_6일_때_상금_검증() {
        assertEquals(Prize.MATCH_6, Prize.valueOf(6L, false));
        assertEquals(2_000_000_000, Prize.MATCH_6.getPrizeMoney());
        assertEquals("6개 일치 (2,000,000,000원)", Prize.MATCH_6.getDescription());
    }

    @Test
    public void 매치_카운트가_0일_때_미당첨_검증() {
        assertEquals(Prize.NOTING, Prize.valueOf(0L, false));
        assertEquals(0, Prize.NOTING.getPrizeMoney());
        assertEquals("미당첨", Prize.NOTING.getDescription());
    }

    @Test
    public void 유효하지_않은_매치_카운트일_때_미당첨_검증() {
        assertEquals(Prize.NOTING, Prize.valueOf(7L, true));
        assertEquals(Prize.NOTING, Prize.valueOf(7L, false));
        assertEquals(Prize.NOTING, Prize.valueOf(-1L, true));
    }
}
