package lotto.domain;

import static lotto.domain.LottoResult.createLottoResult;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.globar.LottoResultInfo;
import lotto.service.LottoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    @DisplayName("게임 결과가 옳게 생성된다.")
    void testCreateGameResult() {
        // given
        long lottoPurchasePrice = 7000;

        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto(List.of(1, 12, 13, 14, 15, 16)));
        lottos.add(new Lotto(List.of(1, 2, 13, 14, 15, 16)));
        lottos.add(new Lotto(List.of(1, 2, 3, 14, 15, 16)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 15, 16)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 16)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        LottoWinningCombination lottoWinningCombination = LottoWinningCombination.createLottoWinningCombination(
                List.of(1, 2, 3, 4, 5, 6), 7);

        List<LottoResult> lottoResults = LottoService.determineLottoResults(lottos, lottoWinningCombination);

        // when
        GameResult gameResult = GameResult.createGameResult(lottoResults, lottoPurchasePrice);

        // then
        double expectedAllPrize = 0;
        Map<LottoResultInfo,Integer> expectedFinalResult = new HashMap<>();
        for (LottoResultInfo value : LottoResultInfo.values()) {
            expectedAllPrize += value.getPrize();
            expectedFinalResult.put(value, 1);
        }

        double exceptedRateOfReturn = Math.round((expectedAllPrize/ lottoPurchasePrice * 1000.0))/ 10.0;

        assertEquals(gameResult.getFinalResult(),expectedFinalResult);
        assertEquals(gameResult.getRateOfReturn(),exceptedRateOfReturn);

    }
    @Test
    @DisplayName("null인 로또 결과가 있으면 NullPointerException이 발생한다.")
    void testInvalidCreateGameResult() {
        // given
        long lottoPurchasePrice = 7000;

        Lotto oneMatchlotto = new Lotto(List.of(1, 12, 13, 14, 15, 16));
        Lotto twoMatchlotto = new Lotto(List.of(1, 2, 13, 14, 15, 16));
        Lotto threeMatchlotto = new Lotto(List.of(1, 2, 3, 14, 15, 16));
        Lotto fourMatchlotto = new Lotto(List.of(1, 2, 3, 4, 15, 16));
        Lotto fiveMatchlotto = new Lotto(List.of(1, 2, 3, 4, 5, 16));
        Lotto fiveplusbonusMatchlotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto sixMatchlotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoWinningCombination lottoWinningCombination = LottoWinningCombination.createLottoWinningCombination(
                List.of(1, 2, 3, 4, 5, 6), 7);

        List<LottoResult> lottoResults = new ArrayList<>();
        lottoResults.add(createLottoResult(oneMatchlotto, lottoWinningCombination));
        lottoResults.add(createLottoResult(twoMatchlotto, lottoWinningCombination));
        lottoResults.add(createLottoResult(threeMatchlotto, lottoWinningCombination));
        lottoResults.add(createLottoResult(fourMatchlotto, lottoWinningCombination));
        lottoResults.add(createLottoResult(fiveMatchlotto, lottoWinningCombination));
        lottoResults.add(createLottoResult(fiveplusbonusMatchlotto, lottoWinningCombination));
        lottoResults.add(createLottoResult(sixMatchlotto, lottoWinningCombination));

        // when
        assertThrows(NullPointerException.class,() -> GameResult.createGameResult(lottoResults, lottoPurchasePrice));
    }


    @Test
    @DisplayName("최종 결과값의 전치리가 옳게 들어간다.")
    void testPreProcessFinalResult() {
        // given
        Map<LottoResultInfo, Integer> finalResult = new HashMap<>();

        //when
        GameResult.preprocessFinalResult(finalResult);

        //then
        for (LottoResultInfo value : LottoResultInfo.values()) {
            assertEquals(0,finalResult.get(value));
        }

    }
}