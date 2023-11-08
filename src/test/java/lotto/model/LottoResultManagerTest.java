package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultManagerTest {

    @DisplayName("로또 결과가 제대로 출력되는지 검증한다.")
    @Test
    public void testCalculateLottoResults() {
        //로또 입력
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)),
            new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26))
        );

        //당첨 번호와 보너스 번호 입력
        LottoResultPolicy lottoResultPolicy = new LottoResultPolicy();
        lottoResultPolicy.setWinningNumbers(List.of(1,2,3,4,5,6));
        lottoResultPolicy.setBonusNumber(7);

        //로또 결과 계산해서 받아오기 (1등)
        LottoResultManager lottoResultManager = new LottoResultManager(lottos, lottoResultPolicy);
        long actualWinningAmount = lottoResultManager.getWinningAmount();
        Map<LottoRank, Integer> actualLottoResults = lottoResultManager.getLottoResults();

        //테스트를 진행할 로또 결과 지정하기 (1등)
        long expectedWinningAmount = LottoRank.FIRST.getPrizeAmount();
        Map<LottoRank, Integer> expectedLottoResults = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            expectedLottoResults.put(rank, 0);
        }
        expectedLottoResults.put(LottoRank.FIRST, 1);

        //로또 결과와 금액이 일치하는지 확인
        assertEquals(expectedWinningAmount, actualWinningAmount);
        assertEquals(expectedLottoResults, actualLottoResults);
    }
}