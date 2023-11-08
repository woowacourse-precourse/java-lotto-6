package lotto;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    LottoService lottoService = new LottoService();
    PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
    @DisplayName("수익률이 정상적으로 계산되는지 확인하는 테스트")
    @Test
    void 수익률_정상작동_테스트(){
        String expectedResult = "62.5";
        int[] winResult = {1,0,0,0,0};
        assertEquals(expectedResult, lottoService.calcWinningRate(winResult, purchaseAmount));
    }

    @DisplayName("맞은 개수가 정상적으로 counting되는지 테스트")
    @Test
    void 개수_정상_테스트(){
        Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,6));
        List<Lotto> lottos = Arrays.asList(new Lotto(List.of(1,3,5,13,14,15)));
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(3);
        assertEquals(expectedResult, lottoService.calcWinningResult(winningNumber,lottos));
    }

    @DisplayName("맞은 개수에 따른 등수 인덱스가 정상적으로 분류되는지 테스트 (예시: 3개 일치, 5개 일치 + 보너스 일치)")
    @Test
    void 등수_정상_테스트(){
        List<Integer> countWinningNum = new ArrayList<>();
        countWinningNum.add(3);
        countWinningNum.add(5);
        Bonus bonus = new Bonus(7);
        Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,7));
        int[] expectedResult = new int[5];
        expectedResult[0] = 1;
        expectedResult[3] = 1;
        assertArrayEquals(expectedResult, lottoService.calcRanking(countWinningNum,winningNumber,bonus));
    }



}
