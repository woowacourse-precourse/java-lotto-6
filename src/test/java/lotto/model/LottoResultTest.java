package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Map;



class LottoResultTest {

    @DisplayName("로또 결과 테스트")
    @Test
    void lottoResultTest(){
        //given
        Lotto winningNumber = new Lotto(Arrays.asList(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(8);
        LotteryNumbers lotteryNumbers = new LotteryNumbers(winningNumber, bonusNumber);

        Lottos purchasedLottos = new Lottos();
        purchasedLottos.add(Arrays.asList(1,2,3,10,11,12));
        purchasedLottos.add(Arrays.asList(1,2,3,4,5,8));
        purchasedLottos.add(Arrays.asList(1,2,3,4,5,7));
        purchasedLottos.add(Arrays.asList(1,2,3,11,12,14));
        purchasedLottos.add(Arrays.asList(1,2,3,4,12,14));


        //when
        LottoResult lottoResult = new LottoResult(purchasedLottos,lotteryNumbers);

        //then
        Map<WinningCriteria, Integer> result = lottoResult.getNumberMatchResult();

        // 예상 결과와 비교
        assertEquals(2, result.get(WinningCriteria.MATCHES_THREE));
        assertEquals(1, result.get(WinningCriteria.MATCHES_FOUR));
        assertEquals(1, result.get(WinningCriteria.MATCHES_FIVE));
        assertEquals(1, result.get(WinningCriteria.MATCHES_FIVE_WITH_BONUS));
        assertNull(result.get(WinningCriteria.MATCHES_SIX));

    }

}