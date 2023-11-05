package study.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import lotto.domain.MoneyRate;
import lotto.domain.TotalAmount;
import org.junit.jupiter.api.Test;

public class MoneyRateTest {

    @Test
    void getRate(){
        TotalAmount totalAmount = new TotalAmount(5000L);
        Money money = new Money(1000L);

        MoneyRate moneyRate = new MoneyRate(totalAmount, money);

        assertThat(moneyRate.getRate()).isEqualTo(500.0);
    }
}
