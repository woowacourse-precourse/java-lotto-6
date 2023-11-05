package lotto.domain.enums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoPrize 클래스")
class LottoPrizeTest {

    @DisplayName("일치 번호에 따라 정확한 상금을 찾아 반환한다.")
    @Test
    void returnLottoPrizeIfNumbersMatched() {
        assertEquals(LottoPrize.FIFTH, LottoPrize.findLottoPrize(3, false));
        assertEquals(LottoPrize.FOURTH, LottoPrize.findLottoPrize(4, false));
        assertEquals(LottoPrize.THIRD, LottoPrize.findLottoPrize(5, false));
        assertEquals(LottoPrize.SECOND, LottoPrize.findLottoPrize(4, true));
        assertEquals(LottoPrize.FIRST, LottoPrize.findLottoPrize(6, false));
    }

    @DisplayName("로또 당첨에 해당하지 않는다면 낙첨을 반환한다.")
    @Test
    void returnLoseIfNumbersNotMatched() {
        assertEquals(LottoPrize.LOSE, LottoPrize.findLottoPrize(2, false));
        assertEquals(LottoPrize.LOSE, LottoPrize.findLottoPrize(1, true));

    }
}