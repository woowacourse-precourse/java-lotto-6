package lotto.domain.player.playermoney;

import static lotto.domain.player.playermoney.UsedMoney.makeZeroUsedMoney;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lottoresult.LottoResult;
import lotto.domain.lottoresult.LottoResultsRepository;
import lotto.domain.player.Profit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsedMoneyTest {

    @DisplayName("사용하는 금액 만큼 usedMoney 가 업데이트 된다.")
    @Test
    void ConsumeMoneyTest() {
        UsedMoney usedMoney = makeZeroUsedMoney();
        usedMoney = usedMoney.updateUsedMoney(2000);
        assertThat(usedMoney.getUsedMoney()).isEqualTo(2000);
    }

    @DisplayName("8000원 사용 해 5000원이 당첨되면 profit 은 62.5 가 된다.")
    @Test
    void ProfitCalculateTest() {
        //Given
        UsedMoney usedMoney = makeZeroUsedMoney();
        usedMoney = usedMoney.updateUsedMoney(8000);
        LottoResultsRepository lottoResultsRepository = new LottoResultsRepository();
        lottoResultsRepository.saveLottoResult(LottoResult.FIFTH);
        //When
        Profit profit = usedMoney.calculateProfit(lottoResultsRepository);
        //Then
        assertThat(profit.getProfit()).isEqualTo(62.5);
    }
}
