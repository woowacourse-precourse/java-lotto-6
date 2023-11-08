package lotto.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;


public class LottoRewardTest {

    @DisplayName("올바른 WinningReward를 가져오는 경우")
    @Test
    void correctWinningReward() {
        int matchLottoCount = 3;
        boolean matchBonusNumber = true;
        lotto.constants.LottoReward fifth = lotto.constants.LottoReward.FIFTH;
        assertEquals(fifth, lotto.constants.LottoReward.getWinningReward(matchLottoCount, matchBonusNumber));
    }
}
