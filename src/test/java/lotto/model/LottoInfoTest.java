package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoInfoTest {

    @Test
    @DisplayName("LottoInfo의 Lotto를 반환한다.")
    void getLotto() {
        //
    }

    @Test
    @DisplayName("LottoInfo 객체의 Lotto와 WinningLotto를 비교하여 LottoMatchCount 객체를 반환한다.")
    void isMatchBonus() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        LottoInfo lottoInfo = new LottoInfo(lotto);
        BonusNumber bonusNumber = new BonusNumber(7);
        //when
        boolean expect = lottoInfo.isMatchBonus(bonusNumber);
        //then
        assertTrue(expect);
    }

    @Test
    @DisplayName("LottoInfo 객체의 Lotto와 WinningLotto를 비교하여 matchCount 멤버 변수를 반환한다.")
    void countMatch() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        LottoInfo lottoInfo = new LottoInfo(lotto);
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        //when
        Integer expect = lottoInfo.countMatch(winningLotto);
        //then
        assertEquals(5, expect);
    }

    @Test
    @DisplayName("LottoInfo 객체의 matchCount 멤버 변수를 0으로 초기화한다.")
    void resetMatchCount() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        LottoInfo lottoInfo = new LottoInfo(lotto);
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        lottoInfo.countMatch(winningLotto);
        //when
        lottoInfo.resetMatchCount();
        //then
        assertEquals(0, lottoInfo.getMatchCount());
    }
}