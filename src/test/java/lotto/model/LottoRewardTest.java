package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LottoRewardTest {

    @Test
    public void testGetReward() {
        assertEquals(LottoReward.FIRST_PLACE, LottoReward.getReward(6, false));
        assertEquals(LottoReward.SECOND_PLACE, LottoReward.getReward(5, true));
        assertEquals(LottoReward.FOURTH_PLACE, LottoReward.getReward(4, true));
        assertEquals(LottoReward.THIRD_PLACE, LottoReward.getReward(5, false));
        assertEquals(LottoReward.FOURTH_PLACE, LottoReward.getReward(4, false));
        assertEquals(LottoReward.FIFTH_PLACE, LottoReward.getReward(3, false));
        assertEquals(LottoReward.NOTHING, LottoReward.getReward(0, false));
    }

    @Test
    public void testGetMatchNumbersCount() {
        assertEquals(6, LottoReward.FIRST_PLACE.getMatchNumbersCount());
        assertEquals(5, LottoReward.SECOND_PLACE.getMatchNumbersCount());
        assertEquals(5, LottoReward.THIRD_PLACE.getMatchNumbersCount());
        assertEquals(4, LottoReward.FOURTH_PLACE.getMatchNumbersCount());
        assertEquals(3, LottoReward.FIFTH_PLACE.getMatchNumbersCount());
        assertEquals(0, LottoReward.NOTHING.getMatchNumbersCount());
    }

    @Test
    public void testGetWinningReward() {
        assertEquals(2_000_000_000L, LottoReward.FIRST_PLACE.getWinningReward());
        assertEquals(30_000_000L, LottoReward.SECOND_PLACE.getWinningReward());
        assertEquals(1_500_000L, LottoReward.THIRD_PLACE.getWinningReward());
        assertEquals(50_000L, LottoReward.FOURTH_PLACE.getWinningReward());
        assertEquals(5_000L, LottoReward.FIFTH_PLACE.getWinningReward());
        assertEquals(0L, LottoReward.NOTHING.getWinningReward());
    }

}
