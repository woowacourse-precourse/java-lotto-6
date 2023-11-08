package lotto.enums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("로또 랭크를 제대로 판단하는지 확인한다")
    @Test
    public void testFirstPrize() {
        LottoRank rank = LottoRank.determineRank(6, false);
        assertEquals(LottoRank.FIRST, rank);
        assertEquals(2_000_000_000L, rank.getPrizeAmount());
    }

    @DisplayName("로또 랭크를 제대로 판단하는지 확인한다")
    @Test
    public void testSecondPrize() {
        LottoRank rank = LottoRank.determineRank(5, true);
        assertEquals(LottoRank.SECOND, rank);
        assertEquals(30_000_000L, rank.getPrizeAmount());
    }

    @DisplayName("로또 랭크를 제대로 판단하는지 확인한다")
    @Test
    public void testThirdPrize() {
        LottoRank rank = LottoRank.determineRank(5, false);
        assertEquals(LottoRank.THIRD, rank);
        assertEquals(1_500_000L, rank.getPrizeAmount());
    }

    @DisplayName("로또 랭크를 제대로 판단하는지 확인한다")
    @Test
    public void testFourthPrize() {
        LottoRank rank = LottoRank.determineRank(4, false);
        assertEquals(LottoRank.FOURTH, rank);
        assertEquals(50_000L, rank.getPrizeAmount());
    }

    @DisplayName("로또 랭크를 제대로 판단하는지 확인한다")
    @Test
    public void testFifthPrize() {
        LottoRank rank = LottoRank.determineRank(3, false);
        assertEquals(LottoRank.FIFTH, rank);
        assertEquals(5_000L, rank.getPrizeAmount());
    }
}