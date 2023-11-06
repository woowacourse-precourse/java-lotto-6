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


    @DisplayName("로또 결과 테스트 2")
    @Test
    void lottoResult2() {
        // given
        LottoResult lottoResult = new LottoResult(4);

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinNumber winNumber = new WinNumber(winLotto, 7);

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));  // 6개 일치 -> 1등
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));  // 6개 일치 -> 1등
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 14, 15, 16));  // 3개 일치 -> 5등
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 7));  // 5개 일치 + 보너스 -> 2등

        // when
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4);
        lottoResult.addLottoResult(lottos.stream().map(lotto -> lotto.calcRank(winNumber)).toList());

        // then
        HashMap<LottoGrade, Integer> lottoResultMap = lottoResult.getLottoResult();
        assertEquals(2, lottoResultMap.get(LottoGrade.FIRST));
        assertEquals(1, lottoResultMap.get(LottoGrade.SECOND));
        assertEquals(1, lottoResultMap.get(LottoGrade.FIFTH));
    }

    @DisplayName("로또 수익률")
    @Test
    void lottoProfit() {
        // given
        LottoResult lottoResult = new LottoResult(4);

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinNumber winNumber = new WinNumber(winLotto, 7);

        Lotto lotto1 = new Lotto(List.of(1, 2, 9, 10, 15, 16));  // 2개 일치 -> 0원
        Lotto lotto2 = new Lotto(List.of(1, 2, 9, 10, 15, 16));  // 2개 일치 -> 0원
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 14, 15, 16));  // 3개 일치 -> 5등, 5000원
        Lotto lotto4 = new Lotto(List.of(14, 33, 43, 24, 5, 7));  // 1개 일치 -> 0원

        // when
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4);
        lottoResult.addLottoResult(lottos.stream().map(lotto -> lotto.calcRank(winNumber)).toList());
        int totalPrizeMoney = lottos.stream().map(lotto -> lotto.calcRank(winNumber).getPrizeMoney()).reduce(0, Integer::sum);
        int purchaseMoney = 4 * 1000; // 1000원짜리 로또 4개 구매

        // then
        double expected = totalPrizeMoney / (double) purchaseMoney * 100;
        assertEquals(expected, lottoResult.calcProfitRate());
    }

}