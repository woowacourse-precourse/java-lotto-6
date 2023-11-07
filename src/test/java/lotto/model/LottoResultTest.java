package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LottoResultTest {
    @Test
    @DisplayName("")
    void test() throws Exception {
        //given
        int bonusNumber = 8;
        LotteryNumbers lotteryNumbers = new LotteryNumbers(Arrays.asList(1,2,3,4,5,6), bonusNumber);

        PurchasedLottos purchasedLottos = new PurchasedLottos();
        purchasedLottos.add(Arrays.asList(1,2,3,10,11,12));
        purchasedLottos.add(Arrays.asList(1,2,3,4,5,8));

        //when
        LottoResult lottoResult = new LottoResult(purchasedLottos,lotteryNumbers);

        //then
        Map<WinningStrategy, Integer> result = lottoResult.getNumberMatchResult();

        // 예상 결과와 비교
        assertEquals(1, result.get(WinningStrategy.MATCHES_THREE));
        assertEquals(1, result.get(WinningStrategy.MATCHES_FIVE_WITH_BONUS));
        assertNull(result.get(WinningStrategy.MATCHES_SIX));

    }

}