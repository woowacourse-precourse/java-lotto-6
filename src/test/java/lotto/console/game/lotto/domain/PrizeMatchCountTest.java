package lotto.console.game.lotto.domain;

import lotto.console.game.lotto.constants.PrizeRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeMatchCountTest {
    @DisplayName("등수 계산 - 성공 테스트")
    @Test
    public void get_prize_money_success_test() {
        // given
        PrizeMatchCount prizeMatchCount = new PrizeMatchCount();
        prizeMatchCount.addCount();
        prizeMatchCount.addCount();
        prizeMatchCount.addCount();
        prizeMatchCount.addCount();
        prizeMatchCount.addCount();
        prizeMatchCount.matchBonus();

        // when & then
        assertEquals(PrizeRank.SECOND, prizeMatchCount.getPrizeRank());
    }
}