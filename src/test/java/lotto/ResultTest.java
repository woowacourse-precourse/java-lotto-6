package lotto;

import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    LottoService lottoService = new LottoService();
    PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
    @DisplayName("수익률 정상이 정상적으로 작동되는지 확인하는 테스트")
    @Test
    void 수익률_정상작동_테스트(){
        String expectedResult = "62.5";
        int[] winResult = {1,0,0,0,0};
        assertEquals(expectedResult, lottoService.calcWinningRate(winResult, purchaseAmount));
    }



}
