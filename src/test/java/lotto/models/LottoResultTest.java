package lotto.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @DisplayName("로또 결과 테스트 1")
    @Test
    void lottoResult1() {
        // given
        LottoResult lottoResult = new LottoResult(3);

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinNumber winNumber = new WinNumber(winLotto, 7);

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));  // 6개 일치 -> 1등
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));  // 5개 일치 + 보너스 -> 2등
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 8, 9));  // 4개 일치 -> 4등


        // when
        lottoResult.addLottoResult(lotto1.calcRank(winNumber));
        lottoResult.addLottoResult(lotto2.calcRank(winNumber));
        lottoResult.addLottoResult(lotto3.calcRank(winNumber));

        // then
        HashMap<LottoGrade, Integer> lottoResultMap = lottoResult.getLottoResult();
        assertEquals(1, lottoResultMap.get(LottoGrade.FIRST));
        assertEquals(1, lottoResultMap.get(LottoGrade.SECOND));
        assertEquals(1, lottoResultMap.get(LottoGrade.FOURTH));
    }


}