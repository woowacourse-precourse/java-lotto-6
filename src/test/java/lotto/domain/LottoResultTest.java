package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.globar.LottoResultInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("로또와 당첨조합 중 당첨번호 6개가 전부 같으면, 6개 일치하는 결과를 반환해준다.")
    void testCreateSixMatchLottoResult(){
        // given
        LottoWinningCombination lottoWinningCombination = LottoWinningCombination.createLottoWinningCombination(
                List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //
        assertEquals(LottoResult.createLottoResult(lotto,
                lottoWinningCombination).getLottoResultInfo(), LottoResultInfo.SIX_MATCH);
    }@Test
    @DisplayName("로또와 당첨조합 중 당첨번호 5개가 같고 보너스 번호가 같으면, 헤당하는 결과를 반환해준다.")
    void testCreateFiveMatchWithBonusLottoResult(){
        // given
        LottoWinningCombination lottoWinningCombination = LottoWinningCombination.createLottoWinningCombination(
                List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //
        assertEquals(LottoResult.createLottoResult(lotto,
                lottoWinningCombination).getLottoResultInfo(), LottoResultInfo.FIVE_MATCH_WITH_BONUS);
    }
    @Test
    @DisplayName("로또와 당첨조합 중 당첨번호 5개가 같으면, 헤당하는 반환해준다.")
    void testCreateFiveMatchLottoResult(){
        // given
        LottoWinningCombination lottoWinningCombination = LottoWinningCombination.createLottoWinningCombination(
                List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        //
        assertEquals(LottoResult.createLottoResult(lotto,
                lottoWinningCombination).getLottoResultInfo(), LottoResultInfo.FIVE_MATCH);
    }
    @Test
    @DisplayName("로또와 당첨조합 중 당첨번호 4개가 같으면, 헤당하는 반환해준다.")
    void testCreateFourthMatchLottoResult(){
        // given
        LottoWinningCombination lottoWinningCombination = LottoWinningCombination.createLottoWinningCombination(
                List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 15, 16));

        //
        assertEquals(LottoResult.createLottoResult(lotto,
                lottoWinningCombination).getLottoResultInfo(), LottoResultInfo.FOUR_MATCH);
    }
    @Test
    @DisplayName("로또와 당첨조합 중 당첨번호 3개가 같으면, 헤당하는 반환해준다.")
    void testCreateThreeMatchLottoResult(){
        // given
        LottoWinningCombination lottoWinningCombination = LottoWinningCombination.createLottoWinningCombination(
                List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 14, 15, 16));

        //
        assertEquals(LottoResult.createLottoResult(lotto,
                lottoWinningCombination).getLottoResultInfo(), LottoResultInfo.THREE_MATCH);
    }
    @Test
    @DisplayName("로또와 당첨조합 중 당첨번호 2개 이하가 같으면, null을 반환해준다.")
    void testCreateLottoResult(){
        // given
        LottoWinningCombination lottoWinningCombination = LottoWinningCombination.createLottoWinningCombination(
                List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto twoMatchLotto = new Lotto(List.of(1, 2, 13, 14, 15, 16));
        Lotto oneMatchLotto = new Lotto(List.of(1, 12, 13, 14, 15, 16));
        Lotto noMatchLotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));

        //
        Assertions.assertNull(LottoResult.createLottoResult(twoMatchLotto,
                lottoWinningCombination));
        Assertions.assertNull(LottoResult.createLottoResult(oneMatchLotto,
                lottoWinningCombination));
        Assertions.assertNull(LottoResult.createLottoResult(noMatchLotto,
                lottoWinningCombination));
    }

    @Test
    @DisplayName("보너스번호와 같은 값이 없으면, false를 보내준다.")
    void testBonusNumIsNotMatch() {
        assertFalse(LottoResult.bonusNumMatched(List.of(1, 2, 3, 4, 5, 6), 7));
        assertFalse(LottoResult.bonusNumMatched(List.of(1, 2, 3, 4, 5, 6), 10));
        assertFalse(LottoResult.bonusNumMatched(List.of(1, 2, 3, 4, 5, 16), 45));
    }
    @Test
    @DisplayName("보너스번호와 같은 값이 존재하면, ture를 보내준다.")
    void testBonusNumIsMatch() {
        assertTrue(LottoResult.bonusNumMatched(List.of(1, 2, 3, 4, 5, 6), 1));
        assertTrue(LottoResult.bonusNumMatched(List.of(1, 2, 3, 4, 5, 6), 6));
        assertTrue(LottoResult.bonusNumMatched(List.of(11, 12, 13, 14, 15, 16), 13));
    }

    @Test
    @DisplayName("두 리스트를 비교해서 같은 값이 있는 만큼 숫자를 반환해준다.")
    void test(){
        assertEquals(LottoResult.countMatchingLottoWithWinnerNums(List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6)), 6);
        assertEquals(LottoResult.countMatchingLottoWithWinnerNums(List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12)), 0);
        assertEquals(LottoResult.countMatchingLottoWithWinnerNums(List.of(11, 12, 13, 14, 15, 16),
                List.of(11, 12, 13, 4, 5, 6)), 3);
        assertEquals(LottoResult.countMatchingLottoWithWinnerNums(List.of(21, 22, 23, 24, 25, 26),
                List.of(21, 2, 3, 4, 5, 26)), 2);
    }
}