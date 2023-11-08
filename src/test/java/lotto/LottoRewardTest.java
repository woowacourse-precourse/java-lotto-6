package lotto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LottoRewardTest {

    @Test
    public void testGetReward() {
        assertEquals(LottoReward.FIRST_PRIZE, LottoReward.getReward(6, false));
        assertEquals(LottoReward.SECOND_PRIZE, LottoReward.getReward(5, true));
        assertEquals(LottoReward.FOURTH_PRIZE, LottoReward.getReward(4, true));
        assertEquals(LottoReward.THIRD_PRIZE, LottoReward.getReward(5, false));
        assertEquals(LottoReward.FOURTH_PRIZE, LottoReward.getReward(4, false));
        assertEquals(LottoReward.FIFTH_PRIZE, LottoReward.getReward(3, false));
        assertEquals(LottoReward.NOTHING, LottoReward.getReward(0, false));
    }

    @Test
    public void testGetMatchNumbersCount() {
        assertEquals(6, LottoReward.FIRST_PRIZE.getMatchNumbersCount());
        assertEquals(5, LottoReward.SECOND_PRIZE.getMatchNumbersCount());
        assertEquals(5, LottoReward.THIRD_PRIZE.getMatchNumbersCount());
        assertEquals(4, LottoReward.FOURTH_PRIZE.getMatchNumbersCount());
        assertEquals(3, LottoReward.FIFTH_PRIZE.getMatchNumbersCount());
        assertEquals(0, LottoReward.NOTHING.getMatchNumbersCount());
    }

    @Test
    public void testGetWinningReward() {
        assertEquals(2_000_000_000L, LottoReward.FIRST_PRIZE.getWinningReward());
        assertEquals(30_000_000L, LottoReward.SECOND_PRIZE.getWinningReward());
        assertEquals(1_500_000L, LottoReward.THIRD_PRIZE.getWinningReward());
        assertEquals(50_000L, LottoReward.FOURTH_PRIZE.getWinningReward());
        assertEquals(5_000L, LottoReward.FIFTH_PRIZE.getWinningReward());
        assertEquals(0L, LottoReward.NOTHING.getWinningReward());
    }
}
