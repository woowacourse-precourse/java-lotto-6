package lotto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.LottoLogic;
import lotto.dto.LottoNumbersInfo;
import lotto.dto.LottoPurchaseInfo;
import lotto.message.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoLogicTest {
    @Test
    @DisplayName("로또의 총 수익률을 계산한다.")
    void calculateTotalProfitRate() {
        LottoPurchaseInfo purchaseInfo = new LottoPurchaseInfo(new BigDecimal(1000), Lotto.PRICE);
        LottoNumbersInfo numbersInfo = new LottoNumbersInfo(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                List.of(1, 2, 3, 4, 5, 6), 1);
        assertTrue(new LottoLogic(purchaseInfo, numbersInfo).getProfitRate()
                == (float) LottoResult.FIRST.getPrize() / 1000);

    }


}
