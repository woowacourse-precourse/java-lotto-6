package lotto.model.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeMoneyTest {

    private Money money;
    private PrizeMoney prizeMoney;


    @BeforeEach
    void setUp() {
        money = Money.of(1000);
        prizeMoney = new PrizeMoney();
    }

    @DisplayName("수익률을 올바르게 계산한다.")
    @Test
    void testGetProfitRateInfo() {
        // given
        float expectedProfitRate = 50.f;
        prizeMoney.addMoney(500);
        Money expectedMoney = Money.of(1000);

        // when
        float actualProfit = prizeMoney.getProfitRateInfo(expectedMoney);

        // then
        assertThat(expectedProfitRate).isEqualTo(actualProfit);
    }
}