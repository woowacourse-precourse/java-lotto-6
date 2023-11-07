package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottosResult;
import lotto.domain.service.KoreanMoneyService;
import lotto.domain.service.Money;
import org.junit.jupiter.api.Test;

public class LottosResultTest {
    @Test
    void countProfitableTest() {

        List<LottoResult> givenLottoResults = List.of(LottoResult.FOUR_MATCHES, LottoResult.SIX_MATCHES);
        int moneySpent = 200;
        LottosResult lottosResult = new LottosResult(givenLottoResults);

        double expectedProfit = ((LottoResult.FOUR_MATCHES.getPrizeAmount() + LottoResult.SIX_MATCHES.getPrizeAmount()) / (double) moneySpent) * 100;
        Money money = new KoreanMoneyService();
        money.saveMoney(moneySpent);
        lottosResult.countProfitable(money);

        assertThat(lottosResult.getTotalProfit()).isEqualTo(expectedProfit);
    }

}
