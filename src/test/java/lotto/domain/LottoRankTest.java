package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @Test
    @DisplayName("")
    public void testGetPrizeMoney() throws Exception {
        //given
        LottoRank fourthPrizeRank = LottoRank.findLottoRank(3, false);

        //when
        int result = fourthPrizeRank.getPrizeMoney();

        //then
        assertEquals(result, 5000);
    }
    @Test
    @DisplayName("당첨되지 않은 로또를 검증한다.")
    public void testNoPrize() {
        //given&when
        LottoRank noPrizeRank = LottoRank.findLottoRank(0, false);
        //then
        assertEquals(LottoRank.NO_PRIZE, noPrizeRank);
    }

    @Test
    @DisplayName("5등 당첨을 검증한다.")
    public void testFourthPlace() throws Exception {
        //given&when
        LottoRank fourthPrizeRank = LottoRank.findLottoRank(3, false);

        //then
        assertEquals(LottoRank.FIFTH_PRIZE, fourthPrizeRank);
    }

    @Test
    @DisplayName("4등 당첨을 검증한다.")
    public void testThirdPlace() throws Exception {
        //given&when
        LottoRank thirdPrizeRank = LottoRank.findLottoRank(4, false);

        //then
        assertEquals(LottoRank.FOURTH_PRIZE, thirdPrizeRank);
    }

    @Test
    @DisplayName("보너스 번호를 맞춘 2등 당첨을 검증한다.")
    public void testSecondPlaceWithBonusMatch() throws Exception {
        //given&when
        LottoRank secondPrizeRankWithBonusMatch = LottoRank.findLottoRank(5, true);

        //then
        assertEquals(LottoRank.SECOND_PRIZE, secondPrizeRankWithBonusMatch);

    }

    @Test
    @DisplayName("2등 당첨을 검증한다.")
    public void testSecondPlace() throws Exception {
        //given&when
        LottoRank secondPrizeRankWithoutBonusMatch = LottoRank.findLottoRank(5, false);

        //then
        assertEquals(LottoRank.THIRD_PRIZE, secondPrizeRankWithoutBonusMatch);

    }

    @Test
    @DisplayName("1등 당첨을 검증한다.")
    public void testFirstPlace() throws Exception {
        //given&when
        LottoRank firstPrizeRank = LottoRank.findLottoRank(6, false);

        //then
        assertEquals(LottoRank.FIRST_PRIZE, firstPrizeRank);
    }
}