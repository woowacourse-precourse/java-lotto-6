package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTypeTest {
    @DisplayName("등수 확인 - 6개 일치 (1등) 당첨")
    @Test
    void sixMatch() {
        PrizeType prizeType = PrizeType.getPrizeType(LottoPolicy.LOTTO_SIZE, false);

        assertEquals(PrizeType.FIRST, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 5개 일치 보너스 ( 2등 )")
    @Test
    void fiveMatchWithBonus() {
        PrizeType prizeType = PrizeType.getPrizeType(5, true);

        assertEquals(PrizeType.SECOND, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 5개 일치 ( 3등 )")
    @Test
    void fiveMatch() {
        PrizeType prizeType = PrizeType.getPrizeType(5, false);

        assertEquals(PrizeType.THIRD, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 4개 일치 보너스 ( 4등 )")
    @Test
    void fourMatchWithBonus() {
        PrizeType prizeType = PrizeType.getPrizeType(4, true);

        assertEquals(PrizeType.FOURTH, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 4개 일치 ( 4등 )")
    @Test
    void fourMatch() {
        PrizeType prizeType = PrizeType.getPrizeType(4, false);

        assertEquals(PrizeType.FOURTH, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 3개 일치 보너스 ( NONE )")
    @Test
    void threeMatchWithBonus() {
        PrizeType prizeType = PrizeType.getPrizeType(3, true);

        assertEquals(PrizeType.FIFTH, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 3개 일치 보너스 ( NONE )")
    @Test
    void threeMatch() {
        PrizeType prizeType = PrizeType.getPrizeType(3, false);

        assertEquals(PrizeType.FIFTH, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 2개 일치 보너스 ( NONE )")
    @Test
    void twoMatchWithBonus() {
        PrizeType prizeType = PrizeType.getPrizeType(2, true);

        assertEquals(PrizeType.NONE, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 2개 일치 보너스 ( NONE )")
    @Test
    void twoMatch() {
        PrizeType prizeType = PrizeType.getPrizeType(2, false);

        assertEquals(PrizeType.NONE, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 1개 일치 보너스 ( NONE )")
    @Test
    void oneMatchWithBonus() {
        PrizeType prizeType = PrizeType.getPrizeType(1, true);

        assertEquals(PrizeType.NONE, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 1개 일치 NONE")
    @Test
    void oneMatch() {
        PrizeType prizeType = PrizeType.getPrizeType(1, false);

        assertEquals(PrizeType.NONE, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 0개 일치 보너스 ( NONE )")
    @Test
    void noneMatchWithBonus() {
        PrizeType prizeType = PrizeType.getPrizeType(0, true);

        assertEquals(PrizeType.NONE, prizeType);
    }

    @DisplayName("당첨 등수 확인 - 0개 일치 ( NONE ) ")
    @Test
    void noneMatch() {
        PrizeType prizeType = PrizeType.getPrizeType(0, false);

        assertEquals(PrizeType.NONE, prizeType);
    }

}