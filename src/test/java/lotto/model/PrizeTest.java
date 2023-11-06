package lotto.model;

import lotto.model.prize.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("당첨 결과 테스트")
class PrizeTest {
    @Test
    @DisplayName("객체 생성 테스트")
    void createPrize() {
        Prize prize = new Prize(1000, 1, 2, 3, 4, 5);
        assertEquals(1000, prize.prizeMoney());
        assertEquals(1, prize.threeMatchCount());
        assertEquals(2, prize.fourMatchCount());
        assertEquals(3, prize.fiveMatchCount());
        assertEquals(4, prize.fiveMatchWithBonusCount());
        assertEquals(5, prize.sixMatchCount());
    }
}