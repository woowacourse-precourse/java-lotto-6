package lotto;

import lotto.domain.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.Lotto.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 안에 있는 당첨 번호 몇 개인지 세는 메서드 테스트")
    @Test
    void testCountingWinningNumberInLotto(){
        assertEquals(3, countWinningNumberInLotto(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(2, 4, 6, 8, 10, 12))));
    }

    @DisplayName("로또 번호, 보너스 번호, 당첨 번호로 등수 판단하는 메서드 테스트 - 미당첨")
    @Test
    void testJudgingLottoRankNOT() {
        Rank resultRankNot = judgeLottoRank(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(2, 4, 8, 9, 10, 12)), 7);
        assertEquals(Rank.NOT, resultRankNot);
    }
    @DisplayName("로또 번호, 보너스 번호, 당첨 번호로 등수 판단하는 메서드 테스트 - 5등")
    @Test
    void testJudgingLottoRankFIFTH() {
        Rank resultRankFIFTH = judgeLottoRank(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(1, 2, 3, 7, 8, 9)), 7);
        assertEquals(Rank.FIFTH, resultRankFIFTH);
    }

    @DisplayName("로또 번호, 보너스 번호, 당첨 번호로 등수 판단하는 메서드 테스트 - 4등")
    @Test
    void testJudgingLottoRankFOURTH() {
        Rank resultRankFOURTH = judgeLottoRank(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(1, 2, 3, 4, 8, 9)), 7);
        assertEquals(Rank.FOURTH, resultRankFOURTH);
    }
    @DisplayName("로또 번호, 보너스 번호, 당첨 번호로 등수 판단하는 메서드 테스트 - 3등")
    @Test
    void testJudgingLottoRankTHIRD() {
        Rank resultRankTHIRD = judgeLottoRank(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(1,2,3,4,5,8)), 7);
        assertEquals(Rank.THIRD, resultRankTHIRD);
    }
    @DisplayName("로또 번호, 보너스 번호, 당첨 번호로 등수 판단하는 메서드 테스트 - 2등")
    @Test
    void testJudgingLottoRankSECOND() {
        Rank resultRankSECOND = judgeLottoRank(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(1,2,3,4,5,7)), 7);
        assertEquals(Rank.SECOND, resultRankSECOND);
    }
    @DisplayName("로또 번호, 보너스 번호, 당첨 번호로 등수 판단하는 메서드 테스트 - 1등")
    @Test
    void testJudgingLottoRankFIRST() {
        Rank resultRankFIRST = judgeLottoRank(List.of(1, 2, 3, 4, 5, 6), new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertEquals(Rank.FIRST, resultRankFIRST);
    }

    @DisplayName("한 정수가 당첨 번호 안에 있는지 판단하는 메서드 테스트 - True")
    @Test
    void testCheckingLottoNumberInWinningNumberTrue() {
        assertTrue(checkLottoNumberInWinningNumber(List.of(1, 2, 3, 4, 5, 6), 3));
    }
    @DisplayName("한 정수가 당첨 번호 안에 있는지 판단하는 메서드 테스트 - False")
    @Test
    void testCheckingLottoNumberInWinningNumberFalse() {
        assertFalse(checkLottoNumberInWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7));
    }

    @DisplayName("보너스 번호가 로또 번호 안에 있는지 판단하는 메서드 테스트 - True")
    @Test
    void testIsBonusNumberInLottoTrue() {
        assertTrue(isBonusNumberInLotto(new Lotto(List.of(2, 4, 6, 8, 10, 12)), 6));
    }
    @DisplayName("보너스 번호가 로또 번호 안에 있는지 판단하는 메서드 테스트 - False")
    @Test
    void testIsBonusNumberInLottoFalse() {
        assertFalse(isBonusNumberInLotto(new Lotto(List.of(2, 4, 6, 8, 10, 12)), 7));
    }

}